package com.example.studente4c.esercizio_40619;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tNome=null, tCognome=null, tMail=null, tMatricola=null;
    private Button btStampa=null;
    private Anagrafica info=null;
    private studente Stud=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        info=new Anagrafica();
        Stud=new studente();
        setContentView(R.layout.activity_main);
        tNome=findViewById(R.id.txtNome);
        tCognome=findViewById(R.id.txtCognome);
        tMail=findViewById(R.id.txtMail);
        tMatricola=findViewById(R.id.txtMatricola);
        btStampa=findViewById(R.id.btnStampa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btStampa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setNome(tNome);
                info.setCognome(tCognome);
                info.setMail(tMail);
                Stud.setMatricola(tMatricola);
                if(tNome==null){
                    if(tCognome==null){
                        if(tMail==null){
                            if(tMatricola==null){
                                StampaDati();
                            }
                        }
                    }
                }
            }
        });
    }

    public void StampaDati(){
        AlertDialog.Builder finestra=new AlertDialog.Builder(MainActivity.this);
        finestra.setMessage("Nome:"+info.getNome()+" Cognome:"+info.getCognome()+" Mail:"+ info.getMail()+"Matricola:"+Stud.getMatricola());
        finestra.show();
    }
}
