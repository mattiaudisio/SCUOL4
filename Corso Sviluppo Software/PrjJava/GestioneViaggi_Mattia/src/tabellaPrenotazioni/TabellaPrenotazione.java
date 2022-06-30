package tabellaPrenotazioni;

public class TabellaPrenotazione {
	private int prenotazioniID, posti, agenziaViaggiID, viaggioID;
	private boolean prenotati, acquistati;
	private double costoPosto, costoPrenotazione;

	public int getPrenotazioniID() {
		return prenotazioniID;
	}

	public void setPrenotazioniID(int prenotazioniID) {
		this.prenotazioniID = prenotazioniID;
	}

	public int getAgenziaViaggiID() {
		return agenziaViaggiID;
	}

	public void setAgenziaViaggiID(int agenziaViaggiID) {
		this.agenziaViaggiID = agenziaViaggiID;
	}

	public int getViaggioID() {
		return viaggioID;
	}

	public void setViaggioID(int viaggioID) {
		this.viaggioID = viaggioID;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public double getCostoPosto() {
		return costoPosto;
	}

	public void setCostoPosto(double costoPosto) {
		this.costoPosto = costoPosto;
	}

	public double getCostoTotale() {
		if (getPrenotati()) {
			return getPosti() * getCostoPrenotazione();
		}
		return getPosti() * getCostoPosto();
	}

	public boolean getPrenotati() {
		return prenotati;
	}

	public void setPrenotati(boolean prenotati) {
		this.prenotati = prenotati;
	}

	public boolean isAcquistati() {
		return acquistati;
	}

	public void setAcquistati(boolean acquistati) {
		this.acquistati = acquistati;
	}

	public double getCostoPrenotazione() {
		return costoPrenotazione;
	}

	public void setCostoPrenotazione(double costoPrenotazione) {
		this.costoPrenotazione = costoPrenotazione;
	}

	public String getQueryInsert() {
		String query = "INSERT INTO prenotazioni(agenziaViaggiID, viaggioID,posti,prenotati,acquistati,totale,costoPosto,costoPrenotazione)"
				+ "VALUES("+this.getAgenziaViaggiID()+","+this.getViaggioID()+"," + this.getPosti() + "," + this.getPrenotati() + "," + this.isAcquistati() + ","
				+ this.getCostoTotale() + "," + this.getCostoPosto() + "," + this.getCostoPrenotazione() + ");";
		return query;
	}

	public String getQueryUpdate() {
		String query = "UPDATE prenotazioni SET posti = " + this.getPosti() + ",prenotati = " + this.getPrenotati()
				+ ",acquistati = " + this.isAcquistati() + ",costoPosto = " + this.getCostoPosto()
				+ ",costoPrenotazione = " + this.getCostoPrenotazione() + " WHERE prenotazioniID = "
				+ this.getPrenotazioniID() + ";";
		return query;
	}
}
