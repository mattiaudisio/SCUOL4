package master;

public class BiciclettaBase {

	private boolean inCarica = false, inMovimento = false;
	private int livelloBatteria = 0; // da 0 a 100

	// Funzione che pedala
	protected void pedala() {
		inMovimento = true;
		System.out.println("\nBiciclettaBase: Sto pedalando");
	}

	// Funzione che si ferma
	protected void fermati() {
		inMovimento = false;
		System.out.println("\nBiciclettaBase: mi sto fermando");
	}

	// Funzione che mette in carica la batteria
	protected boolean mettiInCarica() {
		inCarica = false;
		try {
			if (livelloBatteria < 4 && inCarica != true) {
				inCarica = true;
				livelloBatteria = 4;
				System.out.println("\nLa batteria è stata caricata!");
				togliCaricaBatteria();
				return true;
			} else {
				System.out.println("\nLa batteria è già carica! o è già in carica");
			}
		} catch (Exception e) {
			// .. gestisco l'errore
		}
		return false;
	}

	// Funzione che toglie la batteria dalla carica
	protected void togliCaricaBatteria() {
		inCarica = false;
	}

}
