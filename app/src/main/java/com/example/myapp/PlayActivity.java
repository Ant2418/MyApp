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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PlayActivity extends AppCompatActivity {

    Button[] buttonsList = new Button[16];
    Boolean startedBoolean = false;
    String[] colorsList = new String[16];
    String referenceColor, color;
    String[] easyParameters = {"60","#080708","#3772FF","#DF2935","#FDCA40"};
    String[] mediumParameters = {"40","#080708","#3772FF","#DF2935","#FDCA40","#9BC53D","#E83F6F"};
    String[] hardParameters = {"1","#080708","#3772FF","#DF2935","#FDCA40","#9BC53D","#E83F6F","#32936F","#FF6700"};
    Map<String, String[]> difficultyParameters = new HashMap<String, String[]>() {{
        put("0", easyParameters);
        put("1", mediumParameters);
        put("2", hardParameters);
    }};
    Integer maxTime = Integer.parseInt(difficultyParameters.get(MainActivity.difficulty)[0]);
    Integer timer = maxTime;
    Integer score = 0;
    Timer gameTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        for (int i = 0; i < 16; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonsList[i] = findViewById(resID);
            color = difficultyParameters.get(MainActivity.difficulty)[new Random().nextInt(difficultyParameters.get(MainActivity.difficulty).length - 1)+ 1];
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
                    String color = difficultyParameters.get(MainActivity.difficulty)[new Random().nextInt(difficultyParameters.get(MainActivity.difficulty).length - 1)+ 1];
                    buttonsList[index].setBackgroundColor(Color.parseColor(color));
                    colorsList[index] = color;
                    GradientDrawable drawable = (GradientDrawable)findViewById(R.id.referenceView).getBackground();
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
        ((TextView)findViewById(R.id.scoreText)).setText(String.valueOf(score));
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
                        ((ProgressBar)findViewById(R.id.gameProgressBar)).setProgress((timer*100)/maxTime);
                        if (timer <= 0) {
                            Intent myIntent = new Intent(PlayActivity.this, LooserActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score);
                            myIntent.putExtras(b);
                            PlayActivity.this.startActivity(myIntent);
                            gameTimer.cancel();
                            gameTimer.purge();
                            PlayActivity.this.finish();
                        } else if (timer >= maxTime){
                            timer = maxTime;
                        }
                        ((TextView)findViewById(R.id.countdownText)).setText(String.valueOf(timer));
                    }
                });
            }
        }, 0, 1000);
    }
}
