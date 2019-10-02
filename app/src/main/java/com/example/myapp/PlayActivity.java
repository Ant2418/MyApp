package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PlayActivity extends AppCompatActivity {

    Button[] buttonsList = new Button[16];
    View referenceView;
    Boolean startedBoolean = false;
    TextView countdownText, scoreText;
    String[] colorsList = new String[16];
    String[] predefinedColorsList = {"#080708","#3772FF","#DF2935","#FDCA40"};
    String referenceColor, color;
    Integer timer = 10;
    Integer score = 0;
    Timer gameTimer;
    ProgressBar gameProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        referenceView = findViewById(R.id.referenceView);
        countdownText = findViewById(R.id.countdownText);
        gameProgressBar = findViewById(R.id.gameProgressBar);
        gameProgressBar.setProgress(100);
        scoreText = findViewById(R.id.scoreText);
        for (int i = 0; i < 16; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonsList[i] = findViewById(resID);
            color = predefinedColorsList[new Random().nextInt(predefinedColorsList.length)];
            buttonsList[i].setBackgroundColor(Color.parseColor(color));
            colorsList[i] = color;
            final Integer index = i;
            buttonsList[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!startedBoolean){
                        startedBoolean = true;
                        launchTimer();
                    } else {
                        setRefreshedTime(referenceColor,colorsList[index]);
                    }
                    String color = predefinedColorsList[new Random().nextInt(predefinedColorsList.length)];
                    buttonsList[index].setBackgroundColor(Color.parseColor(color));
                    colorsList[index] = color;
                    GradientDrawable drawable = (GradientDrawable)referenceView.getBackground();
                    referenceColor = getRandomColor(colorsList);
                    drawable.setColor(Color.parseColor(referenceColor));
                }
            });
        }
    }

    public String getRandomColor(String[] colorsList){
        String[] colorsSet = new HashSet<>(Arrays.asList(colorsList)).toArray(new String[0]);
        int rnd = new Random().nextInt(colorsSet.length);
        return colorsSet[rnd];
    }

    public void setRefreshedTime(String referenceColor, String caseColor){
        if (referenceColor.equals(caseColor)){
            timer += 1;
            score +=3;
        } else {
            score -=1;
        }
        scoreText.setText(""+score);
    }

    public void launchTimer () {
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        timer=timer-1;
                        gameProgressBar.setProgress((timer*100)/10);
                        if (timer <= 0) {
                            Intent myIntent = new Intent(PlayActivity.this, LooserActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score);
                            myIntent.putExtras(b);
                            PlayActivity.this.startActivity(myIntent);
                            countdownText.setText(R.string.looser);
                            gameTimer.cancel();
                            gameTimer.purge();
                            PlayActivity.this.finish();
                        } else {
                            countdownText.setText(""+timer);
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}
