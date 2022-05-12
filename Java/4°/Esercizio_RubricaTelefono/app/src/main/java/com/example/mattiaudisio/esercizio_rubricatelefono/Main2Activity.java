package com.example.mattiaudisio.esercizio_rubricatelefono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText cognome=null;
    private Button cerca=null;
    private FileRubrica miaRubrica=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cognome=findViewById(R.id.txtCognomeCerca);
        cerca=findViewById(R.id.btnCerca);
        miaRubrica=new FileRubrica();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cognomeStringa=cognome.getText().toString();
                String risultato=miaRubrica.cerca(cognomeStringa);                       //cerca il cognome che gli abbiamo dato
                if(risultato!=null){
                    Toast.makeText(getApplicationContext(),risultato,Toast.LENGTH_LONG);
                }else{
                    Toast.makeText(getApplicationContext(),"ERRORE",Toast.LENGTH_LONG);
                }
            }
        });
    }
}
