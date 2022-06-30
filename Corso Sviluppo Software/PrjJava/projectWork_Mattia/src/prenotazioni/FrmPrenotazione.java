package prenotazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clienti.FrmClientiVisualizza;
import clienti.TabellaCliente;
import database.Db;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;
import passaggioID.ISelezioneByID;
import tipoPagamento.TipoPagamento;
import utili.UtyMsgBox;
import utili.UtyParsing;
import viaggi.FrmViaggiVisualizza;
import viaggi.TabellaViaggi;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class FrmPrenotazione extends JFrame implements ISelezioneByID, ISelectPassResultSet {

	private JPanel contentPane;
	private JPanel panDati;
	private JPanel panComandi;
	private JButton btnSalva;
	private JButton btnElimina;
	private JButton btnAnnulla;
	private JLabel lblNewLabel;
	private JFormattedTextField txtID;
	private JLabel lblNewLabel_1;
	private JFormattedTextField txtClienteID;
	private JButton btnRicercaCliente;
	private JLabel lblClienteNome;
	private JLabel lblTelefonoMail;
	private JLabel lblNewLabel_2;
	private JButton btnRicercaViaggio;
	private JLabel lblPartenza;
	private JLabel lblArrivo;
	private JLabel lblNewLabel_3;
	private JFormattedTextField txtPostiPrenotati;
	private JFormattedTextField txtViaggioID;
	private JButton btnCalcola;
	private JLabel lblNewLabel_4;
	private JLabel lblPostiDisponibili;
	private JLabel lblNewLabel_5;
	private JLabel lblImporto;
	private JRadioButton rdbtnBonifico;
	private JRadioButton rdbtnCartaDiCredito;
	private JLabel lblDataPrenotazione;
	private JButton btnRicercaPrenotazioni;
	// *********************************************
	private TabellaPrenotazione oggettoTabella;
	private JLabel lblNewLabel_6;
	private JLabel lblPrezzo;

	private int tipoResulset = 0;
	private final int TIPO_RESULTSET_PRENOTAZIONE = 1;
	private final int TIPO_RESULTSET_VIAGGIO = 2;
	private final int TIPO_RESULTSET_CLIENTE = 3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrenotazione frame = new FrmPrenotazione();
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
	public FrmPrenotazione() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\projectWork_Mattia\\icon.png"));
		setTitle("Gestione Prenotazione Viaggi | Mattia Audisio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(64, 224, 208));
		this.contentPane.setForeground(Color.WHITE);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panDati = new JPanel();
		this.panDati.setBackground(new Color(64, 224, 208));
		this.contentPane.add(this.panDati, BorderLayout.CENTER);
		this.panDati.setLayout(null);

		this.lblNewLabel = new JLabel("ID");
		this.lblNewLabel.setBounds(10, 8, 11, 14);
		this.panDati.add(this.lblNewLabel);

		this.txtID = new JFormattedTextField();
		this.txtID.setEditable(false);
		this.txtID.setBounds(31, 5, 81, 20);
		this.panDati.add(this.txtID);

		this.lblNewLabel_1 = new JLabel("Cliente");
		this.lblNewLabel_1.setBounds(10, 52, 46, 14);
		this.panDati.add(this.lblNewLabel_1);

		this.txtClienteID = new JFormattedTextField();
		this.txtClienteID.setEditable(false);
		this.txtClienteID.setBounds(55, 49, 82, 20);
		this.panDati.add(this.txtClienteID);

		this.btnRicercaCliente = new JButton("Ricerca Cliente");
		this.btnRicercaCliente.setBackground(UIManager.getColor("Button.background"));
		this.btnRicercaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ricercaCliente();
			}
		});
		this.btnRicercaCliente.setBounds(147, 48, 146, 23);
		this.panDati.add(this.btnRicercaCliente);

		this.lblClienteNome = new JLabel("Cliente nome");
		this.lblClienteNome.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		this.lblClienteNome.setBounds(106, 111, 304, 14);
		this.panDati.add(this.lblClienteNome);

		this.lblTelefonoMail = new JLabel("Telefono Mail");
		this.lblTelefonoMail.setBackground(UIManager.getColor("Button.darkShadow"));
		this.lblTelefonoMail.setBounds(10, 136, 404, 14);
		this.panDati.add(this.lblTelefonoMail);

		this.lblNewLabel_2 = new JLabel("Viaggio");
		this.lblNewLabel_2.setBounds(10, 86, 46, 14);
		this.panDati.add(this.lblNewLabel_2);

		this.btnRicercaViaggio = new JButton("Ricerca Viaggio");
		this.btnRicercaViaggio.setBackground(UIManager.getColor("Button.background"));
		this.btnRicercaViaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ricercaViaggio();
			}
		});
		this.btnRicercaViaggio.setBounds(158, 82, 146, 23);
		this.panDati.add(this.btnRicercaViaggio);

		this.lblPartenza = new JLabel("Localit\u00E0 partenza, data, ora");
		this.lblPartenza.setBackground(UIManager.getColor("Button.darkShadow"));
		this.lblPartenza.setBounds(75, 161, 304, 14);
		this.panDati.add(this.lblPartenza);

		this.lblArrivo = new JLabel("Localit\u00E0 arrivo, data, ora");
		this.lblArrivo.setBackground(UIManager.getColor("Button.darkShadow"));
		this.lblArrivo.setBounds(55, 180, 297, 14);
		this.panDati.add(this.lblArrivo);

		this.lblNewLabel_3 = new JLabel("Posti Prenotati");
		this.lblNewLabel_3.setBounds(6, 211, 92, 14);
		this.panDati.add(this.lblNewLabel_3);

		this.txtPostiPrenotati = new JFormattedTextField();
		this.txtPostiPrenotati.setBounds(106, 208, 72, 20);
		this.panDati.add(this.txtPostiPrenotati);

		this.txtViaggioID = new JFormattedTextField();
		this.txtViaggioID.setEditable(false);
		this.txtViaggioID.setBounds(62, 83, 72, 20);
		this.panDati.add(this.txtViaggioID);

		this.btnCalcola = new JButton("Calcola Importo");
		this.btnCalcola.setBackground(UIManager.getColor("Button.background"));
		this.btnCalcola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				oggettoTabella.setPostiPrenotati(((Number) txtPostiPrenotati.getValue()).intValue());
				calcolaImporto();
			}
		});
		this.btnCalcola.setBounds(188, 207, 180, 23);
		this.panDati.add(this.btnCalcola);

		this.lblNewLabel_4 = new JLabel("Posti disponibili");
		this.lblNewLabel_4.setVisible(false);
		this.lblNewLabel_4.setBounds(10, 236, 92, 14);
		this.panDati.add(this.lblNewLabel_4);

		this.lblPostiDisponibili = new JLabel("1234");
		this.lblPostiDisponibili.setVisible(false);
		this.lblPostiDisponibili.setBounds(110, 236, 46, 14);
		this.panDati.add(this.lblPostiDisponibili);

		this.lblNewLabel_5 = new JLabel("Importo:");
		this.lblNewLabel_5.setBounds(313, 236, 55, 14);
		this.panDati.add(this.lblNewLabel_5);

		this.lblImporto = new JLabel("123456");
		this.lblImporto.setBounds(364, 236, 46, 14);
		this.panDati.add(this.lblImporto);

		this.rdbtnBonifico = new JRadioButton("Bonifico");
		this.rdbtnBonifico.setBackground(new Color(64, 224, 208));
		buttonGroup.add(this.rdbtnBonifico);
		this.rdbtnBonifico.setBounds(10, 257, 109, 23);
		this.panDati.add(this.rdbtnBonifico);

		this.rdbtnCartaDiCredito = new JRadioButton("Carta di Credito");
		this.rdbtnCartaDiCredito.setBackground(new Color(64, 224, 208));
		buttonGroup.add(this.rdbtnCartaDiCredito);
		this.rdbtnCartaDiCredito.setBounds(130, 257, 109, 23);
		this.panDati.add(this.rdbtnCartaDiCredito);

		this.lblDataPrenotazione = new JLabel("27/06/2021");
		this.lblDataPrenotazione.setBounds(289, 8, 135, 14);
		this.panDati.add(this.lblDataPrenotazione);

		this.btnRicercaPrenotazioni = new JButton("Ricerca Prenotazioni");
		this.btnRicercaPrenotazioni.setBackground(UIManager.getColor("Button.background"));
		this.btnRicercaPrenotazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ricercaPrenotazione();
			}
		});
		this.btnRicercaPrenotazioni.setBounds(133, 4, 174, 23);
		this.panDati.add(this.btnRicercaPrenotazioni);

		this.lblNewLabel_6 = new JLabel("Prezzo:");
		this.lblNewLabel_6.setBounds(192, 236, 46, 14);
		this.panDati.add(this.lblNewLabel_6);

		this.lblPrezzo = new JLabel("1234");
		this.lblPrezzo.setBounds(242, 236, 46, 14);
		this.panDati.add(this.lblPrezzo);
		
		this.lblNewLabel_7 = new JLabel("Nome Cognome:");
		this.lblNewLabel_7.setBounds(10, 111, 102, 14);
		this.panDati.add(this.lblNewLabel_7);
		
		this.lblNewLabel_8 = new JLabel("Partenza:");
		this.lblNewLabel_8.setBounds(10, 161, 86, 14);
		this.panDati.add(this.lblNewLabel_8);
		
		this.lblNewLabel_9 = new JLabel("Arrivo:");
		this.lblNewLabel_9.setBounds(10, 180, 72, 14);
		this.panDati.add(this.lblNewLabel_9);

		this.panComandi = new JPanel();
		this.panComandi.setBackground(new Color(64, 224, 208));
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);

		this.btnSalva = new JButton("Salva");
		this.btnSalva.setIcon(new ImageIcon("U:\\PrjJava\\projectWork_Mattia\\save.png"));
		this.btnSalva.setBackground(UIManager.getColor("Button.background"));
		this.btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salva();
			}
		});
		this.panComandi.add(this.btnSalva);

		this.btnElimina = new JButton("Elimina");
		this.btnElimina.setIcon(new ImageIcon("U:\\PrjJava\\projectWork_Mattia\\delete.png"));
		this.btnElimina.setBackground(UIManager.getColor("Button.background"));
		this.btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (UtyMsgBox.confermaEliminazione() == 0) {
					esegueDelete();
					pulisceCampiVideo();
				}
			}

		});
		this.panComandi.add(this.btnElimina);

		this.btnAnnulla = new JButton("Annulla");
		this.btnAnnulla.setBackground(UIManager.getColor("Button.background"));
		this.btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pulisceCampiVideo();
			}
		});
		this.panComandi.add(this.btnAnnulla);

		// *********************************
		pulisceCampiVideo();
	}

	protected void ricercaPrenotazione() {
		// TODO Auto-generated method stub
		tipoResulset = TIPO_RESULTSET_PRENOTAZIONE;
		FrmPrenotazioniVisualizza f = new FrmPrenotazioniVisualizza(this);
		f.setModal(true);
		f.setVisible(true);
	}

	protected void ricercaViaggio() {
		// TODO Auto-generated method stub
		tipoResulset = TIPO_RESULTSET_VIAGGIO;
		FrmViaggiVisualizza f = new FrmViaggiVisualizza(this);
		f.setModal(true);
		f.setVisible(true);

	}

	protected void ricercaCliente() {
		// TODO Auto-generated method stub
		tipoResulset = TIPO_RESULTSET_CLIENTE;
		FrmClientiVisualizza f = new FrmClientiVisualizza(this);
		f.setModal(true);
		f.setVisible(true);

	}

	private void esegueDelete() {
		// TODO Auto-generated method stub
		String sql = oggettoTabella.getSqlDelete();
		QueryDbExecute.executeUpdate(sql);
	}

	private void daOggettoTabellaAVideo() {
		// TODO Auto-generated method stub
		// ** sposta valori da oggetto tabella a campi/label del form
		TabellaPrenotazione tb = oggettoTabella;
		txtID.setValue(tb.getPrenotazioneID());
		lblDataPrenotazione.setText("");
		txtClienteID.setValue(tb.getClienteID());
		txtViaggioID.setValue(tb.getViaggioID());
		txtPostiPrenotati.setValue(tb.getPostiPrenotati());
		lblPrezzo.setText(((Number) tb.getPrezzo()).toString());
		// ****
		lblClienteNome.setText("");
		lblTelefonoMail.setText("");
		lblArrivo.setText("");
		lblPartenza.setText("");
		lblPostiDisponibili.setText(((Number) tb.getPostiDisponibili()).toString());
		lblImporto.setText(((Number) tb.getImporto()).toString());

		if (tb.getPagamento() == TipoPagamento.BONIFICO) {
			rdbtnBonifico.setSelected(true);
		} else {
			rdbtnCartaDiCredito.setSelected(true);
		}

		daDatiClienteAForm(tb.getClienteID(), tb.getCognome(), tb.getNome(), tb.getTelefono(), tb.getMail());
		daDatiViaggioAForm(tb.getViaggioID(), tb.getViaggioPartenza(), tb.getDataPartenza(), tb.getOraPartenza(),
				tb.getViaggioArrivo(), tb.getDataArrivo(), tb.getOraArrivo(), tb.getPrezzo(), tb.getPostiDisponibili(),tb.getPostiPrenotati());
	}

	private void assegnaValoriDefault() {
		// TODO Auto-generated method stub
		// ** assegna la data del giorno della prenotazione
		oggettoTabella.setDataPrenotazione(LocalDate.now());
	}

	private void creaOggettoTabella() {
		// ** crea oggetto relativo alla tabella di interesse per questo form
		oggettoTabella = new TabellaPrenotazione();
	}

	private void salva() {
		// TODO Auto-generated method stub
		daVideoAOggettoTabella();
		String msg = convalida();
		if (msg != null && msg.trim() != "") {
			UtyMsgBox.Avviso(msg);
			return;
		}
		if (oggettoTabella.getPrenotazioneID() > 0) {
			esegueUpdate();
		} else {
			esegueInsert();
		}
		pulisceCampiVideo();
	}

	private void pulisceCampiVideo() {
		// TODO Auto-generated method stub
		creaOggettoTabella();
		assegnaValoriDefault();
		daOggettoTabellaAVideo();
	}

	private void esegueInsert() {
		// TODO Auto-generated method stub
		String sql = oggettoTabella.getSqlInsert();
		QueryDbExecute.executeUpdate(sql);
	}

	private void esegueUpdate() {
		// TODO Auto-generated method stub
		String sql = oggettoTabella.getSqlUpdate();
		QueryDbExecute.executeUpdate(sql);
	}

	private String convalida() {
		// TODO Auto-generated method stub
		String msg = "";
		if(oggettoTabella.getClienteID() == 0) {
			msg += "Inserire dati cliente \r\n";
		}
		if(oggettoTabella.getViaggioID() == 0) {
			msg += "Inserire viaggio \r\n";			
		}
		if(oggettoTabella.getPostiPrenotati() == 0) {
			msg += "Inserire posti prenotati \r\n";
		}
		return msg;
	}

	private void daVideoAOggettoTabella() {
		// TODO Auto-generated method stub
		TabellaPrenotazione tb = oggettoTabella;

		tb.setClienteID(UtyParsing.toInt(txtClienteID.getValue().toString()));
		tb.setViaggioID(UtyParsing.toInt(txtViaggioID.getValue().toString()));
		tb.setPostiPrenotati(UtyParsing.toInt(txtPostiPrenotati.getValue().toString()));
		tb.setPrezzo(UtyParsing.toDouble(lblPrezzo.getText()));

		if (rdbtnBonifico.isSelected())
			tb.setPagamento(TipoPagamento.BONIFICO);
		else
			tb.setPagamento(TipoPagamento.CARTACREDITO);
	}

	@Override
	public void selezione(int pID) {
		// TODO Auto-generated method stub
		String query = "";
		String where = "";
		if (tipoResulset == 0)
			return;
		else if (tipoResulset == TIPO_RESULTSET_CLIENTE) {
			where = "WHERE ClienteID =" + pID;
			query = TabellaCliente.getSqlSelect(where);
		} else if (tipoResulset == TIPO_RESULTSET_VIAGGIO) {
			where = "WHERE viaggioID =" + pID;
			query = TabellaViaggi.getSqlSelect(where);
		} else if (tipoResulset == TIPO_RESULTSET_PRENOTAZIONE) {
			where = "WHERE prenotazioneID =" + pID;
			query = TabellaPrenotazione.getSqlSelect(where);
		}

		Db.executeQuery(query, this);
	}

	@Override
	public void passResultSet(ResultSet rows) {
		// TODO Auto-generated method stub
		if (tipoResulset == TIPO_RESULTSET_CLIENTE) {
			leggeRowCliente(rows);
		} else if (tipoResulset == TIPO_RESULTSET_VIAGGIO) {
			leggeRowViaggio(rows);
		} else if (tipoResulset == TIPO_RESULTSET_PRENOTAZIONE) {
			leggeRowPrenotazione(rows);
		}
	}

	private void leggeRowPrenotazione(ResultSet rows) {
		// TODO Auto-generated method stub
		try {
			while (rows.next()) {
				oggettoTabella = TabellaPrenotazione.getPrenotazioneFromRowSet(rows);
				daOggettoTabellaAVideo();
				daDatiPrenotazioneAForm(oggettoTabella);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void leggeRowViaggio(ResultSet rows) {
		// TODO Auto-generated method stub
		try {
			while (rows.next()) {
				TabellaViaggi tb = TabellaViaggi.getViaggioFromRowSet(rows);
				daDatiViaggioAForm(tb.getViaggioID(), tb.getPartenza(), tb.getDataPartenza(), tb.getOra_Partenza(),
						tb.getArrivo(), tb.getDataArrivo(), tb.getOra_Arrivo(), tb.getPrezzo(), tb.getDisponibili(),0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void leggeRowCliente(ResultSet rows) {
		// TODO Auto-generated method stub
		try {
			while (rows.next()) {
				TabellaCliente tb = TabellaCliente.getClienteFromRowSet(rows);
				daDatiClienteAForm(tb.getClienteID(), tb.getCognome(), tb.getNome(), tb.getTelefono(), tb.getMail());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void daDatiPrenotazioneAForm(TabellaPrenotazione tb) {
		// TODO Auto-generated method stub
		txtID.setValue(tb.getPrenotazioneID());
		daDatiClienteAForm(tb.getClienteID(), tb.getCognome(), tb.getNome(), tb.getTelefono(), tb.getMail());
		daDatiViaggioAForm(tb.getViaggioID(), tb.getViaggioPartenza(), tb.getDataPartenza(), tb.getOraPartenza(),
				tb.getViaggioArrivo(), tb.getDataArrivo(), tb.getOraArrivo(), tb.getPrezzo(), tb.getPostiDisponibili(),tb.getPostiPrenotati());

	}

	private void daDatiClienteAForm(int clienteID, String cognome, String nome, String telefono, String mail) {
		// TODO Auto-generated method stub
		txtClienteID.setValue(0);
		lblClienteNome.setText("");
		lblTelefonoMail.setText("");

		if (clienteID > 0) {
			txtClienteID.setValue(clienteID);
			lblClienteNome.setText(cognome + " " + nome);
			lblTelefonoMail.setText("tel.: " + telefono + " Mail:" + mail);
		}
	}

	private void daDatiViaggioAForm(int viaggioID, String partenza, LocalDate partenzaData, double ora_Partenza,
			String arrivo, LocalDate arrivoData, double ora_Arrivo, Double prezzo, Integer postiDisponibili, int prenotati) {
		// TODO Auto-generated method stub
		txtViaggioID.setValue(0);
		lblPartenza.setText("");
		lblArrivo.setText("");
		lblPrezzo.setText("0");
		lblPostiDisponibili.setText("0");
		txtPostiPrenotati.setValue(0);
		oggettoTabella.setPrezzo(prezzo);

		String dataPartenza = "";
		String dataArrivo = "";
		if (partenzaData != null)
			dataPartenza = partenzaData.toString();
		if (arrivoData != null)
			dataArrivo = arrivoData.toString();
		else
			dataArrivo = dataPartenza;

		if (viaggioID > 0) {
			txtViaggioID.setValue(viaggioID);
			lblPartenza.setText(partenza + " il " + dataPartenza + " alle ore " + ora_Partenza);
			lblArrivo.setText(arrivo + " il " + dataArrivo + " alle ore " + ora_Arrivo);
		}

		lblPrezzo.setText(prezzo.toString());
		lblPostiDisponibili.setText(postiDisponibili.toString());
		txtPostiPrenotati.setValue(prenotati);
		calcolaImporto();
	}

	private void calcolaImporto() {
		// TODO Auto-generated method stub
		lblImporto.setText(oggettoTabella.getImporto().toString());
	}
}