package com.example.a5c_audisio_rubrica;

import android.os.Build;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Comparator;

public class Ordina {

    private static final String SERVER = "http://10.0.2.2:2000/";
    private RequestQueue codaVolley = null;
    private ArrayList<String> rubrica = null;

    public void OrdinaRubrica(){
        JsonArrayRequest mioArray = new JsonArrayRequest(Request.Method.GET, SERVER, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject mioJson = new JSONObject();
                    for(int i = 0; i< mioJson.length(); i++){
                        String contatto = mioJson.getJSONObject(String.valueOf(i)).getString("nome") + mioJson.getJSONObject(String.valueOf(i)).getString("cognome") + mioJson.getJSONObject(String.valueOf(i)).getString("numero");
                        rubrica.set(i,contatto);
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        rubrica.sort((Comparator<? super String>) rubrica);
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

}
