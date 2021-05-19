package com.example.valiumtavorserenase;

import java.util.ArrayList;

//QUESTA CLASSE CONTIENE TUTTI I METODI CHE SERVONO PER CONTROLLARE I RISTOARANTI
public class Ristoranti {
    //DEVE CONTENERE UN INSIEME DI RISTORANTI
    private ArrayList<Ristorante> mieiRistoranti=null;
    //BISOGNA USARE IL COSTRUTTORE(NON RITORNA NIENTE, IL NOME DEVE ESSERE UGUALE A QUELLA DELLE CLASSI)
    public Ristoranti(){
        mieiRistoranti=new ArrayList<Ristorante>();
    }
    //PER PRELEVARE I 2 PARAMETRI DI RISTORANTE O METTO UNA FIRMA NEL COSTRUTTORE O CREO UN METODO
    public int caricaRistorante(String name,int posti){
        mieiRistoranti.add(new Ristorante(name,posti));            //LO METTO PERCHÈ È UNA STRINGA DI OGGETTI
        return 0;
    }
}
