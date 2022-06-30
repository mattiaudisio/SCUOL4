package persona01;

public class Alunno extends Persona01{

	public Alunno(String nome) {
		super();
		setNome(nome);
	}
	
	public Alunno(String nome,String cognome) {
		this(nome);
		setCognome(cognome);
	}
}