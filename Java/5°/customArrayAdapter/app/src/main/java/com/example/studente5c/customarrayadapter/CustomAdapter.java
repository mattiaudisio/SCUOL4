package com.example.studente5c.customarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Persone> {

    public CustomAdapter(Context context, int resource, List<Persone> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater mioInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mioInflater.inflate(R.layout.layoutlistview,null);  // mioInflater.inflate( , ); mi ritorna una View
        TextView testo1 = convertView.findViewById(R.id.txt1);
        final TextView testo2 = convertView.findViewById(R.id.txt2);
        Button bottone1 = convertView.findViewById(R.id.btn1);
        testo1.setText(getItem(position).getNome().toString());                 //getItem permette di recuperare l'elemento X che si trova nell'array
        testo2.setText(getItem(position).getCognome().toString());
        bottone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testo2.setText(getItem(position).getCognome()+"x".toString());
            }
        });
        return convertView;
    }
}