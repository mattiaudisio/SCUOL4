package manutenzioneDB;

public class Main {

	public static void main(String[] args) {
		//tessera,cognome, nome, indirizzo;
		//tessera numero 
		
		CreateDatabase database = new CreateDatabase("studenti");
		database.buildDB();
		System.out.println("Programma terminato");
		// TODO Auto-generated method stub

	}

}
