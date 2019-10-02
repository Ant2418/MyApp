package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static String userName;
    static String difficulty;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        //TODO Refaire apparaitre la difficulté et l'username quand on rejoue à la page d'accueil
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SeekBar)findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        ((TextView)findViewById(R.id.difficultyText)).setText(R.string.easy);
                        break;
                    case 1:
                        ((TextView)findViewById(R.id.difficultyText)).setText(R.string.medium);
                        break;
                    case 2:
                        ((TextView)findViewById(R.id.difficultyText)).setText(R.string.hard);
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        findViewById(R.id.buttonLight).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               /* SharedPreferences pref = getSharedPreferences("cleTheme", MODE_PRIVATE);
                if (pref.contains("cleTheme")){
                    getApplicationContext().getTheme()
                    getApplicationContext().setTheme(getApplicationContext().getTheme().getResourcesId());
                }*/
                getApplicationContext().setTheme(R.style.AppDark);
                onCreate(savedInstanceState);
                /*Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(myIntent);*/
            }
        });

        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                difficulty = String.valueOf(((SeekBar)findViewById(R.id.seekBar)).getProgress());
                userName = ((EditText)findViewById(R.id.editTextPseudo)).getText().toString();
                Intent myIntent = new Intent(MainActivity.this, PlayActivity.class);
                MainActivity.this.startActivity(myIntent);
                MainActivity.this.finish();
            }
        });

        findViewById(R.id.buttonScore).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                MainActivity.this.startActivity(myIntent);
                MainActivity.this.finish();
            }
        });

        TextWatcher monTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((TextView)findViewById(R.id.textViewPseudo)).setText(((EditText)findViewById(R.id.editTextPseudo)).getText());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        };

        ((EditText)findViewById(R.id.editTextPseudo)).addTextChangedListener(monTextWatcher);
    }
}