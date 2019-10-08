package com.example.myapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.view.LayoutInflaterCompat;

import com.example.myapp.R;

import java.util.List;

public class SharedPreferencesListView extends BaseAdapter {

    private List<Save> preferences;

    public SharedPreferencesListView(List<Save> thePreferences){
        preferences = thePreferences;
    }


    @Override
    public int getCount() {
        return preferences.size();
    }

    @Override
    public Save getItem(int i) {
        return preferences.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.list_item, viewGroup, false);
        }

        ((TextView)view.findViewById(R.id.userName)).setText(preferences.get(i).getUserName());
        ((TextView)view.findViewById(R.id.score)).setText(String.valueOf(preferences.get(i).getScoreUser()));
        switch (String.valueOf(preferences.get(i).getDifficulty())){
            case "0":
                ((TextView)view.findViewById(R.id.userDifficulty)).setText(R.string.easy);
                break;
            case "1":
                ((TextView)view.findViewById(R.id.userDifficulty)).setText(R.string.medium);
                break;
            case "2":
                ((TextView)view.findViewById(R.id.userDifficulty)).setText(R.string.hard);
                break;
        }
        return view;
    }

    protected void onCreate(Bundle savedInstanceState) {

    }


}