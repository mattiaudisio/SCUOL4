package it.denina.rivoira.ProvaClasseAstratta;

public interface Animale {

	public abstract void verso();
	public void mangia();	//Posso avere un interfaccia con un attributo non astratto; questo non è dichiarato come metodo astratto; definisce un metodo pubblico normalissimo
	//public void dorme();	//I METODI ASTRATTI NON HANNO BISOGNO DI UN CORPO; QUINDI NIENTE {}
	
}
