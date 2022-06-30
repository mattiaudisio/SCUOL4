package frameTester;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * L'oggetto JFrame è un discendente della classe JFrame
 * 
 * @author audisiom
 *
 */
public class Frame_SecondaDimostrazione extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		/*
		 * crea istanza di questa classe e la rende visibile
		 */
		Frame_SecondaDimostrazione frm = new Frame_SecondaDimostrazione();
		frm.setVisible(true);
	}
 
	/*
	 * Costruttore di classe senza parametri
	 */
	public Frame_SecondaDimostrazione() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.setLocation(0, 0);
		this.setTitle("Finestra figlia di JFrame");
		// *** Imposto colore backGround in Jframe
		this.setBackground(Color.YELLOW);
		/*
		 * contenPanel di JFrame è un oggetto di tipo JPanel anche se lo restituisce
		 * come Container che è una sua classe padre
		 */
		Container contentPanel = this.getContentPane();
		contentPanel.setLayout(null);
		/*
		 * Devo mettere setOpaque(false) in modo da vedere cosa c'è sotto contentPanel
		 * (in questo caso il background impostato per l'oggetto JFrame)
		 * Container.setOpaque(false); container non ha il metodo setOpaque che invece
		 * ha la sua classe discendente JPanel
		 * 
		 * eseguo quindi il casting per ottenere una variabile di tipo JPanel
		 * 
		 */
		JPanel panel = (JPanel) contentPanel;
		panel.setOpaque(false);
		// ** Metodo alternativo: ((JPanel) contentPanel).setOpaque(false);
		impostaControlli();
	}

	private void impostaControlli() {
		// ** Primo button btnOk
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(5, 5, 100, 25);
		btnOk.setBackground(Color.BLACK);
		btnOk.setForeground(Color.WHITE);
		this.getContentPane().add(btnOk);
		// ** Primo button btCancel
		JButton btCancel = new JButton("Cancel");
		btCancel.setBounds(155, 5, 100, 25);
		btCancel.setBackground(Color.GRAY);
		btCancel.setForeground(Color.BLUE);
		this.getContentPane().add(btCancel);
		// ** label nome
		JLabel label = new JLabel("Nome: ");
		label.setBounds(5, 35, 100, 25);
		this.getContentPane().add(label);
		// ** label cognome
		JTextField textField = new JTextField("");
		textField.setBounds(50, 35, 100, 25);
		this.getContentPane().add(textField);

	}
}