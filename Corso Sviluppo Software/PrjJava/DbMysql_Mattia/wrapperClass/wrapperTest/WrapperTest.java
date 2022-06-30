package wrapperTest;

public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		castInt();
		InteroMinimoMassimo();
		StringToIntegerError();
	}

	private static void StringToIntegerError() {
		// TODO Auto-generated method stub
		try {
			String s1 = "89.67";
			int i1 = Integer.parseInt(s1);
			System.out.println(i1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void castInt() {
		String s = "101";
		String s2 = "1000";

		// ** "somma" le due stringhe ovvero le unisce
		System.out.println(s + s2);

		// ** conversione stringhe in intero e somma
		// ** si deve usare la wrapper class Integer perché non è possibile
		// ** fare il casting da stringa a intero (ma neppure a qualunque altro tipo
		// ** dato numerico)
		// ** int in1 = (int)n1; non è possibile
		int i1 = Integer.parseInt(s);
		int i2 = Integer.parseInt(s2);
		int iTotale = i1 + i2;
		System.out.println("iTotale = i1 + i2: " + iTotale);

		// *****************************************

		int ii = Integer.parseInt(s);
		long ll = Long.parseLong(s);
		short ss = Short.parseShort(s);
		double dd = Double.parseDouble(s);
		float ff = Float.parseFloat(s);
		byte bb = Byte.parseByte(s);

		System.out.println(ii);
		System.out.println(ll);
		System.out.println(ss);
		System.out.println(dd);
		System.out.println(ff);
		System.out.println(bb);
	}

	private static void InteroMinimoMassimo() {
		// ** Valore minimo e massimo integer
		System.out.println("MAX VALUE: " + Integer.MAX_VALUE);
		System.out.println("MAX VALUE: " + Integer.MIN_VALUE);
		long l1 = Integer.MAX_VALUE + 10;
		System.out.println("l1 = Integer.MAX_VALUE+10: " + l1);
		// ** provo a fare casting di un long in int
		// ** ma il long ha un valore maggiore di max int
		// ** "Integer.MAX_VALUE+10"
		int i1 = (int) l1;
		short s1 = (short) l1;
		System.out.println("i1 = (int) l1: " + i1 + "\ns1 = (short) l1: " + s1);

	}

}
