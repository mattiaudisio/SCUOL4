package com.example.studente5c.customarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView miaLista = null;
    private ArrayList<Persone> alunni = new ArrayList<Persone>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miaLista=findViewById(R.id.listMia);
        alunni.add(new Persone("Mario","Rossi"));
        alunni.add(new Persone("Simona","Bianchi"));
        CustomAdapter mioCustom = new CustomAdapter(this,R.layout.layoutlistview,alunni);   //1: this,  2: layout (R.layout.nomeFile), 3: quello che gli vogliamo passare (es. alunni)
        miaLista.setAdapter(mioCustom);
    }

}