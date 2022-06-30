package tabellaViaggi;

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
import java.awt.geom.Arc2D.Double;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FrmTabellaViaggiRicerca extends JDialog implements ISelectPassResultSet {

	private JPanel contentPane;
	private JPanel panTable;
	private JPanel panComandi;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSeleziona;
	private ISelezioneByID frmByID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaViaggiRicerca frame = new FrmTabellaViaggiRicerca();
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
	public FrmTabellaViaggiRicerca(ISelezioneByID frmByID, JFrame frameChiamante) {
		super(frameChiamante, true);
		this.frmByID = frmByID;
		inizializza();
		buildTableModel();
		visualizzaDati();
	}

	public FrmTabellaViaggiRicerca() {
		inizializza();
		buildTableModel();
	}

	public void inizializza() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panTable = new JPanel();
		this.contentPane.add(this.panTable, BorderLayout.CENTER);
		this.panTable.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.panTable.add(this.scrollPane, BorderLayout.CENTER);

		this.table = new JTable();
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() != 2)
					return;
				int rigaSelezionata = table.getSelectedRow();
				if (rigaSelezionata == -1)
					return;
				// ** Se non esisite colonna con il nome indicato nel parametro
				int colonnaID = UtyJTable.ritornaIndiceColonnaDatoIlSuoNome(table, "ID");
				if (colonnaID == -1)
					return;
				// il valore tornato è un object
				Object o = table.getValueAt(rigaSelezionata, 0);
				if (o == null)
					return;

				// ** casting per ottenere int da object
				int id = ((Number) o).intValue();
				// ** ritornare l'ID al jframe da cui è stato richiamato/creato questo JDialog
				frmByID.selezione(id);
				inviaIDaFormChiamante();
			}
		});
		this.scrollPane.setViewportView(this.table);

		this.panComandi = new JPanel();
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);
		this.panComandi.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		this.btnSeleziona = new JButton("Seleziona");
		this.panComandi.add(this.btnSeleziona);
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
		frmByID.selezione(id);
		this.dispose();
	}

	protected void visualizzaDati() {
		String query = "SELECT viaggiID, l1.localita as PartLocalitaID, l1.provincia as PartLocalitaProvincia,"
				+ " partData, PartOra,l2.localita as ArrivoLocalitaID, l2.provincia as ArrivoLocalitaProvincia,"
				+ "ArrivoData, ArrivoOra, nrPosti, nrPrenotati, nrConfermati, CostoPosto, CostoPostoPrenotazione FROM viaggi"
				+ " INNER JOIN localita as l1 ON viaggi.PartlocalitaID = l1.localitaID"
				+ " INNER JOIN localita as l2 ON viaggi.ArrivolocalitaID = l2.localitaID;";
		Db.executeQuery(query, this);
	}

	protected void buildTableModel() {
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { null, null }, },
				new String[] { "ID", "Località Partenza", "Partenza Data", "Partenza Ora", "Località arrivo",
						"Arrivo Data", "Arrivo Ora", "Numero Posti", "Numero Prenotati", "Numero Confermati",
						"Costo Posto", "Costo Posto Prenotazione", }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, LocalDate.class, LocalTime.class,
					String.class, LocalDate.class, LocalTime.class, Integer.class, Integer.class, Integer.class,
					Double.class, Double.class };

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
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(1).setMinWidth(35);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(2).setMinWidth(35);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(3).setMinWidth(35);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(4).setMinWidth(35);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(5).setMinWidth(35);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(6).setMinWidth(35);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(7).setMinWidth(35);
		this.table.getColumnModel().getColumn(8).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(8).setMinWidth(35);
		this.table.getColumnModel().getColumn(9).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(9).setMinWidth(35);
		this.table.getColumnModel().getColumn(10).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(10).setMinWidth(35);
		this.table.getColumnModel().getColumn(11).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(11).setMinWidth(35);
	}

	@Override
	public void passResultset(ResultSet rows) {
		// TODO Auto-generated method stub
		UtyJTable.eliminaTutteLeRighe(table);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		try {
			while (rows.next()) {
				int id = rows.getInt("viaggiID");
				String partID = rows.getString("PartLocalitaID");
				String partData = rows.getString("partData");
				String partOra = rows.getString("partOra");
				String arrivoLocalitaID = rows.getString("ArrivoLocalitaID");
				String arrivoData = rows.getString("ArrivoData");
				String arrivoOra = rows.getString("ArrivoOra");
				int nrPosti = rows.getInt("nrPosti");
				int nrPrenotati = rows.getInt("nrPrenotati");
				int nrConfermati = rows.getInt("nrConfermati");
				double costoPosto = rows.getDouble("CostoPosto");
				double costoPostoPrenotazione = rows.getDouble("CostoPostoPrenotazione");
				Object[] o = { id, partID, partData, partOra, arrivoLocalitaID, arrivoData, arrivoOra, nrPosti,
						nrPrenotati, nrConfermati, costoPosto, costoPostoPrenotazione };
				dtm.addRow(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
