package sort;

import java.util.Arrays;

import random.ReadRandom;

public class ReadSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayNumeri = creaArray();	//inserisco dentro arrayNumeri l'array che la funzione creaArray gli passa
		ordina(arrayNumeri);
		stampa(arrayNumeri);
	}

	public static int[] creaArray() {
		//Metodo che crea l'array
		int[] array = new int[500];
		for (int i = 0; i < 500; i++) {
			int controllo = 0; //Serve per controllare se il numero è già presente nell'array
			int num = ReadRandom.getByMinMax(5, 1000); //numero casuale
			for (int j = 0; j < i; j++) {
				if (array[j] == num) {	//Se il numero è già presente, faccio metto come controllo 1
					controllo = 1;
				}
			}
			if (controllo == 0) {	//Se controllo è 0 meto il numero nell'array, altrimenti decementro i
				array[i] = num;
			} else {
				i--;				//Decementro i in modo che alla fine venga fuori un array di 500 numeri DIVERSI TRA LORO
			}

		}
		return array;
	}

	public static void stampa(int[] array) {
		//Metodo che stampa l'array
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}

	public static void ordina(int[] array) {
		//Metodo che ordina l'array
		Arrays.sort(array);		
	}

}
