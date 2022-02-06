package com.example.mattiaudisio.app_drag__drop;

import android.content.ClipData;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {      //SONO 2 INTERFACCE CHE IMPLEMENTO
   //POSSO EREDITARE DA UNA CLASSE MA POSSO IMPLEMENTARE DA PIÙ CLASSI
   private TextView txt1,txt2,txt3,txt4,txt5,txt6; //È UN CAMPO VISIBILE SIA NELL'onCreate CHE NELL'onResume

    @Override       //SIGNIFICA SOVASCRIVI
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //super RIHCIAMA IL METODO onCreate DAL PADRE,PRENDE IL savedInstanceState E LO PASSA AD appCompatActivity
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.txt4);
        txt5=findViewById(R.id.txt5);
        txt6=findViewById(R.id.txt6);
    }

    @Override
    protected void onResume() {
        super.onResume();
       //SI PUÒ CREARE UN SOLO SPETTATORE PER LE TEXT WIEW
       //PER AVERE UN SOLO SPETTATORE DEVO IMPLEMENTARE SU public class MainActivity extends AppCompatActivity LE INTERFACCE E SE È SOTTOLINEATO IN ROSSO DEVO IMPLEMENTARE I METODI
       txt1.setOnLongClickListener(this);
       txt2.setOnLongClickListener(this);
       txt3.setOnLongClickListener(this);
       txt4.setOnLongClickListener(this);
       txt5.setOnLongClickListener(this);
       txt6.setOnLongClickListener(this);

       //GESTISCO L'EVENTO DEL FRAG & DROP
       txt1.setOnDragListener(this);
       txt2.setOnDragListener(this);
       txt3.setOnDragListener(this);
       txt4.setOnDragListener(this);
       txt5.setOnDragListener(this);
       txt6.setOnDragListener(this);

    }

    @Override
    public boolean onLongClick(View v) {    //V CORRISPONDE ALL'OGGETO CHE HAI CLICCATO

        try{
            TextView txtselezionata=(TextView) v;           //FACCIO DIVENTARE UN OGGETTO GENERICO IN UNA TEXTVIEW
             //txtselezionata.getText();
            ClipData miaClipData= ClipData.newPlainText("primo",txtselezionata.getText()); //serve per non passare un parametro, al posto di passare un parametro passo un clip data, miaClipData conterrà un dizionario
            View.DragShadowBuilder mioShadow= new View.DragShadowBuilder(v);        //View.DragShadowBuilder() VUOLE UNA VIEW GENERICA, viene utilizzato per far vedere una determinata cosa quando trasciniamo
            txtselezionata.startDrag(miaClipData,mioShadow,null,0);     //IL TERZO PARAMETRO RAPPRESENTA L'OGGETTO CHE TU VUOI PASSARE AL CONTENITORE(OGGETTO --> VIEW);    METODO DEPRECATO
        }
        catch (Exception e){
            System.err.println("eccezzione di cast");
        }
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        //I PARAMETRI DI QUESTO METODO: VIEW FA RIFERIMENTO AL CONTENITORE, DragEvent FA RIFERIMENTO ALL'OGGETTO
        //ESISTONO DELLE COSTANTI
        switch(event.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:     //QAUNDO TI AGGANCI

                return false;

            case DragEvent.ACTION_DRAG_ENTERED:     //QUANDO L'OGGETTO TOCCA IL CONTENITORE
                v.setBackgroundColor(Color.RED);
                return true;

            case  DragEvent.ACTION_DRAG_LOCATION:
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                v.setBackgroundColor(Color.TRANSPARENT);
                return true;

            case DragEvent.ACTION_DROP:
                v.setBackgroundColor(Color.TRANSPARENT);
                int numerosorgente=Integer.parseInt(event.getClipData().getItemAt(0).getText().toString()); //getText MI RITORNA UNA CHAR SEQUENCE E NON UNA STRINGA; INTEGER È UNA CLASSE/OGGETTO (CI SONO I METODI), (int) È UNA VARIABILE PRIMITIVA (NON CI SONO I METODI)
                TextView contenitore=(TextView) v;
                int numerocontenitore=Integer.parseInt(contenitore.getText().toString());
                int risultato=numerocontenitore+numerosorgente;
                contenitore.setText(String.valueOf(risultato));         //setText NON VUOLE UN INT MA VUOLE UNA STRINGA
                return true;

            case  DragEvent.ACTION_DRAG_ENDED:
                return true;

        }
        return false;
    }
}
