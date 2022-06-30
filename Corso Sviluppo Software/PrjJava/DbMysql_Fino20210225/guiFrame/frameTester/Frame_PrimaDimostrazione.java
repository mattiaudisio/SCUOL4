package frameTester;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * oggetto JFrame è creato all'interno di una classe 
 */

public class Frame_PrimaDimostrazione {

	public static void main(String[] args) {
		createFrame();
	}

	private static void createFrame() {
		JFrame frm = primaFinestra();
		primaFinestraAddComponents(frm);
		frm.setVisible(true);
		secondaFinestra();
	}

	private static void primaFinestraAddComponents(JFrame pFrm) {
		// ** Prende il contenitore di default della finestra
		Container contentPane = pFrm.getContentPane();
		// ** Imposa a null il layout:
		// ** quindi il programmatore è responsabile della posizione e dimensione dei
		// ** controlli
		contentPane.setLayout(null);
		// ** disabilita intero form
		pFrm.setEnabled(true);
		contentPane.setBackground(Color.cyan);

		// * per il jfram non serve
		// pFrm.setFocusable(false);

		// ** Crea JButton, Dimensione e aggiunge a contentPane
		JButton btn = new JButton();
		btn.setBounds(10, 400, 100, 25);
		contentPane.add(btn);
		btn.setText("OK");
		// ** Impedisce al button di prendere il focus(controllo) con tast TAB
		btn.setFocusable(false);
		// ** disabilita l'utilizzo del controllo
		btn.setEnabled(false);
		// ** JLabel
		JLabel lbl = new JLabel("Nome: ");
		lbl.setLocation(0, 5);
		lbl.setSize(100, 25);
		contentPane.add(lbl);
		// ** JTextField (controllo di testo)
		JTextField txt = new JTextField();
		txt.setBounds(100, 5, 200, 25);
		contentPane.add(txt);
		// ** JLabel secondo
		JLabel lbl2 = new JLabel("Cognome: ");
		lbl2.setLocation(0, 50);
		lbl2.setSize(100, 25);
		contentPane.add(lbl2);
		// ** JTextField (controllo di testo secondo)
		JTextField txt2 = new JTextField();
		txt2.setBounds(100, 50, 200, 25);
		contentPane.add(txt2);
	}

	private static JFrame primaFinestra() {
		// usiamo la classe JFrame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(300, 400);
		frame.setBounds(10, 20, 400, 500);
		frame.setTitle("Prima Finestra");
		return frame;
	}

	private static JFrame secondaFinestra() {
		// *** secondo Jframe
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setLocation(500, 100);
		frame.setTitle("Seconda Finestra");
		frame.setVisible(true);
		return frame;
	}

}
