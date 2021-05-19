package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RubricaTelefono3 extends AppCompatActivity {

    private EditText cognome=null;
    private Button elimina=null;
    private FileRubrica miaRubrica=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rubrica_telefono3);
        cognome=findViewById(R.id.txtCognomeElimina);
        elimina=findViewById(R.id.btnElimina);
        miaRubrica=new FileRubrica();
    }

    @Override
    protected void onResume() {
        super.onResume();
        elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cognomeStringa=cognome.getText().toString();
                String risultato= (String) miaRubrica.remove(cognomeStringa);
                if(risultato!=null){

                }
            }
        });
    }
}