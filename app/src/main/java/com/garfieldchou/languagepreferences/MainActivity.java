package com.garfieldchou.languagepreferences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView langTextView;

    public void updatePreferences (String language) {

        Toast.makeText(MainActivity.this, "Select " + language + " !", Toast.LENGTH_SHORT).show();
        langTextView.setText(language);
        sharedPreferences.edit().putString("language selection", language).apply();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = this.getMenuInflater();

        menuInflater.inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        langTextView = (TextView) findViewById(R.id.langTextView);

        sharedPreferences = getSharedPreferences("com.garfieldchou.languagepreferences", Context.MODE_PRIVATE);

        langTextView.setText(sharedPreferences.getString("language selection", "Hello New World!"));

        if (langTextView.getText() == "Hello New World!") {

            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("Choose a language")
                    .setMessage("Which language would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            updatePreferences("English");
                        }
                    })
                    .setNegativeButton("SPANISH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            updatePreferences("Spanish");
                        }
                    }).show();
        }
    }
}
