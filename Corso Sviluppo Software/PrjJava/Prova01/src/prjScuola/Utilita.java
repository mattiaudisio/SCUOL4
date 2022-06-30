package prjScuola;

public class Utilita {

	public static String inizialeMaiuscola(String pValue){
		String s2 = pValue.substring(1).toLowerCase();
		String s1 = pValue.substring(0,1).toUpperCase();
		return s1+s2;
	}
}
