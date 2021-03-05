package provaClasseAstratta;

public interface Animale {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mangia(); // Posso avere un interfaccia con un attributo non astratto; questo non è
					// dichiarato come metodo astratto; definisce un metodo pubblico normalissimo
		// public void dorme(); //I METODI ASTRATTI NON HANNO BISOGNO DI UN CORPO;
		// QUINDI NIENTE {}
	}

	public static void mangia() {
		// TODO Auto-generated method stub
		System.out.println("\nSto mangiando");

	}

	void verso();
}
