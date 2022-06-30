package prenotazioni;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import viaggi.TabellaViaggi;

public class TabellaPrenotazione {

	private int prenotazioneID;
	private LocalDate dataPrenotazione;
	private int viaggioID;
	private int clienteID;
	private String nome;
	private String cognome;
	private String telefono;
	private String mail;
	private String  viaggioPartenza ;
	private LocalDate dataPartenza;
	private  double oraPartenza;
	private String viaggioArrivo;
	private LocalDate dataArrivo;
	private double oraArrivo;
	private double oreViaggio;
	private double prezzo;
	private int pagamento;
	private int postiTotali;
	private int postiDisponibili;
	private int postiPrenotati;
	
	public Double getImporto() {
		return prezzo * postiPrenotati;
	}
	
	public int getPrenotazioneID() {
		return prenotazioneID;
	}
	public void setPrenotazioneID(int prenotazioneID) {
		this.prenotazioneID = prenotazioneID;
	}

	
	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	public int getViaggioID() {
		return viaggioID;
	}
	public void setViaggioID(int viaggioID) {
		this.viaggioID = viaggioID;
	}
	public int getClienteID() {
		return clienteID;
	}
	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}
	public String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	private void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTelefono() {
		return telefono;
	}
	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	private void setMail(String mail) {
		this.mail = mail;
	}
	public String getViaggioPartenza() {
		return viaggioPartenza;
	}
	private void setViaggioPartenza(String viaggioPartenza) {
		this.viaggioPartenza = viaggioPartenza;
	}
	public LocalDate getDataPartenza() {
		return dataPartenza;
	}
	private void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public double getOraPartenza() {
		return oraPartenza;
	}
	private void setOraPartenza(double oraPartenza) {
		this.oraPartenza = oraPartenza;
	}
	public String getViaggioArrivo() {
		return viaggioArrivo;
	}
	private void setArrivo(String arrivo) {
		this.viaggioArrivo = arrivo;
	}
	public LocalDate getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(LocalDate dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public double getOraArrivo() {
		return oraArrivo;
	}
	private void setOraArrivo(double oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	public double getOreViaggio() {
		return oreViaggio;
	}
	private void setOreViaggio(double oreViaggio) {
		this.oreViaggio = oreViaggio;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getPagamento() {
		return pagamento;
	}
	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}
	public int getPostiTotali() {
		return postiTotali;
	}
	private void setPostiTotali(int postitotali) {
		this.postiTotali = postitotali;
	}
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	public void setPostiDisponibili(int disponibili) {
		this.postiDisponibili = disponibili;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	public void setPostiPrenotati(int prenotati) {
		this.postiPrenotati = prenotati;
	}
	
	public static TabellaPrenotazione getPrenotazioneFromRowSet(ResultSet row) {
		TabellaPrenotazione tb = new TabellaPrenotazione();
		try {

			tb.setPrenotazioneID(row.getInt("prenotazioneID"));
			System.out.println(tb.getPrenotazioneID());
		
			tb.setViaggioID(row.getInt("ViaggioID"));
			tb.setClienteID(row.getInt("ClienteID"));
			
			tb.setDataPrenotazione(row.getDate("dataPrenotazione").toLocalDate());
			
			tb.setNome(row.getString("Nome"));
			tb.setCognome(row.getString("cognome"));
			tb.setTelefono(row.getString("telefono"));
			tb.setMail(row.getString("Mail"));
			
			tb.setViaggioPartenza(row.getString("Partenza"));
			tb.setDataPartenza(row.getDate("dataPartenza").toLocalDate());
			tb.setOraPartenza(row.getDouble("oraPartenza"));

			tb.setArrivo(row.getString("Arrivo"));

			if(row.getObject("dataArrivo")!=null) {
				tb.setDataArrivo(row.getDate("dataArrivo").toLocalDate());	
			} else 	tb.setDataArrivo(row.getDate("dataPartenza").toLocalDate());
			tb.setOraArrivo(row.getDouble("OraArrivo"));
			
			tb.setOreViaggio(row.getDouble("OreViaggio"));
			
			tb.setPrezzo(row.getBigDecimal ("Prezzo").doubleValue());
			tb.setPostiPrenotati(row.getInt("postiPrenotati"));
			tb.setPostiTotali(row.getInt("PostiTotali"));
			tb.setPostiDisponibili(row.getInt("Disponibili"));
			
			tb.setPagamento(row.getInt("tipoPagamento"));
//** inserisce i dati in array 
//** ogni elemento dell'array corrisponde a una colonna
		//	Object[] o = { id, partenza, data, oraPartenza, arrivo, oraArrivo, prezzo, disponbili };
//** inserisce nuova riga in jtable 
//** la nuova riga corrisponte all'array definito 
//** la riga precedente
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tb;
	}

	public static String getSqlSelect(String where) {
		
		String query ="";
		if (where == null) where  = "";

//	
		query = "SELECT 				  "
				+ " prenotazioni.prenotazioneID,"
				+ " prenotazioni.dataPrenotazione,"
				+ " prenotazioni.ViaggioID,"
				+ " prenotazioni.postiPrenotati,"
				+ " prenotazioni.tipoPagamento,"
				+ " clienti.ClienteID,"
				+ " clienti.Nome,"
				+ " clienti.Cognome,"
				+ " clienti.Telefono,"
				+ " clienti.Mail,"
				+ " localitaPart.Localita AS Partenza ,"
				+ " viaggi.dataPartenza,"
				+ " viaggi_organizzati.oraPartenza,"
				+ " localitaArr.Localita AS Arrivo,"
				+ " viaggi.dataArrivo,"
				+ " viaggi_organizzati.OraArrivo,"
				+ " viaggi_organizzati.OreViaggio,"
				+ " viaggi_organizzati.Prezzo,"
				+ " viaggi.PostiTotali,"
				+ " viaggi.PostiTotali - viaggi.PostiPrenotati AS Disponibili"
				+ " FROM prenotazioni "
				+ " INNER JOIN clienti "
				+ " ON prenotazioni.ClienteID =     clienti.ClienteID"
				+ " INNER JOIN viaggi "
				+ " ON prenotazioni.ViaggioID =     viaggi.ViaggioID"
				+ " INNER JOIN viaggi_organizzati "
				+ " ON viaggi.ViaggioOrganizzatoID = viaggi_organizzati.ViaggioOrganizzatoID"
				+ " INNER JOIN localita localitaPart "
				+ " ON viaggi_organizzati.LocalitaPartenzaID = localitaPart.LocalitaID"
				+ " INNER JOIN localita localitaArr "
				+ " ON viaggi_organizzati.LocalitaArrivoID = localitaArr.LocalitaID "
				+ where
				//+ " ORDER BY Cognome, Nome, Partenza, Data, Ora_Partenza "
				+ ";";

		return query;
	}
	
	public String getSqlInsert() {
		//Date DataPrenotazioneSql = Date.valueOf(getDataPrenotazione());
		Date dataPrenotazioneSql = Date.valueOf(getDataPrenotazione());
		String query="INSERT INTO prenotazioni "
				+ "("
				+ "clienteID,"
				+ "viaggioID,"
				+ "tipoPagamento,"
				+ "prezzo,"
				+ "postiPrenotati,"
				+ "dataPrenotazione)"
				+ "VALUES "
				+ "("+getClienteID()+","
						+ getViaggioID()+","
						+ getPagamento()+","
						+ getPrezzo()+","
						+ getPostiPrenotati() +","
						+ "'"+dataPrenotazioneSql+"'"
						+");";
		return query;
				
	}


	public String getSqlUpdate() {
		Date dataPrenotazioneSql = Date.valueOf(getDataPrenotazione());
		String sql="UPDATE prenotazioni "
				+ "SET "
				+ " clienteID =" + getClienteID()+","
				+ " viaggioID =" + getViaggioID()+","
				+ " tipoPagamento = " + getPagamento() +","
				+ " prezzo = " + getPrezzo()+","
				+ " postiPrenotati = "+ getPostiPrenotati ()+ ","
				+ " dataPrenotazione = '"+ dataPrenotazioneSql+"'"
				+ " WHERE prenotazioneID = "+ getPrenotazioneID ()+";";
		return sql;
	}


	public String getSqlDelete() {
		String sql="DELETE FROM prenotazioni"
				+ " WHERE prenotazioneID = " + getPrenotazioneID ();
		return sql;
	}
}
