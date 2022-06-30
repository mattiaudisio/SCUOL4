package clienti;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.Db;
import dbMysql.ISelectPassResultSet;
import passaggioID.ISelezioneByID;
import utili.UtyJTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;

public class FrmClientiVisualizza extends JDialog implements ISelectPassResultSet{
	private JTable table;
	private ISelezioneByID daForm;
	private JTextField txtClienti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmClientiVisualizza dialog = new FrmClientiVisualizza();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmClientiVisualizza(ISelezioneByID frmObject) {
		this();
		daForm = frmObject;
	}
	
	public FrmClientiVisualizza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\projectWork_Mattia\\icon.png"));
		setTitle("Visualizza Clienti | Mattia Audisio");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(64, 224, 208));
			buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSeleziona = new JButton("Seleziona");
				btnSeleziona.setBackground(UIManager.getColor("Button.background"));
				btnSeleziona.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						seleziona();
					}
				});
				btnSeleziona.setActionCommand("OK");
				buttonPane.add(btnSeleziona);
				getRootPane().setDefaultButton(btnSeleziona);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				this.table = new JTable();
				this.table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() != 2) return;
						seleziona();
					}
				});
				this.table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null},
					},
					new String[] {
						"ID", "Cognome", "Nome", "Telefono", "Mail"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						true, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				this.table.getColumnModel().getColumn(0).setPreferredWidth(50);
				this.table.getColumnModel().getColumn(0).setMaxWidth(75);
				this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
				this.table.getColumnModel().getColumn(1).setMinWidth(100);
				this.table.getColumnModel().getColumn(1).setMaxWidth(250);
				this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
				this.table.getColumnModel().getColumn(2).setMinWidth(100);
				this.table.getColumnModel().getColumn(2).setMaxWidth(250);
				this.table.getColumnModel().getColumn(3).setPreferredWidth(100);
				this.table.getColumnModel().getColumn(3).setMinWidth(100);
				this.table.getColumnModel().getColumn(3).setMaxWidth(250);
				this.table.getColumnModel().getColumn(4).setPreferredWidth(100);
				this.table.getColumnModel().getColumn(4).setMinWidth(100);
				this.table.getColumnModel().getColumn(4).setMaxWidth(250);
				scrollPane.setViewportView(this.table);
				{
					JPanel panTop = new JPanel();
					panTop.setBackground(new Color(64, 224, 208));
					FlowLayout flowLayout = (FlowLayout) panTop.getLayout();
					flowLayout.setAlignment(FlowLayout.LEFT);
					getContentPane().add(panTop, BorderLayout.NORTH);
					{
						JLabel lblNewLabel = new JLabel("Clienti");
						panTop.add(lblNewLabel);
					}
					{
						this.txtClienti = new JTextField();
						panTop.add(this.txtClienti);
						this.txtClienti.setColumns(10);
					}
					{
						JButton btnCerca = new JButton("Cerca");
						btnCerca.setBackground(UIManager.getColor("Button.background"));
						btnCerca.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if  (!btnCerca.isEnabled()) return;
								btnCerca.setEnabled(false);
								
								esegueQuery();
								btnCerca.setEnabled(true);
							}
						});
						panTop.add(btnCerca);
					}
				}
				esegueQuery();
			}
		}
	}

	private void esegueQuery() {
		// TODO Auto-generated method stub
		String query = getQuery();
		Db.executeQuery(query, this);
	}

	private String getQuery() {
		// TODO Auto-generated method stub
		String where = getWhere();
		String query = TabellaCliente.getSqlSelect(where);
		return query;
	}
	
	private String getWhere() {
		String where="";
		String partenza = txtClienti.getText().trim();
		if (partenza .isEmpty()) {
			return "";
		}
		where = " WHERE clienti.cognome >= '"+partenza + "'";
		return where;
	}

	protected void seleziona() {
		// TODO Auto-generated method stub
		int rigaSelezionata = table.getSelectedRow();
		// ** rigaSelezionata = -1 se non è stata selezionata una riga valida
		if(rigaSelezionata == -1) return;
		// ** se non esiste colonna con il nome indicato nel parametro
		int colonnaID = UtyJTable.ritornaIndiceColonnaDatoIlSuoNome(table, "ID");
		if(colonnaID == -1) return;
		// il valore tornato è un object
		Object o = table.getValueAt(rigaSelezionata, colonnaID);
		if(o == null) return;
		// ** casting  per ottenere int da object
		int id = ((Number)o).intValue();
		// ** ritornare l'ID al jframe da cui è stato richiamato/creato questo JDialog
		daForm.selezione(id);
		this.dispose();
	}

	
	@Override
	public void passResultSet(ResultSet rows) {
		// TODO Auto-generated method stub
		// ** metodo richiamato da executeQuery
		// ** rows è un oggetto che contiene il risultato della query (ovvero le righe)
		visualizzaDati(rows);
	}
	
	private void visualizzaDati(ResultSet rows) {
		// TODO Auto-generated method stub
		UtyJTable.eliminaTutteLeRighe(table);
		// ** devo ritrovare l'oggetto di tipo DefaultTableModel
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		try {
			while (rows.next()) {
				int id = rows.getInt("ClienteID");
				String cognome = rows.getString("Cognome");
				String nome = rows.getString("Nome");
				String telefono = rows.getString("Telefono");
				String mail = rows.getString("Mail");
				// ** inserisce i dati in array
				// ** ogni elemento dell'array corrisponde a una colonna
				Object[] o = {id,cognome,nome,telefono,mail};
				// ** inserisce nuova riga in jtable
				// ** la nuova riga corrisponde all'array definito
				// ** la riga precedente
				dtm.addRow(o);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
