package com.garfieldchou.languagepreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView langTextView = (TextView) findViewById(R.id.langTextView);

        final SharedPreferences sharedPreferences = getSharedPreferences("com.garfieldchou.languagepreferences", Context.MODE_PRIVATE);

        langTextView.setText(sharedPreferences.getString("language selection", "Hello New World!"));

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_btn_speak_now)
                .setTitle("Choose a language")
                .setMessage("Which language would you like?")
                .setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Select English!", Toast.LENGTH_SHORT).show();
                        langTextView.setText("English");
                        sharedPreferences.edit().putString("language selection", "English").apply();
                    }
                })
                .setNegativeButton("SPANISH", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Select SPANISH!", Toast.LENGTH_SHORT).show();
                        langTextView.setText("Spanish");
                        sharedPreferences.edit().putString("language selection", "Spanish").apply();
                    }
                }).show();
    }
}
