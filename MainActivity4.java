package com.codewithabhijeet.netcampproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class MainActivity4 extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText e1,e2;
    ProgressBar p1;
    Button b1,b2,b3;
    FirebaseAuth firebaseAuth;

    String phone;
    String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ccp = (CountryCodePicker) findViewById(R.id.countryCodePicker);
        e1=(EditText)findViewById(R.id.editTextPhone);
        e2=(EditText) findViewById(R.id.editTextTextPersonName2);
        p1=(ProgressBar) findViewById(R.id.progressBar3);
        b1=(Button) findViewById(R.id.button12);
        b2=(Button) findViewById(R.id.button13);
        b3=(Button) findViewById(R.id.button15);
        firebaseAuth=FirebaseAuth.getInstance();

        ccp.registerCarrierNumberEditText(e1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MainActivity4.this,MainActivity2.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone=ccp.getFullNumberWithPlus().trim();
                getOtp();

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(e1.getText().toString().isEmpty())
                    e1.setError("required");
                else {
                    if(e2.getText().toString().length()!=6){
                        e2.setError("otp length mismatch");
                    }
                        else{
                            PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e2.getText().toString());
                            signInWithPhoneAuthCredential(credential);
                        }
                    }
                }
            });
        }
        private void getOtp(){
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phone,
                    60,
                    TimeUnit.SECONDS,
                    this,
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            super.onCodeSent(s, forceResendingToken);
                            otp=s;
                        }

                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            signInWithPhoneAuthCredential(phoneAuthCredential);
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Toast.makeText(MainActivity4.this, "Internet connection required", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }
        private  void  signInWithPhoneAuthCredential(PhoneAuthCredential credential){
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity4.this, "login success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity4.this,MusicPlayer.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity4.this, "Verification failed ", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
