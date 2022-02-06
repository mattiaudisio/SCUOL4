package com.example.menuappnuovo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mioinflater = getMenuInflater();       //Crea un oggetto di tipo Inflater
        mioinflater.inflate(R.menu.mio_menu,menu);          //Associa il mio XML al menu dellìactivity
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {       //Viene richiamato dalle opzioni del menu
        //Oppure posso fare int OpzSelezionata = item.getItemID();
        switch(item.getItemId()){
            case(R.id.opz1):
                SharedPreferences mioshared = PreferenceManager.getDefaultSharedPreferences(this);
                mioshared.getInt("tempo",1);
                break;

            case(R.id.opz2):
                break;

            case(R.id.opz3):
                Intent avviaSetting = new Intent(this,mia_setting.class);
                startActivity(avviaSetting);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}