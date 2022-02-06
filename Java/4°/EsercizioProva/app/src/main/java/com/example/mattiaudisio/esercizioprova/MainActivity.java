package com.example.mattiaudisio.esercizioprova;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Nome=null;
    private EditText Cognome=null;
    private RadioGroup sesso=null;
    private RadioButton Maschio=null;
    private RadioButton Femmina=null;
    private RadioGroup patente=null;
    private RadioButton patenteSi=null;
    private RadioButton patenteNo=null;
    private CheckBox Calcio=null;
    private CheckBox Tennis=null;
    private CheckBox Basket=null;
    private Button pulsante=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nome=findViewById(R.id.txtNome);
        Cognome=findViewById(R.id.txtCognome);
        sesso=findViewById(R.id.radioGroup);
        Maschio=findViewById(R.id.rbMaschio);
        Femmina=findViewById(R.id.rbFemmina);
        patente=findViewById(R.id.patente);
        patenteSi=findViewById(R.id.rbSi);
        patenteNo=findViewById(R.id.rbNo);
        Calcio=findViewById(R.id.chCalcio);
        Tennis=findViewById(R.id.chTennis);
        Basket=findViewById(R.id.chBasket);
        pulsante=findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder nome=new StringBuilder();
                nome.append(Nome);
                nome.append(Cognome);
                Toast nomeCognome=Toast.makeText(getApplicationContext(),nome,Toast.LENGTH_LONG);
                nomeCognome.show();
                int selezione=sesso.getCheckedRadioButtonId();
                switch(selezione){
                    case R.id.rbMaschio:
                          Toast xxx=Toast.makeText(getApplicationContext(),"sei un maschio",Toast.LENGTH_LONG);
                          xxx.show();
                    case R.id.rbFemmina:
                        Toast xxx2=Toast.makeText(getApplicationContext(),"sei una femmina",Toast.LENGTH_LONG);
                        xxx2.show();
                }
                int Selezione=patente.getCheckedRadioButtonId();
                switch(selezione){
                    case R.id.rbSi:
                        Toast xxx=Toast.makeText(getApplicationContext(),"hai la patente",Toast.LENGTH_LONG);
                        xxx.show();
                    case R.id.rbNo:
                        Toast xxx2=Toast.makeText(getApplicationContext(),"non hai la patente",Toast.LENGTH_LONG);
                        xxx2.show();
                }
                nome.append("I tuo hobby sono:");
                if(Calcio.isChecked()){
                    nome.append("Calcio,");
                }
                if(Tennis.isChecked()){
                    nome.append("Tennis,");
                }
                if(Basket.isChecked()){
                    nome.append("Basket");
                }
                Toast frase=Toast.makeText(getApplicationContext(),nome,Toast.LENGTH_LONG);
                frase.show();
            }
        });
    }
}
