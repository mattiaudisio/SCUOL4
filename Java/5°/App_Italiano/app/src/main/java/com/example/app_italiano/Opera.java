package com.example.app_italiano;

public class Opera {

    private String nome, nomeSelezionato, autore = "";

    public  Opera(String nome, String autore) {
        this.nome = nome;
    }

    public String getNome() {

        return nome;
    }

    public String getNomeSelezionato() {
        return nomeSelezionato;
    }

    public void setNomeSelezionato(String nomeSelezionato) {
        this.nomeSelezionato = nomeSelezionato;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }
}
