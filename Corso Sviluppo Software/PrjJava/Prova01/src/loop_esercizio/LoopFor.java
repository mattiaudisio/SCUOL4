package loop_esercizio;

public class LoopFor {

	//Eseguire il loop da 1 a 20 e mostrare a video e tra apici il valore del contatore per ogni passaggio, ogni valore deve essere scritto su sulla stessa riga ma separato da uno spazio
	public static void esercizio01() {
		//Inizializzo variabili
		int somma = 0;
		//Loop stampa contatore e somma il contatore in una variabile
		for(int i = 1; i <= 20; i++) {
			System.out.print("\""+i+"\" ");
			somma+=i;
		}
		System.out.println("\nLa somma totale vale: " + somma+"\n");
	}
	
	//Ripetere l'esempio precedente ma stavolta l’incremento del contatore non deve essere di 1 ma di 5
	public static void esercizio02() {
		//Inizializzo variabili
		int somma = 0;
		//Loop stampa contatore e somma il contatore in una variabile
		for(int i = 1; i <= 20; i=i+5) {
			System.out.print("\""+ i +"\" ");
			somma+=i;
		}
		System.out.println("\nLa somma totale vale: " + somma+"\n");
	}
	
	//Eseguire il loop da 20 a 0 ma il decremento deve essere di 3 invece che di 1 e mostrare a video il valore del contatore per ogni passaggio, ogni valore deve essere scritto su sulla stessa riga ma separato da uno spazio
	public static void esercizio03() {
		//Inizializzo variabili
		int somma = 0;
		//Loop stampa contatore e somma il contatore in una variabile
		for(int i = 20; i >= 0; i=i-3) {
			System.out.print("\""+ i +"\" ");
			somma+=i;
		}
		System.out.println("\nLa somma totale vale: " + somma+"\n");
	}
}
