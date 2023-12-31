package com.example.capital_city_quiz;

import java.io.Serializable;

public class FragenAntworten implements Serializable {

    private String frage, antwort1, antwort2, antwort3, antwort4;
    private int loesung;

    public FragenAntworten(String frage, String antwort1, String antwort2, String antwort3, String antwort4, int loesung){
       this.setFrage(frage);
       this.setAntwort1(antwort1);
       this.setAntwort2(antwort2);
       this.setAntwort3(antwort3);
       this.setAntwort4(antwort4);
       this.setLoesung(loesung);
    }

    public void setFrage(String frage){
        this.frage = frage;
    }

    public String getFrage() {
        return frage;
    }

    public String getAntwort1() {
        return antwort1;
    }

    public void setAntwort1(String antwort1) {
        this.antwort1 = antwort1;
    }

    public String getAntwort2() {
        return antwort2;
    }

    public void setAntwort2(String antwort2) {
        this.antwort2 = antwort2;
    }

    public String getAntwort3() {
        return antwort3;
    }

    public void setAntwort3(String antwort3) {
        this.antwort3 = antwort3;
    }

    public String getAntwort4() {
        return antwort4;
    }

    public void setAntwort4(String antwort4) {
        this.antwort4 = antwort4;
    }

    public int getLoesung() {
        return loesung;
    }

    public void setLoesung(int loesung) {
        this.loesung = loesung;
    }
}
