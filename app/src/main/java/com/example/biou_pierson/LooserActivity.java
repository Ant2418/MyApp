package com.example.biou_pierson;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class LooserActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    /**
     * OnCreate of LooserActivity
     * All methods to run the LooserActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looser);

        ((KonfettiView)findViewById(R.id.viewKonfetti)).build()
                .addColors(Color.parseColor("#080708"), Color.parseColor("#3772FF"), Color.parseColor("#DF2935"), Color.parseColor("#FDCA40"))
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, findViewById(R.id.viewKonfetti).getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);

        ValueAnimator animator = ValueAnimator.ofInt(0, getIntent().getExtras().getInt("score"));
        animator.setDuration(4000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ((TextView) findViewById(R.id.scoreText)).setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();

        sharedPreferences = getSharedPreferences("ID", MODE_PRIVATE);
        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString(sharedPreferences.getString("numberOfParty", "0")+"-userName", MainActivity.userName).apply();
                sharedPreferences.edit().putString(sharedPreferences.getString("numberOfParty", "0")+"-scoreUser", String.valueOf(getIntent().getExtras().getInt("score"))).apply();
                sharedPreferences.edit().putString(sharedPreferences.getString("numberOfParty", "0")+"-difficulty", MainActivity.difficulty).apply();
                sharedPreferences.edit().putString("numberOfParty", String.valueOf(Integer.parseInt(sharedPreferences.getString("numberOfParty", "0"))+1)).apply();
                Intent myIntent = new Intent(LooserActivity.this, MainActivity.class);
                LooserActivity.this.startActivity(myIntent);
                Toast.makeText(getApplicationContext(), R.string.saved, Toast.LENGTH_SHORT).show();
                LooserActivity.this.finish();
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
