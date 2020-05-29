package com.example.mattiaudisio.correzione_120219;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcola=null;
    private Spinner provincie=null;
    private CheckBox cdp=null;
    private EditText kw=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcola=findViewById(R.id.btncalcola);
        provincie=findViewById(R.id.spinner);
        cdp=findViewById(R.id.checkBox);
        kw=findViewById(R.id.editText);
        ArrayList<String>arrayProv=new ArrayList<String>();
        arrayProv.add("Cuneo");
        arrayProv.add("torino");
        arrayProv.add("Biella");
        arrayProv.add("Asti");
        ArrayAdapter<String> mioAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayProv);
        provincie.setAdapter(mioAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCalcola.setOnClickListener(new View.OnClickListener() {      //STIAMO DICENDO CHE btnCalcola HA UN ASCOLTATORE
            @Override
            public void onClick(View v) {
                if(kw.getText()!=null){
                  String selezione=provincie.getSelectedItem().toString();

                }
            }
        });
    }
}
