package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//con volley possiamo leggere sia oggetti che array(insieme di oggetti) json

public class VolleyActivity extends AppCompatActivity {

    private RequestQueue miaCoda = null;
    private Button btnStringa = null;
    private Button btnOggetto = null;
    private Button btnArray = null;
    private String concatena = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        btnStringa = findViewById(R.id.btn1);
        btnOggetto = findViewById(R.id.btn2);
        btnArray = findViewById(R.id.btn3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnStringa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.denina.it/";
                //La classe StringRequest ha 4 parametri: metodo get/post, url(indirizzo della pagina), onResponse, onError
                StringRequest mioRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map pluto = new HashMap();     //Map => Chiave/Valore
                        pluto.put("nome","luigi");
                        pluto.put("password","123456");
                        return pluto;
                    }
                };
                miaCoda.add(mioRequest);
            }
        });
        btnOggetto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.mocky.io/v2/5dc299ec2f0000cd764be1dd";
                JSONObject minni = new JSONObject();
                try {
                    minni.put("boh","prova");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //ci sono 5 paprametri: metodo get/post, url(indirizzo della pagina), onResponse, onError
                JsonObjectRequest mioOggetto = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String cognome = response.getString("cognome");
                            Toast.makeText(getApplicationContext(),cognome,Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                miaCoda.add(mioOggetto);
            }
        });
        btnArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.mocky.io/v2/5dc29d892f00000e004be216";
                JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject pinco = response.getJSONObject(i);
                                concatena = concatena+" "+pinco.getString("name")+"\n";
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        Toast.makeText(getApplicationContext(),concatena,Toast.LENGTH_LONG).show();
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