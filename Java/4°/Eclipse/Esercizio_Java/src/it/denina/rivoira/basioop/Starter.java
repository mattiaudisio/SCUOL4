package it.denina.rivoira.basioop;

public class Starter {
	public static void main(String[] args) {
		//COSTRUTTORI
		Padre p1= new Padre("Rossi", 0);
		Padre p2= new Padre("Bianchi");
		Figlio f1= new Figlio("Rossi",0);
//		Figlio f2= new Figlio("Bianchi",18);
				
		System.out.println("Padre p1 is" + p1.getCognome());	//getCognome() SPECIFICATORE D'ACCESSO, LO VEDE SOLO IL PADRE
		System.out.println("Padre p1 is" + p2.getCognome());	
		System.out.println("Figlio p1 is" + f1.getCognome());
	
		//CASTING
		Padre p3= new Figlio("Rossi",0);
		//non posso fare figlio f3=new Padre("Rossi") perchè figlio estende padre
		// quindi figlio può essere padre ma padre non può essere figlio 
		System.out.println("Mail di p3 is"+((Figlio)p3).getMail()); //((figlio)p3) istanzio padre come figlio
	}
}