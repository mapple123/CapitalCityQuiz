package com.example.capital_city_quiz;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HighscoreActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLoeschen, btnZureuckzumHauptmenue;
    private ListView lv;
    protected static CustomArrayAdapter myArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        lv = (ListView) findViewById(R.id.listView);
        DBZugriff db = MainActivity.db;
        int ArraySizeScore = db.leseDatensaetzeHighscore().size();
        // Beispieldaten in einer ArrayList
        myArrayAdapter = new CustomArrayAdapter(this, R.id.textViewRowName, db.leseDatensaetzeHighscore());
        lv.setAdapter(myArrayAdapter);
    }

    @Override
    public void onClick(View view) {

    }
}
