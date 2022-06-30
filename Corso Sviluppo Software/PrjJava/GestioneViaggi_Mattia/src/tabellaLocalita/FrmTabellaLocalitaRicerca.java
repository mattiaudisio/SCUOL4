package tabellaLocalita;

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
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmTabellaLocalitaRicerca extends JDialog implements ISelectPassResultSet {

	private JPanel contentPane;
	private JPanel panTable;
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
					FrmTabellaLocalitaRicerca frame = new FrmTabellaLocalitaRicerca();
					frame.buildTableModel();
					frame.visualizzaDati();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmTabellaLocalitaRicerca(ISelezioneByID pFrmChiamante, JFrame formOrigine) {
		// ** richiama un costruttore padre di JDialog
		// ** e gli passa il JFrame che crea questo JDialog
		super(formOrigine, true);
		frmChiamante = pFrmChiamante;
		inizializza();
		buildTableModel();
		visualizzaDati();
	}
	
	/**
	 * Create the frame.
	 */
	public FrmTabellaLocalitaRicerca() {
		inizializza();
	}

	private void inizializza() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
				inviaIDaFormChiamante();
			}

		});
		this.scrollPane.setViewportView(this.table);

		this.panComandi = new JPanel();
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);
		this.panComandi.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

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

	protected void buildTableModel() {
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { null, null }, }, new String[] { "ID", "Località","Provincia"}) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class};

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
	}

	protected void visualizzaDati() {
		String query = "SELECT * FROM localita";
		Db.executeQuery(query, this);		
	}

	@Override
	public void passResultset(ResultSet rows) {
		// ** svuotare la JTable (rimane solo riga intestazione)
		UtyJTable.eliminaTutteLeRighe(table);
		// ** devo ritrovare l'oggetto di tipo DefaultTableModel
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		try {
			while (rows.next()) {
				int id = rows.getInt("localitaID");
				String localita = rows.getString("localita");
				String provincia = rows.getString("provincia");
				// ** termina simulazione lettura dati record tabella
				// ** inserisce i dati in array
				// ** ogni elemento dell'array corrisponde a una colonna
				Object[] o = { id, localita, provincia };
				// ** inserisce nuova riga in JTable
				// ** la nuova riga corrisponde all'array definito la riga precedente
				dtm.addRow(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
