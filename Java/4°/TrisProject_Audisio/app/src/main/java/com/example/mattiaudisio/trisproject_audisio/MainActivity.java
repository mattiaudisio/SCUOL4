package com.example.mattiaudisio.trisproject_audisio;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText nome=null;
    private Button bottone0=null;
    private Button bottone1=null;
    private Button bottone2=null;
    private Button bottone3=null;
    private Button bottone4=null;
    private Button bottone5=null;
    private Button bottone6=null;
    private Button bottone7=null;
    private Button bottone8=null;
    private Button terminaPartita=null;
    private Button cominciaPartita=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nome=findViewById(R.id.NomeGIocatore);
        bottone0=findViewById(R.id.button_00);
        bottone1=findViewById(R.id.button_01);
        bottone2=findViewById(R.id.button_02);
        bottone3=findViewById(R.id.button_03);
        bottone4=findViewById(R.id.button_04);
        bottone5=findViewById(R.id.button_05);
        bottone6=findViewById(R.id.button_06);
        bottone7=findViewById(R.id.button_07);
        bottone8=findViewById(R.id.button_08);
        terminaPartita=findViewById(R.id.finisciPartita);
        cominciaPartita=findViewById(R.id.cominciaPartita);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottone0.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);        //Serve per creare l'alert dialog
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 1 Riga 1", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),


        bottone1.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);        //Serve per creare l'alert dialog
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 2 Riga 1", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),

        bottone2.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 3 Riga 1", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),

        bottone3.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 1 Riga 2", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),

        bottone4.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);        //Serve per creare l'alert dialog
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 2 Riga 2", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),


        bottone5.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 3 Riga 2", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),

        bottone6.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);
                        finestra.setIcon(R.drawable.ic_launcher_background);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 1 Riga 3", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),

        bottone7.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);
                        AlertDialog alert = finestra.create();
                        finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast pop = Toast.makeText(getApplicationContext(), "Casella 2 Riga 3", Toast.LENGTH_LONG);
                                pop.show();
                            }
                        });
                    }
                }),

        bottone8.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder finestra = new AlertDialog.Builder(MainActivity.this);
                finestra.setIcon(R.drawable.ic_launcher_background);
                AlertDialog alert = finestra.create();
                finestra.setPositiveButton(" ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast pop = Toast.makeText(getApplicationContext(), "Casella 3 Riga 3", Toast.LENGTH_LONG);
                        pop.show();
                    }
                });
            }
        }),
    }
}