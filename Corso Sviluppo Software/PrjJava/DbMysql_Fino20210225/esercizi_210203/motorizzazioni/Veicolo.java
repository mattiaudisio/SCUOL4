package motorizzazioni;

public abstract class Veicolo {
	
	private String targa="";
	private String marca="";
	private String modello="";
	
	public Veicolo(String targa) {
		setTarga(targa);
	}

	public Veicolo(String marca,String modello,String targa) {
		setTarga(targa);
		setMarca(marca);
		setModello(modello);
	}
	
	private void setTarga(String targa) {
		this.targa = targa.toUpperCase();		
	}
	
	public String getTarga() {
		return targa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getModello() {
		return modello;
	}

}
