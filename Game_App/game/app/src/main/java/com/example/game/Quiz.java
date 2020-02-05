package com.example.game;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Quiz extends AppCompatActivity{
    Button op1,op2,op3,op4,submit;
    List<Shapes> list;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.options);

     op1 = findViewById(R.id.op1);
     op2 = findViewById(R.id.op2);
     op3 = findViewById(R.id.op3);
     op4 = findViewById(R.id.op4);

     list = new ArrayList<>();

     for (int i = 0; i < new Database().answers.length; i++) {
         list.add(new Shapes(new Database().answers[i], new Database().shapes[i]));
     }

     Collections.shuffle(list);

     op1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });
     op2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     op3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });

     op4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });
 }


 }
