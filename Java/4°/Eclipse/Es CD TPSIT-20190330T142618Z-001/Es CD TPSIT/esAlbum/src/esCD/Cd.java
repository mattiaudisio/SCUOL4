package esCD;

public class Cd {
	private String tit="";
	private String aut="";
	private int nBrani=0;
	private int dur=0;
	
	public Cd(String titolo,String autore,int numBrani,int durata) {
		tit=titolo;
		aut=autore;
		nBrani=numBrani;
		dur=durata;
		Starter s=new Starter();
		
	}
	
	
	
	void setTitolo(String titolo) {
        this.tit=titolo;
	}
    String getTitolo() {
        return tit;
	}
    
    void setAutore(String autore) {
    	this.aut=autore;
    }
    String getAutore() {
        return this.aut;
    }
    
    void setBrani(int nBran) {
    	this.nBrani=nBran;
    }
    int getBrani() {
        return this.nBrani;
    }
    
    void setDurata(int durata) {
    	this.dur=durata;
    }
    int getDurata() {
        return this.dur;
	}
}
