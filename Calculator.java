package com.codewithabhijeet.netcampproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        t1=(TextView)findViewById(R.id.textView10);
        t2=(TextView)findViewById(R.id.textView11);
        t3=(TextView)findViewById(R.id.textView12);

        b1=(Button) findViewById(R.id.button23);
        b2=(Button) findViewById(R.id.button24);
        b3=(Button) findViewById(R.id.button25);
        b4=(Button) findViewById(R.id.button26);
        b5=(Button) findViewById(R.id.button27);
        b6=(Button) findViewById(R.id.button28);
        b7=(Button) findViewById(R.id.button29);
        b8=(Button) findViewById(R.id.button30);
        b9=(Button) findViewById(R.id.button31);
        b10=(Button) findViewById(R.id.button32);
        b11=(Button) findViewById(R.id.button33);
        b12=(Button) findViewById(R.id.button34);
        b13=(Button) findViewById(R.id.button35);
        b14=(Button) findViewById(R.id.button36);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("7");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("9");
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText("0");
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = t2.getText().toString();
                String s2 =t2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1+i2;
                String s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = t2.getText().toString();
                String s2 =t3.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1-i2;
                String s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = t2.getText().toString();
                String s2 =t2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1*i2;
                String s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = t2.getText().toString();
                String s2 =t2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1/i2;
                String s3=Integer.toString(i3);
                t1.setText(s3);
            }
        });
    }
}