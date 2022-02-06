package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Decadentismo extends AppCompatActivity {

    private Button btnBaudelaire, btnAnnunzio, btnPascoli = null;
    private ArrayList<Button> arrayButton = new ArrayList<>();
    private ArrayList<String> arrayClass = new ArrayList<String>();
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decadentismo);
        btnBaudelaire=findViewById(R.id.btnBaudelaire);
        btnAnnunzio=findViewById(R.id.btnAnnunzio);
        btnPascoli=findViewById(R.id.btnPascoli);

        arrayButton.add(btnBaudelaire);
        arrayButton.add(btnAnnunzio);
        arrayButton.add(btnPascoli);
        arrayClass.add("Charles Baudelaire");
        arrayClass.add("Gabriele D’Annunzio");
        arrayClass.add("Giovanni Pascoli");
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0; i < arrayButton.size(); i++){
            final int finalI = i;
            arrayButton.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opera.setNomeSelezionato(arrayClass.get(finalI));
                    Intent mioIntent = new Intent(getApplicationContext(),Opere.class);
                    startActivity(mioIntent);
                }
            });
        }
    }
}
