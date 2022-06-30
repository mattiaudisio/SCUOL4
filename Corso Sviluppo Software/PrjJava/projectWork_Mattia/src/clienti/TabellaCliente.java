package clienti;

import java.sql.ResultSet;

public class TabellaCliente {
	private int clienteID;
	private String cognome;
	private String nome;
	private String telefono;
	private String mail;

	public int getClienteID() {
		return clienteID;
	}

	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public static String getSqlSelect(String where) {
		String query = "";
		if (where == null)
			where = "";
		query = "SELECT clienti.ClienteID, clienti.Nome, clienti.Cognome, clienti.Telefono, clienti.Mail FROM clienti "
				+ where + " ORDER BY clienti.Cognome;";
		return query;
	}

	public static TabellaCliente getClienteFromRowSet(ResultSet row) {
		// TODO Auto-generated method stub
		TabellaCliente tb = new TabellaCliente();
		try {
			tb.setClienteID(row.getInt("ClienteID"));
			tb.setNome(row.getString("nome"));
			tb.setCognome(row.getString("cognome"));
			tb.setTelefono(row.getString("telefono"));
			tb.setMail(row.getString("mail"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		return tb;
	}
}