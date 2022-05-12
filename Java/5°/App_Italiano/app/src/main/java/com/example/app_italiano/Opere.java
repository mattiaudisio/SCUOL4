package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Opere extends AppCompatActivity {


    private ListView listaNomeAdapter = null;
    private String nomeSelezionato, nome, nomeAutore = null;
    private OpereApprofondimento opereApprofondimento = null;
    private static final String url = "127.0.0.1:1345";
    private final JSONObject informazioni = new JSONObject();
    private JSONArray nomiAutori, opereAutori;
    private ArrayList<Opera> numeroOpere = null;
    private RequestQueue miaCoda = null;
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opere);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JsonObjectRequest mioOggetto = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    nomiAutori = informazioni.getJSONArray("Autore");
                    for (int i = 0; i < nomiAutori.length(); i++) {
                        nomeAutore = nomiAutori.getJSONObject(i).getString("Autore");
                        if (opera.getNomeSelezionato().equals(nomeAutore)) {
                            opereAutori = informazioni.getJSONArray("Opera");
                            for (int j = 0; j < opereAutori.length(); i++) {
                                nome = opereAutori.getJSONObject(j).getString("Opera");
                                    numeroOpere.add(new Opera(nome,nomeAutore));
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        miaCoda.add(mioOggetto);
        NomeOpereAdapter nomeAdapter = new NomeOpereAdapter(this,R.layout.activity_opere,numeroOpere);
        listaNomeAdapter.setAdapter(nomeAdapter);
    }

}
