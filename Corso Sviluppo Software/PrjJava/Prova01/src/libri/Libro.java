package libri;

public class Libro {

	String titolo;
	int ID;
	Pagina pagina;
	
	private Libro() {
		ID = -1;
		titolo = "";
		pagina = null;
	}
	
	public Libro(String titolo, int id, int pagine) {
		this();
		this.titolo  = titolo;
		this.ID = id;
		this.pagina = new Pagina(pagine);
	}

}
