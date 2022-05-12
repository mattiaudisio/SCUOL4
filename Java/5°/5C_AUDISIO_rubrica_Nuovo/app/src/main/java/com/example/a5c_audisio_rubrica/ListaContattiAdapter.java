package com.example.a5c_audisio_rubrica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListaContattiAdapter extends ArrayAdapter<Contatto> {

    private int resourceLayout;
    private Context mContext;


    public ListaContattiAdapter(Context context, int resource, List<Contatto> objects) {
        super(context, resource, objects);
        this.resourceLayout = resource;
        this.mContext = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater mioInflater = LayoutInflater.from(mContext);
        convertView=mioInflater.inflate(R.layout.activity_elencocontatti,null);
        ImageView imgContatto=convertView.findViewById(R.id.imageView2);
        TextView txtNomeContatto=convertView.findViewById(R.id.txtNomeContatto);
        TextView txtCognomeContatto = convertView.findViewById(R.id.txtCognomeContatto);
        TextView txtNumeroContatto = convertView.findViewById(R.id.txtNumeroContatto);
        txtNomeContatto.setText(getItem(position).getNomeContatto());
        txtCognomeContatto.setText(getItem(position).getCognomeContatto());
        txtNumeroContatto.setText(getItem(position).getNumeroContatto());
        return convertView;

    }




}
