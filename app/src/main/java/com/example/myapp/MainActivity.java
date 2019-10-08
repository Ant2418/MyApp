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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String userName; // name of user
    static String difficulty; // game difficulty

    /**
     * onCreate of MainActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        //TODO Refaire apparaitre la difficulté et l'username quand on rejoue à la page d'accueil
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SeekBar)findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                difficulty = String.valueOf(progress);
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

        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                difficulty = String.valueOf(((SeekBar)findViewById(R.id.seekBar)).getProgress());
                userName = ((EditText)findViewById(R.id.editTextPseudo)).getText().toString();
                if (userName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.no_username, Toast.LENGTH_SHORT).show();
                } else {
                    Intent myIntent = new Intent(MainActivity.this, PlayActivity.class);
                    MainActivity.this.startActivity(myIntent);
                    MainActivity.this.finish();
                }
            }
        });

        findViewById(R.id.buttonScore).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        TextWatcher monTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((TextView)findViewById(R.id.textViewPseudo)).setText(String.valueOf(getResources().getText(R.string.hello))+" "+((EditText)findViewById(R.id.editTextPseudo)).getText());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        };

        ((EditText)findViewById(R.id.editTextPseudo)).addTextChangedListener(monTextWatcher);
    }
}