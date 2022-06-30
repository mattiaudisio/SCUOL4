package persona01;

public class Main {

	public static void main(String[] args) {
		Alunno elisa = new Alunno("Elisa","Gorizia");
		Alunno luca = new Alunno("Luca","De Felice");
		Alunno paolo = new Alunno("Paolo","Gatti");
		Alunno anna = new Alunno("Anna","Girolamo");
		
		Alunno[] arrayAlunni = new Alunno[15];
		arrayAlunni[0] = elisa;
		arrayAlunni[1] = luca;
		arrayAlunni[2] = paolo;
		arrayAlunni[3] = anna;
		
		/* ***Metodo 1 ****
		for(int i = 0; i < arrayAlunni.length; i++) {
			if(arrayAlunni[i] == null) {
				break;
			}
			arrayAlunni[i].Stampa();				
		}*/
		
		//Metodo 2 
		int i = 0;
		while(arrayAlunni[i] != null) {
			arrayAlunni[i].Stampa();
			i++;
		}
		
	}

}