package com.example.a5c_audisio_rubrica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class CaricaAcitivity extends AppCompatActivity {

    private TextView txtNomeNuovo, txtCognomeNuovo, txtNumeroNuovo = null;
    private Button btnCarica = null;
    private static final String SERVER = "http://10.0.2.2:2000/carica";
    private RequestQueue codaVolley = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carica_acitivity);
        txtNomeNuovo = findViewById(R.id.txtNomeNuovo);
        txtCognomeNuovo = findViewById(R.id.txtCognomeNuovo);
        txtNumeroNuovo = findViewById(R.id.txtNumeroNuovo);
        btnCarica = findViewById(R.id.btnCaricaNuovo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, SERVER, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject mioJson = new JSONObject();
                            mioJson.put("nome",txtNomeNuovo.getText().toString());
                            mioJson.put("cognome",txtCognomeNuovo.getText().toString());
                            mioJson.put("numero",txtNumeroNuovo.getText().toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {    }
                });
                codaVolley.add(mioArray);
            }
        });
    }
}
