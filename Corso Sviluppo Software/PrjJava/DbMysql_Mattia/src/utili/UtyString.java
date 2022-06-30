package utili;

public class UtyString {
	public static String getSqlString(String value) {
		// ** aggiunge apice singolo all'inizio e alla fine della stringa
		if (!value.startsWith("'"))	//** Se non ha apice all'inizio aggiunge
			value = "'" + value;
		if (!value.endsWith("'")) //** Se non ha apice alla fine aggiunge
			value = value + "'";
		return value;
	}
}
