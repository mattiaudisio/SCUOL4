package prenotazioni;

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
import javax.swing.ListSelectionModel;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;

public class FrmPrenotazioniVisualizza extends JDialog implements ISelectPassResultSet {
	
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
	private TabellaPrenotazione tb = new TabellaPrenotazione();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrenotazioniVisualizza frame = new FrmPrenotazioniVisualizza();
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
	
	public FrmPrenotazioniVisualizza(ISelezioneByID frmObject) {
		this();
		daForm = frmObject;
	}
	public FrmPrenotazioniVisualizza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\projectWork_Mattia\\icon.png"));
		setTitle("Visualizza Viaggi Prenotati | Mattia Audisio");
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
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() != 2) return;
				seleziona();
			}
		});
		this.table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Cognome", "Nome", "Telefono", "Mail", "Partenza", "Data", "Ora", "Arrivo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			/**
			 * ritorna true o false a seconda che la colonna relativa a columnIndex sia
			 * editabile o meno
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				// ** nessuna colonna è editable
				return false;
			}
		});
		this.table.getColumnModel().getColumn(0).setPreferredWidth(50); //ID
		this.table.getColumnModel().getColumn(0).setMaxWidth(75); 
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150); // cognome
		this.table.getColumnModel().getColumn(1).setMinWidth(150);
		this.table.getColumnModel().getColumn(1).setMaxWidth(200);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(150);// nome
		this.table.getColumnModel().getColumn(2).setMinWidth(50);
		this.table.getColumnModel().getColumn(2).setMaxWidth(200);

		
		this.table.getColumnModel().getColumn(3).setPreferredWidth(100); // telefono
		this.table.getColumnModel().getColumn(3).setMinWidth(50);
		this.table.getColumnModel().getColumn(3).setMaxWidth(200);
		
		this.table.getColumnModel().getColumn(4).setPreferredWidth(150); // mail
		this.table.getColumnModel().getColumn(4).setMinWidth(50);
		this.table.getColumnModel().getColumn(4).setMaxWidth(200);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(100); // arrivo
		this.table.getColumnModel().getColumn(5).setMinWidth(150);
		this.table.getColumnModel().getColumn(5).setMaxWidth(200);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(150); // data
		this.table.getColumnModel().getColumn(7).setPreferredWidth(100); // ora 
		this.table.getColumnModel().getColumn(7).setPreferredWidth(150); // arrivo
		this.table.getColumnModel().getColumn(7).setMinWidth(150);
		this.table.getColumnModel().getColumn(7).setMaxWidth(200);

		this.scrollPane.setViewportView(this.table);
		//** la query deve essere sempre eseguita all'inizio
		cmdSeleziona.setVisible(false);
		esegueQuery();
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

	

	private void esegueQuery() {
		String query = getQuery();
		Db.executeQuery(query, this);
	}

	private String getQuery() {
		// TODO Auto-generated method stub
		String query ="";
		String where="";
//		where = getWhere();
		query = tb.getSqlSelect("");
//		query = "SELECT 				  "
//				+ " prenotazioni.ViaggioID,"
//				+ " clienti.Nome,"
//				+ " clienti.Cognome,"
//				+ " clienti.Telefono,"
//				+ " clienti.Mail,"
//				+ " localitaPart.Localita AS Partenza ,"
//				+ " viaggi.dataPartenza,"
//				+ " viaggi_organizzati.oraPartenza,"
//				+ " localitaArr.Localita AS Arrivo,"
//				+ " viaggi_organizzati.OraArrivo,"
//				+ " viaggi_organizzati.OreViaggio,"
//				+ " viaggi_organizzati.Prezzo,"
//				+ " viaggi.PostiTotali,"
//				+ " viaggi.PostiTotali - viaggi.PostiPrenotati AS Disponbili"
//				+ " FROM prenotazioni "
//				+ " INNER JOIN clienti "
//				+ " ON prenotazioni.ClienteID =     clienti.ClienteID"
//				+ " INNER JOIN viaggi "
//				+ " ON prenotazioni.ViaggioID =     viaggi.ViaggioID"
//				+ " INNER JOIN viaggi_organizzati "
//				+ " ON viaggi.ViaggioOrganizzatoID = viaggi_organizzati.ViaggioOrganizzatoID"
//				+ " INNER JOIN localita localitaPart "
//				+ " ON viaggi_organizzati.LocalitaPartenzaID = localitaPart.LocalitaID"
//				+ " INNER JOIN localita localitaArr "
//				+ " ON viaggi_organizzati.LocalitaArrivoID = localitaArr.LocalitaID"
//				+ where
//				//+ " ORDER BY Cognome, Nome, Partenza, Data, Ora_Partenza "
//				+ ";";
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
				int id = rows.getInt("prenotazioneID");
				String cognome = rows.getString("cognome");
				String nome= rows.getString("nome");
				String telefono = rows.getString("telefono");
				String mail = rows.getString("mail");
				String partenza = rows.getString("partenza");
				LocalDate dt = rows.getDate("dataPartenza").toLocalDate();
				String data = dt.toString();

				String ora = rows.getString("OraPartenza");
				String arrivo = rows.getString("arrivo");

				//String data = rows.getString("Data");

				//** inserisce i dati in array 
				//** ogni elemento dell'array corrisponde a una colonna
				Object[] o = {id, cognome, nome, telefono, mail,partenza,data,ora,arrivo};
				//** inserisce nuova riga in jtable 
				//** la nuova riga corrisponte all'array definito 
				//** la riga precedente
				dtm.addRow(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
