package it.denina.rivoira.Esercizio_CD2;

public class CD {
	
	private String titolo;
	private String autore;
	private int numeroBrani;
	private int durata;
	
	public CD(String titolo, String autore, int numeroBrani, int durata) {
		// TODO Auto-generated constructor stub
		this.numeroBrani=numeroBrani;
		this.durata=durata;
		this.titolo=titolo;
		this.autore=autore;		
	}
	
	public String getTitolo(){
		return titolo;
	}
	
	public void setTitolo(String titolo){
		this.titolo=titolo;
	}

	public String getAutore(){
		return autore;
	}
	
	public void setAutore(String autore){
		this.autore=autore;
	}
}