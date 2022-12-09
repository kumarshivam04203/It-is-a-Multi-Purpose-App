package com.codewithabhijeet.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputBinding;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {

    Button b8,b9;
    EditText e1,e2,e3;
    FirebaseAuth firebaseAuth;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9) ;
        p1=(ProgressBar)findViewById(R.id.progressBar);
        e1=(EditText)findViewById(R.id.editTextTextPersonName4);
        e2=(EditText)findViewById(R.id.editTextTextPersonName5);
        e3=(EditText)findViewById(R.id.editTextTextPersonName6);
        firebaseAuth=FirebaseAuth.getInstance();

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(j);
                finish();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                String s3=e3.getText().toString();

                if(s1.isEmpty())
                    e1.setError("required field");
                if(s2.isEmpty())
                    e2.setError("required field");
                else{
                    if(s3.isEmpty())
                        e3.setError("required field");
                    else
                        p1.setVisibility(View.VISIBLE);
                        firebaseAuth.createUserWithEmailAndPassword(s2,s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity3.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent j = new Intent(MainActivity3.this,MainActivity.class);
                                    startActivity(j);
                                    finish();
                                }
                                else{
                                    Toast.makeText(MainActivity3.this, "Something went wrong pls try again!", Toast.LENGTH_SHORT).show();
                                    p1.setVisibility(View.INVISIBLE);
                                }
                            }
                        });

                }
            }
        });

    }
}