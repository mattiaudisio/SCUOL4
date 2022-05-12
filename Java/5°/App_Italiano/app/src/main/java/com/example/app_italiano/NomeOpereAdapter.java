package com.example.app_italiano;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.util.ArrayList;

public class NomeOpereAdapter extends ArrayAdapter<Opera> {

    private int resourceLayout;
    private Context mContext;
    private OpereApprofondimento opereApprofondimento = null;

    public NomeOpereAdapter(Opere opere, int activity_opere, ArrayList<Opera> numeroOpere) {
        super(opere, activity_opere, numeroOpere);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater mioInflater = LayoutInflater.from(mContext);
        convertView=mioInflater.inflate(R.layout.activity_opere,null);
        Button btnOpera = convertView.findViewById(R.id.btnOpera);
        btnOpera.setText(getItem(position).getNome());
        btnOpera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opereApprofondimento.setTxtNomeAutore(getItem(position).getAutore());
                Intent mioIntent = new Intent(mContext.getApplicationContext(),Opere.class);
                mContext.startActivity(mioIntent);
            }
        });
        return convertView;
    }
}
