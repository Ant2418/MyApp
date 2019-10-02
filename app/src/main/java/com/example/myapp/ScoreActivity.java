package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TableLayout maTable = (TableLayout) findViewById(R.id.tabScore);
        /**TableRow row = new TableRow(this);
        TextView tv = new TextView(this);
        tv.setText("This is text");

        maTable.addView(row);
        row.addView(tv);

         table = (TableLayout)findViewById(R.id.mytable);

         for(int i=0;i<data.size();i++)
         {
         TableRow row=new TableRow(this);
         String phone = data.get(i);
         String amount = data1.get(i);
         TextView tv1=new TextView(this);
         tv1.setText(phone);
         TextView tv2=new TextView(this);
         tv2.setText(amount);
         row.addView(tv1);
         row.addView(tv2);
         table.addView(row);
         }

         */

    }


}
