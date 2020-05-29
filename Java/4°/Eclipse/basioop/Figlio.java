package it.denina.rivoira.basioop;

public class Figlio extends Padre {

	private String mail;
	private Telefono telefono;
	
	/*
	 * Il campo cognome è accessibile? Perché? In che modo?
	 * Sì perchè posso fare una get ed una set su cognome
	 */
	
	public Figlio(String cognome) {
		super(cognome);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		//Sono nella classe, è privata, posso accederci tramite il this.
		this.mail = mail;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
		this.telefono.setnCasa("+39 " + this.telefono.getnCasa());
		this.telefono.setnLavoro("+39 " + this.telefono.getnLavoro());
	}
	
	

}
