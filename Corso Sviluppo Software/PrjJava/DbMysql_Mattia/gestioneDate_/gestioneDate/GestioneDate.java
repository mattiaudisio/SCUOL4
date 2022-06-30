package gestioneDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestioneDate {

	public static void main(String[] args) {
		// *** creazione di un oggetto localDate
		LocalDate oggi = LocalDate.now();
		//LocalDate dt = LocalDate.of(2020, 12, 31);
		// ** utilizza formato US yyyy/mm/dd
		//LocalDate dtParse = LocalDate.parse("2021-12-31");
		// ** utilizza formato US yyyy/mm/dd
		DateTimeFormatter dtf4y = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate drParseIT4y = LocalDate.parse("31/12/2021", dtf4y);
		System.out.println("Data IT4y: " + drParseIT4y + "\nla data è IT4y: " + oggi.format(dtf4y));
		DateTimeFormatter dtf2y = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate drParseIT2y = LocalDate.parse("31/12/21", dtf2y);
		System.out.println("Data IT2y: " + drParseIT2y + "\nla data è IT2y: " + oggi.format(dtf2y));

		// ************* alcuni metodi
		System.out.println("giorno del mese: " + oggi.getDayOfMonth());
		System.out.println("giorno della settimana: " + oggi.getDayOfWeek());
		System.out.println("giorno dell'anno: " + oggi.getDayOfYear());
		System.out.println("mese (nome): " + oggi.getMonth());
		System.out.println("mese (numero): " + oggi.getMonthValue());
		System.out.println("anno bisestile: " + oggi.isLeapYear());
		System.out.println("giorni del mese: " + oggi.lengthOfMonth());
		System.out.println("giorni dell'anno: " + oggi.lengthOfYear());

		// ******* alcuni metodi per operazioni sulle date
		System.out.println("togliere dei giorni: " + oggi.minusDays(10));
		System.out.println("togliere delle settimane: " + oggi.minusWeeks(4));
		System.out.println("togliere dei mesi: " + oggi.minusMonths(5));
		System.out.println("togliere degli anni: " + oggi.minusYears(7));

		System.out.println("aggiunge dei giorni: " + oggi.plusDays(10));
		System.out.println("aggiunge delle settimane: " + oggi.plusWeeks(4));
		System.out.println("aggiunge dei mesi: " + oggi.plusMonths(5));
		System.out.println("aggiunge degli anni: " + oggi.plusYears(7));
		// ***
		System.out.println("la data è :" + oggi.toString());
	}

}
