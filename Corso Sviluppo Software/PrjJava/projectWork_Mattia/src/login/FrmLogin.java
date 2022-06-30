package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import clienti.FrmClientiVisualizza;
import database.Db;
import dbMysql.ISelectPassResultSet;
import prenotazioni.FrmPrenotazione;
import prenotazioni.FrmPrenotazioniVisualizza;
import utili.UtyMsgBox;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class FrmLogin extends JFrame implements ISelectPassResultSet {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNomeUtente;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField txtPassword;
	private JButton btnNewButton;
	private Account account;
	private boolean varPass = false;
	private JRadioButton rdbtnMostraPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\projectWork_Mattia\\icon.png"));
		setTitle("Login ProjectWork | Mattia Audisio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 262);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(64, 224, 208));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.lblNewLabel = new JLabel("Nome Utente");
		this.lblNewLabel.setBounds(131, 52, 84, 14);
		this.contentPane.add(this.lblNewLabel);

		this.txtNomeUtente = new JTextField();
		this.txtNomeUtente.setBackground(Color.WHITE);
		this.txtNomeUtente.setBounds(101, 77, 141, 20);
		this.contentPane.add(this.txtNomeUtente);
		this.txtNomeUtente.setColumns(10);

		this.lblNewLabel_1 = new JLabel("BENVENUTO NELLA PAGINA DI LOGIN");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.lblNewLabel_1.setBounds(28, 11, 349, 14);
		this.contentPane.add(this.lblNewLabel_1);

		this.lblNewLabel_2 = new JLabel("Password");
		this.lblNewLabel_2.setBounds(141, 108, 74, 14);
		this.contentPane.add(this.lblNewLabel_2);

		this.txtPassword = new JPasswordField();
		this.txtPassword.setBackground(UIManager.getColor("Button.background"));
		this.txtPassword.setForeground(Color.BLACK);
		this.txtPassword.setBounds(101, 133, 141, 20);
		this.contentPane.add(this.txtPassword);
		this.txtPassword.setColumns(10);

		this.btnNewButton = new JButton("Accedi");
		this.btnNewButton.setIcon(new ImageIcon("U:\\PrjJava\\projectWork_Mattia\\login.png"));
		this.btnNewButton.setForeground(SystemColor.desktop);
		this.btnNewButton.setBackground(UIManager.getColor("Button.background"));
		this.btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
		this.btnNewButton.setBounds(119, 189, 109, 23);
		this.contentPane.add(this.btnNewButton);
		
		this.rdbtnMostraPassword = new JRadioButton("Mostra Password");
		this.rdbtnMostraPassword.setBackground(new Color(64, 224, 208));
		this.rdbtnMostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (varPass) {
		            txtPassword.setEchoChar('*');
		            varPass = false;
		        } else {
		            txtPassword.setEchoChar((char)0);
		            varPass = true;
		        }
			}
		});
		this.rdbtnMostraPassword.setBounds(244, 132, 133, 23);
		this.contentPane.add(this.rdbtnMostraPassword);
	}

	protected void login() {
		// TODO Auto-generated method stub
		String msg = convalida();
		if (msg != null && msg.trim() != "") {
			UtyMsgBox.Avviso(msg);
			return;
		}
		String where = "userName = '" + txtNomeUtente.getText().trim() + "' AND password = '"
				+ txtPassword.getText().trim() + "';";
		String query = Account.getSqlSelect(where);
		Db.executeQuery(query, this);

	}

	private String convalida() {
		// TODO Auto-generated method stub
		String msg = "";
		if (txtNomeUtente.getText().trim() == "") {
			msg += "Inserire Nome Utente \r\n";
		}
		if (txtPassword.getText().trim() == "") {
			msg += "Inserire Password \r\n";
		}
		return msg;
	}

	private void pulisceCampiVideo() {
		// TODO Auto-generated method stub
		txtNomeUtente.setText("");
		txtPassword.setText("");
	}
	
	@Override
	public void passResultSet(ResultSet rows) {
		// TODO Auto-generated method stub
		int  i = 0;
		account = new Account();
		try {
			while (rows.next()) {
				account.setNomeUtente(rows.getString("userName"));
				account.setPassword(rows.getString("password"));
				FrmPrenotazione f = new FrmPrenotazione();
				i = 1;
				f.setVisible(true);
				dispose();
			}
			if(i == 0) {
				UtyMsgBox.Avviso("Accesso Negato.\nMail o password errate");
			}else {
				pulisceCampiVideo();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
