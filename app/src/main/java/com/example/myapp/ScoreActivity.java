package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreActivity extends AppCompatActivity {
    private String diff ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences sharedPreferences = getSharedPreferences("ID", Context.MODE_PRIVATE);
        ArrayList<Save> saves = new ArrayList<>();
        HashMap<String, String> preferences = (HashMap<String, String>)sharedPreferences.getAll();
        for (int i = 0; i <= Integer.parseInt(sharedPreferences.getString("numberOfParty", "0")); i++) {
            saves.add(new Save(preferences.get(i+"-userName"),preferences.get(i+"-scoreUser"),preferences.get(i + "-difficulty")));
        }
        ((ListView) findViewById(R.id.list_view)).setAdapter(new SharedPreferencesListView(saves.subList(0,saves.size()-1)));
    }


}
