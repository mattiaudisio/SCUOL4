package com.example.mattiaudisio.bluetootharduino_audisio;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button bottoneAccendi=null, bottoneSpegni=null, bottoneConnetti=null, bottoneSconnetti=null;
    private int costante=1;
    private  BluetoothDevice ArduinoBT=null;
    private BluetoothSocket mioSocket=null;     //LO METTO QUA PERCHÈ DEVE ESSERE VISTO DA TUTTI
    private  OutputStream mioStream=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottoneAccendi.findViewById(R.id.btnAccendi);
        bottoneSpegni.findViewById(R.id.btnSpegni);
        bottoneConnetti.findViewById(R.id.btnconnetti);
        bottoneSconnetti.findViewById(R.id.btnSconnetti);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottoneSconnetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mioStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bottoneAccendi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mioStream=mioSocket.getOutputStream();
                    mioStream.flush();     //pulisce il Buffer
                    mioStream.write(96);
                    mioStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bottoneSconnetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mioSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bottoneConnetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BluetoothAdapter --> Bluetooth del nostro cellulare, viene usata per gestire il Bluetooth del nostro cellulare
                //BluetoothDevice --> Arduino, Bluetooth remoto
                //BluetoothSocket --> canale di trasmissione delle informazioni, le informazioni vengono inviate attraverso i socket

                BluetoothAdapter  mioBluetooth=BluetoothAdapter.getDefaultAdapter();        //Prende il Bluetooth che c'è sul nostro cellulare
                //ritorna un oggetto di tipo Socket Server
                //il metodo accett blocca il programma e aspetta una risposta
                if(mioBluetooth==null){
                    Toast mioToast=Toast.makeText(getApplicationContext(),"Non c'è il Bluetooth",Toast.LENGTH_LONG);
                    mioToast.show();
                }else{
                    if(!mioBluetooth.isEnabled()){  //controllo se NON è acceso
                        //Bisogna per forza fare un intent implicito
                        Intent mioIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);    //Abbiamo creato una richiesta che verrà inviata al S.O. che ci cercherà un applicazione in grado di attivare il BLuetooth
                        startActivityForResult(mioIntent,costante);
                    }
                    Set<BluetoothDevice> dispositviAssociati=mioBluetooth.getBondedDevices(); //Mi restituisce una lista di BLuetooth Device (Dispositivi associati; max. 7)
                    if(dispositviAssociati.size()>0){
                        for(BluetoothDevice pincopallino:dispositviAssociati){      //prende un device è lo salva in pincopallino
                            if(pincopallino.getName()=="HC-06"){
                                ArduinoBT=pincopallino;
                            }
                        }
                    }else{
                        Toast mioToast=Toast.makeText(getApplicationContext(),"Nessun dispositivo associato",Toast.LENGTH_LONG);
                        mioToast.show();
                    }
                }
                //Bisogna effettuare la connessione con l'Arduino
                //00000000-0000-1000-8000-00805F9B34FB
                UUID miouuid= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");      //profilo del serial
                try {
                    mioSocket=ArduinoBT.createRfcommSocketToServiceRecord(miouuid);
                    OutputStream mioStream=mioSocket.getOutputStream();
//                    mioStream.write(92);
//                    mioSocket.close();
//                    mioStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}