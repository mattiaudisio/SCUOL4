package com.example.studente5c.cliccaimmagini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {       //Una classe astratta è una classe che non può essere instanziata

    private Button btn1 = null, btn2 = null;
    private ImageView img1 = null, img2 = null, img3 = null, img4 = null;
    private Gioco giocata = new Gioco();
    private int prova = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prova == 0) {
                    Toast ToastAllerta = Toast.makeText(MainActivity.this, "Devi premere il bottone START", Toast.LENGTH_LONG);
                }else{
                   giocata.stampaLista();
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prova = 1;
                Start();
            }
        });
    }

    public void Start(){
        switch(prova){
            case R.id.imageView:
                Toast toastInfo1 = Toast.makeText(getApplicationContext(),"Hai premuto1",Toast.LENGTH_LONG);
                toastInfo1.show();
                giocata.aggiungiLista(1);
                break;
            case R.id.imageView2:
                Toast toastInfo2 = Toast.makeText(getApplicationContext(),"Hai premuto2",Toast.LENGTH_LONG);
                toastInfo2.show();
                giocata.aggiungiLista(2);
                break;
            case R.id.imageView3:
                Toast toastInfo3 = Toast.makeText(getApplicationContext(),"Hai premuto3",Toast.LENGTH_LONG);
                toastInfo3.show();
                giocata.aggiungiLista(3);
                break;
            case R.id.imageView4:
                Toast toastInfo4 = Toast.makeText(getApplicationContext(),"Hai premuto4",Toast.LENGTH_LONG);
                toastInfo4.show();
                giocata.aggiungiLista(5);
                break;
        }

    }
}