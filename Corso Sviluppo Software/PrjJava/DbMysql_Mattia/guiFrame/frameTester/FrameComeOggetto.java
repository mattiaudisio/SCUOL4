package frameTester;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameComeOggetto {
	public static void main (String[] args) {
		JFrame frm= new JFrame();
		frm.setBounds(10,100,200,600);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addComponents(frm);
		frm.setVisible(true);
		
	}
	
	private static void addComponents(JFrame pFrm) {
		//prende il contenitore di default della finestra
		Container contentPane=pFrm.getContentPane();
		//imposta a null il layout
		//quindi il programmatore � responsabile della posizione e dimensione dei controlli
		contentPane.setLayout(null);
		contentPane.setBackground(Color.cyan);
		
		//crea JButton, dimensiona  e aggiunge a contentPane
		JButton btn=new JButton();
		contentPane.add(btn);
		btn.setBounds(10, 400, 100, 25);
		btn.setText("OK");
		//il focusable impedisce al button di prendere il focus con TAB
		btn.setFocusable(false);
		// il setEnabled disabilita l'utilizzo del button (compare ma 
		//non pu� essere cliccato!)
		//btn.setEnabled(false);
		//il setVisible mi permette di impedire all'utente di vedere il tasto
		//btn.setVisible(false);
		//JLabel
		JLabel lbl= new JLabel("Nome: ");

		lbl.setLocation(0,5);
		lbl.setSize(100,25);
		contentPane.add(lbl);
		//JTextField (controllo di testo
		JTextField txt= new JTextField();
		txt.setBounds(100,5,200,25);
		contentPane.add(txt);
		//JLabel secondo
		JLabel lbl2=new JLabel("Cognome: ");
		lbl2.setLocation(0,50);
		lbl2.setSize(100,25);
		contentPane.add(lbl2);
		//JTextField (controllo di testo secondo
		JTextField txt2= new JTextField();
		txt2.setBounds(100,50,200,25);
		contentPane.add(txt2);
		
		
		
	}
	
	

}
