package eserciziPm;

public class Mammifero extends Animale{

	String nome = "";
	
	public void parla() {
		System.out.println("Sto parlando");
	}
	
	public void scriviNome(String nome) {
		this.nome = nome;
	}
}
