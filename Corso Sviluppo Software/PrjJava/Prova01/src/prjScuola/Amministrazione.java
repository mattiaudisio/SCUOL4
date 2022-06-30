package prjScuola;

public class Amministrazione extends Persona{

	public Amministrazione(String pNome) {
		super(pNome);
		setTipoPersona(TipoPersona.AMMINISTRAZIONE);
	}
}
