package com.example.mattiaudisio.esercizio_preparazione;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText testo=null;
    private RadioGroup sesso=null;
    private CheckBox italiano=null;
    private CheckBox inglese=null;
    private CheckBox francese=null;
    private CheckBox spagnolo=null;
    private CheckBox tedesco=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sesso=findViewById(R.id.Sesso);
        italiano=findViewById(R.id.cbxItaliano);
        inglese=findViewById(R.id.cbxInglese);
        francese=findViewById(R.id.cbxFrancese);
        spagnolo=findViewById(R.id.cbxSpagnolo);
        tedesco=findViewById(R.id.cbxTedesco);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
