package esercizio;

import java.util.Scanner;

public class ScannerTest {

	Scanner objScanner = new Scanner(System.in);
	Scanner objScanner2 = new Scanner(System.in);

	public void inputString() {
		System.out.print("Inserire un nome: ");
		String s = objScanner.nextLine();
		System.out.println("Il nome inserito è "+s);
	}
	
	public void inputIntero() {
		System.out.print("Inserisci intero 1: ");
		int s1 = objScanner.nextInt();
		System.out.print("Inserisci intero 2: ");
		int s2 = objScanner.nextInt();
		int somma = s1 +s2;
		System.out.println("La somma totale è: "+somma);
	}	
	
	public String getInput(String valore) {
		System.out.print("Inserisci stringa: ");
		return objScanner2.nextLine();
	}

	public int getInput(int num) {
		System.out.print("Inserisci intero: ");
		return objScanner.nextInt();
	}

	public double getInput(double num) {
		System.out.print("Inserisci un dobule: ");
		return objScanner.nextDouble();
	}
	
}