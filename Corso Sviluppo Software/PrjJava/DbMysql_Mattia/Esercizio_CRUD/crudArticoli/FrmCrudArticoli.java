package crudArticoli;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utili.Parsing;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCrudArticoli extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantita;
	private JTextField txtPrezzo;
	private JTextField txtAnno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudArticoli frame = new FrmCrudArticoli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrudArticoli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Qta");
		lblNewLabel.setBounds(59, 12, 26, 19);
		contentPane.add(lblNewLabel);

		txtQuantita = new JTextField();
		txtQuantita.setBounds(131, 11, 86, 20);
		contentPane.add(txtQuantita);
		txtQuantita.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Prezzo");
		lblNewLabel_1.setBounds(59, 61, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtPrezzo = new JTextField();
		txtPrezzo.setBounds(131, 58, 86, 20);
		contentPane.add(txtPrezzo);
		txtPrezzo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Anno");
		lblNewLabel_2.setBounds(59, 111, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtAnno = new JTextField();
		txtAnno.setBounds(131, 108, 86, 20);
		contentPane.add(txtAnno);
		txtAnno.setColumns(10);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Attivo");
		chckbxNewCheckBox.setBounds(289, 10, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		JRadioButton rdbPrimaScelta = new JRadioButton("Prima scelta");
		rdbPrimaScelta.setBounds(295, 52, 109, 23);
		contentPane.add(rdbPrimaScelta);

		JRadioButton rdbSecondaScelta = new JRadioButton("Seconda Scelta");
		rdbSecondaScelta.setBounds(295, 76, 109, 23);
		contentPane.add(rdbSecondaScelta);

		JRadioButton rdbTerzaScelta = new JRadioButton("Terza Scelta");
		rdbTerzaScelta.setBounds(295, 102, 109, 23);
		contentPane.add(rdbTerzaScelta);

		JButton btnTest = new JButton("Test");
		btnTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CrudArticolo articolo = new CrudArticolo();
				// -- legge quantita da controllo JTextField
				Integer i = Parsing.ToInt(txtQuantita.getText());
				if (i == null) {
					// .. errore txtQuantita non contiene un intero
				} else
					articolo.setQuantita(i);
				Double d = Parsing.ToDouble(txtPrezzo.getText());
				if (i == null) {
					// .. errore txtPrezzo non contiene un intero
				} else
					articolo.setPrezzo(i);
			}
		});
		btnTest.setBounds(87, 186, 89, 23);
		contentPane.add(btnTest);

		// **Raggruppare i radioBUtton
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbPrimaScelta);
		buttonGroup.add(rdbSecondaScelta);
		buttonGroup.add(rdbTerzaScelta);
	}
}
