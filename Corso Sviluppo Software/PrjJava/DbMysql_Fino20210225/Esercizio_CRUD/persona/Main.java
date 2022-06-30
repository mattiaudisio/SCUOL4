package persona;

import dbMysql.DbConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection.getDb().setNomeDb("veicoli");
		Persona persona = new Persona();
		persona.setnome("Mattia");
		persona.setCognome("Audisio");

		int ris1 = Persona.Insert(persona);
		System.out.println("Risutlato Insert: " + ris1);
		int ris2 = Persona.Delete(16);
		System.out.println("Risutlato Delete: " + ris2);
		int ris3 = Persona.Update(persona);
		System.out.println("Risutlato Update: " + ris3);
		Persona.Select(17);
	}

}
