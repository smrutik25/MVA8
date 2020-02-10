package com.example.mva8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends BaseActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() == null) {
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        }
    }

    public void eyeTest(View view){
        Intent intent = new Intent(this, EyeTest.class);
        startActivity(intent);
    }

    public void eyeExercise(View view){
        Intent intent = new Intent(this, EyeExercise.class);
        startActivity(intent);
    }

    public void eyeScan(View view){
        Intent intent = new Intent(this, ScanEye.class);
        startActivity(intent);
    }
}
