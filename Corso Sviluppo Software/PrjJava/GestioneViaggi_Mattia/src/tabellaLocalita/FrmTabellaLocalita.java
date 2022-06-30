package tabellaLocalita;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comuni.Db;
import dbMysql.ISelectPassResultSet;
import utili.ISelezioneByID;
import utili.JFormattedNumber;
import utili.Msg;
import utili.UtyString;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmTabellaLocalita extends JFrame implements ISelectPassResultSet, ISelezioneByID {

	private JPanel contentPane;
	private JPanel panDati;
	private JLabel lblNewLabel;
	private JFormattedTextField txtID;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JFormattedTextField txtLocalita;
	private JFormattedTextField txtProvincia;
	private JPanel panComandi;
	private JButton btnSalva;
	private JButton btnElimina;
	private JButton btnAnnulla;
	private TabellaLocalita tabellaLocalita;
	private UtyString utyString;
	private JButton btnRicerca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaLocalita frame = new FrmTabellaLocalita();
					frame.setVisible(true);
					frame.selezione(4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTabellaLocalita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panDati = new JPanel();
		this.contentPane.add(this.panDati, BorderLayout.CENTER);
		this.panDati.setLayout(null);

		this.lblNewLabel = new JLabel("ID");
		this.lblNewLabel.setBounds(10, 11, 46, 14);
		this.panDati.add(this.lblNewLabel);

		this.txtID = new JFormattedNumber();
		this.txtID.setFocusable(false);
		this.txtID.setBounds(110, 8, 85, 20);
		this.panDati.add(this.txtID);

		this.lblNewLabel_1 = new JLabel("Localita");
		this.lblNewLabel_1.setBounds(10, 68, 58, 14);
		this.panDati.add(this.lblNewLabel_1);

		this.lblNewLabel_2 = new JLabel("Provincia");
		this.lblNewLabel_2.setBounds(10, 120, 73, 14);
		this.panDati.add(this.lblNewLabel_2);

		this.txtLocalita = new JFormattedTextField();
		this.txtLocalita.setBounds(110, 68, 85, 20);
		this.panDati.add(this.txtLocalita);

		this.txtProvincia = new JFormattedTextField();
		this.txtProvincia.setBounds(110, 117, 85, 20);
		this.panDati.add(this.txtProvincia);
		
		this.btnRicerca = new JButton("Ricerca");
		this.btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				apriFormRicerca();
			}
		});
		this.btnRicerca.setBounds(223, 7, 89, 23);
		this.panDati.add(this.btnRicerca);

		this.panComandi = new JPanel();
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);
		this.panComandi.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		this.btnSalva = new JButton("Salva");
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!convalida()) {
					JOptionPane.showMessageDialog(panDati, "Completa tutti i campi");
					return;
				}
				int id = getId();
				tabellaLocalita = new TabellaLocalita();
				tabellaLocalita.setLocalitaID(id);
				tabellaLocalita.setLocalita(txtLocalita.getText().trim());
				tabellaLocalita.setProvincia(txtProvincia.getText().trim());
				if (id == 0)
					inserimento();
				else
					aggiornamento();
				pulisceCampi();
			}

		});
		this.panComandi.add(this.btnSalva);

		this.btnElimina = new JButton("Elimina");
		this.btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Msg.confermaEliminazione(rootPane) != Msg.SI)
					return;
				int id = getId();
				if (id > 0)
					eliminazione(id);
				pulisceCampi();
			}
		});
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
		this.panComandi.add(this.btnAnnulla);
	}

	private int inserimento() {
		String query = "INSERT INTO localita (localita,provincia) VALUES ('" + tabellaLocalita.getLocalita() + "','"
				+ tabellaLocalita.getProvincia() + "')";
		return Db.executeUpdate(query);
	}

	private int aggiornamento() {
		String query = "UPDATE localita SET localita = " + utyString.getSqlString(tabellaLocalita.getLocalita())
				+ ", provincia = " + utyString.getSqlString(tabellaLocalita.getProvincia()) + " WHERE localitaID = "
				+ tabellaLocalita.getLocalitaID() + "";
		return Db.executeUpdate(query);
	}

	private int eliminazione(int id) {
		// ** elimina record su database
		String query = "DELETE FROM localita WHERE localitaID = " + id;
		return Db.executeUpdate(query);
	}

	private void pulisceCampi() {
		// ** ricra nuovo oggetto tabella
		tabellaLocalita = new TabellaLocalita();
		emissioneCampiDaTabella();
	}

	private void emissioneCampiDaTabella() {
		// ** mette i valori dell'oggetto tabella nei controlli video
		txtID.setValue(tabellaLocalita.getLocalitaID());
		txtLocalita.setValue(tabellaLocalita.getLocalita());
		txtProvincia.setValue(tabellaLocalita.getProvincia());
	}

	private boolean convalida() {
		if (txtLocalita.getText().trim().equals("") && txtProvincia.getText().trim().equals(""))
			return false;
		return true;
	}

	private int getId() {
		if (txtID.getText().equals(""))
			return 0;
		Object o = txtID.getValue();
		if (o == null)
			return 0;
		return ((Number) o).intValue();
	}

	public void selezione(int id) {
		String query = "SELECT * FROM Localita WHERE localitaID = " + id;
		Db.executeQuery(query, this);
	}

	@Override
	public void passResultset(ResultSet rows) {
		tabellaLocalita = new TabellaLocalita();
		try {
			while (rows.next()) {
				tabellaLocalita.setLocalitaID(rows.getInt("localitaID"));
				tabellaLocalita.setLocalita(rows.getString("localita"));
				tabellaLocalita.setProvincia(rows.getString("provincia"));
				emissioneCampiDaTabella();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void apriFormRicerca() {
		FrmTabellaLocalitaRicerca frm = new FrmTabellaLocalitaRicerca(this,this);
		frm.setLocation(this.getX() + 20, this.getY() + 20);
		frm.setVisible(true);
	}
}
