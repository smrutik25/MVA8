package com.example.mva8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class Profile extends BaseActivity {
    TextView fullName,email,phone;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    String TAG="TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        fullName = findViewById(R.id.name);
        email    = findViewById(R.id.email);
        phone = findViewById(R.id.phno);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();
/*
        fStore.collection("Users").document(userId).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                Log.d(TAG,document.getData().toString());
                                String name = document.getString("name");
                                String eid = document.getString("email");
                                String phno = document.getString("phone");
                                fullName.setText(name);
                                email.setText(eid);
                                phone.setText(phno);
                            } else {
                                Log.d(TAG, "No such document");
                            }
                        } else {
                            Log.d(TAG, "get failed with ", task.getException());
                        }
                    }
                });*/

        fStore.collection("Users").document(userId).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String name = documentSnapshot.getString("name");
                        String eid = documentSnapshot.getString("email");
                        String phno = documentSnapshot.getString("phone");
                        fullName.setText(name);
                        email.setText(eid);
                        phone.setText(phno);
                    }
                });
    }
}
