package automobile_VisualizzaContenuto;

import java.util.ArrayList;

public class TryCatchAutomobile {

	public static Automobile[] funzioneMultipli(Automobile[] automobili){
		for(int i = 0; i < automobili.length; i++) {
			if(automobili[i].getId()%3 == 0) {
				automobili[i].setMarca(null);
			}
		}
		return automobili;
	}
	
	public static ArrayList <Automobile> controlloLenght(Automobile[] automobili) {
		ArrayList <Automobile> arrayAutomobile = new ArrayList<Automobile>();
		for(int i = 0; i < automobili.length; i++) {
			try {
					System.out.println("Marca: "+automobili[i].getMarca().length());					
			} catch (Exception e) {
				arrayAutomobile.add(automobili[i]);
			}
		}
		return arrayAutomobile;
	}
}
