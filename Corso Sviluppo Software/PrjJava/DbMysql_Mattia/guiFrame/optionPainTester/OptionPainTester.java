package optionPainTester;

import javax.swing.JOptionPane;

public class OptionPainTester {

//	YES_OPTION
//	NO_OPTION
//	CANCEL_OPTION
//	OK_OPTION
//	CLOSED_OPTION

//	ERROR_MESSAGE
//	INFORMATION_MESSAGE
//	WARNING_MESSAGE
//	QUESTION_MESSAGE
//	PLAIN_MESSAGE	--> Nessuna icona
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] options = { "Si", "No"};
		int r = JOptionPane.showOptionDialog(null, "ATTENZIONE !!! \nQuesto è il messaggio di testo ", "Titolo della finestra",
	             JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
	             null, options, options[1]);
		if(r == JOptionPane.YES_OPTION) {		//premuto primo bottone: SI
			System.out.println("YES_OPTION");
		}
		if(r == JOptionPane.NO_OPTION) {		//premuto secondo bottone: NO
			System.out.println("NO_OPTION");
		}
	}

}
