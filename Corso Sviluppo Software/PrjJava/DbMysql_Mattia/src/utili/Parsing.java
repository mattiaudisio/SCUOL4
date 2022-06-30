package utili;

import java.time.LocalDate;

public final class Parsing {
	/*
	 * @param txt numero intero in formato stringa
	 * 
	 * @return un intero se la conversione è andata a buon fine, se conversione da
	 * stringa a numero da errore torna null
	 *
	 * es. di errore txt = "89.34" ovvero stringa con decimali
	 */

	public static void main(String[] args) {
		Integer i1 = Parsing.ToInt("101");
		System.out.println("Integer i1: " + i1);
		// ** casting automatico da Integer a long
		long l1 = i1;
		System.out.println("long l1 = i1: " + l1);

		byte b1 = i1.byteValue();
		short sh1 = i1.shortValue();
		long l2 = i1.longValue();
		float f1 = i1.floatValue();
		double d2 = i1.doubleValue();

		System.out.println("b1: " + b1 + "\nsh1: " + sh1 + "\nl2: " + l2 + "\nf1: " + f1 + "\nd2: " + d2);
	}

	public static Integer ToInt(String txt) {
		try {
			return Integer.parseInt(txt.trim());
		} catch (Exception e) {
			// TODO: handle exception
			// se la stringa è empty do per scontato sia zero
			if (txt.trim().equals(""))
				return 0;
			return null;
		}
	}

	public static Long ToLong(String txt) {
		try {
			return Long.parseLong(txt.trim());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			// se la stringa è empty do per scontato sia zero
			if (txt.trim().equals(""))
				return (long) 0;
			return null;
		}
	}

	public static Byte ToByte(String txt) {
		try {
			return Byte.parseByte(txt.trim());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			// se la stringa è empty do per scontato sia zero
			if (txt.trim().equals(""))
				return 0;
			return null;
		}
	}

	public static Short ToShort(String txt) {
		try {
			return Short.parseShort(txt.trim());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			// se la stringa è empty do per scontato sia zero
			if (txt.trim().equals(""))
				return 0;
			return null;
		}
	}

	public static Float ToFloat(String txt) {
		try {
			return Float.parseFloat(txt.trim());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			// se la stringa è empty do per scontato sia zero
			if (txt.trim().equals(""))
				return (float) 0;
			return null;
		}
	}

	public static Double ToDouble(String txt) {
		try {
			return Double.parseDouble(txt.trim());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			// se la stringa è empty do per scontato sia zero
			if (txt.trim().equals(""))
				return (double) 0;
			return null;
		}
	}

	public static LocalDate toLocalDate(String txt) {
		/*
		 * txt potrebbe essere : d/MM/yy - dd/M/yy - d/M/yy (01/01/21 1/01/21 01/1/21)
		 * oppure al posto di yy ci può essere yyyy
		 * 
		 * se arriva come 1/01/21 1/1/21 01/1/21 1/1/21 deve trasformarlo 01/01/2021 e
		 * poi fare parsing
		 */
		try {

			// ** indexOf e lastIndexOf tornano -1 se non trovano
			// il carattere cercato
			// int i1 = txt.indexOf('/');
			// int i2 = txt.lastIndexOf('/');
			//if(i1 == -1 || i2 == -1 || i1 == i2) return null;	
			//txt 01/.....
			//if(i1 == 0 || i1>2) return null;
			//if(i1<2) txt = "0"+txt // 1/...01/

			String[] data = txt.split("/");
			txt = data[0] + "/" + data[1] + "/20" + data[2];
			LocalDate.parse(txt.trim());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
