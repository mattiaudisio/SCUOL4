package tabellaViaggi;

import java.time.LocalDate;
import java.time.LocalTime;

public class TabellaViaggi {
	int viaggioID, partLocalitaID, arrivoLocalitaID, nrPosti, nrPrenotati, nrConfermati;
	LocalDate partData, arrivoData;
	LocalTime parOra, arrivoOra;
	double CostoPosto, CostoPrenotazione;

	public int getViaggioID() {
		return viaggioID;
	}

	public void setViaggioID(int viaggioID) {
		this.viaggioID = viaggioID;
	}

	public int getPartLocalitaID() {
		return partLocalitaID;
	}

	public void setPartLocalitaID(int partLocalitaID) {
		this.partLocalitaID = partLocalitaID;
	}

	public int getArrivoLocalitaID() {
		return arrivoLocalitaID;
	}

	public void setArrivoLocalitaID(int arrivoLocalitaID) {
		this.arrivoLocalitaID = arrivoLocalitaID;
	}

	public int getNrPosti() {
		return nrPosti;
	}

	public void setNrPosti(int nrPosti) {
		this.nrPosti = nrPosti;
	}

	public int getNrPrenotati() {
		return nrPrenotati;
	}

	public void setNrPrenotati(int nrPrenotati) {
		this.nrPrenotati = nrPrenotati;
	}

	public int getNrConfermati() {
		return nrConfermati;
	}

	public void setNrConfermati(int nrConfermati) {
		this.nrConfermati = nrConfermati;
	}

	public LocalDate getPartData() {
		return partData;
	}

	public void setPartData(LocalDate partData) {
		this.partData = partData;
	}

	public LocalDate getArrivoData() {
		return arrivoData;
	}

	public void setArrivoData(LocalDate arrivoData) {
		this.arrivoData = arrivoData;
	}

	public LocalTime getParOra() {
		return parOra;
	}

	public void setPartOra(LocalTime parOra) {
		this.parOra = parOra;
	}

	public LocalTime getArrivoOra() {
		return arrivoOra;
	}

	public void setArrivoOra(LocalTime arrivoOra) {
		this.arrivoOra = arrivoOra;
	}

	public double getCostoPosto() {
		return CostoPosto;
	}

	public void setCostoPosto(double costoPosto) {
		CostoPosto = costoPosto;
	}

	public double getCostoPrenotazione() {
		return CostoPrenotazione;
	}

	public void setCostoPrenotazione(double costoPrenotazione) {
		CostoPrenotazione = costoPrenotazione;
	}

	public String getQueryInsert() {
		String query = "INSERT INTO  viaggi(PartLocalitaID,PartData,PartOra,ArrivoLocalitaID,ArrivoData,"
				+ "ArrivoOra,NrPosti,NrPrenotati,NrConfermati,CostoPosto,CostoPostoPrenotazione)" + " VALUES ("
				+ this.getPartLocalitaID() + ",'" + java.sql.Date.valueOf(this.getPartData()) + "','"
				+ java.sql.Time.valueOf(this.getParOra()) + "', " + this.getArrivoLocalitaID() + ",'"
				+ java.sql.Date.valueOf(this.getArrivoData()) + "','" + java.sql.Time.valueOf(this.getArrivoOra())
				+ "'," + this.getNrPosti() + "," + this.getNrPrenotati() + "," + this.getNrConfermati() + ","
				+ this.getCostoPosto() + "," + this.getCostoPrenotazione() + ")";
		return query;
	}

	public String getQueryUpfate() {
		String query = "UPDATE viaggi SET PartLocalitaID = " + this.getPartLocalitaID() + "," + "PartData = '"
				+ java.sql.Date.valueOf(this.getPartData()) + "'," + "PartOra = '"
				+ java.sql.Time.valueOf(this.getParOra()) + "' , ArrivoLocalitaID = " + this.getArrivoLocalitaID() + ""
				+ ",ArrivoData = '" + java.sql.Date.valueOf(this.getArrivoData()) + "' , " + "arrivoOra = '"
				+ java.sql.Time.valueOf(this.getArrivoOra()) + "', " + "NrPosti = " + this.getNrPosti()
				+ ", NrPrenotati = " + this.getNrPrenotati() + ",NrConfermati = " + this.getNrConfermati()
				+ ",CostoPosto = " + "" + this.getCostoPosto() + ",CostoPostoPrenotazione="
				+ this.getCostoPrenotazione() + " WHERE viaggiID = " + this.getViaggioID() + "";
		return query;
	}

	public String getQueryEliminazione(int id) {
		return "DELETE FROM viaggi WHERE viaggiID =" + id;
	}
}
