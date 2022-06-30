package utili;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * Classe UtyMsgBox
 * Metodi per messaggi box di utilizzo comune con rispostata tramite button
 * 
 * - static int confermaEliminazione() - Box richiesta conferma eliminazione
 * 		torna zero se la risposta é SI
 * - static int confermaEliminazione(Component root) - Box richiesta conferma eliminazione
 * 		root : identifica controllo a cui deve essere "ancorato" il message box
 * 		torna zero se la risposta é "SI"
 
 *
 */
public class UtyMsgBox {
	public static final int SI = 0;
	public static final int NO = 1;
	public static final int CLOSE = -1;
	
	/**
	 * torna zero se la risposta é SI
	 * @return
	 */
	public static int confermaEliminazione() {
		return confermaEliminazione(null);
	}
	
	/**
	 * root : identifica controllo a cui deve essere "ancorato" il message box
	 * torna zero se la risposta é "SI"
	 * @param root 
	 * @return 
	 */
	public static int confermaEliminazione(Component root) {
		Object[] options= {"SI","NO"};
		//*** r = 0 se click SI
		int r = JOptionPane.showOptionDialog(
				// rif. Frame , rif.panel ecc. oppure null
				root
				, "ATTENZIONE !!! \n" + "I dati eliminati "
						+ "non sono recuperabili \n"
						+ "Desideri continuare"
				, "Conferma eliminazione record"
				, JOptionPane.DEFAULT_OPTION
				    , JOptionPane.WARNING_MESSAGE
				, null
				, options
				, options[1] // bottone di default
			);
		return r;
	}
	
	public static int Avviso(String msg) {
		return Avviso(null,msg);
	}
	
	public static int Avviso (Component root, String msg) {
		Object[] options= {"OK"};
		//*** r = 0 se click SI
		int r = JOptionPane.showOptionDialog(
				// rif. Frame , rif.panel ecc. oppure null
				root
				, msg
				, ""
				, JOptionPane.DEFAULT_OPTION
				    , JOptionPane.WARNING_MESSAGE
				, null
				, options
				, options[0] // bottone di default
			);
		return r;
	}
}
