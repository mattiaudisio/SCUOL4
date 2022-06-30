package scuola;

/*
 * Alunno abbia conoscenza dell'aula in cui è
 * */

public class Alunno extends Persona{

	public Alunno(String nome, String cognome) {
		super(nome, cognome);
	}

	public void aggiungiAula(Aula aula) {
		aula.aggiungiAlunno(this);
	}
}
