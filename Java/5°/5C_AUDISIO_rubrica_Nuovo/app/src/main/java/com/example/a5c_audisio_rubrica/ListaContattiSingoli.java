package com.example.a5c_audisio_rubrica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

public class ListaContattiSingoli extends ArrayAdapter<Contatto> {

    private int resourceLayout;
    private Context mContext;


    public ListaContattiSingoli(Context context, int resource, List<Contatto> rubrica) {
        super(context, resource, rubrica);
        this.resourceLayout = resource;
        this.mContext = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final LayoutInflater mioInflater = LayoutInflater.from(mContext);
        convertView=mioInflater.inflate(R.layout.activity_elencocontatti,null);
        final View finalConvertView = convertView;
        final JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, "http://10.0.2.2:2000/visualizza", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject mioJson = new JSONObject();
                    for(int i = 0; i< mioJson.length(); i++){
                        ImageView imgContatto= finalConvertView.findViewById(R.id.imageView2);
                        TextView txtNomeContatto= finalConvertView.findViewById(R.id.txtNomeContatto);
                        TextView txtCognomeContatto = finalConvertView.findViewById(R.id.txtCognomeContatto);
                        TextView txtNumeroContatto = finalConvertView.findViewById(R.id.txtNumeroContatto);
                        if(txtNomeContatto.getText().toString().equals(mioJson.getJSONObject(String.valueOf(i)).getString("nome"))  && txtCognomeContatto.getText().toString().equals(mioJson.getJSONObject(String.valueOf(i)).getString("cognome"))){
                            txtNomeContatto.setText(getItem(position).getNomeContatto());
                            txtCognomeContatto.setText(getItem(position).getCognomeContatto());
                            txtNumeroContatto.setText(getItem(position).getNumeroContatto());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {    }
        });
        return convertView;
    }
}