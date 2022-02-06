package com.example.a5c_audisio_rubrica;

public class Contatto {
    private String nomeContatto, cognomeContatto, numeroContatto = null;

    public Contatto(String nomeContatto,String cognomeContatto, String numeroContatto){
        this.nomeContatto = nomeContatto;
        this.cognomeContatto = cognomeContatto;
        this.numeroContatto = numeroContatto;
    }

    public String getNomeContatto() {
        return nomeContatto;
    }

    public String getCognomeContatto() {
        return cognomeContatto;
    }


    public String getNumeroContatto() {
        return numeroContatto;
    }

}
