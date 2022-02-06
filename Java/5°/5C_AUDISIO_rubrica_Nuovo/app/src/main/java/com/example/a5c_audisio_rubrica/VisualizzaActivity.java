package com.example.a5c_audisio_rubrica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class VisualizzaActivity extends AppCompatActivity {

    private ListView listaRubrica = null;
    private ArrayList<Contatto> rubricaContatti = null;
    String jsonArray = getIntent().getStringExtra("jsonArray");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza);
        listaRubrica=findViewById(R.id.lvRubrica);
        rubricaContatti=new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            JSONArray jsonRubrica = new JSONArray(jsonArray);
            for(int i=0; i< jsonRubrica.length(); i++){
                String nomeContatto = jsonRubrica.getJSONObject(i).getString("Nome");
                String cognomeContatto = jsonRubrica.getJSONObject(i).getString("Cognome");
                String numeroContatto = jsonRubrica.getJSONObject(i).getString("Numero");
                rubricaContatti.add(new Contatto(nomeContatto,cognomeContatto,numeroContatto));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListaContattiAdapter contattiAdapter = new ListaContattiAdapter(this,R.layout.activity_elencocontatti,rubricaContatti);
        listaRubrica.setAdapter(contattiAdapter);
        ListaContattiSingoli conttatiSingoli = new ListaContattiSingoli(this,R.layout.activity_elencocontattisingoli,rubricaContatti);
        listaRubrica.setAdapter(conttatiSingoli);
    }

}