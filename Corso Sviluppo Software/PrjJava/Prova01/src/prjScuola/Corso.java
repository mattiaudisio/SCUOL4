package prjScuola;

import java.util.ArrayList;

public class Corso {
	private String nome;
	private ArrayList <Docente> docenti;
	private ArrayList <Alunno> alunni;
	private ArrayList <Materia> materie;
	
	public Corso() {
		nome = "";

		ArrayList <Docente> docenti = new ArrayList<Docente>();
		ArrayList <Alunno> alunni = new ArrayList<Alunno>();
		ArrayList <Materia> materie = new ArrayList<Materia>();
	}

}