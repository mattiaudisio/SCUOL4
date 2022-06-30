package esercizio;

import java.util.Scanner;

public class Ts01 {
	public static void ese() {		//Metodo di classe: posso anche richiamarlo dalla Classe senza creare l'Oggetto
		Scanner objScan = new Scanner(System.in);
		String s = objScan.nextLine(); 		//Metodo public String nextLine() {...} dentro classe Scanner
		System.out.println("Ciao a tutti");	//Metodo public static void print(String value) {...} dentro classe out
	}
	
	public String nextLine() { //Metodo d'istanza: devo per forza creare un oggetto per richiamarlo
		return null;
	}
	
	public String getInput() {
		System.out.println("GetInput senza parametri");
		return null;
	}

	public String getInput(String pNome) {
		System.out.println("GetInput pNome String: " + pNome);
		return null;
	}

	public String getInput(int pValue){
		System.out.println("GetInput pValue int: " + pValue);
		return " "+pValue;
	}
	
	public int getRecord(int pID) {
		//.. ricerca record in tabella alunni con ID = pID
		return 891;
	}

	public int getRecord(String pCodiceFiscale) {
		//.. ricerca record in tabella alunno con cf = pCodiceFiscale
		return 891;
	}

	public int getRecord(String pCodiceFiscale, String pPartitaIva) {
		//.. ricerca record in tabella alunno con cf = pCodiceFiscale
		return 891;
	}

}
