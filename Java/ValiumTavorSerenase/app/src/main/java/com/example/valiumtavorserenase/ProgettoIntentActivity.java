package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ProgettoIntentActivity extends AppCompatActivity {

    private RadioGroup Scelta = null;
    private RadioButton Telefono=null;
    private RadioButton SMS=null;
    private Button Invia=null;
    private Button Cerca=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progetto_intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*int selezione=Scelta.getCheckedRadioButtonId();
        RadioButton opzione=findViewById(selezione);
        switch (selezione){
            case R.id.Telefono:
                Intent Telefono= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:26231775687"));
                startActivity(Telefono);
                break;

            case R.id.SMS:
                Intent SMS= new Intent(Intent.ACTION_SENDTO, Uri.parse("tel:26231775687"));
                startActivity(SMS);
                break;

        }*/
    }
}