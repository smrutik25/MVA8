package com.example.mva8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BookAppointment extends AppCompatActivity {

    Button btn;
    EditText name,age,phone,location,date;
    FirebaseFirestore db;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appointment);

        db = FirebaseFirestore.getInstance();
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        btn = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        location = findViewById(R.id.location);
        date = findViewById(R.id.date);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName, ageYears, phno, place, dateOfAppointment;
                fullName = name.getText().toString().trim();
                ageYears = age.getText().toString().trim();
                phno = phone.getText().toString().trim();
                place = location.getText().toString().trim();
                dateOfAppointment = date.getText().toString();

                Map<String,Object> appointment = new HashMap<>();
                appointment.put("name",fullName);
                appointment.put("age", ageYears);
                appointment.put("phone",phno);
                appointment.put("location",place);
                appointment.put("date",dateOfAppointment);
                appointment.put("madeBy",userId);

                db.collection("Appointments").document().set(appointment);
                Intent intent = new Intent(BookAppointment.this, MainActivity.class);
                startActivity(intent);
            }
        });
        }

}
