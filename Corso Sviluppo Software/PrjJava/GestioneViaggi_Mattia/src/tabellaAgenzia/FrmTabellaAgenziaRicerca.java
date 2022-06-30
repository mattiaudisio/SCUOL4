package tabellaAgenzia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import comuni.Db;
import dbMysql.DbConnection;
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

public class FrmTabellaAgenziaRicerca extends JDialog implements ISelectPassResultSet {

	private JPanel contentPane;
	private JPanel panTable;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panComandi;
	private JButton btnConferma;
	private ISelezioneByID frmChiamante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTabellaAgenziaRicerca frame = new FrmTabellaAgenziaRicerca();
					frame.buildTableModel();
					frame.visualizzaDati();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmTabellaAgenziaRicerca(ISelezioneByID pFrmChiamante, JFrame formOrigine) {
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
	private FrmTabellaAgenziaRicerca() {
		inizializza();
	}

	/*
	 * costruisce e inizializza tutti i componenti del form deve essere richiamato
	 * dai costruttori
	 */
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
			/*
			 * click su oggetto JTable
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				// ** se non è doubleclick esce
				if (e.getClickCount() != 2)
					return;
				inviaIDaFormChiamante();
			}
		});

		// ** esegue autosize di Table in scroll pane
		this.table.setFillsViewportHeight(true);
		this.scrollPane.setViewportView(this.table);

		this.panComandi = new JPanel();
		FlowLayout fl_panComandi = (FlowLayout) this.panComandi.getLayout();
		fl_panComandi.setAlignment(FlowLayout.LEFT);
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);

		this.btnConferma = new JButton("Conferma");
		this.btnConferma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		this.panComandi.add(this.btnConferma);
	}

	private void buildTableModel() {
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { null, null }, }, new String[] { "ID", "Ragione Sociale" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class };

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
		// Impostazione attributi dimensione colonna
		// ** imposta dimensioni minime, massime e di default per alcune colonne
		// colonna ID
		this.table.getColumnModel().getColumn(0).setPreferredWidth(35); // default
		this.table.getColumnModel().getColumn(0).setMinWidth(15); // minima
		this.table.getColumnModel().getColumn(0).setMaxWidth(45); // massima
		// Ragione Sociale
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(1).setMinWidth(35);
		// this.table.getColumnModel().getColumn(1).setMaxWidth(180);
	}

	private void visualizzaDati() {
		String query = "SELECT * FROM agenzie";
		Db.executeQuery(query, this);
	}

	private void inviaIDaFormChiamante() {
		// ** Se nessuna riga valida è stata selezionata
		// ** getSelectedRow() è uguale a -1
		if (table.getSelectedRow() == -1)
			return;
		// ** ricerca indice per la colonna ID
		int index = UtyJTable.ritornaIndiceColonnaDatoIlSuoNome(table, "ID");
		// ** non ha trovato la colonna index = -1
		if (index == -1)
			return;
		// ** ricerco valore per colonna id e riga selezionata
		Object o = table.getValueAt(table.getSelectedRow(), index);
		// ** se object è null significa che colonna ID non contiene alcun valore
		if (o == null)
			return;
		// ** object riferito a ID contiene un valore
		int id = ((Number) o).intValue();

		// ** L'id poi ritrovato verrà poi utilizzatp per query di tipo SELECT
		frmChiamante.selezione(id);
		this.dispose();
	}

	@Override
	public void passResultset(ResultSet rows) {
		// ** svuotare la JTable (rimane solo riga intestazione)
		UtyJTable.eliminaTutteLeRighe(table);
		// ** devo ritrovare l'oggetto di tipo DefaultTableModel
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		try {
			while (rows.next()) {
				int id = rows.getInt("agenziaID");
				String agenzia = rows.getString("ragioneSociale");
				// ** termina simulazione lettura dati record tabella
				// ** inserisce i dati in array
				// ** ogni elemento dell'array corrisponde a una colonna
				Object[] o = { id, agenzia };
				// ** inserisce nuova riga in JTable
				// ** la nuova riga corrisponde all'array definito la riga precedente
				dtm.addRow(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}