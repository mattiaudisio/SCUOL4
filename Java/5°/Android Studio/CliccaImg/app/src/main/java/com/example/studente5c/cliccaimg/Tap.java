package com.example.studente5c.cliccaimg;

public class Tap {
    //Se non c'è niente (public,private) è default (package private)
    //private: solo all'interno della classe posso accedere ad un determinato valore
    //package private: visibile a tutte le classi che sono nel package
    int valore = 0;
    double tempo = 0, momentoTap = 0;
    long variabile = 0;


    public void startTempo(){
        variabile =  System.nanoTime();
    }

    public double stopTempo(){
       long endTempo = System.nanoTime();
       long lunghezzaTempo = endTempo - variabile;
       double secondi = (double) lunghezzaTempo/ 1_000_000_000;
       return  secondi;
    }
}