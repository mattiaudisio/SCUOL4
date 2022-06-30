package classi_esercizio;

public class ClassePersona {
	int ID = 0;
	String nome = "";
	
	static ClassePersona[] arrayObj = new ClassePersona[18];
	
	//costruttore
	public ClassePersona(int pID, String pNome) {
		this.ID = pID;
		this.nome = pNome;
	}

	//Funzione che crea l'array che contiene gli oggetti Persona
	public static void creaObj(String[] arrayNomi) {
		for(int i = 0; i < arrayNomi.length; i++) {
			arrayObj[i] = new ClassePersona(i+1,arrayNomi[i]);
		}
	}
	
	//1° Metodo polimorfismo. Questo metodo richiede solo il nome
	public static String mthInput(String nome) {
		String pNome = null;
		for(int i = 0; i < arrayObj.length; i++) {
			if(arrayObj[i].getNome() == nome) {
				pNome = arrayObj[i].getNome();
			}
		}
		return pNome;	
	}
	
	//2° Metodo polimorfismo. Questo metodo richiede solo l'ID
	public static int mthInput(int id) {
		int pID = 0;
		for(int i = 0; i < arrayObj.length; i++) {
			if(arrayObj[i].getID() == id) {
				pID = arrayObj[i].getID();
			}
		}
		return pID;		
	}

	//Metodo get ID
	public int getID() {
		return ID;
	}
	
	//Metodo get Nome
	public String getNome() {
		return nome;
	}
	
}
