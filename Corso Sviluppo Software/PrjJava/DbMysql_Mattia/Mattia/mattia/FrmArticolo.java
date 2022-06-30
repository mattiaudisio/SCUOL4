package mattia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utili.Parsing;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class FrmArticolo extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtQuantita;
	private JTextField txtPrezzo;
	private JTextField txtAttivo;
	private JTextField txtDescrizione;
	private JButton btnRicerca, btnInserimento, btnUpdate, btnDelete, btnAnnulla;

	private boolean controllo, insert;
	private JTextField txtUnitaMisura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Object[] options = { "Inserimento", "Ricerca/Aggiornamento" };
					int r = JOptionPane.showOptionDialog(null, "Scelta modalità di esecuzione",
							"Scelta modalita di esecuzione", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[1]);
					boolean conferma = false;
					if (r == 0)
						conferma = true;
					FrmArticolo frame = new FrmArticolo(conferma);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmArticolo(boolean pIsInsert) {
		this();
		setIsWindowInsert(pIsInsert);

	}

	/**
	 * Create the frame.
	 */
	public FrmArticolo() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\DbMysql\\Mattia\\mattia\\technology-items.png"));
		setTitle("Gestione Articoli Magazzino (Mattia Audisio)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(117, 10, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		btnRicerca = new JButton("Ricerca");
		btnRicerca.setBackground(new Color(255, 255, 102));
		btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;

				Integer id = Parsing.ToInt(txtID.getText());
				if (id == null) {
					JOptionPane.showMessageDialog(contentPane, "ATTENZIONE!!!\n Inserito ID errato o non presente nel DataBase");
					return;
				}
				Articolo articolo = OperazioniDb.Select(id);
				if(articolo == null) {
					JOptionPane.showMessageDialog(contentPane, "ATTENZIONE!!!\n ID non presente nel DataBase");
					return;					
				}
				txtNome.setText(articolo.getNomeArticolo());
				txtDescrizione.setText(articolo.getDescrizione());
				txtUnitaMisura.setText(articolo.getUnitaMisura());
				txtQuantita.setText("" + articolo.getQuantita());
				txtPrezzo.setText("" + articolo.getPrezzo());
				txtAttivo.setText("" + articolo.getAttivo());
				setIsWindowInsert(true);

			}
		});
		btnRicerca.setBounds(241, 9, 89, 23);
		contentPane.add(btnRicerca);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 14, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 45, 46, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(117, 41, 86, 20);
		contentPane.add(txtNome);

		JLabel lblCognome = new JLabel("Quantita");
		lblCognome.setBounds(10, 109, 97, 14);
		contentPane.add(lblCognome);

		txtQuantita = new JTextField();
		txtQuantita.setColumns(10);
		txtQuantita.setBounds(117, 106, 86, 20);
		contentPane.add(txtQuantita);

		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(10, 140, 46, 14);
		contentPane.add(lblPrezzo);

		txtPrezzo = new JTextField();
		txtPrezzo.setColumns(10);
		txtPrezzo.setBounds(117, 137, 86, 20);
		contentPane.add(txtPrezzo);

		JLabel lblAttivo = new JLabel("Attivo");
		lblAttivo.setBounds(10, 165, 46, 14);
		contentPane.add(lblAttivo);

		txtAttivo = new JTextField();
		txtAttivo.setColumns(10);
		txtAttivo.setBounds(117, 168, 86, 20);
		contentPane.add(txtAttivo);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(10, 202, 97, 14);
		contentPane.add(lblDescrizione);

		txtDescrizione = new JTextField();
		txtDescrizione.setColumns(10);
		txtDescrizione.setBounds(117, 199, 213, 80);
		contentPane.add(txtDescrizione);

		btnInserimento = new JButton("Inserimento");
		btnInserimento.setBackground(new Color(51, 204, 51));
		btnInserimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;

				if (controlloTxt() == false) {
					JOptionPane.showMessageDialog(contentPane,
							"ERRORE!!\n prima di cliccare sull'inserimento\n DEVi completare tutti i campi");
					return;
				}
				int quantita = Integer.parseInt(txtQuantita.getText());
				double prezzo = Double.parseDouble(txtPrezzo.getText());
				boolean attivo = Boolean.parseBoolean(txtAttivo.getText());
				int i = OperazioniDb.Insert(txtNome.getText(), txtUnitaMisura.getText(), quantita, prezzo, attivo,
						txtDescrizione.getText());
				if (i > 0) {
					ColoraCelle();
					JOptionPane.showMessageDialog(contentPane, "inserimento eseguito con successo");
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"Attenzione!!! \n Inserimento non eseguito, prova a controllare se hai inserito tutto correttamente");
				}
			}

		});
		btnInserimento.setBounds(10, 290, 89, 23);
		contentPane.add(btnInserimento);

		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 102, 255));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controlloTxt() == false) {
					JOptionPane.showMessageDialog(contentPane, "Errore su alcuni campi");
					return;
				}
				int quantita = Integer.parseInt(txtQuantita.getText());
				double prezzo = Double.parseDouble(txtPrezzo.getText());
				boolean attivo = Boolean.parseBoolean(txtAttivo.getText());
				int i = OperazioniDb.Update(Integer.parseInt(txtID.getText()), txtNome.getText(),
						txtUnitaMisura.getText(), quantita, prezzo, attivo, txtDescrizione.getText());
				if (i > 0) {
					JOptionPane.showMessageDialog(contentPane, "Aggiornamento eseguito con successo");
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"Attenzione!!! \n Aggiornamento non eseguito, prova a controllare se hai inserito tutto correttamente");
				}
			}

		});
		btnUpdate.setBounds(172, 290, 89, 23);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;
				Object[] options = { "SÌ", "NO" };
				int r = JOptionPane.showOptionDialog(contentPane,
						"ATTENZIONE !!! \nI dati eliminati non sono recuperabili\nDesideri continuare ",
						"Conferma eliminazione record", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						options, options[1]);
				if (r != 0)
					return;
				Object[] options1 = { "SÌ Ne son sicuro", "Pensandoci Ora.." };
				int r1 = JOptionPane.showOptionDialog(contentPane,
						"ATTENZIONE !!! \nMa sei davvero sicuro di proseguire,\n non vuoi prendere del tempo per pensarci?",
						"Conferma eliminazione record", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						options1, options1[1]);
				if (r1 != 0)
					return;
				Object[] options2 = { "SÌ! Fammelo cancellare!", "No scusa ci ho ripensato" };
				int r2 = JOptionPane.showOptionDialog(contentPane,
						"ATTENZIONE !!! \nOk, poi la smetto... Ma sei davvero sicuro di volerlo fare?",
						"Conferma eliminazione record", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						options2, options2[1]);
				if (r2 != 0)
					return;
				OperazioniDb.Delete(Integer.parseInt(txtID.getText()));
				pulisceCelle();
				JOptionPane.showMessageDialog(contentPane,
						"Il record è stato eliminato dal database...\n A tuo rischio e pericolo...");
				setIsWindowInsert(false);
			}
		});
		btnDelete.setBounds(309, 290, 89, 23);
		contentPane.add(btnDelete);

		JLabel lblUnitMisura = new JLabel("Unit\u00E0 Misura");
		lblUnitMisura.setBounds(10, 70, 97, 14);
		contentPane.add(lblUnitMisura);

		txtUnitaMisura = new JTextField();
		txtUnitaMisura.setColumns(10);
		txtUnitaMisura.setBounds(117, 72, 86, 20);
		contentPane.add(txtUnitaMisura);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBackground(new Color(204, 204, 204));
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;

				pulisceCelle();
				setIsWindowInsert(false);
			}

		});
		btnAnnulla.setBounds(435, 290, 89, 23);
		contentPane.add(btnAnnulla);

		JButton btnCambiaModalita = new JButton("Cambia Modalit\u00E0");
		btnCambiaModalita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (insert) {
					pulisceCelle();
					setIsWindowInsert(false);
				} else {
					pulisceCelle();
					setIsWindowInsert(true);
				}
			}
		});
		btnCambiaModalita.setBounds(381, 9, 143, 23);
		contentPane.add(btnCambiaModalita);
	}

	private void pulisceCelle() {
		txtID.setText("");
		txtNome.setText("");
		txtUnitaMisura.setText("");
		txtQuantita.setText("");
		txtPrezzo.setText("");
		txtAttivo.setText("");
		txtDescrizione.setText("");
	}

	private boolean controlloTxt() {
		controllo = true;
		if (txtNome.getText().trim().equals("")) {
			txtNome.setBackground(Color.RED);
			controllo = false;
		}
		if (txtUnitaMisura.getText().trim().equals("")) {
			txtUnitaMisura.setBackground(Color.RED);
			controllo = false;
		}
		if (txtQuantita.getText().trim().equals("")) {
			txtQuantita.setBackground(Color.RED);
			controllo = false;
		}
		if (txtPrezzo.getText().trim().equals("")) {
			txtPrezzo.setBackground(Color.RED);
			controllo = false;
		}
		if (txtAttivo.getText().trim().equals("")) {
			txtAttivo.setBackground(Color.RED);
			controllo = false;
		}
		if (txtDescrizione.getText().trim().equals("")) {
			txtDescrizione.setBackground(Color.RED);
			controllo = false;
		}
		return controllo;
	}

	private void setIsWindowInsert(boolean pIsWindowInsert) {

		this.insert = pIsWindowInsert;

		if (insert) {
			txtID.setEnabled(false);
		} else {
			txtID.setEnabled(true);
			txtNome.setEnabled(false);
		}
		txtNome.setEnabled(!txtID.isEnabled());
		txtUnitaMisura.setEnabled(!txtID.isEnabled());
		txtQuantita.setEnabled(!txtID.isEnabled());
		txtPrezzo.setEnabled(!txtID.isEnabled());
		txtAttivo.setEnabled(!txtID.isEnabled());
		txtDescrizione.setEnabled(!txtID.isEnabled());

		btnInserimento.setEnabled(!txtID.isEnabled());
		btnRicerca.setEnabled(txtID.isEnabled());
		if (getIsRecordUpdate()) {
			btnDelete.setEnabled(true);
			btnAnnulla.setEnabled(true);
			btnUpdate.setEnabled(true);
			btnInserimento.setEnabled(false);
		} else {
			btnDelete.setEnabled(false);
			btnAnnulla.setEnabled(false);
			btnUpdate.setEnabled(false);
		}
	}
	
	private void ColoraCelle() {
		txtID.setBackground(Color.WHITE);
		txtNome.setBackground(Color.WHITE);
		txtUnitaMisura.setBackground(Color.WHITE);
		txtQuantita.setBackground(Color.WHITE);
		txtPrezzo.setBackground(Color.WHITE);
		txtAttivo.setBackground(Color.WHITE);
		txtDescrizione.setBackground(Color.WHITE);			
	}

	private boolean getIsRecordUpdate() {
		if (txtID.getText().trim().equals(""))
			return false;
		return true;
	}
}
