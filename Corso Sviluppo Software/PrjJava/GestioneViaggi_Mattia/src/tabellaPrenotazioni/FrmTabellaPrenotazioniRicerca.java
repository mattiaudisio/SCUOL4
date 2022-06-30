package tabellaPrenotazioni;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import comuni.Db;
import dbMysql.ISelectPassResultSet;
import utili.ISelezioneByID;
import utili.UtyJTable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmTabellaPrenotazioniRicerca extends JDialog implements ISelectPassResultSet {

	private JPanel panTabella;
	private JPanel panel;
	private JPanel panComandi;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnConferma;
	private ISelezioneByID frmChiamante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaPrenotazioniRicerca frame = new FrmTabellaPrenotazioniRicerca();
					frame.buildTableModel();
					frame.visualizzaDati();
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
	public FrmTabellaPrenotazioniRicerca(ISelezioneByID pFrmChiamante, JFrame formOrigine) {
		// ** richiama un costruttore padre di JDialog
		// ** e gli passa il JFrame che crea questo JDialog
		super(formOrigine, true);
		frmChiamante = pFrmChiamante;
		inizializza();
		buildTableModel();
		visualizzaDati();
	}

	public FrmTabellaPrenotazioniRicerca() {
		inizializza();
	}

	public void inizializza() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.panTabella = new JPanel();
		this.panTabella.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.panTabella.setLayout(new BorderLayout(0, 0));
		setContentPane(this.panTabella);

		this.panel = new JPanel();
		this.panTabella.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panel.add(this.scrollPane, BorderLayout.CENTER);

		this.table = new JTable();
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() != 2)
					return;
				inviaIDaFormChiamante();
			}

		});
		this.scrollPane.setViewportView(this.table);

		this.panComandi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panComandi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.panTabella.add(this.panComandi, BorderLayout.SOUTH);

		this.btnConferma = new JButton("Conferma");
		this.panComandi.add(this.btnConferma);
	}

	private void inviaIDaFormChiamante() {
		if (table.getSelectedRow() == -1)
			return;
		int index = UtyJTable.ritornaIndiceColonnaDatoIlSuoNome(table, "ID");
		if (index == -1)
			return;
		Object o = table.getValueAt(table.getSelectedRow(), index);
		if (o == null)
			return;
		int id = ((Number) o).intValue();
		frmChiamante.selezione(id);
		this.dispose();
	}
	
	private void buildTableModel() {
		// TODO Auto-generated method stub
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { null, null }, }, new String[] { "ID", "agenzia ID", "Viaggio ID", "posti","prenotati","acquistati","costo Posto","costo Prenotazione" }) {
			Class[] columnTypes = new Class[] { Integer.class, Integer.class, Integer.class, Integer.class, Boolean.class, Boolean.class,Double.class, Double.class };

			// ** ritorna il tipo dato per la colonna relativa a columnIndex
			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			/*
			 * ritorna true o false a seconda che la colonna relativa a columnIndex sia
			 * editabile o meno
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		this.table.getColumnModel().getColumn(0).setPreferredWidth(35); // default
		this.table.getColumnModel().getColumn(0).setMinWidth(15); // minima
		this.table.getColumnModel().getColumn(0).setMaxWidth(45); // massima
		// Localita
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(1).setMinWidth(35);
		// Provincia
		this.table.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(2).setMinWidth(35);
		// Localita
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(3).setMinWidth(35);
		// Provincia
		this.table.getColumnModel().getColumn(4).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(4).setMinWidth(35);
		// Localita
		this.table.getColumnModel().getColumn(5).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(5).setMinWidth(35);
		// Provincia
		this.table.getColumnModel().getColumn(6).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(6).setMinWidth(35);
		// Provincia
		this.table.getColumnModel().getColumn(7).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(7).setMinWidth(35);
	}

	protected void visualizzaDati() {
		String query = "SELECT prenotazioniID, l1.ragioneSociale AS agenzia, l2.viaggiID AS viaggio, posti, prenotati,"
				+ "acquistati, prenotazioni.costoPosto, costoPrenotazione FROM prenotazioni "
				+ "INNER JOIN agenzie AS l1 ON prenotazioni.agenziaViaggiID = l1.agenziaID "
				+ "INNER JOIN viaggi AS l2 ON prenotazioni.viaggioID = l2.viaggiID;";
		Db.executeQuery(query, this);		
	}
	
	@Override
	public void passResultset(ResultSet rows) {
		// TODO Auto-generated method stub
		UtyJTable.eliminaTutteLeRighe(table);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		try {
			while(rows.next()) {
				int id = rows.getInt("prenotazioniID");
				String agenziaID = rows.getString("agenzia");
				String viaggiID = rows.getString("viaggio");
				int posti = rows.getInt("posti");
				boolean prenotati = rows.getBoolean("prenotati");
				boolean acquistati = rows.getBoolean("acquistati");
				double costoPosto = rows.getDouble("costoPosto");
				double costoPrenotazione = rows.getDouble("costoPrenotazione");
				Object[] o = {id,agenziaID,viaggiID,posti,prenotati,acquistati,costoPosto,costoPrenotazione};
				dtm.addRow(o);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
