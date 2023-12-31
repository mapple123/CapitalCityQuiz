package com.example.capital_city_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jan on 11.03.2017.
 */

public class DBZugriff extends SQLiteOpenHelper {

    public static SQLiteDatabase db;

    public static final String DB_NAME = "HighscoreListe";

    private final String ROW_ID = "_id";
    private static final String ROW_NAME = "name";
    private final String ROW_PUNKTE = "punkte";

    private final String[] ALL_ROWS = new String[]{ROW_ID,ROW_NAME,ROW_PUNKTE};
    final String sql = "CREATE TABLE " + DB_NAME +
            "(" + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            ROW_NAME + " TEXT NOT NULL," + ROW_PUNKTE + " INTEGER NOT NULL)";

    public DBZugriff(Context c, String dbName){
        super(c,dbName, null, 1);
        db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(sql);
            Toast.makeText(MainActivity.getInstance(), "Erfolg beim Erstellen der Datenbank!",
                    Toast.LENGTH_LONG).show();
        }catch(Exception ex){
            Log.e("Fehler", ex.getMessage());
        }
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int neu) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_NAME);

        onCreate(sqLiteDatabase);
    }

    public synchronized void close(){
        if (db != null && db.isOpen()){
            db.close();
            db = null;
        }

        super.close();
    }


    public long datensatzEinfügenHighscore(HighscoreListe datensatz) {
        try {
            ContentValues daten = erzeugeDatenObjekt(datensatz);
            return db.insert(DB_NAME, null, daten);
        }
        catch(Exception ex) {
            Log.d("Error", ex.getMessage());
            return -1;
        }
    }


    public Cursor erzeugeListViewCursor() {

        return  db.query(DB_NAME, ALL_ROWS, null, null, null, null, ROW_PUNKTE +
                " COLLATE NOCASE ASC");
    }


    public List<HighscoreListe> leseDatensaetzeHighscore() {
        List<HighscoreListe> ergebnis = new ArrayList<HighscoreListe>();
        Cursor cursor = null;

        try {
            cursor = db.query(DB_NAME, null, null, null, null, null, ROW_PUNKTE
                    + " COLLATE NOCASE DESC");
            int anzahl = cursor.getCount();
            cursor.moveToFirst();

            for(int i = 0; i < anzahl; i++) {
                HighscoreListe ds = erzeugeDatensatzVokabel(cursor);
                ergebnis.add(ds);
                cursor.moveToNext();
            }
        }
        catch(Exception ex) {
            Log.e("Error", ex.getMessage());
        }
        finally {
            if(cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return ergebnis;
    }

    public void löscheDatensatz(String id) {
        try {
            db.delete(DB_NAME, ROW_ID + " = " + id, null);
        }
        catch(Exception ex) {
             Log.e("Error", ex.getMessage());
        }
    }

    public HighscoreListe erzeugeDatensatzVokabel(Cursor cursor) {
        HighscoreListe ds = new HighscoreListe();
        ds.id = cursor.getLong(0);
        ds.name = cursor.getString(1);
        ds.punkte = cursor.getInt(2);
        return ds;
    }

    private ContentValues erzeugeDatenObjekt(HighscoreListe datensatz) {
        ContentValues daten = new ContentValues();
        daten.put(ROW_NAME, datensatz.name);
        daten.put(ROW_PUNKTE, datensatz.punkte);
        return daten;
    }

}
