package com.example.tumblingechart;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    Button Yes;
    Button No;
    Button Reset;
    Button End;
    TextView Right;
    TextView Wrong;


    public static final String EXTRA_NUMBER = "Random";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Yes = (Button) findViewById(R.id.buttonYes);
        No = (Button) findViewById(R.id.buttonNo);
        Reset = (Button) findViewById(R.id.buttonReset);
        End = (Button) findViewById(R.id.buttonEnd);

        Right = (TextView) findViewById(R.id.textViewYes);
        Wrong = (TextView) findViewById(R.id.textViewNo);

        ViewPager viewPager = findViewById(R.id.VP);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);

        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = Right.getText().toString();
                int b = Integer.parseInt(a);
                b = b+1;
                Right.setText(String.valueOf(b));
            }
        });

        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String c = Wrong.getText().toString();
                int d = Integer.parseInt(c);
                d = d+1;
                Wrong.setText(String.valueOf(d));
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Right.setText("0");
                Wrong.setText("0");
                counter = counter +1;
            }
        });

        End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResult();
            }
        });
    }

    public void openResult() {
        Intent intent = new Intent(this,result.class);
        intent.putExtra(EXTRA_NUMBER,counter);
        startActivity(intent);
    }


}
