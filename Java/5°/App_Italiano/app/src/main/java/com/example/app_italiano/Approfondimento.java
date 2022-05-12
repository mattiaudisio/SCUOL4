package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Approfondimento extends AppCompatActivity {

    private OpereApprofondimento opereApprofondimento = null;
    private static final String url = "127.0.0.1:1345";
    private final JSONObject informazioni = new JSONObject();
    private JSONArray nomiAutori, opereAutori;
    private String commentoOpera, nomeAutore, nomeOpera, branoOpera, operaScelta = null;
    private TextView txtNomeOpera, txtBranoOpera, txtCommentoOpera = null;
    private RequestQueue miaCoda = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approfondimento);
        txtNomeOpera = findViewById(R.id.txtNomeOpera);
        txtBranoOpera = findViewById(R.id.txtBranoOpera);
        txtCommentoOpera = findViewById(R.id.txtCommentoOpera);
        miaCoda= Volley.newRequestQueue(this);
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
                        if (opereApprofondimento.getTxtNomeAutore().equals(nomeAutore)) {
                            opereAutori = informazioni.getJSONArray("Opera");
                            for (int j = 0; j < opereAutori.length(); i++) {
                                nomeOpera = opereAutori.getJSONObject(j).getString("Opera");
                                if (opereApprofondimento.getTxtNomeOpera().equals(nomeOpera)) {
                                    branoOpera = opereAutori.getJSONObject(j).getString("testo");
                                    commentoOpera = opereAutori.getJSONObject(j).getString("testo");
                                    txtNomeOpera.setText(nomeOpera);
                                    txtBranoOpera.setText(branoOpera);
                                    txtCommentoOpera.setText(commentoOpera);
                                }
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
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        miaCoda.add(mioOggetto);
    }
}
