package com.example.audisioverifica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Toast;

public class InfiormazioniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infiormazioni);

        Toast mioToast = Toast.makeText(this,"Livello Attuale Batteria"+BatteryManager.EXTRA_LEVEL+"/100",Toast.LENGTH_SHORT);
        Toast mioToast2 = Toast.makeText(this,"Livello Max Batteria: "+BatteryManager.EXTRA_SCALE+"/100",Toast.LENGTH_SHORT);
        Toast mioToast3 = Toast.makeText(this,"Livello Temperatura: "+ BatteryManager.EXTRA_VOLTAGE,Toast.LENGTH_SHORT);
        Toast mioToast4 = Toast.makeText(this,"Livello Volt: "+BatteryManager.EXTRA_TEMPERATURE,Toast.LENGTH_SHORT);

        mioToast.show();
        mioToast2.show();
        mioToast3.show();
        mioToast4.show();
    }

}
