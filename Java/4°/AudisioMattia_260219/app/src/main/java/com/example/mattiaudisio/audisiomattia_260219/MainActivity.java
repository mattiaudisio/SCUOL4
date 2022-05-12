package com.example.mattiaudisio.audisiomattia_260219;

import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText modello=null;                      //Modello dell'auto
    private EditText dimensione=null;                   //Dimensione auto
    private EditText matricola=null;                    //Matricola
    private Button caricaDati=null;                     //Carica i dati inseriti dal'utente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modello=findViewById(R.id.modAuto);                 //con modello si intende il Plain Text modAuto
        dimensione=findViewById(R.id.Dim);                  //con dimensione si intende il Plain Text Dim
        matricola=findViewById(R.id.Matr);                  //con matricola si intende il Plaint Text Matr
        caricaDati=findViewById(R.id.caricaInformazioni);               //con caricaDati si intende il button carica
    }

    @Override
    protected void onResume() {
        super.onResume();
        caricaDati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(modello!=null){                              //Fa 3 controlli, se anche solo uno è a null, il button carica niente
                    if(dimensione!=null){
                        if(matricola!=null){
                            AlertDialog.Builder finestra=new AlertDialog.Builder(MainActivity.this);
                            finestra.setMessage("La macchina ");
                            finestra.append(modello);
                            finestra.append(" con matricola ");
                            finestra.append(matricola);
                            finestra.append(" e dimensione ");
                            finestra.append(dimensione);
                            finestra.append(" e stata caricata correttamente!");
                            finestra.show();
                        }
                    }
                }
            }
        });
   }

}
