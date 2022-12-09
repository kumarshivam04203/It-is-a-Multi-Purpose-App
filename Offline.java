package com.codewithabhijeet.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Offline extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);

        e1=(EditText)findViewById(R.id.editTextTextEmailAddress3);
        e2=(EditText)findViewById(R.id.editTextTextPassword2);
        b1=(Button)findViewById(R.id.button18);
        b2=(Button)findViewById(R.id.button19);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Offline.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(Offline.this, "Pls mark all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("database",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists syndicate (name varchar,email varchar,password varchar)");
                    String s3="select * from syndicate where email='"+s1+"' and password='"+s2+"'";
                    Cursor c1=data.rawQuery(s3,null);
                    if(c1.getCount()>0){
                        Toast.makeText(Offline.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(Offline.this,MainActivity.class);
                        j.putExtra("result",s1);
                        startActivity(j);
                        finish();
                    }else{
                        Toast.makeText(Offline.this, "invalid data pls try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
