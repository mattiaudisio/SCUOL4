package com.example.a5c_audisio_rubrica;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//TUTTE LE ACTIVITY DEVONO FINIRE CON Activity
//L'activity visualizza deve avere una ListView
//Questa non è programmazione ad oggetti perchè non c'è nessuna classe

public class PaginaServer extends AppCompatActivity {

    private Button btnVisualizza, btnOrdina, btnElimina, btnCarica = null;
    private String concatena = "";
    private RequestQueue miaCoda = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_server);
        miaCoda= Volley.newRequestQueue(this);
        btnVisualizza=findViewById(R.id.btnVisualizza);
        btnOrdina=findViewById(R.id.btnOrdina);
        btnElimina=findViewById(R.id.btnElimina);
        btnCarica=findViewById(R.id.btnEliminaInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaAggiungi = new Intent(getApplicationContext(),PaginaAggiungi.class);
                startActivity(paginaAggiungi);
            }
        });
        btnElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaElimina = new Intent(getApplicationContext(),PaginaElimina.class);
                startActivity(paginaElimina);
            }
        });
        btnVisualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlSito = "127.0.0.1:1391/Rubrica.json";
                JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, urlSito, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject pinco = response.getJSONObject(i);
                                concatena = concatena+" "+pinco.getString("nome")+" "+pinco.getString("cognome")+" "+pinco.getString("telefono")+"\n";
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Toast.makeText(getApplicationContext(),concatena,Toast.LENGTH_LONG).show();
                    }
                }, new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                miaCoda.add(mioArray);
            }
        });
        btnOrdina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlSito = "127.0.0.1:1391/Rubrica.json";
                JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, urlSito, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONArray array = null;
                        List<JSONObject> jsons = new ArrayList<JSONObject>();
                        for (int j = 0; j < array.length(); j++) {
                            try {
                                jsons.add(array.getJSONObject(j));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Collections.sort(jsons, new Comparator<JSONObject>() {
                            @Override
                            public int compare(JSONObject lhs, JSONObject rhs) {
                                String lid = null;
                                try {
                                    lid = lhs.getString("nome");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                String rid = null;
                                try {
                                    rid = rhs.getString("nome");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                // Here you could parse string id to integer and then compare.
                                return lid.compareTo(rid);
                            }
                        });
                        Toast.makeText(getApplicationContext(),"Ordinato!",Toast.LENGTH_LONG).show();
                    }
                }, new ErrorListener() {
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
