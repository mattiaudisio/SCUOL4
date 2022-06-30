package tabellaViaggi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comuni.Db;
import dbMysql.ISelectPassResultSet;
import dbMysql.QueryDbExecute;
import tabellaLocalita.FrmTabellaLocalitaRicerca;
import utili.ISelezioneByID;
import utili.JFormattedNumber;
import utili.Msg;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;

public class FrmTabellaViaggi extends JFrame implements ISelectPassResultSet, ISelezioneByID {

	// key = combo.selectedIndex e torna localitaID
	private HashMap<Integer, Integer> indexLocalitaID;
	// key = localitaID e torna combo.selectedIndex da impostare
	private HashMap<Integer, Integer> localitaIDIndex;
	private JPanel contentPane;
	private JPanel panDati;
	private JPanel panComandi;
	private JButton btnSalva;
	private JButton btnElimina;
	private JButton btnAnnulla;
	private JLabel lblNewLabel;
	private JFormattedNumber txtID;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JFormattedNumber txtPartGG;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JComboBox cmbPartLocalita;
	private JFormattedNumber txtPartMM;
	private JFormattedNumber txtPartAA;
	private JLabel lblNewLabel_7;
	private JFormattedNumber txtPartHH;
	private JLabel lblNewLabel_8;
	private JFormattedNumber txtPartMin;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JFormattedNumber txtArrivoGG;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JComboBox cmbArrivoLocalita;
	private JFormattedNumber txtArrivoMM;
	private JFormattedNumber txtArrivoAA;
	private JLabel lblNewLabel_16;
	private JFormattedNumber txtArrivoHH;
	private JLabel lblNewLabel_17;
	private JFormattedNumber txtArrivoMin;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JFormattedNumber txtNrPosti;
	private JFormattedNumber txtNrPrenotati;
	private JLabel lblNewLabel_20;
	private JFormattedNumber txtNrConfermati;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JFormattedNumber txtCostoPosto;
	private JFormattedNumber txtCostoPrenotazione;
	private JLabel lblNewLabel_23;
	private JButton btnRicerca;
	private JButton btnRicercaPartLocalita;
	private JFrame thisFrame;
	private int tipoResultset = 0;
	// ** per SELECT elenco località in comboBox
	private final int TIPO_RESULT_SET_LOCALITA = 1;
	// ** per SELECT ricerca viaggio by ID
	private final int TIPO_RESULT_SET_SELECT = 2;
	// ** per SELECT ricerca localita PARTENZA by ID
	private final int TIPO_RESULT_SET_PARTENZA = 3;
	// ** per SELECT ricerca localita ARRIVO by ID
	private final int TIPO_RESULT_SET_ARRIVO = 4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaViaggi frame = new FrmTabellaViaggi();
					frame.setVisible(true);
					frame.SelezioneLocalita();
					frame.pulisceCampi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTabellaViaggi() {
		thisFrame = this;
		setTitle("Manutenzione Viaggi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
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
		this.txtID.setEditable(false);
		this.txtID.setBounds(91, 8, 46, 20);
		this.panDati.add(this.txtID);

		this.lblNewLabel_1 = new JLabel("Partenza");
		this.lblNewLabel_1.setBounds(10, 50, 46, 14);
		this.panDati.add(this.lblNewLabel_1);

		this.lblNewLabel_2 = new JLabel("Localit\u00E0");
		this.lblNewLabel_2.setBounds(91, 50, 46, 14);
		this.panDati.add(this.lblNewLabel_2);

		this.lblNewLabel_3 = new JLabel("Data");
		this.lblNewLabel_3.setBounds(91, 107, 46, 14);
		this.panDati.add(this.lblNewLabel_3);

		this.txtPartGG = new JFormattedNumber();
		this.txtPartGG.setBounds(139, 107, 26, 20);
		this.panDati.add(this.txtPartGG);

		this.lblNewLabel_4 = new JLabel("GG");
		this.lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_4.setBounds(139, 92, 26, 14);
		this.panDati.add(this.lblNewLabel_4);

		this.lblNewLabel_5 = new JLabel("MM");
		this.lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_5.setBounds(175, 92, 27, 14);
		this.panDati.add(this.lblNewLabel_5);

		this.lblNewLabel_6 = new JLabel("AA");
		this.lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_6.setBounds(222, 92, 26, 14);
		this.panDati.add(this.lblNewLabel_6);

		this.cmbPartLocalita = new JComboBox();
		this.cmbPartLocalita.setBounds(147, 46, 235, 22);
		this.panDati.add(this.cmbPartLocalita);

		this.txtPartMM = new JFormattedNumber();
		this.txtPartMM.setBounds(175, 107, 39, 20);
		this.panDati.add(this.txtPartMM);

		this.txtPartAA = new JFormattedNumber();
		this.txtPartAA.setBounds(222, 107, 46, 20);
		this.panDati.add(this.txtPartAA);

		this.lblNewLabel_7 = new JLabel("Ora");
		this.lblNewLabel_7.setBounds(283, 107, 26, 14);
		this.panDati.add(this.lblNewLabel_7);

		this.txtPartHH = new JFormattedNumber();
		this.txtPartHH.setBounds(319, 107, 26, 20);
		this.panDati.add(this.txtPartHH);

		this.lblNewLabel_8 = new JLabel("HH");
		this.lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_8.setBounds(319, 92, 26, 14);
		this.panDati.add(this.lblNewLabel_8);

		this.txtPartMin = new JFormattedNumber();
		this.txtPartMin.setBounds(355, 107, 26, 20);
		this.panDati.add(this.txtPartMin);

		this.lblNewLabel_9 = new JLabel("mm");
		this.lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_9.setBounds(355, 92, 27, 14);
		this.panDati.add(this.lblNewLabel_9);

		this.lblNewLabel_10 = new JLabel("Arrivo");
		this.lblNewLabel_10.setBounds(10, 156, 46, 14);
		this.panDati.add(this.lblNewLabel_10);

		this.lblNewLabel_11 = new JLabel("Localit\u00E0");
		this.lblNewLabel_11.setBounds(91, 156, 46, 14);
		this.panDati.add(this.lblNewLabel_11);

		this.lblNewLabel_12 = new JLabel("Data");
		this.lblNewLabel_12.setBounds(91, 217, 46, 14);
		this.panDati.add(this.lblNewLabel_12);

		this.txtArrivoGG = new JFormattedNumber();
		this.txtArrivoGG.setBounds(139, 217, 26, 20);
		this.panDati.add(this.txtArrivoGG);

		this.lblNewLabel_13 = new JLabel("GG");
		this.lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_13.setBounds(139, 202, 26, 14);
		this.panDati.add(this.lblNewLabel_13);

		this.lblNewLabel_14 = new JLabel("MM");
		this.lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_14.setBounds(175, 202, 27, 14);
		this.panDati.add(this.lblNewLabel_14);

		this.lblNewLabel_15 = new JLabel("AA");
		this.lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_15.setBounds(222, 202, 26, 14);
		this.panDati.add(this.lblNewLabel_15);

		this.cmbArrivoLocalita = new JComboBox();
		this.cmbArrivoLocalita.setBounds(147, 156, 235, 22);
		this.panDati.add(this.cmbArrivoLocalita);

		this.txtArrivoMM = new JFormattedNumber();
		this.txtArrivoMM.setBounds(175, 217, 39, 20);
		this.panDati.add(this.txtArrivoMM);

		this.txtArrivoAA = new JFormattedNumber();
		this.txtArrivoAA.setBounds(222, 217, 46, 20);
		this.panDati.add(this.txtArrivoAA);

		this.lblNewLabel_16 = new JLabel("Ora");
		this.lblNewLabel_16.setBounds(283, 217, 26, 14);
		this.panDati.add(this.lblNewLabel_16);

		this.txtArrivoHH = new JFormattedNumber();
		this.txtArrivoHH.setBounds(319, 217, 26, 20);
		this.panDati.add(this.txtArrivoHH);

		this.lblNewLabel_17 = new JLabel("HH");
		this.lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_17.setBounds(319, 202, 26, 14);
		this.panDati.add(this.lblNewLabel_17);

		this.txtArrivoMin = new JFormattedNumber();
		this.txtArrivoMin.setBounds(355, 217, 26, 20);
		this.panDati.add(this.txtArrivoMin);

		this.lblNewLabel_18 = new JLabel("mm");
		this.lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel_18.setBounds(355, 202, 27, 14);
		this.panDati.add(this.lblNewLabel_18);

		this.lblNewLabel_19 = new JLabel("Nr. Posti");
		this.lblNewLabel_19.setBounds(10, 261, 60, 14);
		this.panDati.add(this.lblNewLabel_19);

		this.txtNrPosti = new JFormattedNumber();
		this.txtNrPosti.setBounds(66, 258, 39, 20);
		this.panDati.add(this.txtNrPosti);

		this.txtNrPrenotati = new JFormattedNumber();
		this.txtNrPrenotati.setBounds(199, 258, 39, 20);
		this.panDati.add(this.txtNrPrenotati);

		this.lblNewLabel_20 = new JLabel("Nr. Prenotati");
		this.lblNewLabel_20.setBounds(115, 261, 87, 14);
		this.panDati.add(this.lblNewLabel_20);

		this.txtNrConfermati = new JFormattedNumber();
		this.txtNrConfermati.setBounds(355, 258, 39, 20);
		this.panDati.add(this.txtNrConfermati);

		this.lblNewLabel_21 = new JLabel("Nr. Confermati");
		this.lblNewLabel_21.setBounds(272, 261, 97, 14);
		this.panDati.add(this.lblNewLabel_21);

		this.lblNewLabel_22 = new JLabel("Costo Posto");
		this.lblNewLabel_22.setBounds(10, 299, 72, 14);
		this.panDati.add(this.lblNewLabel_22);

		this.txtCostoPosto = new JFormattedNumber();
		this.txtCostoPosto.setBounds(87, 299, 39, 20);
		this.panDati.add(this.txtCostoPosto);

		this.txtCostoPrenotazione = new JFormattedNumber();
		this.txtCostoPrenotazione.setBounds(330, 299, 39, 20);
		this.panDati.add(this.txtCostoPrenotazione);

		this.lblNewLabel_23 = new JLabel("Costo Posto Prenotazione");
		this.lblNewLabel_23.setBounds(175, 299, 154, 14);
		this.panDati.add(this.lblNewLabel_23);

		this.btnRicerca = new JButton("Ricerca");
		this.btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ** dobbiamo utilizzare thisframe in quato questo evento
				// ** this corrisponde al btnRicerca e non al JFrame
				tipoResultset = TIPO_RESULT_SET_SELECT;
				FrmTabellaViaggiRicerca f = new FrmTabellaViaggiRicerca((ISelezioneByID) thisFrame, thisFrame);
				f.setVisible(true);
			}
		});
		this.btnRicerca.setBounds(175, 7, 89, 23);
		this.panDati.add(this.btnRicerca);

		this.btnRicercaPartLocalita = new JButton("...");
		this.btnRicercaPartLocalita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipoResultset = TIPO_RESULT_SET_PARTENZA;
				FrmTabellaLocalitaRicerca f = new FrmTabellaLocalitaRicerca((ISelezioneByID) thisFrame, thisFrame);
				f.setVisible(true);
			}
		});
		this.btnRicercaPartLocalita.setBounds(388, 46, 26, 23);
		this.panDati.add(this.btnRicercaPartLocalita);

		JButton btnRicercaArrivoLocalita = new JButton("...");
		btnRicercaArrivoLocalita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipoResultset = TIPO_RESULT_SET_ARRIVO;
				FrmTabellaLocalitaRicerca f = new FrmTabellaLocalitaRicerca((ISelezioneByID) thisFrame, thisFrame);
				f.setVisible(true);
			}
		});
		btnRicercaArrivoLocalita.setBounds(388, 156, 26, 23);
		this.panDati.add(btnRicercaArrivoLocalita);

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
				}
				inserimento();
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
		// ** verifico che la localita partenza si inserita
		if (cmbPartLocalita.getSelectedIndex() == -1) {
			err += "\nInserire località di partenza";
		}
		// ** verifico che la arrivo partenza si inserita
		if (cmbArrivoLocalita.getSelectedIndex() == -1) {
			err += "\nInserire località di arrivo";
		}
		/**
		 * controllo su dati relativi alla partenza cotrollo sulla località se è
		 * presente sul data partenza ora partenza
		 */

		LocalDate dtPartenza = null;
		LocalDate dtArrivo = null;
		LocalTime oraPartenza = null;
		LocalTime oraArrivo = null;
		// ** verifica data partenza
		int txtY = ((Number) txtPartAA.getValue()).intValue() + 2000;
		if (txtY > 2099) {
			err = "\nAnno partenza deve essere di 2 cifre";
		}
		int txtM = ((Number) txtPartMM.getValue()).intValue();
		int txtG = ((Number) txtPartGG.getValue()).intValue();

		try {
			dtPartenza = LocalDate.of(txtY, txtM, txtG);

		} catch (Exception e) {
			err += "\nData partenza errata";
		}
		// *********************************************************

		txtY = ((Number) txtArrivoAA.getValue()).intValue() + 2000;
		if (txtY > 2099) {
			err = "\nAnno arrivo deve essere di 2 cifre";
		}
		txtM = ((Number) txtArrivoMM.getValue()).intValue();
		txtG = ((Number) txtArrivoGG.getValue()).intValue();

		try {
			dtArrivo = LocalDate.of(txtY, txtM, txtG);

		} catch (Exception e) {
			err += "\nData arrivo errata";
		}
		// ** ora partenza
		int txtH = ((Number) txtPartHH.getValue()).intValue();
		int txtmin = ((Number) txtPartMin.getValue()).intValue();

		try {
			oraPartenza = LocalTime.of(txtH, txtmin);

		} catch (Exception e) {
			err += "\nOra partenza errata";
		}

		// ** ora arrivo
		txtH = ((Number) txtArrivoHH.getValue()).intValue();
		txtmin = ((Number) txtArrivoMin.getValue()).intValue();

		try {
			oraArrivo = LocalTime.of(txtH, txtmin);

		} catch (Exception e) {
			err += "\nOra arrivo errata";
		}
		// -- viaggi inseribli da domani in poi
		/**
		 * il metodo compareTo compara due date se torna un valore minore di 0 vuol dire
		 * che la data di partenza è minore della data odierna e quindi non può essere
		 * se torna 0 vuol dire che sono uguali se torna un valore maggiore di 0 vuol
		 * dire che la data di partenza è maggiore della data odierna
		 */
		LocalDateTime dtTimePartenza = null;
		LocalDateTime dtTimeArrivo = null;
		if (dtPartenza != null && dtPartenza.compareTo(LocalDate.now()) < 0) {
			err = "\nData di partenza non può essere inferiore o uguale";
		}
		/**
		 * confontiamo data e ora partenza con data ora arrivo la partenza deve essrere
		 * precedente alla data de arrivo
		 */
		if (dtPartenza != null && oraPartenza != null) {
			dtTimePartenza = LocalDateTime.of(dtPartenza, oraPartenza);
		}

		if (dtArrivo != null && oraArrivo != null) {
			dtTimeArrivo = LocalDateTime.of(dtArrivo, oraArrivo);
		}

		if (dtTimePartenza != null && dtTimeArrivo != null) {

			if (dtTimePartenza.compareTo(dtTimeArrivo) > 0) {
				err = "\nData di artenza non può essere successiva a data arrivo";
			}
		}
		return err;
	}

	private int getId() {
		if (txtID.getText().equals(""))
			return 0;
		Object o = txtID.getValue();
		if (o == null)
			return 0;
		return ((Number) o).intValue();
	}

	private LocalTime creaOra(JFormattedNumber txtHH, JFormattedNumber txtMin) {
		LocalTime dtOra = null;
		int h = ((Number) txtPartHH.getValue()).intValue();
		int min = ((Number) txtPartMin.getValue()).intValue();
		try {
			dtOra = LocalTime.of(h, min);
			return dtOra;
		} catch (Exception e) {
			return dtOra;
		}
	}

	private LocalDate creaData(JFormattedNumber txtAA, JFormattedNumber txtMM, JFormattedNumber txtGG) {
		LocalDate dtArrivo = null;
		int txtY = ((Number) txtAA.getValue()).intValue() + 2000;
		int txtM = ((Number) txtMM.getValue()).intValue();
		int txtG = ((Number) txtGG.getValue()).intValue();

		try {
			dtArrivo = LocalDate.of(txtY, txtM, txtG);
			return dtArrivo;
		} catch (Exception e) {
			return dtArrivo;
		}
	}

	public void SelezioneLocalita() {
		tipoResultset = TIPO_RESULT_SET_LOCALITA;
		String query = "SELECT localitaID, localita,provincia FROM localita ORDER BY localita, provincia";
		Db.executeQuery(query, this);
	}

	private void inserimento() {
		TabellaViaggi viaggio = new TabellaViaggi();
		// *** ricerco ID per partLocalita
		// ** Imposto dati partenza

		int viaggioID = ((Number) txtID.getValue()).intValue();
		viaggio.setViaggioID(viaggioID);

		int id = 0;
		if (cmbPartLocalita.getSelectedIndex() != -1) {
			Object obj = indexLocalitaID.get(cmbPartLocalita.getSelectedIndex());
			id = ((Number) obj).intValue();
		}

		viaggio.setPartLocalitaID(id);
		viaggio.setPartData(creaData(txtPartAA, txtPartMM, txtPartGG));
		viaggio.setPartOra(creaOra(txtPartHH, txtPartMin));

		// ** Imposto dati arrivo
		id = 0;
		if (cmbArrivoLocalita.getSelectedIndex() != -1) {
			Object obj = indexLocalitaID.get(cmbArrivoLocalita.getSelectedIndex());
			id = ((Number) obj).intValue();
		}
		viaggio.setArrivoLocalitaID(id);
		viaggio.setArrivoData(creaData(txtArrivoAA, txtArrivoMM, txtArrivoGG));
		viaggio.setArrivoOra(creaOra(txtArrivoHH, txtArrivoMin));

		viaggio.setNrPosti(((Number) txtNrPosti.getValue()).intValue());
		viaggio.setNrPrenotati(((Number) txtNrPrenotati.getValue()).intValue());
		viaggio.setNrConfermati(((Number) txtNrConfermati.getValue()).intValue());
		viaggio.setCostoPosto(((Number) txtCostoPosto.getValue()).doubleValue());
		viaggio.setCostoPrenotazione(((Number) txtCostoPrenotazione.getValue()).doubleValue());

		String query = "";
		if (viaggioID == 0) {
			query = viaggio.getQueryInsert();
		} else {
			query = viaggio.getQueryUpfate();
		}
		Db.execute(query);
	}

	private void apriFormRicerca() {
		FrmTabellaViaggiRicerca frm = new FrmTabellaViaggiRicerca(this, this);
		frm.setLocation(this.getX() + 20, this.getY() + 20);
		frm.setVisible(true);
	}

	private void elementiComboSenzaID(ResultSet rows) {
		// TODO Auto-generated method stub
		try {
			int index = 0;
			while (rows.next()) {
				int id = rows.getInt("localitaID");
				String locprov = rows.getString("localita") + " (" + rows.getString("provincia") + ")";
				cmbPartLocalita.addItem(locprov);
				cmbArrivoLocalita.addItem(locprov);
				indexLocalitaID.put(index, id);
				localitaIDIndex.put(id, index);
				index++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//	private void elementiComboConID(ResultSet rows) {
//		try {
//			int index = 0;
//			while (rows.next()) {
//				int id = rows.getInt("localitaID");
//				String locprov = id + " | " + rows.getString("localita") + " (" + rows.getString("provincia") + ")";
//				cmbPartLocalita.addItem(locprov);
//				cmbArrivoLocalita.addItem(locprov);
//				indexLocalitaID.put(index, id);
//				localitaIDIndex.put(id, index);
//				index++;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	@Override
	public void selezione(int pID) {
		String query = "";
		if(tipoResultset == 0) {
			return;
		}
		// ID è da ricerca viaggi
		if (tipoResultset == TIPO_RESULT_SET_SELECT) {
			query = "SELECT * FROM Viaggi WHERE viaggiID = " + pID;
		}
		// ID è da località di partenza
		if (tipoResultset == TIPO_RESULT_SET_PARTENZA) {
			int i = localitaIDIndex.get(pID);
			cmbPartLocalita.setSelectedIndex(i);
			return;
		}
		// ID è da località di arrivo
		if (tipoResultset == TIPO_RESULT_SET_ARRIVO) {
			int i = localitaIDIndex.get(pID);
			cmbArrivoLocalita.setSelectedIndex(i);
			return;
		}
		Db.executeQuery(query, this);
	}

	@Override
	public void passResultset(ResultSet rows) {
		// *** creo/ricreo ArrayList
		if (tipoResultset == TIPO_RESULT_SET_LOCALITA) {
			indexLocalitaID = new HashMap<Integer, Integer>();
			localitaIDIndex = new HashMap<Integer, Integer>();
			elementiComboSenzaID(rows);
		}else if (tipoResultset == TIPO_RESULT_SET_SELECT) {
			letturaCampiTabella(rows);
		}
		tipoResultset = 0;
	}
	
	private void letturaCampiTabella(ResultSet rows) {
		TabellaViaggi tb = new TabellaViaggi();
		try {
			while (rows.next()) {
				tb.setViaggioID(rows.getInt("viaggiID"));
				tb.setNrPosti(rows.getInt("nrPosti"));
				tb.setNrPrenotati(rows.getInt("nrPrenotati"));
				tb.setNrConfermati(rows.getInt("nrConfermati"));
				tb.setCostoPosto(rows.getDouble("CostoPosto"));
				tb.setCostoPrenotazione(rows.getDouble("CostoPostoPrenotazione"));

				tb.setPartLocalitaID(rows.getInt("PartLocalitaID"));
				tb.setPartData(rows.getDate("PartData").toLocalDate());
				tb.setPartOra(rows.getTime("PartOra").toLocalTime());
				tb.setArrivoLocalitaID(rows.getInt("ArrivoLocalitaID"));
				tb.setArrivoData(rows.getDate("ArrivoData").toLocalDate());
				tb.setArrivoOra(rows.getTime("ArrivoOra").toLocalTime());
				emissioneCampiTabella(tb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void emissioneCampiTabella(TabellaViaggi tb) {
		// TODO Auto-generated method stub
		txtID.setValue(tb.getViaggioID());
		txtNrPosti.setValue(tb.getNrPosti());
		txtNrPrenotati.setValue(tb.getNrPrenotati());
		txtNrConfermati.setValue(tb.getNrConfermati());
		txtCostoPosto.setValue(tb.getCostoPosto());
		txtCostoPrenotazione.setValue(tb.getCostoPrenotazione());

		// ** Partenza
		// ** da fare la combo
		if (tb.getPartLocalitaID() == 0) {
			cmbPartLocalita.setSelectedIndex(-1);
		} else {
			int i = localitaIDIndex.get(tb.getPartLocalitaID());
			cmbPartLocalita.setSelectedIndex(i);
		}
		// ** se data e ora sono null mette valori 0
		if (tb.getPartData() == null && tb.getParOra() == null) {
			txtPartGG.setValue(0);
			txtPartMM.setValue(0);
			txtPartAA.setValue(0);

			txtPartHH.setValue(0);
			txtPartMin.setValue(0);
		} else {
			txtPartGG.setValue(tb.getPartData().getDayOfMonth());
			txtPartMM.setValue(tb.getPartData().getMonthValue());
			txtPartAA.setValue(tb.getPartData().getYear() - 2000);

			txtPartHH.setValue(tb.getParOra().getHour());
			txtPartMin.setValue(tb.getParOra().getMinute());
		}

		// ** Arrivo
		// ** da fare la combo
		if (tb.getArrivoLocalitaID() == 0) {
			cmbArrivoLocalita.setSelectedIndex(-1);
		} else {
			int i = localitaIDIndex.get(tb.getArrivoLocalitaID());
			cmbArrivoLocalita.setSelectedIndex(i);
		}
		// ** se data e ora sono null mette valori 0
		if (tb.getArrivoData() == null && tb.getArrivoOra() == null) {
			txtArrivoGG.setValue(0);
			txtArrivoMM.setValue(0);
			txtArrivoAA.setValue(0);

			txtArrivoHH.setValue(0);
			txtArrivoMin.setValue(0);
		} else {
			txtArrivoGG.setValue(tb.getArrivoData().getDayOfMonth());
			txtArrivoMM.setValue(tb.getArrivoData().getMonthValue());
			txtArrivoAA.setValue(tb.getArrivoData().getYear() - 2000);

			txtArrivoHH.setValue(tb.getArrivoOra().getHour());
			txtArrivoMin.setValue(tb.getArrivoOra().getMinute());
		}
	}

	private void eliminaDati() {
		TabellaViaggi tb = new TabellaViaggi();
		int id = ((Number) txtID.getValue()).intValue();
		if (id <= 0)
			return;
		String query = tb.getQueryEliminazione(id);
		QueryDbExecute.execute(query);
	}

	private void pulisceCampi() {
		// TODO Auto-generated method stub
		emissioneCampiTabella(new TabellaViaggi());
		cmbPartLocalita.setSelectedIndex(-1);
		cmbArrivoLocalita.setSelectedIndex(-1);
	}
}
