package com.example.valiumtavorserenase;

import android.widget.TextView;

public class Anagrafica {
    private TextView Stnome=null, Stcognome=null, Stmail=null;

    public void setNome(TextView nome){
        Stnome=nome;
    }

    public TextView getNome(){
        return Stnome;
    }

    public void setCognome(TextView cognome){
        Stcognome=cognome;
    }

    public TextView getCognome(){
        return Stcognome;
    }

    public void setMail(TextView mail){
        Stmail=mail;
    }

    public TextView getMail(){
        return Stmail;
    }
}
