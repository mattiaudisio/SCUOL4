package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DopoGuerra extends AppCompatActivity {

    private Button btnSciaScia = null;
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dopo_guerra);
        btnSciaScia=findViewById(R.id.btnSciascia);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSciaScia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opera.setNomeSelezionato("Leonardo Sciascia");
                Intent mioIntent = new Intent(getApplicationContext(), Opere.class);
                startActivity(mioIntent);
            }
        });
    }
}
