package stampantiHP;

import stampantiBase.*;

public class HpLaser107 extends StampanteBase{

	@Override
	public void accendiStampante() {
		System.out.println("Accende HPLaser107");
		scaldaLaser();
		pulisciRullo();
	}
	
	private void scaldaLaser() { }

	private void pulisciRullo() { }
	
	@Override
	public void inserisciCavo() {
		//... definisce come insierire cavo alimentazione
		//... utilizza alimentazione a parte
	}

}