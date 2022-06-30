package pennarelli;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		//Creo l'oggetto metodo, in modo che possa richiamre i metodi aggiungiLista e stampaLista
		Metodo metodo = new Metodo();
		/*  salvo all'interno dell'array listaPennarello l'array che il metodo aggiungiLista, contenuto dentro la
		 *  classe Metodo e richiamato tramite l'oggetto metodo, ci rimanda indietro
		 */
		ArrayList<Pennarello> listaPennarello = metodo.aggiungiLista();	
		/* Richiamo, grazie all'oggetto metodo, il metodo
		 * stampaLista che ci stampa le informazioni presenti nell'Array
		 */
		metodo.stampaLista(listaPennarello);
	}
	
}
