package prjScuola;

public class Alunno extends Persona{

	public Alunno() {
		super();
	}
	
	public Alunno(String pNome) {
		super(pNome);
		setTipoPersona(TipoPersona.ALUNNO);
	}
	
	public Alunno(String pNome, String pCognome) {
		super(pNome);
		setCognome(pCognome);
	}

}
