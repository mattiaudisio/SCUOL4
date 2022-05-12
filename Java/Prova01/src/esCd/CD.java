package esCd;

public class CD {
	private String titolo, autore;
	private int numeroBrani, durata;

	public CD(String titolo, String autore, int numeroBrani, int durata) {
		// TODO Auto-generated constructor stub
		this.numeroBrani = numeroBrani;
		this.durata = durata;
		this.titolo = titolo;
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	int getDurata() {
		return this.durata;
	}

	public void setTracce(int numeroBrani) {
		this.numeroBrani = numeroBrani;
	}

	int getTracce() {
		return this.numeroBrani;
	}
}
