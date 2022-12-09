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

public class MainActivity5 extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        e1=(EditText)findViewById(R.id.editTextTextPersonName);
        e2=(EditText)findViewById(R.id.editTextTextEmailAddress);
        e3=(EditText)findViewById(R.id.editTextTextPassword);
        b1=(Button)findViewById(R.id.button16);
        b2=(Button)findViewById(R.id.button17);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity5.this,MainActivity2.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(MainActivity5.this, "Pls mark all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data =openOrCreateDatabase("database",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists syndicate (name varchar,email varchar,password varchar) ");
                    String s4="select * from syndicate where email='"+s2+"' and name='"+s1+"'";
                    Cursor c1=data.rawQuery(s4,null);
                    if(c1.getCount()>0){
                        Toast.makeText(MainActivity5.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        data.execSQL("insert into syndicate values ('"+s1+"' , '"+s2+"' , '"+s3+"')");
                        Toast.makeText(MainActivity5.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(MainActivity5.this,MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}
