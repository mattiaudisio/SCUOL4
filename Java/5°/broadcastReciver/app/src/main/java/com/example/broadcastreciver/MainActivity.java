package com.example.broadcastreciver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

//Broadcast Receiver è un ricevitore di broadcast; l'O.S. invia un messaggio di broadcast a tutte le apllicazioni; Possono essere impliciti o espliciti

public class MainActivity extends AppCompatActivity {

    //Autorizzazioni Pericolose: Sensori corporei(Giroscopio,Accellerometro), calendario, videocamera, contatti, posizione, microfono, telefono (Batteria,Connessione...), SMS e archivazione
    //Quando si parla di autorizzazioni pericolose i permessi devono essere dichiarati all'interno dell'Activity (in RunTime), non all'interno dell'AndroidManifest
    //Per prima cosa dobbiamo dire quale intent-filter vogliamo creare

    IntentFilter mioIntentFilter = null;
    mioReceiverWiFi mioReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BATTERY_STATS},0);
        mioIntentFilter = new IntentFilter();
        mioIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE"); //intercetta quando la connessione cambia
        mioReceiver = new mioReceiverWiFi();
        mioIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mioReceiver,mioIntentFilter); //Passa il messaggio al Broadcast Receiver
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_DENIED){             //All'inzio bisogna vedere se hai il permesso o no
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALENDAR},0);
        }
    }
}