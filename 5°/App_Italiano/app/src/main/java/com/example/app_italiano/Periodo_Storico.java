package com.example.app_italiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Periodo_Storico extends AppCompatActivity {

    private Button btnPostUnitaria, btnNaturalismoVerismo,btnDecadentismo, btnNovecento, btnGuerre, btnDopoGuerra = null;
    private ArrayList<Button> arrayButton = new ArrayList<>();
    private ArrayList<Class> arrayClassi = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo__storico);
        btnPostUnitaria=findViewById(R.id.btnPostunitaria);
        btnNaturalismoVerismo=findViewById(R.id.btnNaturalismoVerismo);
        btnDecadentismo=findViewById(R.id.btnDecadentismo);
        btnNovecento=findViewById(R.id.btnNovecento);
        btnGuerre=findViewById(R.id.btnGuerre);
        btnDopoGuerra=findViewById(R.id.btnDopoGuerra);

        arrayButton.add(btnPostUnitaria);
        arrayButton.add(btnNaturalismoVerismo);
        arrayButton.add(btnDecadentismo);
        arrayButton.add(btnNovecento);
        arrayButton.add(btnGuerre);
        arrayButton.add(btnDopoGuerra);

        arrayClassi.add(PostUnitaria.class);
        arrayClassi.add(NaturalismoVerismo.class);
        arrayClassi.add(Decadentismo.class);
        arrayClassi.add(Novecento.class);
        arrayClassi.add(Guerre.class);
        arrayClassi.add(DopoGuerra.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0; i < arrayButton.size(); i++){
            final int finalI = i;
            arrayButton.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mioIntent = new Intent(getApplicationContext(),arrayClassi.get(finalI));
                    startActivity(mioIntent);
                }
            });
        }
    }
}
