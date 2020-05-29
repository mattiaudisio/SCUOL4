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
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private Button btnVisualizza, btnCarica, btnOrdina, btnElimina = null;
    private static final String SERVER = "http://10.0.2.2:2000/visualizza";
    private JSONArray ListaJson=null;
    private RequestQueue codaVolley = null;
    private Ordina miaOrdina = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVisualizza=findViewById(R.id.btnVisualizza);
        btnCarica=findViewById(R.id.btnCaricaNuovo);
        btnOrdina=findViewById(R.id.btnOrdina);
        btnElimina=findViewById(R.id.btnELimina);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnVisualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest mioJson = new JsonArrayRequest(Request.Method.GET, SERVER, null, new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        Intent intentVisualizza = new Intent( getApplicationContext(), VisualizzaActivity.class);
                        intentVisualizza.putExtra("jsonArray",ListaJson.toString());
                        startActivity(intentVisualizza);
                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                codaVolley.add(mioJson);
            }
        });
        btnCarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCarica = new Intent(getApplicationContext(),CaricaAcitivity.class);
                startActivity(intentCarica);
            }
        });
        btnOrdina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miaOrdina.OrdinaRubrica();
            }
        });
        btnElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentElimina = new Intent(getApplicationContext(),EliminaActivity.class);
                startActivity(intentElimina);
            }
        });
    }
}