package com.example.mattiaudisio.base_progetti;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button pulsante=null;
    private EditText testo=null;
    private Button pulsante2=null;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pulsante=findViewById(R.id.btnToast);
        pulsante2=findViewById(R.id.btnAlert);
        EditText testo=findViewById(R.id.txtMsg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String frase=testo.getText().toString();
                Toast popUp=Toast.makeText(getApplicationContext(), frase, Toast.LENGTH_LONG);
                popUp.show();
            }
        });
        pulsante2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder finestra=new AlertDialog.Builder(MainActivity.this);
                finestra.setTitle("IO SONO IL TITOLO");
                finestra.setMessage("IO SONO IL MESSAGGIO");
                finestra.setIcon(R.drawable.ic_launcher_background);
                finestra.setPositiveButton("ETICHETTA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast pop=Toast.makeText("SONO IL TOAST", Toast.LENGTH_LONG);
                        pop.show();
                    }
                });
                finestra.create();
                finestra.show();
            }
        });

    }

}
