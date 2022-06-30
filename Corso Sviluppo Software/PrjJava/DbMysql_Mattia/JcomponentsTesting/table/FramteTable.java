package table;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class FramteTable extends JFrame {

	private JPanel contentPane;
	private JPanel panTable;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panComandi;
	private JButton btnInserisceRighe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramteTable frame = new FramteTable();
					frame.setVisible(true);
					frame.buildTableModel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramteTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 276);
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
				// ** Se nessuna riga valida è stata selezionata
				// ** getSelectedRow() è uguale a -1
				if (table.getSelectedRow() == -1)
					return;
				// ** ricerca indice per la colonna ID
				int index = ritornaIndiceColonnaDatoIlSuoNome(table, "ID");
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
			}
		});
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { null, null }, }, new String[] { "ID", "Ragione Sociale" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		// Impostazione attributi dimensione colonna
		// colonna 1 (ID)
		this.table.getColumnModel().getColumn(0).setPreferredWidth(45);
		this.table.getColumnModel().getColumn(0).setMinWidth(45);
		this.table.getColumnModel().getColumn(0).setMaxWidth(45);
		// colonna 2 (Ragione Sociale)
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(1).setMinWidth(35);
		this.table.getColumnModel().getColumn(1).setMaxWidth(180);
		// ** per riempire lo scrollPane con la table
		// ** in pratica esegue autosize di table in scrollpane
		this.table.setFillsViewportHeight(true);
		this.scrollPane.setViewportView(this.table);

		this.panComandi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panComandi.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);

		this.btnInserisceRighe = new JButton("Inserisce Righe");
		this.btnInserisceRighe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inserisceRighe();
			}
		});
		this.panComandi.add(this.btnInserisceRighe);
	}

	/*
	 * questo metodo svuota completamente la JTable lascia solo la riga di
	 * intestazione
	 */
	private void eliminaTutteLeRighe() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}

	/*
	 * torna indice (ovvero la posizione in tabella) di una colonna il cui nome è
	 * passato come parmetro (colName)
	 * 
	 * se colonna non trovata torna -1
	 * 
	 * @param tb tabella in cui si deve ricercare la colonna per nome
	 * 
	 * @param colName nome della colonna da ricercare
	 * 
	 * @return
	 */
	private int ritornaIndiceColonnaDatoIlSuoNome(JTable tb, String colName) {
		int result = -1;
		colName = colName.trim();
		// ** getColumnCount() torna numero colonne presenti in tb
		for (int i = 0; i < tb.getColumnCount(); i++) {
			if (tb.getColumnName(i).trim().equalsIgnoreCase(colName)) {
				result = i;
				break;
			}
		}
		return result;
	}

	private void buildTableModel() {
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { new Integer(1), "aa", null, null }, { new Integer(2), "bb", null, null },
						{ new Integer(3), "cc", null, null }, { new Integer(4), "dd", null, null },
						{ new Integer(5), "ee", null, null }, },
				new String[] { "ID", "Ragione Sociale", "Telefono", "partita IVA" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Object.class, Object.class };

			// ** ritorna il tipo dato per la colonna relativa a columnIndex
			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			/*
			 * definisce se una colonna è editabile o meno
			 * 
			 * true = editabie
			 * 
			 * false = NON è editabile
			 */
			boolean[] columnEditables = new boolean[] { true, false, true, true };

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
		// colonna 1 (ID)
		this.table.getColumnModel().getColumn(0).setPreferredWidth(45); // default
		this.table.getColumnModel().getColumn(0).setMinWidth(45); // minima
		this.table.getColumnModel().getColumn(0).setMaxWidth(45); // massima
		// ** la colonna 1 non può essere ne allungata ne ristretta
		// colonna 2 (Ragione Sociale)
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(1).setMinWidth(35);
		this.table.getColumnModel().getColumn(1).setMaxWidth(180);
	}

	/*
	 * simula la lettura di un ResultSet (o altro tipo di file) e ne inserisce i
	 * valori in oggetto JTable
	 */
	private void inserisceRighe() {
		// ** svuotare la JTable (rimane solo riga intestazione)
		eliminaTutteLeRighe();
		// ** devo ritrovare l'oggetto di tipo DefaultTableModel
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		// *** inizia simulazione lettura dati record tabella
		int id = 0;
		String ragioneSociale = "";
		String telefono = "";
		String pIva = "";
		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 1:
				id = i;
				ragioneSociale = "Brema";
				telefono = "4571692078";
				pIva = "98989";
				break;
			case 0:
			case 2:
				id = i;
				ragioneSociale = "Malaguti";
				telefono = "3146920147";
				pIva = "hy9698";
				break;
			case 5:
			case 3:
				id = i;
				ragioneSociale = "Misfits";
				telefono = "1980198600";
				pIva = "78767574";
				break;
			case 4:
				id = i;
				ragioneSociale = "Superga";
				telefono = "3410259648";
				pIva = "78769600";
				break;
			default:
				break;
			}
			// ** termina simulazione lettura dati record tabella
			// ** inserisce i dati in array
			// ** ogni elemento dell'array corrisponde a una colonna
			Object[] o = { id, ragioneSociale, telefono, pIva };
			// ** inserisce nuova riga in JTable
			// ** la nuova riga corrisponde all'array definito la riga precedente
			dtm.addRow(o);
		}

	}
}
