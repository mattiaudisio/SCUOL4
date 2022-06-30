package classeMotorino;

import dbMysql.DbConnection;

public class UsoMotorino {

	public static void main(String[] args) {
		// ** imposto il nome del db da utilizzare
		DbConnection.getDb().setNomeDb("Veicoli");

		CreateDatabase_Veicoli.buildDatabase();
		CreateDatabase_Veicoli.buildTable();
		CreateDatabase_Veicoli.truncateTable();

		for (int i = 0; i < 20; i++) {
			MotorinoImmatricolato mI = new MotorinoImmatricolato("Aprilia", "Scarabeo", "rosso", 60, "CV1234" + i);
			Motorino_operazioniSuDb.motorino_Insert(mI);
		}

//		Motorino motorino = new Motorino("Piaggio", "Liberty", "Grigio Metallizato");
//		motorino.accellera(40.5);
//
//		MotorinoImmatricolato motorinoImmatricolato = new MotorinoImmatricolato("Aprilia", "Scarabeo", "rosso", 60,
//				"CV1234");
//		System.out.println(motorinoImmatricolato.getMaxVelocita());
//
//		System.out.println("Applicazione terminata");
	}

}