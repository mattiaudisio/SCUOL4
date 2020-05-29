package it.denina.rivoira.basioop;

public class Starter {

	public static void main(String[] args) {
		
		// COSTRUTTORI

		Padre p1 = new Padre("Rossi");
		Padre p2 = new Padre("Bianchi", 40);	
		Figlio f1 = new Figlio("Rossi");		
//		Figlio f2 = new Figlio("Bianchi", 18);	// undefined
		
		System.out.println("Padre p1 is " + p1.getCognome());
		System.out.println("Padre p1 is " + p1.getCognome());
		System.out.println("Figlio f1 is " + f1.getCognome());
		
		
		
		
		// CASTING
		
		Padre p3 = new Figlio("Rossi");				
//		Figlio f3 = new Padre("Rossi");			// Type mismatch	
//		prima creo il padre e poi lo assegno ad un oggetto di classe figlio, però l'opposto funziona
		
//		System.out.println("Mail di p3 is " + p3.getMail());				// undefined
		System.out.println("Mail di p3 is " + ((Figlio) p3).getMail());		// casting
		
		
		
		
		
		
		// PASSAGGIO PARAMETRI PRIMITIVI
		
		int mainEta = 14;
		String mainCognome = "De Paperi";

		Figlio f3 = new Figlio(mainCognome); //gli setto come cognome mainCognome
		f3.setEta(mainEta);		//gli setto come età mainEta
		System.out.println("\n- - - - - - - - - - - -");
		System.out.println("mainEta is " + mainEta + " [PRIMA della variazione]");
		System.out.println("mainCognome is " + mainCognome + " [PRIMA della variazione]");
		System.out.println("f3 ha " + f3.getEta() + " anni [PRIMA della variazione]");
		System.out.println("f3 is " + f3.getCognome() + " anni [PRIMA della variazione]");
		
		mainEta++;		//Variabile incrementata
		mainCognome = "De Topolinis";

		System.out.println("\n- - - - - - - - - - - -");
		System.out.println("mainEta is " + mainEta + " [DOPO la variazione]");
		System.out.println("mainCognome is " + mainCognome + " [DOPO la variazione]");
		System.out.println("f3 ha " + f3.getEta() + " anni [DOPO la variazione]");				//è 14 perchè ho fatto solo la variazione nel main
		System.out.println("f3 is " + f3.getCognome() + " anni [DOPO la variazione]");			//è De Paperi perchè ho fatto solo la variazione nel main
		System.out.println("\n- - - - - - - - - - - -");

		
		
		
		
		// PASSAGGIO PARAMETRI OGGETTI
		//String è di tipo primitivo 
		Telefono t3 = new Telefono("13571357", "24682468");
		System.out.println("t3 is " + t3.getnCasa() + " e " + t3.getnLavoro() + " [PRIMA della variazione]");
		Figlio f4 = new Figlio("QUARTO");
		f4.setEta(22);				//il passaggio degli oggetti è da riferimento
		f4.setTelefono(t3);
		System.out.println("t3 (main) is " + t3.getnCasa() + " e " + t3.getnLavoro() + " [DOPO la variazione dentro figlio]");
		System.out.println("telefono di f4 is " + f4.getTelefono().getnCasa() + " e " + f4.getTelefono().getnLavoro() + " [DOPO la variazione]");
		
		//IN JAVA TUTTO FUNZIONA PER PASSAGGIO DI VALORE
		//AI TIPI OGGETTI È PASSATO IL RIFERIMENTO
		

	}

}
