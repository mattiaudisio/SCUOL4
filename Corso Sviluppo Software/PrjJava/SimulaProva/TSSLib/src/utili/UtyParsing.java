package utili;

/**
 * final class UtyParsing
 * 
 * - static Integer toInt(String txt)
 * 
 * @param - txt numero intero in formato stringa
 * @return - un oggetto Integer se la conversione è andata a buon fine - se
 *         conversione da stringa a numero da errore torna null es. di errore
 *         txt = "89.34" ovvero stringa con decimali
 * 
 * - static Long toLong(String txt) - static Byte toByte(String txt)
 * - static Short toShort(String txt) static Float toFloat(String txt) 
 * - static Double toDouble(String txt) 
 * 
 */

public final class UtyParsing {
	/**
	 * 
	 * @param - txt numero intero in formato stringa
	 * @return - un oggetto Integer se la conversione è andata a buon fine - se
	 *         conversione da stringa a numero da errore torna null - es. di errore
	 *         txt = "89.34" ovvero stringa con decimali
	 */
	public static Integer toInt(String txt) {
		try {
			// se la stringa è empty do per scontato sia zero
			if (txt == null || txt.trim().equals("")) 
				return 0;
			
			return Integer.parseInt(txt.trim());
		} catch (NumberFormatException e) {
			// la stringa contiene caratteri e non solo cifre	
			return null;
		}
	}

	public static Long toLong(String txt) {
		try {
			// se la stringa è empty do per scontato sia zero
			if (txt == null || txt.trim().equals("")) 
				return (long) 0;

			return Long.parseLong(txt.trim());
		} catch (NumberFormatException e) {
			// la stringa contiene caratteri e non solo cifre 
			return null;
		}
	}

	public static Byte toByte(String txt) {
		try {
			// se la stringa è empty do per scontato sia zero
			if (txt == null || txt.trim().equals("")) 
				return  0;

			return Byte.parseByte(txt.trim());
		} catch (NumberFormatException e) {
			// la stringa contiene caratteri e non solo cifre 
			return null;
		}
	}

	public static Short toShort(String txt) {
		try {
			// se la stringa è empty do per scontato sia zero
			if (txt == null || txt.trim().equals("")) 
				return  0;

			return Short.parseShort(txt.trim());
		} catch (NumberFormatException e) {
			// la stringa contiene caratteri e non solo cifre 
			return null;
		}
	}

	public static Float toFloat(String txt) {
		try {
			if (txt == null || txt.trim().equals("")) 
				return (float) 0;

			return Float.parseFloat(txt.trim());
		} catch (NumberFormatException e) {
			// la stringa contiene caratteri e non solo cifre 
			return null;
		}
	}

	public static Double toDouble(String txt) {
		try {
			if (txt == null || txt.trim().equals("")) 
				return (double) 0;

			return Double.parseDouble(txt.trim());
		} catch (NumberFormatException e) {
			// la stringa contiene caratteri e non solo cifre 
			return null;
		}
	}

	
}
