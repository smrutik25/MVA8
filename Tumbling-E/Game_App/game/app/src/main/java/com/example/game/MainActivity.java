package com.example.game;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView shape;
    List<Shapes> list;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void move(View view){

        ImageView image = (ImageView)findViewById(R.id.shape);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }

    private void newQuestion(int number){
        shape.setImageResource(list.get(number -1).getImage());
        int correct_answer= r.nextInt(2)+1;
        int firstButton= number-1;
    }
}

