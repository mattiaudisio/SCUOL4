package it.denina.rivoira.basioop;

public class Telefono {
	
	private String nCasa;
	private String nLavoro;
	
	public String getnCasa() {
		return nCasa;
	}
	public void setnCasa(String nCasa) {
		this.nCasa = nCasa;
	}
	public String getnLavoro() {
		return nLavoro;
	}
	public void setnLavoro(String nLavoro) {
		this.nLavoro = nLavoro;
	}
	public Telefono(String nCasa, String nLavoro) {
		super();
		this.nCasa = nCasa;
		this.nLavoro = nLavoro;
	}
	
	

}
