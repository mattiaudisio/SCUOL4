package gestioneNumeri;

import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.JFormattedTextField;

public class FrameGestioneNumeri01 extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txt01, txt02;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGestioneNumeri01 frame = new FrameGestioneNumeri01();
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
	public FrameGestioneNumeri01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt01 = createJFormattedTextField();
		txt01.setFormatterFactory(createNumberFormat(0));
		txt01.setValue(0);
		txt01.setBounds(174, 74, 141, 20);
		contentPane.add(txt01);
		
		txt02 = createJFormattedTextField();
		txt02.setFormatterFactory(createNumberFormat(0));
		txt02.setValue(0);
		txt02.setBounds(128, 134, 178, 20);
		contentPane.add(txt02);
	}
	
	private JFormattedTextField createJFormattedTextField() {
		return new JFormattedTextField() {
			@Override
			protected void processFocusEvent(final FocusEvent e) {
				if(e.isTemporary()) {
					
				}
				if(e.getID() == FocusEvent.FOCUS_LOST) {
					if(getText() == null || getText().equals("")) {
						
					}
				}
				super.processFocusEvent(e);
			}
		};
	}

	private DefaultFormatterFactory createNumberFormat(int digit) {
		DecimalFormat df = null;
		if (digit == 0) df = new DecimalFormat("#,##0");
		else if (digit == 1) df = new DecimalFormat("#,##0.0");
		else if (digit == 2) df = new DecimalFormat("#,##0.00");
		else if (digit == 3) df = new DecimalFormat("#,##0.000");
		else if (digit == 4) df = new DecimalFormat("#,##0.0000");
		
		NumberFormatter nf = new NumberFormatter(df);
		DefaultFormatterFactory dff = new DefaultFormatterFactory(nf);
		return dff;
	}
}
