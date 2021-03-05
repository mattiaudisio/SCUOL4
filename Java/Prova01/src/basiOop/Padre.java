package basiOop;

public class Padre {

	private String cognome;
	private int eta;

	public Padre(String cognome, int eta) {
		this.eta = eta;
		this.cognome = cognome.toUpperCase();
	}

	public Padre(String cognome) {
		this.cognome = cognome.toUpperCase();
		this.eta = 0;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
}
