package esercizio;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScannerTest obj = new ScannerTest();
		
		Ts01.ese();	//Metodo di classe: posso anche richiamarlo dalla Classe senza creare l'Oggetto
		Ts01 objTs = new Ts01(); //Metodo d'istanza: devo per forza creare un oggetto per richiamarlo
		objTs.nextLine();
		objTs.getInput();
		objTs.getInput("Mattia");
		objTs.getInput(10);

		int[] numArray = new int[10];
		ProvArray.buildArray(numArray);
		for(int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i]);
		}
		
		System.out.println("****************************************");
		
		obj.inputString();
		obj.inputIntero();

		System.out.println("****************************************");
		System.out.println("objValore che ritorna String: "+obj.getInput(""));
		System.out.println("objValore che ritorna int: "+obj.getInput(0));
		System.out.println("objValore che ritorna double: "+  obj.getInput(0.0));
		System.out.println("****************************************");
		System.out.println("Programma terminato");
		
	}

}
