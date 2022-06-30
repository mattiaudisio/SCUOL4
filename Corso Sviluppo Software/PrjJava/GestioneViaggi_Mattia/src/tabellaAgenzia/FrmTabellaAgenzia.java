package tabellaAgenzia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comuni.Db;
import dbMysql.DbConnection;
import dbMysql.ISelectPassResultSet;
import utili.ISelezioneByID;
import utili.JFormattedNumber;
import utili.Msg;
import utili.UtyString;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmTabellaAgenzia extends JFrame implements ISelectPassResultSet, ISelezioneByID {

	private TabellaAgenzia tabellaAgenzia;
	private UtyString utyString;
	private JPanel contentPane;
	private JPanel panDati;
	private JPanel panComandi;
	private JButton btnSalva;
	private JButton btnElimina;
	private JButton btnAnnulla;
	private JLabel lblNewLabel;
	private JFormattedTextField txtID;
	private JLabel lblNewLabel_1;
	private JFormattedTextField txtRagioneSociale;
	private JButton btnRicerca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DbConnection.getDb();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaAgenzia frame = new FrmTabellaAgenzia();
					frame.setVisible(true);
//					frame.selezione(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTabellaAgenzia() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.panDati = new JPanel();
		this.contentPane.add(this.panDati, BorderLayout.CENTER);
		this.panDati.setLayout(null);

		this.lblNewLabel = new JLabel("ID");
		this.lblNewLabel.setBounds(23, 11, 46, 14);
		this.panDati.add(this.lblNewLabel);

		this.txtID = new JFormattedNumber();
		this.txtID.setFocusable(false);
		this.txtID.setEditable(false);
		this.txtID.setBounds(118, 8, 61, 20);
		this.panDati.add(this.txtID);

		this.lblNewLabel_1 = new JLabel("Ragione Sociale");
		this.lblNewLabel_1.setBounds(23, 41, 85, 14);
		this.panDati.add(this.lblNewLabel_1);

		this.txtRagioneSociale = new JFormattedTextField();
		this.txtRagioneSociale.setBounds(118, 35, 115, 20);
		this.panDati.add(this.txtRagioneSociale);

		this.btnRicerca = new JButton("Ricerca");
		this.btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apriFormRicerca();
			}
		});
		this.btnRicerca.setBounds(189, 7, 89, 23);
		this.panDati.add(this.btnRicerca);

		this.panComandi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panComandi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);

		this.btnSalva = new JButton("Salva");
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ** richiede convalida campi del form
				if (!convalida()) {
					JOptionPane.showMessageDialog(panDati, "Inserire ragione sociale");
					return;
				}
				// ** convalida con esito positivo
				int id = getId();
				// ** Crea Oggetto Tabella Agenzia e gli assegna i valori
				tabellaAgenzia = new TabellaAgenzia();
				tabellaAgenzia.setAgenziaID(id);
				tabellaAgenzia.setRagioneSociale(txtRagioneSociale.getText().trim());
				// ** verifica se inserimento o aggiornamento
				if (id == 0)
					inserimento();
				else
					aggiornamento();
				pulisceCampi();
			}

		});
		this.btnSalva.setFocusable(false);
		this.panComandi.add(this.btnSalva);

		this.btnElimina = new JButton("Elimina");
		this.btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ** messaggio convalida eliminazione
				if (Msg.confermaEliminazione(rootPane) != Msg.SI)
					return;
				int id = getId();
				// id > 0 significa che esiste un record allora elimina
				if (id > 0)
					eliminazione(id);
				pulisceCampi();
			}
		});
		this.btnElimina.setFocusable(false);
		this.panComandi.add(this.btnElimina);

		this.btnAnnulla = new JButton("Annulla");
		this.btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false)
					return;

				pulisceCampi();
			}
		});
		this.btnAnnulla.setFocusable(false);
		this.panComandi.add(this.btnAnnulla);
	}

	private int getId() {
		// ** se id = 0 significa inserimento nuovo record

		// ** se txtID non contine niente allora id = 0
		if (txtID.getText().equals(""))
			// ** se Object o è null allora id = 0;
			return 0;
		Object o = txtID.getValue();
		if (o == null)
			return 0;
		// ** ritorno il valore contenuto in txtID
		return ((Number) o).intValue();
	}

	private int inserimento() {
		String query = "INSERT INTO agenzie (ragioneSociale) VALUES ('" + tabellaAgenzia.getRagioneSociale() + "')";
		return Db.executeUpdate(query);
	}

	private int aggiornamento() {
		String query = "UPDATE agenzie SET ragioneSociale = "
				+ utyString.getSqlString(tabellaAgenzia.getRagioneSociale()) + " WHERE agenziaID = "
				+ tabellaAgenzia.getAgenziaID() + "";
		return Db.executeUpdate(query);
	}

	public void selezione(int id) {
		String query = "SELECT * FROM Agenzie WHERE agenziaID = " + id;
		Db.executeQuery(query, this);
	}

	private boolean convalida() {
		if (txtRagioneSociale.getText().trim().equals(""))
			return false;
		return true;
	}

	private void pulisceCampi() {
		// ** ricra nuovo oggetto tabella
		tabellaAgenzia = new TabellaAgenzia();
		emissioneCampiDaTabella();
	}

	private void emissioneCampiDaTabella() {
		// ** mette i valori dell'oggetto tabella nei controlli video
		txtID.setValue(tabellaAgenzia.getAgenziaID());
		txtRagioneSociale.setValue(tabellaAgenzia.getRagioneSociale());
	}

	private int eliminazione(int id) {
		// ** elimina record su database
		String query = "DELETE FROM agenzie WHERE agenziaID = " + id;
		return Db.executeUpdate(query);
	}

	@Override
	public void passResultset(ResultSet rows) {
		tabellaAgenzia = new TabellaAgenzia();
		try {
			while (rows.next()) {
				tabellaAgenzia.setAgenziaID(rows.getInt("agenziaID"));
				tabellaAgenzia.setRagioneSociale(rows.getString("ragioneSociale"));
				emissioneCampiDaTabella();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void apriFormRicerca() {
		FrmTabellaAgenziaRicerca frm = new FrmTabellaAgenziaRicerca(this,this);
		frm.setLocation(this.getX() + 20, this.getY() + 20);
		frm.setVisible(true);
	}
}