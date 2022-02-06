package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Guerre extends AppCompatActivity {

    private Button btnKafka, btnJoyce, btnSaba, btnUngaretti, btnQuasimodo, btnMontale = null;
    private ArrayList<Button> arrayButton = new ArrayList<>();
    private ArrayList<String> arrayClass = new ArrayList<String>();
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guerre);
        btnKafka = findViewById(R.id.btnKafka);
        btnJoyce = findViewById(R.id.btnJoyce);
        btnSaba = findViewById(R.id.btnSaba);
        btnUngaretti = findViewById(R.id.btnUngaretti);
        btnQuasimodo = findViewById(R.id.btnQuasimodo);
        btnMontale = findViewById(R.id.btnMontale);

        arrayButton.add(btnKafka);
        arrayButton.add(btnJoyce);
        arrayButton.add(btnSaba);
        arrayButton.add(btnUngaretti);
        arrayButton.add(btnQuasimodo);
        arrayButton.add(btnMontale);

        arrayClass.add("Franz Kafka");
        arrayClass.add("James Joyce");
        arrayClass.add("Umberto Saba");
        arrayClass.add("Giuseppe Ungaretti");
        arrayClass.add("Salvatore Quasimodo");
        arrayClass.add("Eugenio Montale");
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
