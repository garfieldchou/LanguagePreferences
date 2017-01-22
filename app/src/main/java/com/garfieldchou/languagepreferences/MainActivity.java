package com.garfieldchou.languagepreferences;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView textView;

    public void setLanguage(String language) {

        sharedPreferences.edit().putString("language", language).apply();

        textView.setText(language);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.garfieldchou.languagepreferences", Context.MODE_PRIVATE);

        textView = (TextView) findViewById(R.id.textView);

        String language = sharedPreferences.getString("language", "");

        if (language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("Choose a language")
                    .setMessage("Which language would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("English");

                        }
                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            setLanguage("Spanish");

                        }
                    })
                    .show();
        } else {

            textView.setText(language);

        }
    }
}
