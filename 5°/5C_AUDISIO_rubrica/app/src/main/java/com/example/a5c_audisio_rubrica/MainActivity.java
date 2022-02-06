package com.example.a5c_audisio_rubrica;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnConnetti = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnetti = findViewById(R.id.btnConnetti);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnConnetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaServer = new Intent(getApplicationContext(), PaginaServer.class);
                startActivity(paginaServer);
            }
        });
    }
}