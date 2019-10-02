package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView monTextView;
    EditText monEditText;
    static User theUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monEditText = findViewById(R.id.editTextPseudo);
        monTextView = findViewById(R.id.textViewPseudo);

        Button playButton = findViewById(R.id.buttonStart);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                theUser = new User(monEditText.getText().toString());
                Intent myIntent = new Intent(MainActivity.this, PlayActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button scoreButton = findViewById(R.id.buttonScore);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Score.class);
                MainActivity.this.startActivity(myIntent);
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