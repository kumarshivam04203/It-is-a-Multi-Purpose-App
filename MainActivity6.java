package com.codewithabhijeet.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity6 extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        e1=(EditText) findViewById(R.id.editTextTextPersonName3);
        e2=(EditText) findViewById(R.id.editTextTextPersonName7);
        e3=(EditText) findViewById(R.id.editTextTextPersonName10);
        b1=(Button) findViewById(R.id.button21);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("raw");
                if(e1.getText().toString().isEmpty()){
                    e1.setError("required field");
                }
                else {
                    if(e2.getText().toString().isEmpty()){
                        e2.setError("required field");
                    }if(e3.getText().toString().length()!=10){
                        e3.setError("Please enter a valid phone number");
                    }else {
                        users users = new users(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                        databaseReference.child(e3.getText().toString()).setValue(users);
                        Toast.makeText(MainActivity6.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}