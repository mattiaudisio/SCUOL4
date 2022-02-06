package com.example.audisioverifica;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

public class ReceiverBatteria extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String azione = intent.getAction();
        NotificationManager mioManager = (NotificationManager) context.getApplicationContext().getSystemService(azione);
        NotificationCompat.Builder miaNotifica = new NotificationCompat.Builder();
        miaNotifica.setContentTitle("Livello batteria");
        miaNotifica.setContentText("Il livello di batteria è "+azione);
        mioManager.notify();
    }
}