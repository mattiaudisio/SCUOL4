package motorizzazioni;

public class Moto extends Veicolo{

	private int cilindrata = 0;
	
	public Moto(String targa,int cilindrata) {
		super(targa);
		setCilindrata(cilindrata);
	}
	
	public Moto(String marca,String modello,String targa,int cilindrata) {
		super(marca, modello, targa);
		setCilindrata(cilindrata);
	}

	private void setCilindrata(int cilindrata) {
		if(cilindrata > 0) {
			this.cilindrata = cilindrata;						
		}		
	}
	
	public int getCilindrata() {
		return cilindrata;
	}
	
}
