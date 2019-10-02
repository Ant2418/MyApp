package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LooserActivity extends AppCompatActivity {

    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looser);
        Bundle b = getIntent().getExtras();
        if(b != null)
            scoreText = findViewById(R.id.scoreText);
            scoreText.setText(""+b.getInt("score"));

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.saveList.add(new Save(MainActivity.userName, Integer.parseInt(scoreText.getText().toString())));
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
