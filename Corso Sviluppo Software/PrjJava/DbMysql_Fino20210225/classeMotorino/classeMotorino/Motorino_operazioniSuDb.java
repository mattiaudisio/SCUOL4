package classeMotorino;

import dbMysql.QueryDbExecute;

public class Motorino_operazioniSuDb {
	
	public static void motorino_Insert(MotorinoImmatricolato pMotorinoImmatricolato) {
		// inserisce nel db un nuovo record con i dati dell'oggetto Motorino
		String query = "INSERT IGNORE INTO moto(marca,modello,colore,velocitaMax,targa) VALUES (\""
				+ pMotorinoImmatricolato.getMarca() + "\",\"" + pMotorinoImmatricolato.getModello() + "\",\""
				+ pMotorinoImmatricolato.getColore() + "\",\"" + pMotorinoImmatricolato.getMaxVelocita() + "\",\""
				+ pMotorinoImmatricolato.getTarga() + "\");";
		if(QueryDbExecute.executeUpdate(query) >= 0){
			System.out.println("Inserimento eseguito");
		}else {
			System.out.println("Errore inserimento");			
		}
	}
	
	public static void motorinoDelete(int num) {
		String query = "DELETE FROM moto WHERE motoId="+num;
		if(QueryDbExecute.executeUpdate(query) >= 0){
			System.out.println("Inserimento eseguito");
		}else {
			System.out.println("Errore inserimento");			
		}
	}
}