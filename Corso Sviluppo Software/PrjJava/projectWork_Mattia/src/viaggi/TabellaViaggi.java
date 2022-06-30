package viaggi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class TabellaViaggi {

	

	

	private int viaggioID;
	private int viaggioOrganizzatoID;
	private int localitaPartenzaID;
	private int localitaArrivoID;
	private double prezzo;
	private LocalDate dataPartenza;
	private double oreViaggio;
	private double  ora_Partenza;
	private LocalDate dataArrivo;
	private double  ora_Arrivo;

	private String partenza;
	private String arrivo;
	private int  disponibili;
	

	public int getViaggioID() {
		return viaggioID;
	}

	public void setViaggioID(int viaggioID) {
		this.viaggioID = viaggioID;
	}
	



	public int getViaggioOrganizzatoID() {
		return viaggioOrganizzatoID;
	}

	public void setViaggioOrganizzatoID(int viaggioOrganizzatoID) {
		this.viaggioOrganizzatoID = viaggioOrganizzatoID;
	}

	public int getLocalitaPartenzaID() {
		return localitaPartenzaID;
	}

	public void setLocalitaPartenzaID(int localitaPartenzaID) {
		this.localitaPartenzaID = localitaPartenzaID;
	}

	public int getLocalitaArrivoID() {
		return localitaArrivoID;
	}

	public void setLocalitaArrivoID(int localitaArrivoID) {
		this.localitaArrivoID = localitaArrivoID;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double  getOreViaggio() {
		return oreViaggio;
	}

	public void setOreViaggio(double  oreViaggio) {
		this.oreViaggio = oreViaggio;
	}

	public LocalDate getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public double  getOra_Partenza() {
		return ora_Partenza;
	}

	public void setOra_Partenza(double  ora_Partenza) {
		this.ora_Partenza = ora_Partenza;
	}

	public LocalDate getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(LocalDate dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public double  getOra_Arrivo() {
		return ora_Arrivo;
	}

	public void setOra_Arrivo(double  ora_Arrivo) {
		this.ora_Arrivo = ora_Arrivo;
	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getArrivo() {
		return arrivo;
	}

	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}

	public int getDisponibili() {
		return disponibili;
	}

	public void setDisponibili(int disponibili) {
		this.disponibili = disponibili;
	}

	//******************
	public static String getSqlUpdate_PostiDIpsonibili(int pID, int pPostiPrenotati)
	{
		String query = "UPDATE viaggi SET PostiPrenotati = " +pPostiPrenotati +";";
		
		return query;
	}
	public static String getSqlSelect(String where) {

		if (where == null)
			where = "";

		String query = "SELECT " + " ViaggioID, viaggi_organizzati.ViaggioOrganizzatoID," + " localitaPart.Localita AS Partenza,"
				+ ""  + " viaggi.dataPartenza,"+ " viaggi.dataArrivo,"+  " viaggi_organizzati.OraPartenza,"
				+ " localitaArr.Localita AS Arrivo, " + " viaggi_organizzati.OraArrivo,"
				+ " viaggi_organizzati.OreViaggio," + " viaggi_organizzati.Prezzo," + " viaggi.PostiTotali,"
				+ " viaggi.PostiTotali - viaggi.PostiPrenotati AS Disponibili"
				+ " FROM viaggi " + " INNER JOIN viaggi_organizzati "
				+ "	ON viaggi.ViaggioOrganizzatoID = viaggi_organizzati.ViaggioOrganizzatoID"
				+ " INNER JOIN localita localitaPart "
				+ " ON viaggi_organizzati.LocalitaPartenzaID = localitaPart.LocalitaID"
				+ " INNER JOIN localita localitaArr ON viaggi_organizzati.LocalitaArrivoID = localitaArr.LocalitaID "
				+ where + " ORDER BY Partenza, DataPartenza, OraPartenza " + ";";
		return query;
	}

	public static TabellaViaggi getViaggioFromRowSet(ResultSet row) {
		TabellaViaggi tb = new TabellaViaggi();
		try {

			tb.setViaggioID(row.getInt("ViaggioID"));
			tb.setViaggioOrganizzatoID(row.getInt("viaggi_organizzati.ViaggioOrganizzatoID"));
			tb.setPartenza(row.getString("Partenza"));
			tb.setDataPartenza(row.getDate("dataPartenza").toLocalDate());
			tb.setOra_Partenza(row.getDouble("OraPartenza"));

			tb.setArrivo(row.getString("Arrivo"));
		
			if(row.getObject("dataArrivo")!=null) {
				tb.setDataArrivo(row.getDate("dataArrivo").toLocalDate());	
			}
			
			tb.setOra_Arrivo(row.getDouble("OraArrivo"));
			tb.setPrezzo(row.getBigDecimal ("Prezzo").doubleValue());
			tb.setDisponibili(row.getInt("Disponibili"));
			
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
	//******************
}
