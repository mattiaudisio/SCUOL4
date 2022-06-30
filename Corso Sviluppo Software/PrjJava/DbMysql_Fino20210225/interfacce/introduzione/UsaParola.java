package introduzione;

public class UsaParola {

	public static void main(String[] args) {
		Cane fido = new Cane();
		Trota nemo = new Trota();
		Pietra marmo = new Pietra();

		setUsaParola(fido);
		setUsaParola(nemo);
		// setUsaParola(marmo);
	}

	public static void setUsaParola(IAnimale obj/* parametro ogetto_parlante */) {
		// ogetto_parlante.parla();
		obj.Parla();
	}
}
