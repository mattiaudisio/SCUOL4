package com.example.mattiaudisio.audisiomattia_verifica_120219;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText kilowatt=null;
    private Spinner lista=null;
    private ArrayList mialista=null;
    private RadioButton CDP=null;
    private Button bottone=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kilowatt=findViewById(R.id.kilowatt);
        bottone=findViewById(R.id.button);
        CDP=findViewById(R.id.radioButton);
        lista=findViewById(R.id.spinner);
        mialista=new ArrayList<String>();
        mialista.add("Biella");
        mialista.add("Cuneo");
        mialista.add("Asti");
        mialista.add("Torino");
        mialista.add("Savona");
        mialista.add("Genova");
        mialista.add("Imperia");

        ArrayAdapter<String> mioAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,mialista);
        lista.setAdapter(mioAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String strkw=kilowatt.getText().toString();
        double cdp=43.86;
        if(CDP.isChecked()){
            cdp=29.24;
        }
        double intKw=Double.parseDouble(strkw);
        double num=0;
        if(intKw<53) {
            num=150.81;
        }else{
            num=3.5119;
        }
        double perc=0;
        switch(lista.toString()){
            case "Biella":
                perc=30/100;
                break;
            case "Cuneo":
                perc=20/100;
                break;
            case "Asti":
                perc=11/100;
                break;
            case "Torino":
                perc=27/100;
                break;
            case "Savona":
                perc=35/100;
                break;
            case "Genova":
                perc=32/100;
                break;
            case "imperia":
                perc=14/100;
                break;
        }
        double ris=intKw*num;
        final double risultato=ris+perc+cdp;
        String ris=String.parseDouble(risultato);
        bottone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder finestra=new AlertDialog.Builder(MainActivity.this);
                AlertDialog allert=finestra.create();
                finestra.setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast pop=Toast.makeText(this,risultato, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}