package com.example.studente5c.cliccaimg;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import java.util.ArrayList;

public class Gioco extends AppCompatDialogFragment {
    int i = 0;
    private ArrayList<Integer> listaNum = new ArrayList<Integer>();

    public void aggiungiLista(int numero){
        listaNum.add(numero);
    }

    public void stampaLista(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Le immagini che Hai cliccato");
        builder.setMessage("Eccoti, in elenco, il numero delle immagini che hai cliccato:");
        for(i=0; i<listaNum.size(); i++){
            builder.setMessage(listaNum.get(i)+",");
        }
    }
}