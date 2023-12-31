package com.example.capital_city_quiz;

import android.content.Intent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static com.example.capital_city_quiz.FrageChange.myTimer;

public class Fragen {
    private final static String F = "Wie lautet die Hauptstadt von ";

    protected static int zufall;
    protected static ArrayList<Integer> alvorhandeneZufallszahlen =  new ArrayList<Integer>();
    protected static ArrayList<FragenAntworten> alFragen = new ArrayList<FragenAntworten>();
    protected static  int alFragenSize = 0;
    protected static int alFragenSizeCounter = 0;
    protected static FragenAntworten frage;

    public Fragen() {
        if(alFragenSize == 0){
            alFragen.add(new FragenAntworten(F + "Albanien?", "Madrid", "Luxemburg", "Tirana", "Brüssel", 3));
            alFragen.add(new FragenAntworten(F + "Andorra?", "Andorra la Vella", "Sofia", "Berlin", "Paris", 1));
            alFragen.add(new FragenAntworten(F + "Belgien?", "Amsterdam", "Rom", "Astana", "Brüssel", 4));
            alFragen.add(new FragenAntworten(F + "Bosnien und Herzegowina?", "Sarajevo", "Helsinki", "Athen", "Dublin", 1));
            alFragen.add(new FragenAntworten(F + "Bulgarien?", "Kopenhagen", "Sofia", "Berlin", "Brüssel", 2));
            alFragen.add(new FragenAntworten(F + "Dänemark?", "Kopenhagen", "Oslo", "Riga", "Brüssel", 1));
            alFragen.add(new FragenAntworten(F + "Deutschland?", "Madrid", "Luxemburg", "Berlin", "Brüssel", 3));
            alFragen.add(new FragenAntworten(F + "Estland?", "Andorra la Vella", "Amsterdam", "Sofia", "Tallinn", 4));
            alFragen.add(new FragenAntworten(F + "Finnland?", "Paris", "Helsinki", "Berlin", "Astana", 2));
            alFragen.add(new FragenAntworten(F + "Frankreich?", "Vilnius", "Vaduz", "Paris", "Rom", 3));
            alFragen.add(new FragenAntworten(F + "Griechenland?", "Riga", "Luxemburg", "Zagreb", "Athen", 4));
            alFragen.add(new FragenAntworten(F + "Irland?", "Dublin", "Monaco", "Berlin", "Minsk", 1));
            alFragen.add(new FragenAntworten(F + "Island?", "Madrid", "Reykjavik", "Berlin", "Brüssel", 2));
            alFragen.add(new FragenAntworten(F + "Italien?", "Wien", "Warschau", "Rom", "Podgorica", 3));
            alFragen.add(new FragenAntworten(F + "Kasachstan?", "Moskau", "Minsk", "Berlin", "Astana", 4));
            alFragen.add(new FragenAntworten(F + "Kroatien?", "Zagreb", "Prag", "Madrid", "Brüssel", 1));
            alFragen.add(new FragenAntworten(F + "Lettland?", "Madrid", "Riga", "Berlin", "Lissabon", 2));
            alFragen.add(new FragenAntworten(F + "Liechtenstein?", "Stockholm", "Luxemburg", "Ankara", "Vaduz", 4));
            alFragen.add(new FragenAntworten(F + "Litauen?", "Bukarest", "Oslo", "Vilnius", "Brüssel", 3));
            alFragen.add(new FragenAntworten(F + "Luxemburg?", "Madrid", "Luxemburg", "Berlin", "Ankara", 2));
            alFragen.add(new FragenAntworten(F + "Malta?", "Valletta", "Luxemburg", "Berlin", "Brüssel", 1));
            alFragen.add(new FragenAntworten(F + "Mazedonien?", "Bratislava", "Warschau", "Bukarest", "Skopje", 4));
            alFragen.add(new FragenAntworten(F + "Moldawien?", "Berlin", "Amsterdam", "Chisinau", "Brüssel", 3));
            alFragen.add(new FragenAntworten(F + "Monaco?", "Monaco", "Madrid", "Berlin", "San Marino", 1));
            alFragen.add(new FragenAntworten(F + "Montenegro?", "Prag", "Podgorica", "Kiew", "Budapest", 2));
            alFragen.add(new FragenAntworten(F + "Niederlande?", "Oslo", "Skopje", "Minsk", "Amsterdam", 4));
            alFragen.add(new FragenAntworten(F + "Norwegen?", "Wien", "Ljubljana", "Oslo", "London", 3));
            alFragen.add(new FragenAntworten(F + "Österreich?", "Madrid", "Wien", "Prag", "Chisinau", 2));
            alFragen.add(new FragenAntworten(F + "Polen?", "Madrid", "Luxemburg", "Berlin", "Warschau", 4));
            alFragen.add(new FragenAntworten(F + "Portugal?", "Lissabon", "Kopenhagen", "Rom", "Dublin", 1));
            alFragen.add(new FragenAntworten(F + "Rumänien?", "Lissabon", "Stockholm", "Bern", "Bukarest", 4));
            alFragen.add(new FragenAntworten(F + "Russland?", "Moskau", "Luxemburg", "Berlin", "Brüssel", 1));
            alFragen.add(new FragenAntworten(F + "San Marino?", "Madrid", "San Marino", "Kiew", "Vatikanstadt", 2));
            alFragen.add(new FragenAntworten(F + "Schweden?", "Belgrad", "Bern", "Stockholm", "Brüssel", 3));
            alFragen.add(new FragenAntworten(F + "Schweiz?", "Kiew", "Madrid", "Rom", "Bern", 4));
            alFragen.add(new FragenAntworten(F + "Serbien?", "Berlin", "Amsterdam", "Belgrad", "Stockholm", 3));
            alFragen.add(new FragenAntworten(F + "Slowakei?", "Bratislava", "Madrid", "Berlin", "Prag", 1));
            alFragen.add(new FragenAntworten(F + "Slowenien?", "Madrid", "Ljubljana", "London", "Rom", 2));
            alFragen.add(new FragenAntworten(F + "Spanien?", "Madrid", "Luxemburg", "Berlin", "Brüssel", 1));
            alFragen.add(new FragenAntworten(F + "Tschechien?", "Vatikanstadt", "Luxemburg", "Prag", "Rom", 3));
            alFragen.add(new FragenAntworten(F + "Türkei?", "Luxemburg", "Madrid", "Kiew", "Ankara", 4));
            alFragen.add(new FragenAntworten(F + "Ukraine?", "Moskau", "Bratislava", "Kiew", "Brüssel", 3));
            alFragen.add(new FragenAntworten(F + "Ungarn?", "Budapest", "Luxemburg", "Berlin", "Brüssel", 1));
            alFragen.add(new FragenAntworten(F + "Vatikanstadt?", "Berlin", "Vatikanstadt", "Madrid", "Rom", 2));
            alFragen.add(new FragenAntworten(F + "Vereinigtes Königreich?", "Kopenhagen", "Paris", "Riga", "London", 4));
            alFragen.add(new FragenAntworten(F + "Weißrussland?", "Minsk", "San Marino", "Bern", "Amsterdam", 1));

        }
        speichern();
        readFragen();
        alFragenSize = alFragen.size();
    }

    protected static void hinzufuegen(String frage, String a1, String a2, String a3, String a4, int loesung) {
        alFragen.add(new FragenAntworten(frage, a1, a2, a3, a4, loesung));
    }

    protected static void speichern() {
        String filename = "FragenAntworten.ser";
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(alFragen); //Write byte stream to file system.
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    private static int zufall(int min, int max) {
        if(alvorhandeneZufallszahlen.size()>= max ) {
            return -1;
        }
        do {
            zufall = (int) ((max-min) * Math.random()+min);
        }while(alvorhandeneZufallszahlen.contains(zufall));
        alvorhandeneZufallszahlen.add(zufall);
        return zufall;
    }

    @SuppressWarnings("unchecked")
    protected static void readFragen() {
        String filename = "FragenAntworten.ser";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            alFragen = (ArrayList<FragenAntworten>)in.readObject();
            in.close();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }

    public static void newFrage() {
        int zufallszahl = zufall(0, alFragenSize);
        if(alFragenSizeCounter < alFragenSize) {
            alFragenSizeCounter++;
            Quiz.tvFragenCount.setText("Frage " + alFragenSizeCounter + " von " + alFragenSize);
        }else{
            alFragenSizeCounter = 0;
            alvorhandeneZufallszahlen.clear();
            myTimer.cancel();
            Quiz.getInstance().finish();
            Intent intent = new Intent(Quiz.getInstance(), EndeActivity.class);
            Quiz.getInstance().startActivity(intent);
        }


        //Beendet das Quiz, wenn die Zufallszahl = -1 ist. Sonst wird eine neue Frage erstellt
        if( zufallszahl == -1) {
            //MainFrame.bFrage = false;
        }else {
            frage = alFragen.get(zufallszahl);
        }
    }
}
