package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TableLayout maTable = (TableLayout) findViewById(R.id.tabScore);
        TableRow row = new TableRow(this);
        TextView tv = new TextView(this);
        tv.setText("This is text");

        maTable.addView(row);
        row.addView(tv);

    }


}
