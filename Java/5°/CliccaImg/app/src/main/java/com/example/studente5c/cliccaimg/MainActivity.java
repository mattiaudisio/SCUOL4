package com.example.studente5c.cliccaimg;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1 = null, btn2 = null;
    private ImageView img1 = null, img2 = null, img3 = null, img4 = null;
    private Gioco giocata = new Gioco();
    private Tap funzTap = new Tap();
    private int test = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        funzTap.startTempo();
    }

    @Override
    public void onClick(View v) {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                double tempo = 0;
                img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toastInfo1 = Toast.makeText(getApplicationContext(), "Hai premuto1", Toast.LENGTH_SHORT);
                        toastInfo1.show();
                        giocata.aggiungiLista(1);
                        double tempo = funzTap.stopTempo();
                        Toast toastPremuto = Toast.makeText(getApplicationContext(), "Hai premuto per", Toast.LENGTH_SHORT);
                        toastPremuto.setText(tempo + " secondi");
                    }
                });
                img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toastInfo2 = Toast.makeText(getApplicationContext(), "Hai premuto2", Toast.LENGTH_SHORT);
                        toastInfo2.show();
                        giocata.aggiungiLista(2);
                        double tempo = funzTap.stopTempo();
                        Toast toastPremuto = Toast.makeText(getApplicationContext(), "Hai premuto per", Toast.LENGTH_SHORT);
                        toastPremuto.setText(tempo + " secondi");
                    }
                });
                img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toastInfo3 = Toast.makeText(getApplicationContext(), "Hai premuto3", Toast.LENGTH_SHORT);
                        toastInfo3.show();
                        giocata.aggiungiLista(3);
                        double tempo = funzTap.stopTempo();
                        Toast toastPremuto = Toast.makeText(getApplicationContext(), "Hai premuto per", Toast.LENGTH_SHORT);
                        toastPremuto.setText(tempo + " secondi");
                    }
                });
                img4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toastInfo4 = Toast.makeText(getApplicationContext(), "Hai premuto4", Toast.LENGTH_SHORT);
                        toastInfo4.show();
                        giocata.aggiungiLista(5);
                        double tempo = funzTap.stopTempo();
                        Toast toastPremuto = Toast.makeText(getApplicationContext(), "Hai premuto per", Toast.LENGTH_SHORT);
                        toastPremuto.setText(tempo + " secondi");
                    }
                });
                test = 1;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(test == 1){
                    giocata.stampaLista();
                }else{
                    Toast toastInfo =  Toast.makeText(getApplicationContext(),"Devi premere Start",Toast.LENGTH_SHORT);
                    toastInfo.show();
                }
            }
        });
    }
}