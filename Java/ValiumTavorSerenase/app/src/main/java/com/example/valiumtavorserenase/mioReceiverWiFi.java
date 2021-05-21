package com.example.valiumtavorserenase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.widget.Toast;

public class mioReceiverWiFi extends BroadcastReceiver{
    ConnectivityManager mioManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String azione = intent.getAction();
        if("android.net.conn.CONNECTIVITY_CHANGE".equals(azione)){
            mioManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE); //Si recupera dal Context
            NetworkInfo mioNetwork = mioManager.getActiveNetworkInfo();
            if(mioNetwork != null){
                if(mioNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                    Toast.makeText(context,"Il Wi-Fi è acceso",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"Il Wi-Fi è spento",Toast.LENGTH_LONG).show();
                }
            }
        }
        if(intent.getAction().equals(intent.ACTION_BATTERY_CHANGED)){
            Toast.makeText(context,"Batteria",Toast.LENGTH_LONG).show();
            int livelloMax = intent.getIntExtra(BatteryManager.EXTRA_SCALE,0);
            int livelloAttuale = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            int livelloConnessione = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0); // come stai caricando il tuo cellulare;   2 USB 4 WI-FI
            int stato = intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);  //1 unknow, 2 batteria si sta caricando, 3 batteria sta scaricando, 5 batteria carica
            Toast.makeText(context,"Batteria:"+livelloAttuale+"/"+livelloMax,Toast.LENGTH_LONG).show();
        }
    }
}
