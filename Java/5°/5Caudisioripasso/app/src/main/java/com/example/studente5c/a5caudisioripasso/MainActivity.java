package com.example.studente5c.a5caudisioripasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn0 = null, btn1 = null, btn2 = null, btn3 = null, btn4 = null, btn5 = null, btn6 = null, btn7 = null, btn8 = null, btn9 = null;
    private Boolean valoreControllo = null;
    private SalvaValore salvaValore = new SalvaValore();
    private int Prova = 0;    //Serve come controllo perchè, durante delle prove, mi spuntava il Toast appena aprivo l'applicazione e poi non appariva più

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    @Override
    protected void onResume() {
        super.onResume();
            btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(0);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(0);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(1);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(1);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(2);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(2);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(3);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(3);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(4);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(4);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(5);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(5);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(6);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(6);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(7);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(7);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(8);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(8);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    valoreControllo = salvaValore.controllaNum(9);
                    if(valoreControllo == false){
                        salvaValore.aggiungiNum(9);
                        Prova = Prova + 1;
                    }else{
                        stampaAllerta();
                    }
                    stampaNumeri();
                }
            });
    }

   //Ho dovuto fare i Toast nel main perchè altrimenti mi si bloccava l'applicazione all'avvio
   public void stampaNumeri(){
        if(Prova == 10){
            Toast stampaAnteprima = Toast.makeText(getApplicationContext(),"Elenco bottoni premuti:",Toast.LENGTH_SHORT);
            stampaAnteprima.show();
            for(int i=0; i<10; i++){
                int valore = salvaValore.getListaInt(i);
                Toast stampaNumeri = Toast.makeText(getApplicationContext(),valore+"",Toast.LENGTH_SHORT);
                stampaNumeri.show();
            }

        }
    }

   public void stampaAllerta(){
        Toast stampaAllerta = Toast.makeText(getApplicationContext(),"Non è possibile premere un pulsante premuto in precedenza",Toast.LENGTH_SHORT);
        stampaAllerta.show();
   }
}