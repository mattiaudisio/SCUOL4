package esercizi;

import java.util.ArrayList;

import eserciziPm.Cane;
import eserciziPm.Gatto;
import eserciziPm.Mammifero;


public class EserciziSeraMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cane cane1 = new Cane();
		Cane cane2 = new Cane();
		Cane cane3 = new Cane();

		Gatto gatto1 = new Gatto();
		Gatto gatto2 = new Gatto();
		Gatto gatto3 = new Gatto();
		
		ArrayList <Mammifero> array = new ArrayList<>();
		array.add(cane1);
		array.add(cane2);
		array.add(cane3);
		array.add(gatto1);
		array.add(gatto2);
		array.add(gatto3);
		faiParlareTutti(array);
	}
	
	private static void faiParlareTutti(ArrayList<Mammifero> array) {
		for(int i = 0; i < array.size(); i++) {
			array.get(i).parla();
		}
	}
	
}
