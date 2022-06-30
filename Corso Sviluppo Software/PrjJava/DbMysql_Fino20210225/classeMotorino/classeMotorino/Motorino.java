package classeMotorino;

public class Motorino {
	private String colore;
	private String marca;
	private String modello;
	private double velocita;
	private boolean antifurto;

	public Motorino(String marca, String modello, String colore) {
		velocita = -1;
		antifurto = true;
		setMarca (marca);
		setModello (modello);
		setColore(colore);
	}
	
	public void setColore(String value) {
		colore = value;
	}
	private void setMarca(String value) {
		marca = value;
	}
	private void setModello(String value) {
		modello = value;
	}
	private void setVelocita(double value) {
		velocita = value;
	}
	public void setAntifurto(boolean value) {
		antifurto = value;
	}
	
	public String getColore() {
		return colore;
	}
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public double getVelocita() {
		return velocita;
	}
	public boolean getAntifurto() {
		return antifurto;
	}
	
	public void accellera (double value) {
		
		if (antifurto) return ;
		//if (antifurto == false) 
		setVelocita(velocita + value);		
	}

}
