package crudArticoli;

import java.time.LocalDate;

public class CrudArticolo {

	private int quantita;
	private double prezzo;
	private boolean Attivo;
	private boolean primaScelta;
	private boolean secondaScelta;
	private boolean terzaScelta;
	private LocalDate Data;

	// .now();
	// .parse("yyy/MM/dd");
	// .parse("dd/MM/yyy",DateTimeFormatter...)
	
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public boolean isAttivo() {
		return Attivo;
	}
	public void setAttivo(boolean attivo) {
		Attivo = attivo;
	}
	public boolean isPrimaScelta() {
		return primaScelta;
	}
	public void setPrimaScelta(boolean primaScelta) {
		this.primaScelta = primaScelta;
	}
	public boolean isSecondaScelta() {
		return secondaScelta;
	}
	public void setSecondaScelta(boolean secondaScelta) {
		this.secondaScelta = secondaScelta;
	}
	public boolean isTerzaScelta() {
		return terzaScelta;
	}
	public void setTerzaScelta(boolean terzaScelta) {
		this.terzaScelta = terzaScelta;
	}
	public LocalDate getData() {
		return Data;
	}
	public void setData(LocalDate data) {
		Data = data;
	}

}
