package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAccedi = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAccedi=findViewById(R.id.btnAccedi);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mioIntent = new Intent(getApplicationContext(),Periodo_Storico.class);
                startActivity(mioIntent);
            }
        });
    }
}
