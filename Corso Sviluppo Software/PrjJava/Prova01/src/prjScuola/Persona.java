package prjScuola;


public abstract class Persona {

	private TipoPersona TipoPersona;
	private String nome;
	private String cognome;		
	private String indirizzo;		
	private String localita;		
	private String provincia;		
	private String cap;		
	private String telefono;			
	private String mail;			
	private Genere genere;
	private short eta;
	
	Utilita utilita1 = new Utilita();
		
	public Persona() {
		nome = "";
		cognome = "";
		indirizzo = "";
		localita = "";
		provincia = "";
		cap = "";
		telefono = "";
		mail = "";
		eta = 0;
		genere = Genere.NONE;
	}
	
	public Persona (String nome) {
		this();
		setNome(nome);
	}
	
	
	public TipoPersona getTipoPersona() {
		return TipoPersona;
	}

	protected void setTipoPersona(TipoPersona tipoPersona) {
		TipoPersona = tipoPersona;
	}
	
	private void setNome(String pNome) {
		nome = inizialeMaiuscola(pNome);
	}

	public String getNome() {
		return nome;
	}
	
	private String inizialeMaiuscola(String pValue){ 
		return Utilita.inizialeMaiuscola(pValue);
	}
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String pCognome) {
		nome = inizialeMaiuscola(pCognome);
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String pIndirizzo) {
		this.indirizzo = pIndirizzo;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String pLocalita) {
		this.localita = pLocalita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String pProvincia) {
		this.provincia = pProvincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String pCap) {
		this.cap = pCap;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String pTelefono) {
		this.telefono = pTelefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String pMail) {
		this.mail = pMail;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere pGenere) {
		this.genere = pGenere;
	}

	public short getEta() {
		return eta;
	}

	public void setEta(short pEta) {
		this.eta = pEta;
	}

}