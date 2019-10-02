package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

//        TableLayout maTable = (TableLayout) findViewById(R.id.tabScore);

        SharedPreferences sharedPreferences = getSharedPreferences("ID", Context.MODE_PRIVATE);
        ArrayList<Save> saves = new ArrayList<>();
        HashMap<String, String> preferences = (HashMap<String, String>)sharedPreferences.getAll().remove("numberOfParty");
        for (String key : preferences.keySet()){
            String score = preferences.get(key);
            saves.add(new Save(key, score));
        }
        ((ListView) findViewById(R.id.list_view)).setAdapter(new SharedPreferencesListView(saves));
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
