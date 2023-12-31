package com.example.capital_city_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.capital_city_quiz.FrageChange.myTimer;
import static com.example.capital_city_quiz.Fragen.alFragenSizeCounter;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    public static int loesung;
    protected static TextView tvFrage, tvZeit, tvFragenCount, tvPunkte;
    private static RadioButton auswahl1, auswahl2, auswahl3, auswahl4;
    private Button btnWeiter;
    private static Quiz quiz;
    protected static int punkte = 0;
    private  boolean countPunkte = true;
    private DBZugriff db = MainActivity.db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tvZeit = (TextView) findViewById(R.id.textViewZeit);
        tvPunkte = (TextView) findViewById(R.id.textViewPunkte);
        tvFrage = (TextView) findViewById(R.id.textViewFrage);
        tvFragenCount = (TextView) findViewById(R.id.textViewFragenCount);
        auswahl1 = (RadioButton) findViewById(R.id.radioButtonAntwort1);
        auswahl2 = (RadioButton) findViewById(R.id.radioButtonAntwort2);
        auswahl3 = (RadioButton) findViewById(R.id.radioButtonAntwort3);
        auswahl4 = (RadioButton) findViewById(R.id.radioButtonAntwort4);
        btnWeiter = (Button) findViewById(R.id.buttonWeiter);
        btnWeiter.setOnClickListener(this);
        auswahl1.setChecked(true);
        quiz = this;
        tvPunkte.setText("Punkte: " + punkte);
        new FrageChange();
    }

    public static void changeRadiobuttonsText(int button, String text) {
        switch(button) {
            case 1: auswahl1.setText(text);
                break;
            case 2: auswahl2.setText(text);
                break;
            case 3: auswahl3.setText(text);
                break;
            case 4: auswahl4.setText(text);
                break;
        }

    }

    public static void changeLabelText(String text) {
        tvFrage.setText(text);
    }

    @Override
    public void onClick(View view) {
        if(view == btnWeiter){
            myTimer.cancel();
            changeTextColorFromRadioButtons();
            if(loesung == 1 && auswahl1.isChecked()) {
                new FrageChange();
                spielLogik();
            }
            else
            if(loesung == 2 && auswahl2.isChecked()) {
                new FrageChange();
                spielLogik();
            }else
            if(loesung == 3 && auswahl3.isChecked()) {
                new FrageChange();
                spielLogik();
            }else
            if(loesung == 4 && auswahl4.isChecked()) {
                new FrageChange();
                spielLogik();
            }else {
                if(loesung == 1) {
                    auswahl1.setTextColor(Color.GREEN);
                    myTimer.cancel();
                }else if(loesung == 2) {
                    auswahl2.setTextColor(Color.GREEN);
                    myTimer.cancel();
                }else if(loesung == 3) {
                    auswahl3.setTextColor(Color.GREEN);
                    myTimer.cancel();
                }else if(loesung == 4) {
                    auswahl4.setTextColor(Color.GREEN);
                    myTimer.cancel();
                }
                countPunkte = false;
                Toast.makeText(this, "Leider falsche Antwort", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void changeTextColorFromRadioButtons() {
        auswahl1.setTextColor(Color.BLACK);
        auswahl2.setTextColor(Color.BLACK);
        auswahl3.setTextColor(Color.BLACK);
        auswahl4.setTextColor(Color.BLACK);
    }

    private void spielLogik() {
            int count = Integer.parseInt(tvZeit.getText().toString().replaceAll("\\D+",""));
        if(countPunkte == true) {
            if( count >= 18 && count <= 20) {
                    punkte += 24;

            }else if(count >= 14 && count <= 17) {
                    punkte += 20;

            }else if(count >= 10 && count <= 13) {
                    punkte += 16;

            }else if(count >= 6 && count <= 9) {
                    punkte += 12;

            }else if(count >= 2 && count <= 5) {

                    punkte += 8;

            }else if(count >= 0 && count <= 1) {

                    punkte += 4;
            }
        }else {
                countPunkte = true;
            }
        tvPunkte.setText("Punkte: " + punkte);
        }

    public static Quiz getInstance(){
        return quiz;
    }
        @Override
        public void onBackPressed()
        {
            myTimer.cancel();
            finish();
            alFragenSizeCounter = 0;
            Quiz.punkte = 0;
            Fragen.alvorhandeneZufallszahlen.clear();
            Fragen.alFragen.clear();
            new Fragen();
            super.onBackPressed();
        }
}
