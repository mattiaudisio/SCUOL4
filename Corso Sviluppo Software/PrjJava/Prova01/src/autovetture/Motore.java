package autovetture;

public class Motore {
	private static int elementoDaInserire = 0;
	private static Motore[] elencoMotori = new Motore[1000];
	
	private Auto autoPropietariaDelMotore;
	
	public Motore(Auto auto) {
		autoPropietariaDelMotore = auto;
		elencoMotori[elementoDaInserire++] = this;		
	}
}
