package loop_esercizio;

import java.util.ArrayList;
import java.util.Scanner;

public class CalcoliArray {

	private static Scanner objScanner;

	public static double arrayMedia(double[] arrayDouble) {
		double num = 0;
		for(int i = 0; i < arrayDouble.length; i++) {
			num += arrayDouble[i];
		}
		return num / arrayDouble.length;
	}
	
	public static void inserisciArray() {
		ArrayList<Integer> arrayNumeri = new ArrayList<Integer>(1000);
		int numInserito = 0, numSomma = 0, valore = 0;
		while(numInserito != -1) {
			System.out.print("\nInserisci un numero (Inserisci -1 per uscire) : ");
			objScanner = new Scanner(System.in);
			numInserito = objScanner.nextInt();
			if(numInserito != -1) {
				arrayNumeri.add(numInserito);
			}
		}
		System.out.println("\n*** CICLO TERMINATO **");		
		while(numSomma != arrayNumeri.size()) {
			valore += arrayNumeri.get(numSomma);
			numSomma++;
		}
		System.out.println("\nIl valore totale dei numeri inseriti è : "+valore);
	}
}
