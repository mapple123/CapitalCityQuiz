package com.example.capital_city_quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.capital_city_quiz.FrageChange.myTimer;
import static com.example.capital_city_quiz.Fragen.alFragenSizeCounter;

public class EndeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvPunkteFest, tvPunkte;
    private EditText etName;
    private Button btnSpeichern, btnZurueck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ende);
        tvPunkteFest = (TextView) findViewById(R.id.textViewScore);
        tvPunkte = (TextView) findViewById(R.id.textViewScore2);
        etName = (EditText) findViewById(R.id.editTextName);
        btnSpeichern = (Button) findViewById(R.id.buttonScoreSpeichern);
        btnZurueck = (Button) findViewById(R.id.buttonZurueckzumHauptmenue);
        tvPunkte.setText("" + Quiz.punkte);
        btnSpeichern.setOnClickListener(this);
        btnZurueck.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnSpeichern){
            String name = etName.getText().toString();

            if (!tvPunkte.getText().toString().trim().equals("") && !name.trim().equals("")){
                int punkte = Integer.parseInt(tvPunkte.getText().toString());
                HighscoreListe highscoreListe = new HighscoreListe(name,punkte);
                MainActivity.db.datensatzEinfügenHighscore(highscoreListe);
                Toast.makeText(this, "Erfolgreich gespeichert", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Name muss eingegeben werden", Toast.LENGTH_SHORT).show();
            }
        }else if(view == btnZurueck){
            Quiz.punkte = 0;
            Quiz.getInstance().finish();
            finish();
        }
    }
    @Override
    public void onBackPressed()
    {
        myTimer.cancel();
        finish();
        alFragenSizeCounter = 0;
        Quiz.punkte = 0;
        super.onBackPressed();
    }
}
