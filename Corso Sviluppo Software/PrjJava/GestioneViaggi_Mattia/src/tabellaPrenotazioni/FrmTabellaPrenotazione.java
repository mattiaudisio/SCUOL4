package tabellaPrenotazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comuni.Db;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;
import tabellaAgenzia.FrmTabellaAgenziaRicerca;
import tabellaViaggi.FrmTabellaViaggiRicerca;
import utili.ISelezioneByID;
import utili.JFormattedNumber;
import utili.Msg;
import utili.UtyDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmTabellaPrenotazione extends JFrame implements ISelectPassResultSet, ISelezioneByID {

	private JPanel contentPane;
	private JPanel panDati;
	private JPanel panComandi;
	private JLabel lblNewLabel;
	private JFormattedNumber txtID;
	private JButton btnRicerca;
	private JLabel lblNewLabel_1;
	private JTextField txtAgenziaViaggi;
	private JLabel lblNewLabel_2;
	private JTextField txtViaggioPart;
	private JTextField txtPartOrario;
	private JTextField txtViaggioArrivo;
	private JTextField txtViaggioArrivoOrario;
	private JButton btnRicercaAgenzia;
	private JButton btnRicercaViaggio;
	private JLabel lblNewLabel_3;
	private JFormattedNumber txtPosti;
	private JRadioButton rbtPrenotato;
	private JRadioButton rbtAcquistato;
	private JLabel lblNewLabel_4;
	private JFormattedNumber txtCostoPosto;
	private JLabel lblNewLabel_5;
	private JFormattedNumber txtTotale;
	private JButton btnSalva;
	private JButton btnElimina;
	private JButton btnAnnulla;
	private JFormattedNumber txtCostoPrenotazione;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JFrame thisFrame;
	// ******************************************
	private TabellaPrenotazione tabella;
	private int tipoResultset;
	private final int TIPO_RESULTSET_PRENOTAZIONE = 1;
	private final int TIPO_RESULTSET_AGENZIA = 2;
	private final int TIPO_RESULTSET_VIAGGIO = 3;
	int idAgenzia;
	int idViaggio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaPrenotazione frame = new FrmTabellaPrenotazione();
					frame.pulisceCampi();
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
	public FrmTabellaPrenotazione() {
		thisFrame = this;
		setTitle("Tabella Prenotazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 406);
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
		this.txtID.setEditable(false);
		this.txtID.setFocusable(false);
		this.txtID.setBounds(40, 8, 86, 20);
		this.panDati.add(this.txtID);
		this.txtID.setColumns(10);

		this.btnRicerca = new JButton("ricerca");
		this.btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipoResultset = TIPO_RESULTSET_PRENOTAZIONE;
				FrmTabellaPrenotazioniRicerca frm = new FrmTabellaPrenotazioniRicerca((ISelezioneByID) thisFrame,
						thisFrame);
				frm.setVisible(true);
			}
		});
		this.btnRicerca.setBounds(184, 7, 89, 23);
		this.panDati.add(this.btnRicerca);

		this.lblNewLabel_1 = new JLabel("Agenzia");
		this.lblNewLabel_1.setBounds(10, 52, 46, 14);
		this.panDati.add(this.lblNewLabel_1);

		this.txtAgenziaViaggi = new JTextField();
		this.txtAgenziaViaggi.setEditable(false);
		this.txtAgenziaViaggi.setFocusable(false);
		this.txtAgenziaViaggi.setBounds(69, 49, 288, 20);
		this.panDati.add(this.txtAgenziaViaggi);
		this.txtAgenziaViaggi.setColumns(10);

		this.lblNewLabel_2 = new JLabel("Viaggio");
		this.lblNewLabel_2.setBounds(10, 86, 46, 14);
		this.panDati.add(this.lblNewLabel_2);

		this.txtViaggioPart = new JTextField();
		this.txtViaggioPart.setEditable(false);
		this.txtViaggioPart.setFocusable(false);
		this.txtViaggioPart.setBounds(69, 83, 288, 20);
		this.panDati.add(this.txtViaggioPart);
		this.txtViaggioPart.setColumns(10);

		this.txtPartOrario = new JTextField();
		this.txtPartOrario.setFocusable(false);
		this.txtPartOrario.setEditable(false);
		this.txtPartOrario.setColumns(10);
		this.txtPartOrario.setBounds(69, 114, 288, 20);
		this.panDati.add(this.txtPartOrario);

		this.txtViaggioArrivo = new JTextField();
		this.txtViaggioArrivo.setFocusable(false);
		this.txtViaggioArrivo.setEditable(false);
		this.txtViaggioArrivo.setColumns(10);
		this.txtViaggioArrivo.setBounds(69, 142, 288, 20);
		this.panDati.add(this.txtViaggioArrivo);

		this.txtViaggioArrivoOrario = new JTextField();
		this.txtViaggioArrivoOrario.setFocusable(false);
		this.txtViaggioArrivoOrario.setEditable(false);
		this.txtViaggioArrivoOrario.setColumns(10);
		this.txtViaggioArrivoOrario.setBounds(69, 173, 288, 20);
		this.panDati.add(this.txtViaggioArrivoOrario);

		this.btnRicercaAgenzia = new JButton("...");
		this.btnRicercaAgenzia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipoResultset = TIPO_RESULTSET_AGENZIA;
				FrmTabellaAgenziaRicerca f = new FrmTabellaAgenziaRicerca((ISelezioneByID) thisFrame, thisFrame);
				f.setVisible(true);
			}
		});
		this.btnRicercaAgenzia.setBounds(367, 48, 29, 23);
		this.panDati.add(this.btnRicercaAgenzia);

		this.btnRicercaViaggio = new JButton("...");
		this.btnRicercaViaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipoResultset = TIPO_RESULTSET_VIAGGIO;
				FrmTabellaViaggiRicerca f = new FrmTabellaViaggiRicerca((ISelezioneByID) thisFrame, thisFrame);
				f.setVisible(true);
			}
		});
		this.btnRicercaViaggio.setBounds(367, 82, 29, 23);
		this.panDati.add(this.btnRicercaViaggio);

		this.lblNewLabel_3 = new JLabel("Nr Posti");
		this.lblNewLabel_3.setBounds(10, 228, 46, 14);
		this.panDati.add(this.lblNewLabel_3);

		this.txtPosti = new JFormattedNumber();
		txtPosti.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calcoloCostoTotale();
			}
		});
		this.txtPosti.setBounds(69, 225, 57, 20);
		this.panDati.add(this.txtPosti);
		this.txtPosti.setColumns(10);

		this.rbtPrenotato = new JRadioButton("Prenotato");
		this.rbtPrenotato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calcoloCostoTotale();
			}
		});
		this.rbtPrenotato.setBounds(236, 224, 109, 23);
		this.panDati.add(this.rbtPrenotato);

		this.rbtAcquistato = new JRadioButton("Acquistato");
		this.rbtAcquistato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calcoloCostoTotale();
			}
		});
		this.rbtAcquistato.setBounds(347, 224, 109, 23);
		this.panDati.add(this.rbtAcquistato);

		this.lblNewLabel_4 = new JLabel("Costo");
		this.lblNewLabel_4.setBounds(10, 291, 46, 14);
		this.panDati.add(this.lblNewLabel_4);

		this.txtCostoPosto = new JFormattedNumber();
		this.txtCostoPosto.setBounds(69, 288, 57, 20);
		this.txtCostoPosto.setEditable(false);
		this.panDati.add(this.txtCostoPosto);
		this.txtCostoPosto.setColumns(10);

		this.lblNewLabel_5 = new JLabel("Totale");
		this.lblNewLabel_5.setBounds(299, 291, 46, 14);
		this.panDati.add(this.lblNewLabel_5);

		this.txtTotale = new JFormattedNumber();
		this.txtTotale.setBounds(347, 288, 109, 20);
		this.txtTotale.setEditable(false);
		this.panDati.add(this.txtTotale);
		this.txtTotale.setColumns(10);

		this.txtCostoPrenotazione = new JFormattedNumber();
		this.txtCostoPrenotazione.setColumns(10);
		this.txtCostoPrenotazione.setBounds(136, 288, 73, 20);
		this.txtCostoPrenotazione.setEditable(false);
		this.panDati.add(this.txtCostoPrenotazione);

		this.lblNewLabel_6 = new JLabel("Posto");
		this.lblNewLabel_6.setBounds(69, 273, 46, 14);
		this.panDati.add(this.lblNewLabel_6);

		this.lblNewLabel_7 = new JLabel("Prenotazione");
		this.lblNewLabel_7.setBounds(134, 273, 75, 14);
		this.panDati.add(this.lblNewLabel_7);

		this.panComandi = new JPanel();
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);
		this.panComandi.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		this.btnSalva = new JButton("Salva");
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String err = convalida();
				if (!err.equals("")) {
					JOptionPane.showMessageDialog(rootPane, err);
					return;
				}else {
					inserimento();
					pulisceCampi();					
				}
			}
		});
		this.panComandi.add(this.btnSalva);

		this.btnElimina = new JButton("Elimina");
		this.btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Msg.confermaEliminazione(rootPane) != Msg.SI)
					return;
				eliminaDati();
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

	private String convalida() {
		String err = ""; 

		if (txtAgenziaViaggi.getText().equals("")) {
			err += "\nInserire Agenzia viaggi";
		}
		if (txtViaggioPart.getText().equals("")) {
			err += "\nInseririe località di partenza";
		}
		if (txtViaggioArrivo.getText().equals("")) {
			err += "\nInserire località d'arrivo";
		}
		if (txtPartOrario.getText().equals("")) {
			err += "\nInserire ora di partenza";

		}
		if (txtViaggioArrivoOrario.getText() == "") {
			err += "\nInserire ora d'arrivo";
		}
		if(((Number)txtPosti.getValue()).intValue() <= 0) {
			err += "\nInserire posti maggiore a 0";
		}
		return err;
	}

	private void inserimento() {
		TabellaPrenotazione tb = new TabellaPrenotazione();

		int prenotazioneID = ((Number) txtID.getValue()).intValue();
		tb.setPrenotazioniID(prenotazioneID);

		tb.setAgenziaViaggiID(idAgenzia);
		tb.setViaggioID(idViaggio);
		tb.setPosti(((Number) txtPosti.getValue()).intValue());
		tb.setCostoPosto(((Number) txtCostoPosto.getValue()).intValue());
		tb.setCostoPrenotazione(((Number) txtCostoPrenotazione.getValue()).intValue());
		if (rbtAcquistato.isSelected()) {
			tb.setAcquistati(true);
		} else {
			tb.setAcquistati(false);
		}
		if (rbtPrenotato.isSelected()) {
			tb.setPrenotati(true);
		} else {
			tb.setPrenotati(false);
		}

		String query1 = "";
		if (prenotazioneID == 0) {
			query1 = tb.getQueryInsert();
		} else {
			query1 = tb.getQueryUpdate();
		}
		Db.execute(query1);
	}

	@Override
	public void selezione(int pID) {
		if (tipoResultset == TIPO_RESULTSET_PRENOTAZIONE) {
			executeSelectPrenotazione(pID);
		} else if (tipoResultset == TIPO_RESULTSET_AGENZIA) {
			executeSelectAgenzia(pID);
		} else if (tipoResultset == TIPO_RESULTSET_VIAGGIO) {
			executeSelectViaggio(pID);
		}
	}

	// *******************************************
	private void pulisceCampi() {
		tabella = new TabellaPrenotazione();
		txtID.setValue(0);
		txtCostoPosto.setValue(0);
		txtCostoPrenotazione.setValue(0);
		txtPosti.setValue(0);
		rbtAcquistato.setSelected(false);
		rbtPrenotato.setSelected(false);
		txtTotale.setValue(0);
		txtAgenziaViaggi.setText("");
		txtViaggioPart.setText("");
		txtPartOrario.setText("");
		txtViaggioArrivo.setText("");
		txtViaggioArrivoOrario.setText("");
	}

	// *******************************************
	// Metodi che definiscono e mandano in esecuzione query SELECT
	private void executeSelectViaggio(int pID) {
		tabella.setViaggioID(pID);
		String query = "SELECT viaggiID,PartLocalitaID,PartData,PartOra,ArrivoLocalitaID,ArrivoData,ArrivoOra, NrPosti, NrPrenotati,"
				+ "NrConfermati,CostoPosto,CostoPostoPrenotazione, l1.localita AS partLocalita, l1.provincia AS partProvincia,"
				+ "l2.localita AS arrivoLocalita, l2.provincia AS arrivoProvincia From viaggi "
				+ "INNER JOIN localita as l1 ON viaggi.PartLocalitaID = l1.localitaID "
				+ "INNER JOIN localita as l2 ON viaggi.ArrivoLocalitaID = l2.localitaID" + " WHERE viaggiID = " + pID
				+ ";";
		Db.executeQuery(query, this);
	}

	private void executeSelectAgenzia(int pID) {
		tabella.setAgenziaViaggiID(pID);
		String query = "SELECT * FROM Agenzie WHERE agenziaID = " + pID + ";";
		Db.executeQuery(query, this);
	}

	private void executeSelectPrenotazione(int pID) {
		tabella.setAgenziaViaggiID(pID);
		String query = "SELECT *, Agenzie.ragioneSociale, l1.localita AS partLocalita, l1.provincia AS partProvincia,"
				+ "l2.localita AS arrivoLocalita, l2.provincia AS arrivoProvincia FROM Prenotazioni, Agenzie, Viaggi "
				+ " INNER JOIN localita as l1 ON viaggi.PartLocalitaID = l1.localitaID "
				+ " INNER JOIN localita as l2 ON viaggi.ArrivoLocalitaID = l2.localitaID"
				+ " WHERE Prenotazioni.prenotazioniID = " + pID + " "
				+ "AND prenotazioni.agenziaViaggiID = agenzie.agenziaID;";
		Db.executeQuery(query, this);
	}

	@Override
	public void passResultset(ResultSet rows) {
		if (tipoResultset == TIPO_RESULTSET_PRENOTAZIONE) {
			setTabellaPrenotazioneRicerca(rows);
		} else if (tipoResultset == TIPO_RESULTSET_AGENZIA) {
			setDatiAgenzia(rows);
		} else if (tipoResultset == TIPO_RESULTSET_VIAGGIO) {
			setDatiViaggio(rows);
		}
	}

	private void setTabellaPrenotazioneRicerca(ResultSet rows) {
		pulisceCampi();
		try {
			while (rows.next()) {
				txtID.setValue(rows.getInt("prenotazioniID"));
				txtPosti.setValue(rows.getInt("posti"));
				txtCostoPosto.setValue(rows.getInt("costoPosto"));
				txtCostoPrenotazione.setValue(rows.getInt("costoPrenotazione"));
				txtAgenziaViaggi.setText(rows.getString("ragioneSociale"));
				rbtPrenotato.setSelected(rows.getBoolean("prenotati"));
				rbtAcquistato.setSelected(rows.getBoolean("acquistati"));

				txtViaggioPart.setText(rows.getString("partLocalita") + " (" + rows.getString("partProvincia") + ")");
				LocalDate data = rows.getDate("partData").toLocalDate();
				txtPartOrario.setText(UtyDate.getDDMMYYYY(data) + " , " + rows.getTime("PartOra"));
				txtViaggioArrivo
						.setText(rows.getString("arrivoLocalita") + " (" + rows.getString("arrivoProvincia") + ")");
				data = rows.getDate("arrivoData").toLocalDate();
				txtViaggioArrivoOrario.setText(UtyDate.getDDMMYYYY(data) + " , " + rows.getTime("arrivoOra"));

				tabella.setPosti(rows.getInt("posti"));
				tabella.setCostoPosto(rows.getDouble("costoPosto"));
				txtTotale.setValue(tabella.getCostoTotale());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setDatiViaggio(ResultSet rows) {
		try {
			txtViaggioPart.setText("");
			txtPartOrario.setText("");
			txtViaggioArrivo.setText("");
			txtViaggioArrivoOrario.setText("");
			txtCostoPosto.setValue(0);
			txtCostoPrenotazione.setValue(0);
			while (rows.next()) {
				idViaggio = rows.getInt("viaggiID");
				txtViaggioPart.setText(rows.getString("partLocalita") + " (" + rows.getString("partProvincia") + ")");
				LocalDate data = rows.getDate("partData").toLocalDate();
				txtPartOrario.setText(UtyDate.getDDMMYYYY(data) + " , " + rows.getTime("PartOra"));
				txtViaggioArrivo
						.setText(rows.getString("arrivoLocalita") + " (" + rows.getString("arrivoProvincia") + ")");
				data = rows.getDate("arrivoData").toLocalDate();
				txtViaggioArrivoOrario.setText(UtyDate.getDDMMYYYY(data) + " , " + rows.getTime("arrivoOra"));
				txtCostoPosto.setValue(rows.getDouble("CostoPosto"));
				txtCostoPrenotazione.setValue(rows.getDouble("CostoPostoPrenotazione"));
				
				tabella.setCostoPosto(rows.getDouble("CostoPosto"));
				tabella.setCostoPrenotazione(rows.getDouble("CostoPostoPrenotazione"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setDatiAgenzia(ResultSet rows) {
		try {
			txtAgenziaViaggi.setText("");
			while (rows.next()) {
				idAgenzia = rows.getInt("agenziaID");
				txtAgenziaViaggi.setText(rows.getString("ragioneSociale"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void calcoloCostoTotale() {
		try {
			// Forza il controllo di tipo JFormattedField
			// il valore è "value"
			txtPosti.commitEdit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tabella.setPosti(((Number) txtPosti.getValue()).intValue());
		tabella.setPrenotati(rbtPrenotato.isSelected());
		tabella.setAcquistati(rbtAcquistato.isSelected());
		txtTotale.setValue(tabella.getCostoTotale());
	}

	private void eliminaDati() {
		int id = ((Number) txtID.getValue()).intValue();
		if (id <= 0)
			return;
		QueryDbExecute.execute("DELETE FROM prenotazioni WHERE prenotazioniID =" + id);
	}
}
