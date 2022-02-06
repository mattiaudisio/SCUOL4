package com.example.mattiaudisio.verificaaudisio;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText nome=null;
    private EditText cognome=null;
    private RadioGroup sesso=null;
    private RadioGroup patente=null;
    private CheckBox tennis=null;
    private CheckBox calcio=null;
    private CheckBox basket=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome=findViewById(R.string.txtNome);
        cognome=findViewById(R.string.txtCognome);
        sesso=findViewById(R.string.rdgSesso);
        patente=findViewById(R.string.rdgPatente);
        tennis=findViewById(R.string.chkTennis);
        calcio=findViewById(R.string.chkCalcio);
        basket=findViewById(R.string.chkBasket);
    }

    @Override
    protected void onResume() {
        super.onResume();
        patente=setContentView(R.string.rdgPatente);
        switch (patente){
            case ("sì"):
                public
                break;
            case ("no"):
                break;

             default:
                 break;
        }
    }
}