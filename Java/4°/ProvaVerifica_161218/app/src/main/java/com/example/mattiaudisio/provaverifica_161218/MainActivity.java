package com.example.mattiaudisio.provaverifica_161218;

import android.net.sip.SipProfile;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Pulsante=null;
    private EditText Nome=null;
    private EditText Cognome=null;
    private RadioGroup sesso=null;
    private RadioGroup patente=null;
    private CheckBox Calcio=null;
    private CheckBox Basket=null;
    private CheckBox Tennis=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pulsante=findViewById(R.id.Visualizza);
        EditText Nome=findViewById(R.id.Nome);
        EditText Cognome=findViewById(R.id.Cognome);
        sesso=findViewById(R.id.Sesso);
        patente=findViewById(R.id.Patente);
        Calcio=findViewById(R.id.Calcio);
        Basket=findViewById(R.id.Basket);
        Tennis=findViewById(R.id.Tennis);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder finestra= new AlertDialog.Builder(MainActivity.this);

                int selezione=sesso.getCheckedRadioButtonId();
                switch (selezione){
                    case R.id.Femmina:
                        Toast xxx=Toast.makeText(getApplicationContext(),"sei un maschio",Toast.LENGTH_LONG);
                        xxx.show();
                        break;
                    case R.id.Maschio:
                        Toast xxx2=Toast.makeText(getApplicationContext(),"sei una femmina",Toast.LENGTH_LONG);
                        xxx2.show();
                        break;
                }
                int selezione=patente.getCheckedRadioButtonId();
                switch (selezione){
                    case R.id.PatenteSi:
                        Toast xxx=Toast.makeText(getApplicationContext(),"ed hai la patente.",Toast.LENGTH_LONG);
                        break;
                    case R.id.PatenteNo:
                        Toast xxx2=Toast.makeText(getApplicationContext(),"e non hai la patente",Toast.LENGTH_LONG);
                        break;
                }
                finestra.setMessage("I tuoi hobby sono ");
                StringBuilder frase=new StringBuilder();
                if(Calcio.isChecked()){
                    frase.append("calcio,");
                }
                if(Basket.isChecked()){
                    frase.append("basket");
                }
                if(Tennis.isChecked()){
                    frase.append("e tennis");
                }
            }
        });
    }

}
