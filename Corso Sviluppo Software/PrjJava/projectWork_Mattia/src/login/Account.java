package login;

public class Account {

	String nomeUtente = "";
	String password = "";
	
	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static String getSqlSelect(String where) {
		String query = "";
		if (where == null)
			where = "";
		query = "SELECT operatori.userName, operatori.password FROM operatori WHERE " + where;
		return query;
	}
}
