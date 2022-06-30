package prjScuola;

public class Docente extends Persona{
	
	public Docente(String pNome) {
		super(pNome);
		setTipoPersona(TipoPersona.DOCENTE);
	}
}
