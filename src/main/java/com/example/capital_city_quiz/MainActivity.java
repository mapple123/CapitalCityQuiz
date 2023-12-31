package com.example.capital_city_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStarten, btnHighscore, btnBeenden;
    private static MainActivity main;
    protected static DBZugriff db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = this;
        db = new DBZugriff(this, "HighscoreListe");
        btnStarten = (Button) findViewById(R.id.buttonStarten);
        btnHighscore = (Button) findViewById(R.id.buttonHighscore);
        btnBeenden = (Button) findViewById(R.id.buttonBeenden);
        btnStarten.setOnClickListener(this);
        btnHighscore.setOnClickListener(this);
        btnBeenden.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnStarten){
            Intent intent = new Intent(this, Quiz.class);
            startActivity(intent);
            new Fragen();
        }else if(view == btnBeenden){
            finish();
        }else if(view == btnHighscore){
            Intent intent = new Intent(this, HighscoreActivity.class);
            startActivity(intent);
        }
    }

    public static MainActivity getInstance(){
        return main;
    }
}
