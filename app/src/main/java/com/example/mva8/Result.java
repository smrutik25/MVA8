package com.example.mva8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


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
public class Result extends AppCompatActivity {

    TextView Result;
    EditText Name,Age;
    Button Submit;
    String res,number;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Name = findViewById(R.id.name);
        Age = findViewById(R.id.age);
        Submit = findViewById(R.id.button);

        db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        int result = intent.getIntExtra(EyeTest.EXTRA_NUMBER,0);

        Result = (TextView) findViewById(R.id.textViewResult);
        //Result.setText(String.valueOf(Result));
        switch (result){
            case 1:
                res = "20/200";
                number = "-2.00 to -2.50";
                break;
            case 2:
                res = "20/100";
                number = "-1.00 to -1.25";
                break;
            case 3:
                res = "20/80";
                number = "-1.00 to -1.25";
                break;
            case 4:
                res = "20/60";
                number = "-1.00 to -1.25";
                break;
            case 5:
                res = "20/50";
                number = "-1.00 to -1.25";
                break;
            case 6:
                res = "20/40";
                number = "-0.50 to -0.75";
                break;
            case 7:
                res = "20/32";
                number = "-0.50 to -0.75";
                break;
            case 8:
                res = "20/25";
                number = "-0.25 to -0.50";
                break;
            case 9:
                res = "20/20";
                number = "Plano to -0.25";
                break;
            default:
                Result.setText("Invalid Test.");
                break;

        }
        Result.setText("Score: "+res+"\nNumber: "+number);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName, ageYears;
                fullName = Name.getText().toString().trim();
                ageYears = Age.getText().toString().trim();

                Map<String,Object> checkup = new HashMap<>();
                checkup.put("name",fullName);
                checkup.put("age", ageYears);
                checkup.put("result",res);
                checkup.put("number",number);

                db.collection("Checkups").document().set(checkup);
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
