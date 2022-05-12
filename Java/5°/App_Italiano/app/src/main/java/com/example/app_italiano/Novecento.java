package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Novecento extends AppCompatActivity {

    private Button btnFuturisti, btnSvevo, btnPirandello = null;
    private ArrayList<Button> arrayButton = new ArrayList<>();
    private ArrayList<String> arrayClass = new ArrayList<>();
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novecento);
        btnFuturisti = findViewById(R.id.btnFururismo);
        btnSvevo = findViewById(R.id.btnSvevo);
        btnPirandello = findViewById(R.id.btnPirandello);

        arrayButton.add(btnFuturisti);
        arrayButton.add(btnSvevo);
        arrayButton.add(btnPirandello);

        arrayClass.add("Novecento");
        arrayClass.add("Italo Svevo");
        arrayClass.add("Luigi Pirandelllo");
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
