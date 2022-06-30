package utili;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Msg {
	
	public static final int SI = 0;
	public static final int NO = 1;
	public static final int CLOSE = -1;
	
	public static int confermaEliminazione(Component root) {
		Object[] options = { "SI", "NO" };
		// *** r = 0 se click SI
		int r = JOptionPane.showOptionDialog(root,
				"ATTENZIONE !!! \nI dati eliminati non sono recuperabili\nDesideri continuare ",
				"Conferma eliminazione record", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
				options[1]);
		return r;
	}
}
