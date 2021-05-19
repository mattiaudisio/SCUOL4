package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class ProgettoRistorantiActivity extends AppCompatActivity {

    private Spinner nPosti=null;
    private EditText nomeRistorante=null;
    private Button caricaRistorante=null;
    private Ristoranti ris=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progetto_ristoranti);
        nPosti=findViewById(R.id.spinner);
        nomeRistorante=findViewById(R.id.txtRistorante);
        caricaRistorante=findViewById(R.id.btnRistorante);
        ArrayList<Integer> numPosti=new ArrayList<Integer>();
        //SE HO 2 VARIABILI, UNA DI TIPO INT E UNA DI TIPO INTEGER, E FACCIO .toString() MI FUNZIONA SOLO CON LA VARIABILE DI TIPO INEGER
        numPosti.add(1);    //SONO INTEGER. INTEGER È UNA CLASSE
        numPosti.add(2);
        numPosti.add(3);
        ArrayAdapter<Integer> mioAdapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,numPosti);
        nPosti.setAdapter(mioAdapter);      //LO SPINNER HA SEMPRE BISOGNO DELL'ArrayAdapter
        //LO CREO SULL'onCreate PERCHÈ DEVE ESSERE CHIAMATO UNA SOLA VOLTA
        ris=new Ristoranti();
    }

    @Override
    protected void onResume() {
        super.onResume();
        caricaRistorante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome=nomeRistorante.getText().toString();
                Integer numero=5;
                ris.caricaRistorante(nome,numero);
            }
        });
    }
}