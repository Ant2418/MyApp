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

    public void todo(){
        // TODO revoir l'affichage de score (mettre la colonne de difficulter)
        // TODO bloquer le retour en arrière après l'enregistrement
        // TODO ne pas bloquer après la vue du score
        // TODO revoir activity_name layout -> logo et bouton dépassent
        // TODO dark mode ? TU LE FAIS PAS j'ai tout enlever, juste si tu peux enlever le paramétrage des couleurs du mode dans les xml stppp
    }
}