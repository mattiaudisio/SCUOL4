package persona01;

public class Persona01 {
	private int ID;
	private static int contatoreId = 0;
	private String Nome;
	private String Cognome;
	
	public Persona01() {
		setNome(" - ");
		setCognome(" - ");
		contatoreId++;
		ID = contatoreId;
	}

	public void Stampa() {
		System.out.println("\nID: "+getID()+" Nome: "+getNome()+" Cognome: "+ getCognome());
	}
	
	public int getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}
}