package motorizzazioni;

public class Automobile extends Veicolo{

	private int numeroPosti = 0;
	
	public Automobile(String targa) {
		super(targa);
	}
	
	public Automobile(String targa,String marca,String modello) {
		super(targa,marca,modello);
	}
	
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	
	public int getNumeroPosti() {
		return numeroPosti;
	}

}
