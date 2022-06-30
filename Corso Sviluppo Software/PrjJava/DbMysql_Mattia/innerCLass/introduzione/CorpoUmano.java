package introduzione;

import introduzione.CorpoUmano.ditaCorpoUmano;

/*
 * Esempio di inner class
 * CorpoUmano è la classe contenitore delle classi Piede, Testa Torace	 
 * @author audisiom
 *
 */
public class CorpoUmano {
	int eta;

	public class ditaCorpoUmano {
		int numeroFalangi;
		int numeroFalangine;
		int numeroFalangette;
	}

	private class Piede {
		ditaCorpoUmano mignolo;
		ditaCorpoUmano alluce;

		Piede() {

		}

		public int numeroPiede() {
			return 43;
		}
	}

	public class Testa {
		public double Circonferenza() {
			return 36.9;
		}
	}

	protected class Torace {
		// .. attributi e metodi
	}
}