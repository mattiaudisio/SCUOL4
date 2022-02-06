package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class NaturalismoVerismo extends AppCompatActivity {

    private Button btnFlaubert, btnVerga = null;
    private ArrayList<Button> arrayButton = new ArrayList<>();
    private ArrayList<String> arrayClass = new ArrayList<>();
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naturalismo_verismo);
        btnFlaubert = findViewById(R.id.btnFlaubert);
        btnVerga = findViewById(R.id.btnVerga);

        arrayButton.add(btnFlaubert);
        arrayButton.add(btnVerga);

        arrayClass.add("Gustave Flaubert");
        arrayClass.add("Giovanni Verga");
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < arrayButton.size(); i++) {
            final int finalI = i;
            arrayButton.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opera.setNomeSelezionato(arrayClass.get(finalI));
                    Intent mioIntent = new Intent(getApplicationContext(), Opere.class);
                    startActivity(mioIntent);
                }
            });
        }
    }
}