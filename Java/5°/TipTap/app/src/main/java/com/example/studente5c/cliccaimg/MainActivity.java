package com.example.studente5c.cliccaimg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart = null, btnStop = null,btnRestart = null, btn1 = null, btn2 = null, btn3 = null, btn4 = null, btnSfida = null;
    private Gioco giocata = new Gioco();
    private int test = 0,testSfida = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnRestart = findViewById(R.id.btnRestart);
        btnSfida = findViewById(R.id.btnSfida);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 1;
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funzAllertDialog(1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funzAllertDialog(2);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funzAllertDialog(3);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funzAllertDialog(4);
                    }
                });
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
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
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giocata.funzioneRestart(btn1,btn2,btn3,btn4);
            }
        });
        btnSfida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(testSfida == 0){
                    testSfida = 1;
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            giocata.AggiungiValoreSfida(1);
                        }
                    });
                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            giocata.AggiungiValoreSfida(2);
                        }
                    });
                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            giocata.AggiungiValoreSfida(3);
                        }
                    });
                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            giocata.AggiungiValoreSfida(4);
                        }
                    });
                }else{
                    for(int i=0; i<giocata.getListaSfida().size(); i++){
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                giocata.AggiungiValoreSfida1(1);
                            }
                        });
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                giocata.AggiungiValoreSfida1(2);
                            }
                        });
                        btn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                giocata.AggiungiValoreSfida1(3);
                            }
                        });
                        btn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                giocata.AggiungiValoreSfida1(4);
                            }
                        });
                    }
                   int controllo = giocata.controlla();
                   stampaSfida(controllo);
                }
            }
        });
    }

    public void funzAllertDialog(int numero){
        Toast toastInfo1 = Toast.makeText(getApplicationContext(), "Hai premuto"+numero+" ", Toast.LENGTH_SHORT);
        toastInfo1.show();
        giocata.AggiungiValore(numero);
    }

    public void stampaSfida(int numero){
        if(numero == 0){
            Toast toastInfo1 = Toast.makeText(getApplicationContext(), "Hai vinto!", Toast.LENGTH_SHORT);
            toastInfo1.show();

        }else{
            Toast toastInfo1 = Toast.makeText(getApplicationContext(), "Hai vinto ma hai fatto "+numero+" errori", Toast.LENGTH_SHORT);
            toastInfo1.show();
        }
    }
}