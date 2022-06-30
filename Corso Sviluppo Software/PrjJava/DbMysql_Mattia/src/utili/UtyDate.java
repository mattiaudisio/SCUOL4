package utili;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtyDate {
	public static String getDDMMYYYY(LocalDate ldt) {
		String s = "";
		if(ldt != null) {
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			s = ldt.format(formatters);
		}
		return s;
	}
}
