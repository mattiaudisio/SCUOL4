package esercizio;

public class ProvArray { 
	//Metodo che cireve come parametro un array vuoto e questo metodo lo riempie con dei num int che vanno da uno a 10

	public static int[] buildArray(int[] num) {
		for(int i = 0; i < 10; i++) {
			num[i] = i+1;
		}
		return num;
	}
	
}
