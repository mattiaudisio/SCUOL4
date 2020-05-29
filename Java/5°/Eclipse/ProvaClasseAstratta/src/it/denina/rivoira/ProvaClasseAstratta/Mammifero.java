package it.denina.rivoira.ProvaClasseAstratta;

public class Mammifero extends AnimaleAcquatico{
	//Posso estendere più interfacce mentre posso estendere da una sola classe
	@Override
	public void respira() {
		// TODO Auto-generated method stub
		System.out.println("Sono un mammifero ed uso i polmoni");
	}
}
