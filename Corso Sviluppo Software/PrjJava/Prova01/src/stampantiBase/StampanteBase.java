package stampantiBase;

public abstract class StampanteBase {
	
	private boolean stampanteAccesa = false; //* É propria di ogni oggetoM un stampante è accesa un'altra è spenta
	private static boolean AlmenoUnoStampanteAccesa;  //*É una variaile condivisa con tutti gli ogetti stampanti
	
	public boolean tornaAlmenoUnaStampanteAccesa() {
		return AlmenoUnoStampanteAccesa;
	}
	
	public boolean tornaStatoStampante() {
		//* Ritorna stato stampante ON/OFF
		return stampanteAccesa;
	}
	
	protected void accendiStampante() {
		//* Accende la stampante
		System.out.println("Accende Stampante base");
		AlmenoUnoStampanteAccesa = true;
		stampanteAccesa = true;
	}

	public void spegniStampante() {
		//* spegne la stampante
		stampanteAccesa = false;
	}

	public void inserisciCavo() {
		//... definisce come insierire cavo alimentazione
		//... qui definisce cavo standard
	}
}
