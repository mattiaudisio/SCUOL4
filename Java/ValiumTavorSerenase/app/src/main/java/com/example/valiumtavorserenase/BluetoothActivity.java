package com.example.valiumtavorserenase;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class BluetoothActivity extends AppCompatActivity {

    private int costante=1;
    private BluetoothDevice arduinobt=null;
    private Button accendi=null;
    private Button spegni=null;
    private Button collega=null;
    private Button disconnetti=null;
    private BluetoothSocket miosocket=null;
    private OutputStream miostream=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        accendi=findViewById(R.id.btnaccendi);
        spegni=findViewById(R.id.btnspegni);
        collega=findViewById(R.id.btncollega);
        disconnetti=findViewById(R.id.btndisconnetti);


        //BluetoothAdapter      prima calasse da usare, bluethoot del nostro cellulare
        //BluetoothDevice       seconda classe, bluethoot remoto in questo caso l'arduino
        //BluetoothSocket       terza classe, canale che serve per inviare e ricevere info
    }

    @Override
    protected void onResume() {
        super.onResume();
        collega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothAdapter miobluethoot= BluetoothAdapter.getDefaultAdapter();  //prende bluethoot che ce nel cellulare e lo salva in miobluethoot


                //miobluethoot.listenUsingRfcommWithServiceRecord();   ritorna un oggetto di tipo socket server, poi basta richiamare l metodo accept(blocca programma e aspetta una connessione)


                if(miobluethoot==null){ //controllo se ce il bluethoot
                    Toast.makeText(getApplicationContext(),"Non e presente il bluethoot!", Toast.LENGTH_SHORT).show();
                }else{
                    if(!miobluethoot.isEnabled()){  //controllo se e acceso
                        Intent miointent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);  //Intent Implicito -- BluetoothAdapter.ACTION_REQUEST_ENABLE serve per accendere il bluetooth
                        startActivityForResult(miointent,costante);
                    }

                    Set<BluetoothDevice> dispassociati= miobluethoot.getBondedDevices();   //per cercare i dispositivi associati al nostro bluethooth, [getBondedDevices()] restituisce una lista di bluetooth device cioe reomoti
                    if (dispassociati.size()>0) {
                        for(BluetoothDevice pinco:dispassociati){  //cicla per tutti  gli elementi
                            if(pinco.getName()=="HC-06"){  //controllo il nome con getName()
                                arduinobt=pinco;
                            }
                        }

                    }else{
                        Toast.makeText(getApplicationContext(),"Nessun dispositivo associato!",Toast.LENGTH_SHORT).show();
                    }

                }

                //00001101-0000-1000-8000-00805F9B34FB
                UUID miouuid=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); //recuperare il profilo bluetooth
                try {
                    miosocket= arduinobt.createRfcommSocketToServiceRecord(miouuid);  //creato un tubo tra mio bluetooth e quella associato
                    miosocket.connect();
                    /*
                    OutputStream miostream= miosocket.getOutputStream();
                    miostream.write(92);
                    miosocket.close();
                    BluetoothSocket miostream.close();  //per togliere la connessione
                    */


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        disconnetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    miostream.close();
                    miosocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        accendi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    miostream= miosocket.getOutputStream();
                    miostream.flush();  //Per pulire il buffer
                    miostream.write('A');
                    miostream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        spegni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    miostream.flush();  //Per pulire il buffer
                    miostream.write('S');
                    miostream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}