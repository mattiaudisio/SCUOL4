package mdi_child;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmChild01 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChild01 frame = new FrmChild01();
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
	public FrmChild01() {
		setBounds(100, 100, 450, 300);

	}

}
