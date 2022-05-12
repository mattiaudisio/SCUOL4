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

public class EliminaActivity extends AppCompatActivity {

    private TextView txtNomeElimina, txtCognomeElimina = null;
    private Button btnEliminaContatto = null;
    private static final String SERVER = "http://10.0.2.2:2000/elimina";
    private RequestQueue codaVolley = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina);
        txtNomeElimina = findViewById(R.id.txtNomeElimina);
        txtCognomeElimina = findViewById(R.id.txtCognomeElimina);
        btnEliminaContatto = findViewById(R.id.btnEliminaContatto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnEliminaContatto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, SERVER, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject mioJson = new JSONObject();
                            for(int i = 0; i< mioJson.length(); i++){
                                if(txtNomeElimina.getText().toString().equals(mioJson.getJSONObject(String.valueOf(i)).getString("nome"))  && txtCognomeElimina.getText().toString().equals(mioJson.getJSONObject(String.valueOf(i)).getString("cognome"))){
                                    mioJson.remove(mioJson.getJSONObject(String.valueOf(i)).getString("nome"));
                                    mioJson.remove(mioJson.getJSONObject(String.valueOf(i)).getString("cognome"));
                                    mioJson.remove(mioJson.getJSONObject(String.valueOf(i)).getString("numero"));
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
                codaVolley.add(mioArray);
            }
        });
    }
}
