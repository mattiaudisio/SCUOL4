package rubrica;

public class Persona {
	private int ID;
	private String nome, cognome, telefono, mail;
	private boolean amico, cliente, fornitore;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean getAmico() {
		return amico;
	}

	public void setAmico(boolean amico) {
		this.amico = amico;
	}

	public boolean getCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public boolean getFornitore() {
		return fornitore;
	}

	public void setFornitore(boolean fornitore) {
		this.fornitore = fornitore;
	}

	public String getQueryInsert() {
		return "INSERT INTO anagraficapersone (nome,cognome,telefono,mail,amico,cliente,fornitore) VALUES('"
				+ this.getNome() + "','" + this.getCognome() + "','" + this.getTelefono() + "','" + this.getMail()
				+ "'," + this.getAmico() + "," + this.getCliente() + "," + this.getFornitore() + ");";
	}

	public String getQueryUpdate() {
		return "UPDATE anagraficapersone SET nome = '" + this.getNome() + "', cognome = '" + this.getCognome()
				+ "', telefono = '" + this.getTelefono() + "', mail = " + this.getMail() + ", amico = "
				+ this.getAmico() + ", cliente = " + this.getCliente() + ", fornitore = " + this.getFornitore()
				+ " WHERE ID = " + this.getID() + ";";
	}
}
