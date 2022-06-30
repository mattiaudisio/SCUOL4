package rubrica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import utili.Db;
import dbMysql.ISelectPassResultSet;
import utili.ISelezioneByID;
import utili.UtyJTable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmRubricaRicerca extends JDialog implements ISelectPassResultSet {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ISelezioneByID frmChiamante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRubricaRicerca dialog = new FrmRubricaRicerca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.buildTableModel();
			dialog.visualizzaDati();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRubricaRicerca(ISelezioneByID pFrmChiamante, JFrame formOrigine) {
		// ** richiama un costruttore padre di JDialog
		// ** e gli passa il JFrame che crea questo JDialog
		super(formOrigine, true);
		frmChiamante = pFrmChiamante;
		inizializza();
		buildTableModel();
		visualizzaDati();
	}
	
	public FrmRubricaRicerca() {
		inizializza();
	}

	public void inizializza() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				this.table = new JTable();
				this.table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() != 2)
							return;
						inviaIDaFormChiamante();
					}
				});
				scrollPane.setViewportView(this.table);
			}
		}
	}

	private void buildTableModel() {
		this.table.setModel(new DefaultTableModel(
				// ** rappresenta le righe
				new Object[][] { { null, null }, },
				new String[] { "ID", "nome", "cognome", "telefono", "mail", "amico", "cliente", "fornitore" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					Boolean.class, Boolean.class, Boolean.class };

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
	
	protected void visualizzaDati() {
		String query = "SELECT * FROM anagraficapersone;";
		Db.executeQuery(query, this);		
	}
	
	@Override
	public void passResultset(ResultSet rows) {
		// TODO Auto-generated method stub
		UtyJTable.eliminaTutteLeRighe(table);
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		try {
			while (rows.next()) {
				int id = rows.getInt("ID");
				String nome = rows.getString("nome");
				String cognome = rows.getString("cognome");
				String telefono = rows.getString("telefono");
				String mail = rows.getString("mail");
				boolean amico = rows.getBoolean("amico");
				boolean cliente = rows.getBoolean("cliente");
				boolean fornitore = rows.getBoolean("fornitore");
				Object[] o = { id, nome, cognome, telefono, mail, amico, cliente, fornitore };
				dtm.addRow(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
