package autovetture;

public class Auto {
	
	Motore motore;

	public Auto() {
		this.motore = new Motore();
	}
	
	protected void setMotore(Motore motore) {
		this.motore = motore;
	}
}
