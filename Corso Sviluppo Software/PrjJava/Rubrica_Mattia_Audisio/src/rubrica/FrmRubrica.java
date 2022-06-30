package rubrica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utili.*;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmRubrica extends JFrame implements ISelectPassResultSet, ISelezioneByID {

	private JPanel contentPane;
	private JPanel panDati;
	private JFormattedNumber txtID;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtTelefono;
	private JTextField txtMail;
	private JLabel lblNewLabel_4;
	private JPanel panel;
	private JButton btnSalva;
	private JRadioButton rdbtAmico;
	private JRadioButton rdbtCliente;
	private JRadioButton rdbtFornitore;
	private JButton btnElimina;
	private JButton btnAnnulla;
	private Persona persona;
	private JButton btnRicerca;
	private JFrame thisFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRubrica frame = new FrmRubrica();
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
	public FrmRubrica() {
		thisFrame = this;
		setTitle("Rubrica Mattia Audisio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.panDati = new JPanel();
		this.contentPane.add(this.panDati, BorderLayout.CENTER);
		this.panDati.setLayout(null);

		this.txtID = new JFormattedNumber();
		this.txtID.setEditable(false);
		this.txtID.setFocusable(false);
		this.txtID.setColumns(10);
		this.txtID.setBounds(44, 11, 86, 20);
		this.panDati.add(this.txtID);

		this.lblNewLabel = new JLabel("ID");
		this.lblNewLabel.setBounds(10, 14, 46, 14);
		this.panDati.add(this.lblNewLabel);

		this.lblNewLabel_1 = new JLabel("Nome");
		this.lblNewLabel_1.setBounds(10, 60, 46, 14);
		this.panDati.add(this.lblNewLabel_1);

		this.txtNome = new JTextField();
		this.txtNome.setColumns(10);
		this.txtNome.setBounds(107, 57, 86, 20);
		this.panDati.add(this.txtNome);

		this.txtCognome = new JTextField();
		this.txtCognome.setColumns(10);
		this.txtCognome.setBounds(107, 88, 86, 20);
		this.panDati.add(this.txtCognome);

		this.lblNewLabel_2 = new JLabel("Cognome");
		this.lblNewLabel_2.setBounds(10, 91, 87, 14);
		this.panDati.add(this.lblNewLabel_2);

		this.lblNewLabel_3 = new JLabel("Telefono");
		this.lblNewLabel_3.setBounds(10, 122, 87, 14);
		this.panDati.add(this.lblNewLabel_3);

		this.txtTelefono = new JTextField();
		this.txtTelefono.setColumns(10);
		this.txtTelefono.setBounds(107, 119, 86, 20);
		this.panDati.add(this.txtTelefono);

		this.txtMail = new JTextField();
		this.txtMail.setColumns(10);
		this.txtMail.setBounds(107, 150, 181, 20);
		this.panDati.add(this.txtMail);

		this.lblNewLabel_4 = new JLabel("Mail");
		this.lblNewLabel_4.setBounds(10, 153, 46, 14);
		this.panDati.add(this.lblNewLabel_4);

		this.rdbtAmico = new JRadioButton("Amico");
		this.rdbtAmico.setBounds(287, 56, 109, 23);
		this.panDati.add(this.rdbtAmico);

		this.rdbtCliente = new JRadioButton("Cliente");
		this.rdbtCliente.setBounds(287, 82, 109, 23);
		this.panDati.add(this.rdbtCliente);

		this.rdbtFornitore = new JRadioButton("Fornitore");
		this.rdbtFornitore.setBounds(287, 108, 109, 23);
		this.panDati.add(this.rdbtFornitore);
		
		this.btnRicerca = new JButton("Ricerca");
		this.btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmRubricaRicerca frm = new FrmRubricaRicerca((ISelezioneByID) thisFrame, thisFrame);
				frm.setVisible(true);
			}
		});
		this.btnRicerca.setBounds(158, 10, 89, 23);
		this.panDati.add(this.btnRicerca);

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.SOUTH);
		this.panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		this.btnSalva = new JButton("Salva");
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String err = convalida();
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(rootPane, err);
					return;
				} else {
					inserimento();
					pulisciCampi();
				}

			}
		});
		this.panel.add(this.btnSalva);

		this.btnElimina = new JButton("Elimina");
		this.btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Msg.confermaEliminazione(rootPane) != Msg.SI)
					return;
				eliminaDati();
				pulisciCampi();
			}
		});
		this.panel.add(this.btnElimina);

		this.btnAnnulla = new JButton("Annulla");
		this.btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pulisciCampi();
			}
		});
		this.panel.add(this.btnAnnulla);
	}

	private String convalida() {
		String err = "";
		if (txtNome.getText().trim().equals("")) {
			err += "\nInserisci il nome del contatto";
		}
		if (txtCognome.getText().trim().equals("")) {
			err += "\nInserisci il congome del contatto";
		}
		if (txtTelefono.getText().trim().equals("")) {
			err += "\nInserisci il numero di telefono del contatto";
		}
		if (txtMail.getText().trim().equals("")) {
			err += "\nInserisci la mail del contatto";
		}
		return err;
	}

	private void inserimento() {
		Persona tb = new Persona();

		int rubricaID = ((Number) txtID.getValue()).intValue();
		tb.setID(rubricaID);

		tb.setNome(txtNome.getText().trim());
		tb.setCognome(txtCognome.getText().trim());
		tb.setTelefono(txtTelefono.getText().trim());
		tb.setMail(txtMail.getText().trim());

		if (rdbtAmico.isSelected()) {
			tb.setAmico(true);
		}
		if (rdbtCliente.isSelected()) {
			tb.setCliente(true);
		}
		if (rdbtFornitore.isSelected()) {
			tb.setFornitore(true);
		}

		String query = "";
		if (rubricaID == 0) {
			query = tb.getQueryInsert();
		} else {
			query = tb.getQueryUpdate();
		}
		Db.execute(query);
	}

	private void pulisciCampi() {
		txtID.setValue(0);
		txtNome.setText("");
		txtCognome.setText("");
		txtTelefono.setText("");
		txtMail.setText("");
		rdbtAmico.setSelected(false);
		rdbtCliente.setSelected(false);
		rdbtFornitore.setSelected(false);
	}

	private void eliminaDati() {
		int id = ((Number) txtID.getValue()).intValue();
		if (id <= 0)
			return;
		QueryDbExecute.execute("DELETE FROM anagraficapersone WHERE ID =" + id);
	}

	@Override
	public void selezione(int pID) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM anagraficapersone WHERE ID = "+pID+";";
		Db.executeQuery(query, this);
	}

	@Override
	public void passResultset(ResultSet rows) {
		// TODO Auto-generated method stub
		pulisciCampi();
		try {
			while (rows.next()) {
				txtID.setValue(rows.getInt("ID"));
				txtNome.setText(rows.getString("nome"));
				txtCognome.setText(rows.getString("cognome"));
				txtTelefono.setText(rows.getString("telefono"));
				txtMail.setText(rows.getString("mail"));
				rdbtAmico.setSelected(rows.getBoolean("amico"));
				rdbtCliente.setSelected(rows.getBoolean("cliente"));
				rdbtFornitore.setSelected(rows.getBoolean("fornitore"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
