package persona;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utili.Parsing;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class FrmPersona extends JFrame {

	private JPanel contentPane;
	private boolean isWindowInsert;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JButton btnSalva, btnRicerca, btnAnnulla, btnElimina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Object[] options = { "Inserimento", "Aggiornamento" };
					int r = JOptionPane.showOptionDialog(null, "Scelta modalita di esecuzione",
							"Scelta modalita di esecuzione", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[1]);
					boolean conferma = false;
					if (r == 0)
						conferma = true;
					// ** true sono in inserimento nuovo record
					// ** false sono in update, richiede txtID
					FrmPersona frame = new FrmPersona(conferma);
					// ***************************************
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPersona(boolean pIsInsert) {
		this();
		setIsWindowInsert(pIsInsert);

	}

	/**
	 * Create the frame.
	 */
	public FrmPersona() {
		setResizable(false);
		setTitle("Anagrafica Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 242);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(20, 28, 46, 14);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(102, 28, 46, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(20, 70, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(102, 70, 119, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Cognome");
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(20, 118, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtCognome = new JTextField();
		txtCognome.setBounds(102, 118, 119, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);

		btnSalva = new JButton("Salva");
		btnSalva.setBackground(new Color(255, 160, 122));
		btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;
				/*
				 * intercetta click bottone salva richiama metodo per convalida campi del form
				 * (finestra)
				 */
				if (convalidaDati() == false) {
					/*
					 * dialog box segnalazione errore. Obbligatorio permere OK per continuare
					 */
					JOptionPane.showMessageDialog(contentPane, "Errore su alcuni campi");
					// ripristina colore sfondo campi errati in bianco
					txtNome.setBackground(Color.white);
					txtCognome.setBackground(Color.white);
					// eseguo return in quanto essendo presenti errori non
					// deve eseguire scrittura dati su DB
					return;
				}

				// *******************************************

				/*
				 * controlli eseguiti con successo, costruisce oggetto persona per passarlo a
				 * metodi utilizzati per scrittura su database
				 */
				Persona persona = new Persona();
				// assegno a attributo nome valore del controllo di testo txtNome
				persona.setnome(txtNome.getText());
				// assegno a attributo cognome valore del controllo di testo txCognome
				persona.setCognome(txtCognome.getText());
				// richiamo metodo per inserimento nuova persona
				int i = Persona.Insert(persona);
				if (i > 0) {
					System.out.println("inserimento eseguito con successo");
				} else {
					System.out.println("inserimento non eseguito");
					JOptionPane.showMessageDialog(contentPane, "Attenzione!!! \n Inserimento non eseguito");
				}

			}

			/*
			 * metodo utilizzato per convalida dei dati return se esito convalida è positivo
			 * altrimenti false
			 */
			private boolean convalidaDati() {
				boolean ok = true;
				/*
				 * convalida controllo nome
				 */
				if (txtNome.getText().trim().equals("")) {
					// convalida non passata cambia lo sfondo in rosso
					txtNome.setBackground(Color.red);
					ok = false;
				}
				/*
				 * convalida controllo cognome
				 */
				if (txtCognome.getText().trim().equals("")) {
					// convalida non passata cambia lo sfondo in rosso
					txtCognome.setBackground(Color.red);
					ok = false;
				}

				return ok;
			}
		});
		// impedisce a button salva di ottenere focus on tasto TAB

		btnSalva.setFocusable(false);
		btnSalva.setBounds(10, 168, 69, 23);
		contentPane.add(btnSalva);

		btnRicerca = new JButton("Ricerca");
		btnRicerca.setBackground(new Color(255, 160, 122));
		btnRicerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;
				// ** Ricerco persona by ID
				Integer id = Parsing.ToInt(txtID.getText());
				if (id == null) {
					JOptionPane.showMessageDialog(contentPane, "ATTENZIONE!!!\n Inserito array errato");
					return;
				}
				Persona persona = Persona.Select(id);
				if (persona == null) {
					JOptionPane.showMessageDialog(contentPane, "ATTENZIONE!!!\n Persona non trovata");
					return;
				}
				// ** Se persona trovata torna oggetto persona
				// ** e ne inserisco i valori nei relativi controlli video
				txtNome.setText(persona.getNome());
				txtCognome.setText(persona.getCognome());
				txtID.setText("" + persona.getID());
				// ** disabilita controllo ID
				// ** abilita controlli nome e cognome
				setIsWindowInsert(true);
			}
		});
		btnRicerca.setBounds(153, 24, 89, 23);
		contentPane.add(btnRicerca);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * - Non esegue nesssuna operazione su DB
				 * 
				 * - Esegue rest dei campi video
				 * 
				 * - torna a richiesta ID
				 */
				reimpostaCampiVideo();
				setIsWindowInsert(false);
			}

		});
		btnAnnulla.setBackground(new Color(255, 160, 122));
		btnAnnulla.setBounds(89, 168, 69, 23);
		contentPane.add(btnAnnulla);

		btnElimina = new JButton("Elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((JButton) e.getSource()).isEnabled() == false ) return;
				/*
				 * Elimina record da database
				 */
				Object[] options = { "SI", "NO" };
				// *** r = 0 se click SI
				int r = JOptionPane.showOptionDialog(contentPane,
						"ATTENZIONE !!! \nI dati eliminati non sono recuperabili\nDesideri continuare ",
						"Conferma eliminazione record", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
						options, options[1]);
				// se NON si esegue eliminazione record
				if (r != 0)
					return;
				// *** r = 0 significa click su SÌ
				Persona.Delete(Integer.parseInt(txtID.getText()));
				/*
				 * - Non esegue nesssuna operazione su DB
				 * 
				 * - Esegue rest dei campi video
				 * 
				 * - torna a richiesta ID
				 */

				// chiama metodo elimina record
				reimpostaCampiVideo();
				setIsWindowInsert(false);
			}
		});
		btnElimina.setBackground(new Color(255, 160, 122));
		btnElimina.setBounds(163, 168, 79, 23);
		contentPane.add(btnElimina);

	}

	private boolean getIsWindowInsert() {
		return isWindowInsert;
	}

	/*
	 * isInsert true se maschera per inserimento isInsert false se maschera per
	 * richiedere ID
	 * 
	 * @param isInsert
	 */
	private void setIsWindowInsert(boolean pIsWindowInsert) {
		this.isWindowInsert = pIsWindowInsert;

		if (pIsWindowInsert) {
			txtID.setEnabled(false);
			txtNome.setEnabled(true);
		} else {
			txtID.setEnabled(true);
			txtNome.setEnabled(false);
		}
		// ** btnSalva si deve comportare come nome, cognome ecc.
		btnRicerca.setEnabled(txtID.isEnabled());
		btnSalva.setEnabled(!txtID.isEnabled());
		txtCognome.setEnabled(txtNome.isEnabled());
		// ** btnAnnulla e btnElimina attivi solo se sono in update
		if (getIsRecordUpdate()) {
			btnAnnulla.setEnabled(true);
			btnElimina.setEnabled(true);
		} else {
			btnAnnulla.setEnabled(false);
			btnElimina.setEnabled(false);
		}
	}

	/*
	 * torna true se sono in Update / revisione dei dati
	 * 
	 * torna false se sono in Insert / inserimento nuovo record
	 * 
	 */
	private boolean getIsRecordUpdate() {
		if (txtID.getText().trim().equals(""))
			return false;
		return true;
	}

	/*
	 * reimposta campi video ai valori di default
	 */
	private void reimpostaCampiVideo() {
		txtID.setText("");
		txtNome.setText("");
		txtCognome.setText("");
	}
}
