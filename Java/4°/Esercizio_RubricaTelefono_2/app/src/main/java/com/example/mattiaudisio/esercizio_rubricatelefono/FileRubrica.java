package com.example.mattiaudisio.esercizio_rubricatelefono;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRubrica {
    //NON SI PUÒ FARE TUTTO IL CODICE NEL MainActivity
    private File sdCard;
    public FileRubrica(){
        sdCard= Environment.getExternalStorageDirectory();      //Lo metto in un metodo publico così possono usarlo carica e elimina
    }

    //lo metto public così lo usa anche la MainActivity
    //il numero di telefono è string perchè se fosse stato in int il primo zero me l'avrebbe cancellato
    public boolean caricaDati(String nome,String cognome,String telefono){
        String concatena="";
        concatena=nome+";"+cognome+";"+telefono;
        File rub= new File(sdCard,"Rubrica.txt");
        if(rub.exists()){
            try {
                rub.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter scrivi=new FileWriter(rub);
            scrivi.append(concatena);
            scrivi.flush();
            scrivi.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String cerca(String cognome){      //L'input(nome o cognome della persona) è la firma
        String telefono="";
        File mioFile=new File(sdCard,"Rubrica.txt");
        if(mioFile.exists()){
            try {
                BufferedReader mioBuffer= new BufferedReader(new FileReader(mioFile));      //Buffered Reader che ha come parametro un FileReader che ha come parametro mioFile; Bisogna usarlo per forza
                String frase,fraseSplittata[];
                while((frase=mioBuffer.readLine())!=null){
                    //Bisogna splittare
                    fraseSplittata=frase.split(";");
                    if(fraseSplittata[1]==cognome){
                        telefono=fraseSplittata[2];         //La variabile telefono non deve essere dichiarata all'interno dell'if
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return telefono;
    }

    public String remove(String cognome){
        String telefono="";
        File mioFile=new File(sdCard,"Rubrica.txt");
        if(mioFile.exists()){
            try {
                BufferedReader mioBuffer= new BufferedReader(new FileReader(mioFile));
                String frase,fraseSplittata[];
                while((frase=mioBuffer.readLine())!=null){
                    //Bisogna splittare
                    fraseSplittata=frase.split(";");
                    if(fraseSplittata[1]==cognome){
                        remove(frase);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return telefono;
    }
}