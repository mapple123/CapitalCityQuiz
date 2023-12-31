package com.example.capital_city_quiz;

import android.os.CountDownTimer;
import android.widget.Toast;
import static com.example.capital_city_quiz.Quiz.tvZeit;

public class FrageChange {

        @SuppressWarnings("unused")
        private static int loesung = 0;
        private static FragenAntworten aktuelleFrage;
        protected static CountDownTimer myTimer;
        public FrageChange() {
                 myTimer = new CountDownTimer(21000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        tvZeit.setText("Zeit: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        tvZeit.setText("Zeit: 0");
                        Toast.makeText(Quiz.getInstance(), "Zeit abgelaufen", Toast.LENGTH_SHORT).show();
                        new FrageChange();
                        myTimer.cancel();
                        myTimer.start();
                    }
                }.start();
            neueFrage();
        }

        private static void neueFrage() {
            //Fragen werden initialisiert
            Fragen.newFrage();
            //Aktuelle Frage wird gesetzt
            aktuelleFrage = Fragen.frage;
            aendereText();
        }

        private static void aendereText() {
            String frage = aktuelleFrage.getFrage();
            String fA1 = aktuelleFrage.getAntwort1();
            String fA2 = aktuelleFrage.getAntwort2();
            String fA3 = aktuelleFrage.getAntwort3();
            String fA4 = aktuelleFrage.getAntwort4();
            int loesung = aktuelleFrage.getLoesung();
            Quiz.changeLabelText(frage);
            Quiz.loesung = loesung;
            Quiz.changeRadiobuttonsText(1, fA1);
            Quiz.changeRadiobuttonsText(2, fA2);
            Quiz.changeRadiobuttonsText(3, fA3);
            Quiz.changeRadiobuttonsText(4, fA4);
        }
}
