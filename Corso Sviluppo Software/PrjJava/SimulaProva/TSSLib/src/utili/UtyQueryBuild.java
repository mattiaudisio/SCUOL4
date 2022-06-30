package utili;

/** class UtyQueryBuild
 * static String getSqlString(String value) - torna value con apice singolo a inizio e fine
 * 
 */

public class UtyQueryBuild {
	/**
	 * torna string value con apice singolo all'inizio e alla alla fine se non sono già presenti
	 * @return value con apici
	 */
	public static String getSqlString(String value) {
		//** Aggiunge apice singolo all'inizio e alla alla fine della stringa
		if (!value.startsWith("'"))value ="'"+value; //*se non ha apice all'inizio aggiunge
		if (!value.endsWith("'"))value =value +"'";//*se non ha apice alla file aggiunge
		return value;
	}
}
