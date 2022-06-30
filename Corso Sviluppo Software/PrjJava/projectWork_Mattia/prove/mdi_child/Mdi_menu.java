package mdi_child;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mdi_menu extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mdi_menu frame = new Mdi_menu();
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
	public Mdi_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.desktopPane = new JDesktopPane();
		this.contentPane.add(this.desktopPane, BorderLayout.CENTER);
		
		this.btnNewButton = new JButton("New button");
		this.btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JInternalFrame f = new FrmChild01();
				desktopPane.add(f);
				f.show();
			}
		});
		this.btnNewButton.setBounds(10, 11, 89, 23);
		this.desktopPane.add(this.btnNewButton);
	}
}
