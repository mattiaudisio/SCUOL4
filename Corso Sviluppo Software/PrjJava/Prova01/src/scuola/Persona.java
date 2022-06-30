package scuola;

/*
 * Contiene nome, cognome, telefono, mail
 * Come child deve avere Alunno e Impiegato
 * Classe Aula che contiene il nome
 * */


public class Persona {

	private String nome,cognome,telefono,mail;
	
	//*---------- Costruttori
	public Persona(String nome) {
		setNomePersona(nome);
	}
	
	public Persona(String pNome,String cognome) {
		super();
		setCognomePersona(cognome);
	}
	//*---------- 
	
	private void setNomePersona(String nome) {
		this.nome = nome;
	}

	private void setCognomePersona(String cognome) {
		this.cognome = cognome;
	}
	
	public String getNomePersona() {
		return nome;
	}

	public String getCognomePersona() {
		return cognome;
	}

	public String getTelefonoPersona() {
		return telefono;
	}

	public void setTelefonoPersona(String telefono) {
		this.telefono = telefono;
	}

	public String getMailPersona() {
		return mail;
	}

	public void setMailPersona(String mail) {
		this.mail = mail;
	}
	
}
