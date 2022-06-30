package loop_esercizio;

import java.util.ArrayList;

public class LoopForArray {
	
	//metodo di classe che accetti come parametri il calore di inizio e il valore di fine di un ciclo for; esegua il ciclo for ed esegua l’output a video solo dei valori pari; i valori dispari vengono inseriti in un array che deve essere ritornato dal metodo
	public static ArrayList<Integer> n_pariedispari(int pStart,int pFine) {
		ArrayList<Integer> arrayDispari = new ArrayList<Integer>();
		System.out.println("Numeri Pari:");
		for(int i = pStart; i <= pFine; i++) {
			if(i % 2 == 0) {
				System.out.print("\""+i+"\" ");
			}else {
				arrayDispari.add(i);
			}
		}
		System.out.print("\n");
		return arrayDispari;
	}
	
	
	//se il valore del contatore del metodo	richiamato è divisibile con 3 (ovvero da resto 0 se diviso con 3) deve essere utilizzata la keyword “continue” in modo che non si esegua la stampa di un eventuale numero pari né si aggiunga all’array un eventuale numero dispari
	public static ArrayList<Integer> n_pariedispari2(int pStart,int pFine) {
		ArrayList<Integer> arrayDispari = new ArrayList<Integer>();
		for(int i = pStart; i <= (pFine - pStart); i++) {
			if(i % 3 == 0){
				continue;
			}if((i % 2) == 0) {
				System.out.print("\""+i+"\" ");
			}else {
				arrayDispari.add(i);
			}
		}
		return arrayDispari;
	}
}
