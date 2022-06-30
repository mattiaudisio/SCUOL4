package persona;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtCognome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPersona frame = new FrmPersona();
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
	public FrmPersona() {
		setResizable(false);
		setTitle("Anagrafica Persone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 25, 46, 14);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(99, 22, 53, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 59, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(99, 56, 151, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Cognome");
		lblNewLabel_2.setBounds(10, 90, 79, 14);
		contentPane.add(lblNewLabel_2);

		txtCognome = new JTextField();
		txtCognome.setBounds(99, 87, 151, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);

		JButton btnSalva = new JButton("Salva");
		btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controlloDati() == false) {
					JOptionPane.showMessageDialog(contentPane, "Errore su alcuni campi");
					txtNome.setBackground(Color.white);
					txtCognome.setBackground(Color.white);
					return;
				}

				Persona persona = new Persona();
				persona.setnome(txtNome.getText());
				persona.setCognome(txtCognome.getText());
				System.out.println(txtNome.getText() + " " + txtCognome.getText());
			}

			private boolean controlloDati() {
				boolean ok = true;
				// TODO Auto-generated method stub
				if (txtNome.getText().trim().equals("")) {
					ok = false;
				}
				if (txtCognome.getText().trim().equals("")) {
					ok = false;
				}
				return ok;
			}
		});
		btnSalva.setFocusable(false);
		btnSalva.setBounds(88, 133, 75, 23);
		contentPane.add(btnSalva);
	}
}
