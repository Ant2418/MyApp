package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                sharedPreferences.edit().putString(sharedPreferences.getString("numberOfParty", "0")+"-userName", MainActivity.userName).apply();
                sharedPreferences.edit().putString(sharedPreferences.getString("numberOfParty", "0")+"-scoreUser", String.valueOf(getIntent().getExtras().getInt("score"))).apply();
                sharedPreferences.edit().putString("numberOfParty", String.valueOf(Integer.parseInt(sharedPreferences.getString("numberOfParty", "0"))+1)).apply();
                Intent myIntent = new Intent(LooserActivity.this, MainActivity.class);
                LooserActivity.this.startActivity(myIntent);
                Toast.makeText(getApplicationContext(), R.string.saved, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(LooserActivity.this, MainActivity.class);
                LooserActivity.this.startActivity(myIntent);
                LooserActivity.this.finish();
            }
        });
    }
}
