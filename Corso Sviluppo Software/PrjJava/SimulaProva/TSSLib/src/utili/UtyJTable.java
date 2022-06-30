package utili;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/** class UtyJTable classe con metodi per operazioni su jtable
 * 
 * - static void eliminaTutteLeRighe(JTable tb) svuota colpentamenta controllo
 * 				jTable lascia solo la riga intestazione - static int
 * 
 * - static int ritornaIndiceColonnaDatoIlSuoNome(JTable tb, String colName) torna indice
 * 				(ovvero la pozione in tabella) di una colonna il cui nome è passato come
 * 				parametro (colName)
 * 
 * Se colonna non trovata torna -1
 * @param tb      tabella in cui si deve ricercare la colonna per nome
 * @param colName nome della colonna da ricercare
 * @return >=0 se colonna trovata altrimenti -1
 * 
 */
public class UtyJTable {
	/**
	 * eliminaTutteLeRighe(JTable tb) questo metodo svuota colpentamenta la jTable
	 * lascia solo la riga di intestazione
	 */
	public static void eliminaTutteLeRighe(JTable tb) {
		DefaultTableModel dtm = (DefaultTableModel) tb.getModel();
		dtm.setRowCount(0);
	}

	/**
	 * torna indice (ovvero la pozione in tabella) di una colonna il cui nome è
	 * passato come parametro (colName)
	 * 
	 * Se colonna non trovata torna -1
	 * 
	 * @param tb      tabella in cui si deve ricercare la colonna per nome
	 * @param colName nome della colonna da ricercare
	 * @return >=0 se colonna trovata altrimenti -1
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
