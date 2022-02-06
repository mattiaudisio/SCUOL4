package com.example.studente4c.ripasso_18092019;

import android.widget.Button;

public class Pinco {

    MainActivity main = new MainActivity();
    private Button bottone = null;

    public void nomechevoglio(){
        //bottone = main.ritorna();       Salvo i contenuti del MainActivity in bottone
        bottone = main.getInvia();
        //main.invia;                     Se il campo è public non servono i getter ed i setter, ma è sconsigliato tenerli public
        bottone.setText("Ciao");          //Richiamo la proprietà Set per modificare il testo contenuto
    }
}
