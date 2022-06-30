package classeMotorino;

public class MotorinoImmatricolato extends Motorino{
	
	private double maxVelocita;
	private String targa;
	
	public MotorinoImmatricolato(String marca, String modello, String colore, double maxVelocita, String targa) {
		super (marca,modello,colore);
		setTarga(targa);
		setMaxVelocita(maxVelocita);
	}
	
	private void setTarga(String value) {
		this.targa = value.toUpperCase();
	}
	
	private void setMaxVelocita(double  value) {
		if (value < 0) value *= -1; //value = value * -1
		//if (value>50) value = 50;
		maxVelocita = value;
	}

	public String getTarga() {
		return targa;
	}
	
	public double getMaxVelocita() {
		return maxVelocita;
	}

	@Override
	public void accellera(double value) {
		
		if (getVelocita() + value >= getMaxVelocita())
			super.accellera(getMaxVelocita()- getVelocita());
		else  super.accellera(value);
			
	}
	
}
