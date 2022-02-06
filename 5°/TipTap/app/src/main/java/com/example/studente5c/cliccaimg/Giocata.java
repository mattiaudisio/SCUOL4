package com.example.studente5c.cliccaimg;

import java.util.ArrayList;

public class Giocata {
    double tempo = 0.00;
    ArrayList<ArrayList<Integer>> listaGiocata = new ArrayList<ArrayList<Integer>>();

    public double getTempo() {

        return tempo;
    }

    public void setTempo(double tempo) {

        this.tempo = tempo;
    }

   public void aggiornaLista(ArrayList<Integer> lista){

        listaGiocata.add(lista);
    }
}
