package gestioneNumeri;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utili.JFormattedNumber;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameGestioneNumeri02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGestioneNumeri02 frame = new FrameGestioneNumeri02();
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
	public FrameGestioneNumeri02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JFormattedNumber txt01 = new JFormattedNumber(3);
		txt01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
			}
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				char c = e.getKeyChar();
				if (c == '.') {
					e.setKeyChar(',');
				}
			}
		});
		txt01.setBounds(129, 43, 105, 20);
		contentPane.add(txt01);

		JFormattedNumber txt02 = new JFormattedNumber(2);
		txt02.setBounds(129, 120, 105, 20);
		contentPane.add(txt02);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double d = ((Number) txt01.getValue()).doubleValue();
				System.out.println(d);
			}
		});
		btnNewButton.setBounds(129, 189, 89, 23);
		contentPane.add(btnNewButton);
	}
}
