package autovetture;

public class Panda extends Auto {

	public Panda() {
		Motore motore = new Motore(this);
		setMotore(motore);
	}
}
