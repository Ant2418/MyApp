package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView monTextView;
    EditText monEditText;
    static String userName;
    String leTheme;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monEditText = findViewById(R.id.editTextPseudo);
        monTextView = findViewById(R.id.textViewPseudo);

        Button darkButton = findViewById(R.id.buttonLight);
        darkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               /* SharedPreferences pref = getSharedPreferences("cleTheme", MODE_PRIVATE);
                if (pref.contains("cleTheme")){
                    getApplicationContext().getTheme()
                    getApplicationContext().setTheme(getApplicationContext().getTheme().getResourcesId());
                }*/
                System.out.println(getApplicationContext().getTheme().toString());
                getApplicationContext().setTheme(R.style.AppDark);
                onCreate(savedInstanceState);
                System.out.println(getApplicationContext().getTheme().toString());
                /*Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(myIntent);*/
            }
        });


        Button playButton = findViewById(R.id.buttonStart);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                userName = monEditText.getText().toString();
                Intent myIntent = new Intent(MainActivity.this, PlayActivity.class);
                MainActivity.this.startActivity(myIntent);
                MainActivity.this.finish();
            }
        });


        Button scoreButton = findViewById(R.id.buttonScore);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                MainActivity.this.startActivity(myIntent);
                MainActivity.this.finish();
            }
        });

        TextWatcher monTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                monTextView.setText(monEditText.getText());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        
        monEditText.addTextChangedListener(monTextWatcher);

    }
}