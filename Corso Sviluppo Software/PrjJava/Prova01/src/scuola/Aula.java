package scuola;

import java.util.ArrayList;

/*
 * Aula deve contenere elenco alunni
 * */

public class Aula {

	private String nome;
	private ArrayList<Alunno> alunni = new ArrayList<>();
	
	public Aula(String nome) {
		setNome(nome);
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void aggiungiAlunno(Alunno alunno) {
		alunni.add(alunno);
	}
	
	public Alunno getAlunno(String nome,String cognome) {
		// Scorro lista fino a che non trovo alunno con stesso nome e stesso cognome
		for(int i = 0; i < alunni.size(); i++) {
			if(nome.equals(alunni.get(i).getNomePersona()) && cognome.equals(alunni.get(i).getCognomePersona())) {
				return alunni.get(i);
			}
		}
		return null;
	}
}
