package pennarelli;

import java.util.ArrayList;

public class Metodo {

	/*
	 *  CLASSE METODO
	 *  All'interno della classe Metodo sono presenti i metodi che vengono richiamati dal main.
	 *  il metodo aggiungiLista ci permette di creare un lista di oggetti Pennarello
	 *  il metodo stampaLista ci permette di stampare a video le informazioni degli oggetti (ovvero Marca e Colore)
	 */
	
	public  ArrayList<Pennarello> aggiungiLista() {
		/*
		 * All'interno di questo metodo creo l'array di oggetti chiamato listaPennarello e, grazie al 
		 * ciclo For, creo prima gli oggetti Pennarello e poi gli aggiungo all'interno dell'array.
		 * Infine, dopo aver finito il ciclo for, ritorno l'array listaPennarello
		 */
		ArrayList<Pennarello> listaPennarello = new ArrayList<>();
		String[] arrayMarca = {"Bic","Bic","Bic","Bic","Stabilo","Stabilo","Tratto","Tratto"};
		String[] arrayColore = {"Rosso","Blu","Verde","Nero","Blu","Rosso","Verde","Rosso"};
		for(int i = 0; i < 8; i++) {
			listaPennarello.add(new Pennarello(arrayMarca[i],arrayColore[i]));
		}
		return listaPennarello;
	}

	public void stampaLista(ArrayList<Pennarello> listaPennarello) {
		/*
		 * All'interno di questo metodo vengono stampate le informazioni che vengono
		 * ricavate dall'array che gli viene passato
		 */
		for(int i = 0; i < listaPennarello.size(); i++) {
			System.out.println("La Marca del pennarello è "+listaPennarello.get(i).getMarca()+" ed è di colore "+listaPennarello.get(i).getColore());
		}
	}
	
}
