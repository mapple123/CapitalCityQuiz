package com.example.capital_city_quiz;

public class HighscoreListe {
    protected String name;
    protected int punkte;
    protected long id;

    public HighscoreListe(){

    }
    public HighscoreListe(String name, int punkte){
        setName(name);
        setPunkte(punkte);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
