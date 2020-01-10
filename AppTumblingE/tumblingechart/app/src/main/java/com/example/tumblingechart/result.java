package com.example.tumblingechart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


/*
 *
 * 1st : 1 20/200 -2.00 to -2.50
 * 2nd : 2 20/100 -1.75 to -2.00
 * 3rd : 3 20/80 -1.00 to -1.25
 * 4th : 4 20/60 -1.00 to -1.25
 * 5th : 5 20/50 -1.00 to -1.25
 * 6th : 5 20/40 -0.50 to -0.75
 * 7th : 7 20/32 -0.50 to -0.75
 * 8th : 8 20/25 -0.25 to -0.50
 * 9th : 8 20/20 Plano to -0.25
 * total : 43
 *
 * */
public class result extends AppCompatActivity {

    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra(MainActivity.EXTRA_NUMBER,0);

        Result = (TextView) findViewById(R.id.textViewResult);
        //Result.setText(String.valueOf(result));
        switch (result){
            case 1:
                Result.setText("Your score is " +
                        "20/200" +
                        "Number: -2.00 to -2.50"); break;
            case 2:
                Result.setText("Your score is " +
                        "20/100" +
                        "Number: -1.00 to -1.25"); break;
            case 3:
                Result.setText("Your score is " +
                        "20/80" +
                        "Number: -1.00 to -1.25"); break;
            case 4:
                Result.setText("Your score is " +
                        "20/60" +
                        "Number: -1.00 to -1.25"); break;
            case 5:
                Result.setText("Your score is " +
                        "20/50" +
                        "Number: -1.00 to -1.25"); break;
            case 6:
                Result.setText("Your score is " +
                        "20/40" +
                        "Number: -0.50 to -0.75"); break;
            case 7:
                Result.setText("Your score is " +
                        "20/32" +
                        "Number: -0.50 to -0.75"); break;
            case 8:
                Result.setText("Your score is " +
                        "20/25" +
                        "Number: -0.25 to -0.50"); break;
            case 9:
                Result.setText("Your score is " +
                        "20/20" +
                        "Number: Plano to -0.25"); break;
            default:
                Result.setText("Invalid Test."); break;

        }


    }
}
