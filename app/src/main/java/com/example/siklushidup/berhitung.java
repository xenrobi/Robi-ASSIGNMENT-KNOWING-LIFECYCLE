package com.example.siklushidup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class berhitung extends AppCompatActivity{

    EditText angka1,angka2,output;
            double param1,param2,hasil;
    Button btntmbh,btnkrg,btnbgi,btnprs,btnpkt,btnclr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhitung);
        addListeneronButtonClick();
    }
    public boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
    public void konversi(){
            if(isEmpty((angka1))){
                param1 = 0;
            }else{
                param1 = Double.parseDouble(angka1.getText().toString());
            }
            if (isEmpty((angka2))) {
                param2 = 0;
            }else{
                param2 = Double.parseDouble(angka2.getText().toString());
            }
        }


    private void addListeneronButtonClick() {
        btntmbh = (Button) findViewById(R.id.btntmbh);
        btnkrg = (Button) findViewById(R.id.btnkrg);
        btnprs = (Button) findViewById(R.id.btnprs);
        btnbgi = (Button) findViewById(R.id.btnbagi);
        btnpkt = (Button) findViewById(R.id.btnmod);
        btnclr = (Button) findViewById(R.id.btnclear);
        angka1 = (EditText) findViewById(R.id.int1);
        angka2 = (EditText) findViewById(R.id.int2);
        output = (EditText) findViewById(R.id.hasil);

        btntmbh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                konversi();
                hasil   = param1+param2;
                output.setText(Double.toString((hasil)));
            }
        });

        btnkrg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                konversi();
                hasil   = param1-param2;
                output.setText(Double.toString((hasil)));
            }
        });

        btnbgi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                konversi();
                hasil   = param1/param2;
                output.setText(Double.toString((hasil)));
            }
        });


        btnpkt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                konversi();
                hasil   = (param1+param2)*(param1+param2);
                output.setText(Double.toString((hasil)));
            }
        });

        btnprs.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                konversi();
                int a1 = Integer.parseInt(angka1.getText().toString());
                int a2 = Integer.parseInt(angka2.getText().toString());
                int total= a1*a2;
                hasil   = total/100;
                output.setText(Double.toString((hasil)));
            }
        });

        btnclr.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                angka1.setText("");
                angka2.setText("");
                output.setText("");
            }
        });
    }



    }