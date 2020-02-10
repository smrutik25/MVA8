package com.example.dynamic_visual_acuity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class PlayArea extends Activity{
    Random rand = new Random();

    ImageView shapes;
    TextView score;
    TextView lives;
    Button[] buttons = new Button[4];
    int scoreVal = 0;
    int livesVal = 5;
    String diffShapes;
    String[] options = new String[4];

    HashMap<String, String> shape = new HashMap<>();
    String[] fileNames;
    ArrayList<String> workingList = new ArrayList<>();

    int correctLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);
        getFiles();
        sceneInit();
    }

    public void sceneInit(){
        shapes = (ImageView) this.findViewById(R.id.shapeToGuess);
        score = (TextView) this.findViewById(R.id.score);
        lives = (TextView) this.findViewById(R.id.lives);
        buttons[0] = (Button) this.findViewById(R.id.choice1);
        buttons[1] = (Button) this.findViewById(R.id.choice2);
        buttons[2] = (Button) this.findViewById(R.id.choice3);
        buttons[3] = (Button) this.findViewById(R.id.choice4);
        buildMapBuildList();
        buildScene();
        update();
    }

    public void update(){
        score.setText(String.valueOf(scoreVal));
        lives.setText(String.valueOf(livesVal));
        if(workingList.size() >= 4 && livesVal > 0){
            buildScene();
            shapes.setImageBitmap(loadShape(shape.get(diffShapes)));
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
            shapes.startAnimation(animation1);


//            ((TextView) findViewById(R.id.debug)).setText(curCountry);
        }
        else{
            openAlert();
        }
    }



    public void buildScene(){
        ArrayList<String> temp = new ArrayList<>();
        for(String s : workingList){
            temp.add(s);
        }
        Collections.shuffle(temp);
        for(int i = 0 ; i < options.length ; i++){
            options[i] = temp.get(i);
        }

        correctLoc = rand.nextInt(4);
        diffShapes = options[correctLoc];

        for(int i = 0 ; i < options.length ; i++){
            buttons[i].setText(options[i]);
        }
        for(String s : workingList){
            System.out.println(s);
        }
    }

    public void getFiles(){
        try{
            fileNames = getAssets().list("shapes");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Bitmap loadShape(String name){
        AssetManager am = this.getAssets();
        try{
            return BitmapFactory.decodeStream(am.open("shapes/"+name));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String shapeFromFileName(String fileName){ //countryFromFileName
        String result = fileName.substring(0, 1).toUpperCase() + fileName.split("\\.")[0].substring(1);
        return result.replace("_"," ");
    }

    public void buildMapBuildList(){
        for(String name : fileNames){
            shape.put(shapeFromFileName(name), name);
            workingList.add(shapeFromFileName(name));
        }
        for(String s : workingList){
            System.out.println(s);
        }
    }

    public void choose(View view) {
        int id = view.getId();
        if(id == buttons[correctLoc].getId()){
            scoreVal += 1;
            String shapeToRemove = String.valueOf(buttons[correctLoc].getText());//countryToRemove
            workingList.remove(shapeToRemove);

            update();
        }
        else{
            Toast t = Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER_VERTICAL,0,200);
            t.show();
            livesVal -= 1;
            update();
        }
    }

    public void openAlert(){
        Intent alert = new Intent(this, Alert.class);
        if(livesVal > 0)
            alert.putExtra("state",0); //0 when out of countries
        else{
            alert.putExtra("state",-1); //-1 when the user loses
        }
        startActivity(alert);
    }

    public void goToMenu() {
        startActivity(new Intent(this,Menu.class));
    }
}
