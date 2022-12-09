package com.codewithabhijeet.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Email extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    FirebaseAuth firebaseAuth;
    ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        b1=(Button)findViewById(R.id.button10);
        b2=(Button)findViewById(R.id.button11) ;
        p1=(ProgressBar)findViewById(R.id.progressBar2);
        firebaseAuth=FirebaseAuth.getInstance();
        e2=(EditText)findViewById(R.id.editTextTextPersonName8);
        e3=(EditText)findViewById(R.id.editTextTextPersonName9);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Email.this,MainActivity2.class);
                startActivity(j);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                e3.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

                if(s2.isEmpty())
                    e1.setError("required field");
                else{
                    if(s3.isEmpty())
                        e3.setError("required field");
                    else
                        p1.setVisibility(View.VISIBLE);
                    firebaseAuth.signInWithEmailAndPassword(s2,s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                p1.setVisibility(View.INVISIBLE);
                                Toast.makeText(Email.this, "Login success", Toast.LENGTH_SHORT).show();
                                Intent j = new Intent(Email.this,MainActivity.class);
                                startActivity(j);
                                finish();
                            }
                            else{
                                Toast.makeText(Email.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                                p1.setVisibility(View.INVISIBLE);
                            }
                        }
                    });

                }
            }
        });

    }
}