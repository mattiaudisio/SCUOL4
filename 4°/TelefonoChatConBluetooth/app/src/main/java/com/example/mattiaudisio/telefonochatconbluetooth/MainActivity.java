package com.example.mattiaudisio.telefonochatconbluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button bottoneConetti=null;
    private Button bottoneSconnetti=null;
    private OutputStream mioStream=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottoneConetti=findViewById(R.id.btnConnetti);
        bottoneSconnetti=findViewById(R.id.btnDisconnetti);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //bottone "CONNETTI"
        bottoneConetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothAdapter mioBLuetooth=BluetoothAdapter.getDefaultAdapter();
                if(mioBLuetooth==null){
                    Toast mioToast=Toast.makeText(getApplicationContext(),"Bluetooth non attivo",Toast.LENGTH_LONG);
                    mioToast.show();
                }else{
                    if(!mioBLuetooth.isEnabled()){
                        Intent mioIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(mioIntent,1);
                    }
                    Set<BluetoothDevice> dispositiviAssociati=mioBLuetooth.getBondedDevices();
                    for(BluetoothDevice temp: dispositiviAssociati) {
                        if (dispositiviAssociati.size() > 0) {
                            if(temp.getName()=="TelefonoMattio"){
                                BluetoothDevice bluetoothUtente2=temp;
                            }
                        }else{
                            Toast mioToast = Toast.makeText(getApplicationContext(), "Nessun dispositivo associato", Toast.LENGTH_LONG);
                            mioToast.show();
                        }
                    }
                }
            }
        });
        //bottone SCONNETTI
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
    }
}
