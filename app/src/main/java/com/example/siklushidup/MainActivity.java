package com.example.siklushidup;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText komentext;
    private static final String SAVED_TEXT_KEY = "SAVED_TEXT_KEY";
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        komentext = (EditText) findViewById(R.id.komen);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        komentext.setText(prefs.getString(SAVED_TEXT_KEY,""));

    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Siklus hidup onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "Siklus hidup onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "Siklus hidup onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Siklus hidup onStop",Toast.LENGTH_LONG).show();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SAVED_TEXT_KEY,komentext.getText().toString());
        editor.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_TEXT_KEY, komentext.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        komentext.setText(savedInstanceState.getString(SAVED_TEXT_KEY));
    }
}