package com.example.mattiaudisio.es_ristoranti;

//QUESTA CLASSE GESTISCE IL SINGOLO RISTORANTE
public class Ristorante {
    private String nomeRistorante=null;
    private int nPosti=0;           //LE VARIABILI NON LE INIZIALIZZO A NULL

    public Ristorante(String n,int p){  //ABBIAMO DUPLICATO LA CLASSE RISTORANTE
        this.nomeRistorante=n;
        this.nPosti=p;
    }
}
