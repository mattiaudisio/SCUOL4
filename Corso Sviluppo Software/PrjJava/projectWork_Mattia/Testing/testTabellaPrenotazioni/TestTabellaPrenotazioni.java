package testTabellaPrenotazioni;

import java.time.LocalDate;

import database.Db;
import prenotazioni.TabellaPrenotazione;

public class TestTabellaPrenotazioni {
	public static void main(String[] args) {
		insert();
	}

	private static void insert() {
		// TODO Auto-generated method stub
		TabellaPrenotazione tb = new TabellaPrenotazione();
		tb.setClienteID(4);
		tb.setDataPrenotazione(LocalDate.now());
		tb.setPostiPrenotati(4);
		tb.setViaggioID(10);
		tb.setPrezzo(34.95);
		String sql = tb.getSqlInsert();
		Db.executeUpdate(sql);
	}
	
	
}
