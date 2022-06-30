package eserciziPm;

public class Cane extends Mammifero{
	
	public Cane() {
		super.scriviNome("cane");
		parla();
	}
	
	@Override
	public void parla() {
		System.out.println("Sto abbaiando");
	}

}
