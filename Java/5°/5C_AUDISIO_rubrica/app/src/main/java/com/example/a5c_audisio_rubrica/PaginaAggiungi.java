package com.example.a5c_audisio_rubrica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaginaAggiungi extends AppCompatActivity {

    private TextView ptNome, ptCognome, ptTelefono = null;
    private Button btnCaricaInfo = null;
    private RequestQueue miaCoda = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_aggiungi);
        miaCoda= Volley.newRequestQueue(this);
        ptNome=findViewById(R.id.ptNomeElimina);
        ptCognome=findViewById(R.id.ptCognomeELimina);
        ptTelefono=findViewById(R.id.ptTelefono);
        btnCaricaInfo = findViewById(R.id.btnEliminaInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCaricaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlSito = "127.0.0.1:1391/Rubrica.json";
                JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, urlSito, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject nuovoValore = new JSONObject();
                                nuovoValore.put("nome","Nome1");
                                nuovoValore.put("cognome","Cognome1");
                                nuovoValore.put("telefono","11111");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Toast.makeText(getApplicationContext(),"aggiunto!",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                miaCoda.add(mioArray);
            }
        });
    }
}
