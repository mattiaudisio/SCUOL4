package com.example.audisioverifica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BATTERY_STATS},0);
        IntentFilter mioIntentFilter = new IntentFilter();
        Intent mioIntent = new Intent(this,ReceiverBatteria.class);
        mioIntentFilter.addAction("android.net.conn.ACTION_BATTERY_CHANGED");
        ReceiverBatteria mioReceiver = new ReceiverBatteria();
        PendingIntent mioPending = PendingIntent.getActivity(this,0,mioIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        mioIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mioReceiver,mioIntentFilter);
    }
}
