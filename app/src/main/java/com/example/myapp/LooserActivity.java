package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LooserActivity extends AppCompatActivity {

    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looser);
        Bundle b = getIntent().getExtras();
        if(b != null)
            scoreText.setText(""+b.getInt("score"));
    }
}
