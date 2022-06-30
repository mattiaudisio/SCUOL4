package viaggi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.Db;
import dbMysql.ISelectPassResultSet;
import passaggioID.ISelezioneByID;
import utili.UtyJTable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;

public class FrmViaggiVisualizza extends JDialog implements ISelectPassResultSet {
	
	private JPanel contentPane;
	private JPanel panComandi;
	private JPanel panTop;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnFiltro;
	private JTextField txtPartenza;
	private JButton cmdSeleziona;
	private ISelezioneByID daForm;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmViaggiVisualizza frame = new FrmViaggiVisualizza();
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
	public FrmViaggiVisualizza(ISelezioneByID frmObject) {
		this();
		daForm = frmObject;
	}
	public FrmViaggiVisualizza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\projectWork_Mattia\\icon.png"));
		setTitle("Visualizza Viaggi | Mattia Audisio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 726, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(64, 224, 208));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panComandi = new JPanel();
		this.panComandi.setBackground(new Color(64, 224, 208));
		FlowLayout flowLayout_1 = (FlowLayout) this.panComandi.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		this.contentPane.add(this.panComandi, BorderLayout.SOUTH);
		
		this.cmdSeleziona = new JButton("Seleziona");
		this.cmdSeleziona.setBackground(UIManager.getColor("Button.background"));
		this.cmdSeleziona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleziona();
			}
		});
		this.panComandi.add(this.cmdSeleziona);
		
		this.panTop = new JPanel();
		this.panTop.setBackground(new Color(64, 224, 208));
		FlowLayout flowLayout = (FlowLayout) this.panTop.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.contentPane.add(this.panTop, BorderLayout.NORTH);
		
		this.lblNewLabel = new JLabel("Partenza");
		this.panTop.add(this.lblNewLabel);
		
		this.txtPartenza = new JTextField();
		this.panTop.add(this.txtPartenza);
		this.txtPartenza.setColumns(10);
		
		this.btnFiltro = new JButton("Filtro");
		this.btnFiltro.setBackground(UIManager.getColor("Button.background"));
		this.btnFiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if  (!btnFiltro.isEnabled()) return;
				btnFiltro.setEnabled(false);
				
				esegueQuery();
				btnFiltro.setEnabled(true);
			}
			
		});
		this.panTop.add(this.btnFiltro);
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);
		
		this.table = new JTable();
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() != 2) return;
				seleziona();
			}
		});
		this.table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Partenza", "Data", "Ora", "Arrivo", "Ora", "Prezzo", "Disponibili"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		});
		this.table.getColumnModel().getColumn(0).setPreferredWidth(50); //ID
		this.table.getColumnModel().getColumn(0).setMaxWidth(75); 
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150); // Partenza
		this.table.getColumnModel().getColumn(1).setMinWidth(150);
		this.table.getColumnModel().getColumn(1).setMaxWidth(200);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(150);// Data
		this.table.getColumnModel().getColumn(3).setPreferredWidth(100); // ora par
		this.table.getColumnModel().getColumn(4).setPreferredWidth(150); // Arrivo
		this.table.getColumnModel().getColumn(4).setMinWidth(50);
		this.table.getColumnModel().getColumn(4).setMaxWidth(200);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(100); // ora arr
		this.table.getColumnModel().getColumn(6).setPreferredWidth(50); // prezzo
		this.table.getColumnModel().getColumn(7).setPreferredWidth(50); // disponibili
		this.scrollPane.setViewportView(this.table);
		//** la query deve essere sempre eseguita all'inizio
		cmdSeleziona.setVisible(false);
		esegueQuery();
	}
	private void esegueQuery() {
		String query = getQuery();
		Db.executeQuery(query, this);
	}

	private String getQuery() {
		// TODO Auto-generated method stub
		
		String where = getWhere();
		String query = TabellaViaggi.getSqlSelect(where);
		return query;
	}

	private String getWhere() {
		String where="";
		String partenza = txtPartenza.getText().trim();
		if (partenza .isEmpty()) {
			return "";
		}
		where = " WHERE localitaPart.Localita >= '"+partenza + "'";
		return where;
	}

	@Override
	public void passResultSet(ResultSet rows) {
		//** metodo richiamato da executeQuery
		//** rows è un oggetto che contiene il risultato della query (ovvero le righe)

		visualizzaDati(rows);
	}

	private void visualizzaDati(ResultSet rows) {
		// TODO Auto-generated method stub
		UtyJTable.eliminaTutteLeRighe(table);
		//** devo ritrovare l'oggetto di tipo DefaultTableModel
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		
		try {
			while (rows.next()) {
				TabellaViaggi tb = TabellaViaggi.getViaggioFromRowSet(rows);

				//** ogni elemento dell'array corrisponde a una colonna
				Object[] o = {
								tb.getViaggioOrganizzatoID(), 
								tb.getPartenza(), 
								tb.getDataPartenza(), 
								tb.getOra_Partenza(), 
								tb.getArrivo(),
								tb.getOra_Arrivo(),
								tb.getPrezzo(),
								tb.getDisponibili()
							};
				//** inserisce nuova riga in jtable 
				//** la nuova riga corrisponte all'array definito 
				//** la riga precedente
				dtm.addRow(o);
				
				
//				int id = rows.getInt("viaggi_organizzati.ViaggioOrganizzatoID");
//				String partenza = rows.getString("Partenza");
//				//String data = rows.getString("Data");
//				LocalDate dt = rows.getDate("Data").toLocalDate();
//				String data = dt.toString();
//				String oraPartenza= rows.getString("Ora_Partenza");
//				String arrivo = rows.getString("Arrivo");
//				String oraArrivo = rows.getString("Ora_Arrivo");
//				String prezzo = rows.getString("Prezzo");
//				String disponbili = rows.getString("Disponbili");
				//** inserisce i dati in array 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void seleziona() {
		int rigaSelezionata =table.getSelectedRow();
		//** rigaSelezionata = -1 se non è stata selezionata una riga valida
		if (rigaSelezionata == -1) return;
		//** se non esiste colonna con il nome indicato nel parametro
		int colonnaID = UtyJTable.ritornaIndiceColonnaDatoIlSuoNome(table, "ID");
		if (colonnaID == -1) return;
		// il valore tornato è un object
		Object o = table.getValueAt(rigaSelezionata, colonnaID);
		if (o == null ) return;
		//** casting per ottenere int da object
		int id = ((Number)o).intValue();
		//** ritornare l'ID al jframe da cui è stato richiamato/creato questo JDialog
		daForm.selezione(id);
		this.dispose();
		
	}
}
