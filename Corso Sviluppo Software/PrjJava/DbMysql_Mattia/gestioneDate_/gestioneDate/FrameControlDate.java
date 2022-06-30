package gestioneDate;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameControlDate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFormattedTextField txt01;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameControlDate frame = new FrameControlDate();
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
	public FrameControlDate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Campo Data TextField");
		lblNewLabel.setBounds(10, 11, 162, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(226, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Data 1 JFormat");
		lblNewLabel_1.setBounds(10, 42, 116, 14);
		contentPane.add(lblNewLabel_1);

		txt01 = new JFormattedTextField();
		// ***** Oggetto per formattazione cotrollo JFormattedTextField utlizzato come
		// ***** campo data
		// ** step 01
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// ** step 02
		DateFormatter df = new DateFormatter(sdf);
		// ** step 03
		DefaultFormatterFactory dff = new DefaultFormatterFactory(df);
		// **************************************
		// ** step 04 assegnazione dell'oggetto dff appena creato al controllo
		// ** JFormattedTextField
		txt01.setFormatterFactory(dff);
		txt01.setValue(java.sql.Date.valueOf(LocalDate.now()));

		txt01.setBounds(226, 39, 86, 20);
		contentPane.add(txt01);

		JLabel lblNewLabel_2 = new JLabel("Data 2 JFormat");
		lblNewLabel_2.setBounds(10, 76, 116, 14);
		contentPane.add(lblNewLabel_2);

		JFormattedTextField txt02 = new JFormattedTextField();
		txt02.setFormatterFactory(dff);
		txt02.setBounds(226, 73, 86, 20);
		contentPane.add(txt02);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt01.setValue(null);
			}
		});
		btnNewButton.setBounds(335, 38, 57, 23);
		contentPane.add(btnNewButton);
	}
}
