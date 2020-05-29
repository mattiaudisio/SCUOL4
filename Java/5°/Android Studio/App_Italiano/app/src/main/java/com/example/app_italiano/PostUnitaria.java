package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostUnitaria extends AppCompatActivity {

    private Button btnCarducci = null;
    private Opera opera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_unitaria);
        btnCarducci = findViewById(R.id.btnCarducci);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCarducci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opera.setNomeSelezionato("Giosuè Carducci");
                Intent mioIntent = new Intent(getApplicationContext(), Opere.class);
                startActivity(mioIntent);
            }
        });
    }
}
