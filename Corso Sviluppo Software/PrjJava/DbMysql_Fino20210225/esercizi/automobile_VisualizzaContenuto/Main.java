package automobile_VisualizzaContenuto;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Automobile[] automobili = Main.getArrayOggetti(45);
		
		Automobile[] listaAutomobili = TryCatchAutomobile.funzioneMultipli(automobili);
		ArrayList <Automobile> arrayAutomobile = TryCatchAutomobile.controlloLenght(listaAutomobili);
		stampaArrayList(arrayAutomobile);
		
		
		int i = 0;
		while (i < automobili.length) {
		Automobile auto = automobili[i];
		System.out.println(auto.getId() + ":");
		System.out.println(auto.getMarca());
		System.out.println(auto.getColore());
		System.out.println("---------");
		i++;
		}
	}
	private static void stampaArrayList(ArrayList <Automobile> arrayAutomobile) {
		for(int i = 0; i < arrayAutomobile.size(); i++) {
			System.out.println("Id macchina con marca null: "+arrayAutomobile.get(i).getId());
		}
	}
	public static Automobile[] getArrayOggetti(int nrOggetti ) {
		//variabile che definisce il numero di oggetti da creare
		//int nrOggetti = 15;
		//creiamo l'array di oggetti
		Automobile[] ar = new Automobile [nrOggetti];
		//creiamo un ciclo for per un array di nrOggetti oggetti
		for(int i = 0; i < nrOggetti; i++) {
			
			Automobile auto = new Automobile();
			
			switch (i) {
			
			case 0: 
				auto.setMarca("fiat");
				auto.setColore("bianco");
				break;
			case 3:
			case 1:
				auto.setMarca("peugeot");
				auto.setColore("grigio");
				break;
			//questo case 3 prende le caratteristiche del case 1 	
			case 2:
			case 4:
				auto.setMarca("opel");
				auto.setColore("verde");
				break;
				
				default: //equivale ad else nel costrutto if
					auto.setMarca("non definito");
					auto.setColore("non definito");
			}
			auto.setId(i+1);
			// con oggetto auto prende tutte le caratteristiche essendo un oggetto
			ar[i] = auto;
			
		}
		return ar;
	}
}
  