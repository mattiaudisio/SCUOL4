package utili;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** class UtyDate
 * 
 * - static String LocalDateToDDMMYYYY(LocalDate ldt) - da localdate torna data in formato "dd/MM/yyyy"
 * - static String LocalDateToDDMMYY(LocalDate ldt)- da localdate torna data in formato "dd/MM/yy"
 * - static LocalDate toLocalDate(String txt) -  da data in formato testo dd/MM/yy o dd/MM/yyyy a LLcalDate 
 *
	 * txt potrebbe essere : dd/MM/yy d/MM/yy - dd/M/yy d/M/yy 01/01/21 1/01/21
	 * 01/1/21 1/1/21 oppure al posto di yy ci può essere yyyy
	 * 
	 * se arriva come 01/01/21 1/01/21 01/1/21 1/1/21 deve trasformarlo 01/01/2021 e
	 * poi fare parsing
	 * 
 *
 */
public class UtyDate {
	/**
	 * dato un parametro di tipo localdate torna data in formato italiano "dd/MM/yyyy"
	 * @param localdate ldt 
	 * @return string
	 */
	public static String LocalDateToDDMMYYYY(LocalDate ldt) {
		// una data tipo 1/1/2022 ritorna come 01/01/2022
		// una data tipo 1/12/2022 ritorna come 01/12/2022
		// una data tipo 11/1/2022 ritorna come 11/01/2022
		String s="";
		if (ldt !=null)
		{
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			s = ldt.format(formatters);
		}
		
		return s;
	}
	
	/**
	 * dato un parametro di tipo localdate torna data in formato italiano "dd/MM/yy"
	 * @param localdate ldt 
	 * @return string
	 */
	public static String LocalDateToDDMMYY(LocalDate ldt) {
		// una data tipo 1/1/2022 ritorna come 01/01/2022
		// una data tipo 1/12/2022 ritorna come 01/12/2022
		// una data tipo 11/1/2022 ritorna come 11/01/2022
		String s="";
		if (ldt !=null)
		{
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yy");
			s = ldt.format(formatters);
		}
		
		return s;
	}
	
	/** static LocalDate toLocalDate(String txt)
	 * txt potrebbe essere : dd/MM/yy d/MM/yy - dd/M/yy d/M/yy 01/01/21 1/01/21
	 * 01/1/21 1/1/21 oppure al posto di yy ci può essere yyyy
	 * 
	 * se arriva come 01/01/21 1/01/21 01/1/21 1/1/21 deve trasformarlo 01/01/2021 e
	 * poi fare parsing
	 * 
	 */
	public static LocalDate toLocalDate(String txt) {
		// ** indexOf e lastIndexOf tornano -1 se non trovano
		// il carattere cercato
		int i1 = txt.indexOf('/');
		int i2 = txt.lastIndexOf('/');

		if (i1 == -1 || i2 == -1 || i1 == i2)
			return null;
		// txt 01/.....
		if (i1 == 0 || i1 > 2)
			return null;
		if (i1 == 1)
			txt = "0" + txt; // 1/... 01/
		return null;
	}

}
