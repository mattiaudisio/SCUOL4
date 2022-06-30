package frameTester;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FrameEvents extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEvents frame = new FrameEvents();
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
	public FrameEvents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUno = new JButton("Uno");
		btnUno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getClassType(e.getSource());

			}
		});
		btnUno.setEnabled(false);
		btnUno.setBounds(60, 151, 89, 23);
		contentPane.add(btnUno);
		
		JButton btnDue = new JButton("Due");
		btnDue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getClassType(e.getSource());
			}
		});
		btnDue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getClassType(e.getSource());
			}
		});
		btnDue.setEnabled(false);
		btnDue.setBounds(159, 151, 89, 23);
		contentPane.add(btnDue);
		
		JButton btnTre = new JButton("Tre");
		btnTre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getClassType(e.getSource());
			}
		});
		btnTre.setEnabled(false);
		btnTre.setBounds(258, 151, 89, 23);
		contentPane.add(btnTre);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getClassType(e.getSource());
			}


		});
		textField.setBounds(60, 79, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getClassType(e.getSource());
			}
		});
		textField_1.setBounds(261, 79, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	private void getClassType(Object source) {
		// TODO Auto-generated method stub
		if(source instanceof JButton) {
			this.setTitle("JButton");
		}else if(source instanceof JTextField) {
			this.setTitle("JTextField");			
		}
	}
}
