package pennarelli;

public class Pennarello {

	//variabili
	private String marca,colore;
	
	// Costruttore
	public Pennarello(String nome, String colore) {
		setMarca(nome);
		setColore(colore);
	}

	// Metodo get che ci mostra il valore della variabile marca
	public String getMarca() {
		return marca;
	}

	// Metodo get che ci permette di modificare il valore della variabile marca
	private void setMarca(String nome) {
		this.marca = nome;
	}

	// Metodo get che ci mostra il valore della variabile colore
	public String getColore() {
		return colore;
	}

	// Metodo get che ci permette di modificare il valore della variabile colore
	private void setColore(String colore) {
		this.colore = colore;
	}
	
	
}
