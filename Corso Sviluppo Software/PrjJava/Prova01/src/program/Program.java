package program;

//import loop_esercizio.*;  Importa tutte le classi presenti nel package
//import loop_esercizio.LoopFor;				I package lì posso o importare singolarmente oppure tutti insieme
//import loop_esercizio.LoopForArray;

import java.util.ArrayList;
import loop_esercizio.*;
import classi_esercizio.*;

public class Program {

	public static void main(String[] args) {
		String[] arrayNomi = ElencoNomi.elencoNomi();
		double[] num = {1,2,3,4,5,6,7,8,9,10};
		double[] arrayMedia = {1,2,3,4,5,6,7,8,9,10};
		
		ClassePersona.creaObj(arrayNomi);
		Calcoli calcoli = new Calcoli();
		
		LoopFor.esercizio01();
		LoopFor.esercizio02();
		LoopFor.esercizio03();
		ArrayList<Integer> arrayDispari = LoopForArray.n_pariedispari(20,50);
		System.out.println("\n\nNumeri Dispari:");
		for(int i = 0; i < arrayDispari.size(); i++) {
			if(arrayDispari.get(i) == 0) {
				continue;
			}
			System.out.print("\""+arrayDispari.get(i)+"\" ");
		}
		
		//Stampo i valori tramite println i valori. Se la print torna i valori che l'utente aveva scritto
		//prima significa che le informazioni inserite sono presenti nell'array, se invece torna null e 0
		//significa che le informazioni non son presenti nell'array
		System.out.println("\n\nIl valore che è arrivato dal primo mthInput è: " + ClassePersona.mthInput("Giacomo"));
		System.out.println("Il valore che è arrivato dal secondo mthInput è: " + ClassePersona.mthInput(6));
		
		System.out.println("\nSomma : "+calcoli.somma(45, 57, 48));
		System.out.println("\nSomma : "+calcoli.somma(num,5));		
		System.out.println("\nMedia : "+CalcoliArray.arrayMedia(arrayMedia));
		CalcoliArray.inserisciArray();
		
	}	

}