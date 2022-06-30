package utili;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UtyJTable {

	/*
	 * questo metodo svuota completamente la JTable lascia solo la riga di
	 * intestazione
	 */
	public static void eliminaTutteLeRighe(JTable table) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}
	
	/*
	 * torna indice (ovvero la posizione in tabella) di una colonna il cui nome è
	 * passato come parmetro (colName)
	 * 
	 * se colonna non trovata torna -1
	 * 
	 * @param tb tabella in cui si deve ricercare la colonna per nome
	 * 
	 * @param colName nome della colonna da ricercare
	 * 
	 * @return
	 */
	public static int ritornaIndiceColonnaDatoIlSuoNome(JTable tb, String colName) {
		int result = -1;
		colName = colName.trim();
		// ** getColumnCount() torna numero colonne presenti in tb
		for (int i = 0; i < tb.getColumnCount(); i++) {
			if (tb.getColumnName(i).trim().equalsIgnoreCase(colName)) {
				result = i;
				break;
			}
		}
		return result;
	}
}
