package com.example.studente5c.a5caudisioripasso;

import java.util.ArrayList;

public class SalvaValore {

    ArrayList<Integer> listaInt = new ArrayList<Integer>();

    public void aggiungiNum(int numero){
        listaInt.add(numero);
    }

    public boolean controllaNum(int num){
        boolean valore = false;
        for(int i=0; i<listaInt.size(); i++){
            if(listaInt.get(i) == num){
                return true;
            }
        }
        return valore;
    }

    public Integer getListaInt(int numero) {
        return listaInt.get(numero);
    }
}
