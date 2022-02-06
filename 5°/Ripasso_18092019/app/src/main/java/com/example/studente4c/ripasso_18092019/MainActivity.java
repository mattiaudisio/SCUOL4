package com.example.studente4c.ripasso_18092019;

//"Read vcf file android programmatically" per sapere come leggere file su Android
//"Read file res programmatically"

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {       //Se ho 100 pulsanti che fanno la stessa cosa implemento un'interfaccia
//Tutti i metodi presenti all'interno dellìinterfaccia devono essere implementati

    private EditText nome = null;    //CAMPO: visibile a tutti i metodi della classe
    private Spinner spinner = null;
    public Button invia = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //SE UN CAMPO DEVE ESSERE VISIBILE A TUTTI, NON VA MESSO NELL'onCreate()
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.txtNome);      //findViewByID è un metodo che si trova nella classe AppCompatActivity e vuole un intero ID
        spinner = findViewById(R.id.spnCitta);
        invia = findViewById(R.id.btnInvia);

        ArrayList <String> mioarray = new ArrayList<String>();
        mioarray.add("Torino");
        mioarray.add("Aosta");
        mioarray.add("Genova");
        mioarray.add("Milano");
        ArrayAdapter <String> mioadapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item);   //ArrayAdapter addatta il testo allo spinner
        spinner.setAdapter(mioadapter);
    }

/*   ---- Per far diventare una parte di codice ctrl+shift+/ ----

    public Button ritorna(){    //Get campo
        return invia;
    }*/

    public Button getInvia() {          //Proprietà
        return invia;
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*invia.setOnClickListener(new View.OnClickListener() { //Serve per associare l'ascoltatore al button,spinner...
            @Override
            public void onClick(View v) {
                Toast mioToast = Toast.makeText(getApplicationContext(),"ciao",Toast.LENGTH_LONG);  //con new mi da errore perchè ci pensa il metodo a richiamare l'oggetto
                mioToast.show();
            }
        });*/
        invia.setOnClickListener(this);     //i metodi sono sempre col set, le interfaccia hanno l'On..
    }

    @Override
    public void onClick(View v) {   //View: tutti gli oggetti che possiamo inserire in un activity
        int mioID = v.getId();      //ritorna l'ID (l'intero che corrisponde ad un oggetto)
        switch(mioID){
            case R.id.btnInvia:
                Toast mioToast = Toast.makeText(getApplicationContext(),"ciao",Toast.LENGTH_LONG);
                mioToast.show();
                break;
        }
    }
}