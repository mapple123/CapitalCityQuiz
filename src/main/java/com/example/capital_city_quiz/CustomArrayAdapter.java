package com.example.capital_city_quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

import static com.example.capital_city_quiz.MainActivity.db;

public class CustomArrayAdapter extends ArrayAdapter {

    private List<HighscoreListe> myArray;
    private Context context;

    public CustomArrayAdapter(Context context, int textViewResourceId, List<HighscoreListe> myArray) {
        super(context, textViewResourceId, myArray);
        this.myArray = myArray;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        view = inflater.inflate(R.layout.layout_row, null);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewRowName);
        TextView textViewPunkte = (TextView) view.findViewById(R.id.textViewRowPunkte);
        CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkBoxRow);
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.löscheDatensatz(String.valueOf(getItemId(position)));
                //Toast.makeText(MainActivity.getInstance(), "" +position, Toast.LENGTH_SHORT).show();
                HighscoreActivity.myArrayAdapter.remove(HighscoreActivity.myArrayAdapter.getItem(position));
            }
        });
        textViewName.setText(myArray.get(position).name);
        textViewPunkte.setText(String.valueOf(myArray.get(position).punkte));

        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Clicked : "+ myArray.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public long getItemId(int position) {
        return db.leseDatensaetzeHighscore().get(position).id;
    }

}