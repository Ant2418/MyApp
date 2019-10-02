package com.example.myapp;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    TextView countdownText, scorelabelText, scoreText;
    String[] colorsList = new String[16];
    String[] predefinedcolorsList = {"#080708","#3772FF","#DF2935","#FDCA40"};
    String referenceColor, color;
    Integer timer = 10;
    Integer score = 0;
    Timer gameTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        referenceView = (View) findViewById(R.id.referenceView);
        countdownText = (TextView) findViewById(R.id.countdownText);
        scoreText = (TextView) findViewById(R.id.scoreText);
        for (int i = 0; i < 16; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonsList[i] = (Button) findViewById(resID);
            color = predefinedcolorsList[new Random().nextInt(predefinedcolorsList.length)];
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
                    String color = predefinedcolorsList[new Random().nextInt(predefinedcolorsList.length)];
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
        String[] colorsSet = new HashSet<String>(Arrays.asList(colorsList)).toArray(new String[0]);
        int rnd = new Random().nextInt(colorsSet.length);
        return colorsSet[rnd];
    }

    public void setRefreshedTime(String referenceColor, String caseColor){
        if (referenceColor.equals(caseColor)){
            timer += 1;
            score +=3;
            scoreText.setText(""+score);
        }
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
                        if (timer <= 0) {
                            countdownText.setText("Looser!");
                            gameTimer.cancel();
                            gameTimer.purge();
                        } else {
                            countdownText.setText(""+timer);
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}
