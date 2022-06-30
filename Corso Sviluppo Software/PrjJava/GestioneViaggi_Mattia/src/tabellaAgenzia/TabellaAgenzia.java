package tabellaAgenzia;

public class TabellaAgenzia {
	private int agenziaID;
	private String ragioneSociale = "";

	public int getAgenziaID() {
		return agenziaID;
	}

	public void setAgenziaID(int agenziaID) {
		this.agenziaID = agenziaID;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale.trim();
	}
}
