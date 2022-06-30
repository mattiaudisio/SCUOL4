package frameTester;

import javax.swing.JFrame;

public class FrameEreditato extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		FrameEreditato frm = new FrameEreditato();
		frm.setVisible(true);
		
		FrameEreditato frmSecondo = new FrameEreditato();
		frmSecondo.setTitle("Guarda un pò... Un FrmSecondo");
		frmSecondo.setLocation(100,200);
		frmSecondo.setVisible(true);
	}
	
	public FrameEreditato() {
		this.setBounds(10,10,500,500);
		this.setTitle("Una magica e sorprendente pagina vota direttamente dal Frame Ereditato");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
