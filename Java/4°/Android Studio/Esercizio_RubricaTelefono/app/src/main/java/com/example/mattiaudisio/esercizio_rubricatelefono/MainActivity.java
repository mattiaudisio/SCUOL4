package com.example.mattiaudisio.esercizio_rubricatelefono;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //File: serve per salvare in modo permamente un'informazione
    //File di testo: la lettura è sequenziale (Se devo cercare qualcosa devo scorrere tutto il file); la dimensione è variabile
    //File binari: all'interno dei file binari possono essere salvati delle strutture (posso posizionarmi nel punto interessato senza scorrere tutto il contenuto); la dimensione non è variabile
    //Non posso aprire contemporaneamente lo stesso file 2 volte

    //Campo: visibile in tutto     Variabile: visibile solo in quel metodo

    private EditText cognome=null;
    private EditText nome=null;
    private EditText telefono=null;
    private Button salva=null;
    private FileRubrica miaRubrica=null;
    private Button apri=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome=findViewById(R.id.txtNome);
        cognome=findViewById(R.id.txtCognomeCerca);
        telefono=findViewById(R.id.txtTelefono);
        salva=findViewById(R.id.IDSalva);
        miaRubrica=new FileRubrica();
        apri=findViewById(R.id.IDApri);
    }

    @Override
    protected void onResume() {
        super.onResume();
        salva.setOnClickListener(new View.OnClickListener() {       //SEMPRE setOn; è un metodo che vuole come parametro un interfaccia
            @Override
            public void onClick(View v) {
                //FileRubrica miaRubrica=new FileRubrica(); LO FACCIO NELL'onCreate perchè così non me lo crea tutte le volte
                String nomeString=nome.getText().toString();
                String cognomeString=cognome.getText().toString();
                String telefonoString=telefono.getText().toString();
                boolean controlla=miaRubrica.caricaDati(nomeString,cognomeString,telefonoString);
                if(controlla==false){
                    Toast.makeText(getApplicationContext(),"ERRORE",Toast.LENGTH_LONG);
                }
            }
        });
        apri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mioIntent= new Intent(getApplicationContext(),Main2Activity.class);
                //per passare anche dei parametri  mioIntent.putextra()
                startActivity(mioIntent);               //apriamo la seconfa activity
            }
        });
    }
}