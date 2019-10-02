package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LooserActivity extends AppCompatActivity {

    TextView scoreText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looser);
        scoreText = findViewById(R.id.scoreText);
        scoreText.setText(String.valueOf(getIntent().getExtras().getInt("score")));

        sharedPreferences = getSharedPreferences("ID", MODE_PRIVATE);
        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("userName", MainActivity.userName).apply();
                sharedPreferences.edit().putString("scoreUser", String.valueOf(getIntent().getExtras().getInt("score"))).apply();
                //MainActivity.saveList.add(new Save(MainActivity.userName, Integer.parseInt(scoreText.getText().toString())));
                Intent myIntent = new Intent(LooserActivity.this, MainActivity.class);
                LooserActivity.this.startActivity(myIntent);
            }
        });

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(LooserActivity.this, MainActivity.class);
                LooserActivity.this.startActivity(myIntent);
                LooserActivity.this.finish();
            }
        });
    }
}
