package com.example.studente5c.cliccaimg;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.Button;

import java.util.ArrayList;

public class Gioco extends AppCompatDialogFragment {
    int i = 0;
    private ArrayList<Integer> listaNum = new ArrayList<Integer>();
    private ArrayList<Integer> listaSfida = new ArrayList<Integer>();
    private ArrayList<Integer> listaSfida1 = new ArrayList<Integer>();
    private MainActivity main = new MainActivity();
    private Giocata gioca1 = new Giocata();
    int controlloErrori = 0;


    public void AggiungiValore(int numero){
        listaNum.add(numero);
    }

    public void AggiungiValoreSfida(int numero){
        listaSfida.add(numero);
    }

    public void AggiungiValoreSfida1(int numero){
        listaSfida.add(numero);
    }

    public int controlla(){
        for(i=0; i<listaNum.size(); i++){
            if(listaSfida.get(i) != listaSfida1.get(i)){
                controlloErrori = controlloErrori+1;
            }
        }
        return controlloErrori;
    }

    public void stampaLista(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Le immagini che Hai cliccato");
        builder.setMessage("Eccoti, in elenco, il numero delle immagini che hai cliccato:");
        for(i=0; i<listaNum.size(); i++){
            builder.setMessage(listaNum.get(i)+",");
        }
        gioca1.aggiornaLista(listaNum);
    }

    public ArrayList<Integer> getListaSfida() {
        return listaSfida;
    }

    public void funzioneRestart(Button btn1, Button btn2, Button btn3, Button btn4) {
        for(i=0; i<listaNum.size(); i++){
            if(listaNum.get(i) == 1){
                btn1.setPressed(true);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(listaNum.get(i) == 2){
                btn2.setPressed(true);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(listaNum.get(i) == 3){
                btn3.setPressed(true);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(listaNum.get(i) == 4){
                btn4.setPressed(true);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}