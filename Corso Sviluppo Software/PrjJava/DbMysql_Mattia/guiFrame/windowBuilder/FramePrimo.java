package windowBuilder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FramePrimo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrimo frame = new FramePrimo();
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
	public FramePrimo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("U:\\PrjJava\\DbMysql\\guiFrame\\Giuliano.jpg"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Evento JFrame : WindowOpened");
			}
		});
		setTitle("Prima finestra con Window Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 300);

		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(15, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Apri finestra");
		btnNewButton.setIcon(new ImageIcon("U:\\PrjJava\\DbMysql\\guiFrame\\Giuliano.jpg"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// *** apriamo un altra finestra della stessa classe
				FramePrimo frame = new FramePrimo();
				frame.setTitle("OmmioDio questo Button apre una Finestra!!1!");
				frame.setBounds(getX() + 50, getY() + 80, 312, 300);
				frame.getBtnNewButton().setVisible(false);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 141, 225, 109);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("colore verde");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		btnNewButton_1.setBounds(10, 68, 105, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Colore Rosso");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setBackground(Color.RED);
			}
		});
		btnNewButton_2.setBounds(174, 68, 112, 23);
		contentPane.add(btnNewButton_2);
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
}
