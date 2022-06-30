package prjScuola;

import java.util.ArrayList;

public class Scuola {

	public static void main(String[] args) {

		Array_vs_ArrayList();
		
		String[] nomiAlunni = mthElencoAlunni();
		Alunno [] AlunniObj = mthCreaOggettiAlunno(nomiAlunni);
//		int i1 = TipoPersona.ALUNNO.ordinal();
//		int i2 = TipoPersona.ATA.ordinal();
//		int i3 = TipoPersona.DOCENTE.ordinal();
//		int i4 = TipoPersona.AMMINISTRAZIONE.ordinal();
		
		for (int i = 0; i < AlunniObj.length; i++) {
			mthOutput(AlunniObj[i].getNome());
			mthOutput(AlunniObj[i].getNome(),AlunniObj[i].getGenere());
		}
		
	}
	
	private static void mthOutput(String nome, Genere genere) {
		System.out.println(nome+" "+genere);		
	}

	private static void mthOutput(String nome) {
		System.out.println(nome);		
	}

	private static Alunno[] mthCreaOggettiAlunno(String[] nomiAlunni) {
		//crea e riempie array oggetti alunno
		Alunno[] ar = new Alunno[nomiAlunni.length];
		for(int i = 0; i < nomiAlunni.length; i++){
			String[] a = nomiAlunni[i].split("\\|",2);
			ar[i] = new Alunno(a[0]);
			if(a[1].equals("M")) {
				ar[i].setGenere(Genere.MASCHIO);
			}else if(a[1].equals("F")){
				ar[i].setGenere(Genere.FEMMINA);				
			}else {
				ar[i].setGenere(Genere.NONE);								
			}
		}
		return ar;
	}

	private static String[] mthElencoAlunni() {
		//crea elenco nomi alunni
		String[] ar = {"Danilo|M","Davide|M","Rocco|M","Carlo|M","Naomie|F","Daniele|M","Mattia|M","Luca|M","Manuela|F","Marco|M","Sabrina|F","Kevin|M","Teresa|F","Giuliano|M"};
		return ar;
	}
	
	public static void Array_vs_ArrayList() {
		String[] ar = new String[10];
		ArrayList<String> ls = new ArrayList<String>();
		System.out.println("Array: "+ar.length);
		System.out.println("Ls: "+ls.size());
		//************* ARRAY
		//* Assegna stringa ad ogni elemento dell'array
		ar[0]="elemento0";
		ar[1]="elemento1";
		ar[2]="elemento2";
		ar[3]="elemento3";
		ar[4]="elemento4";
		ar[5]="elemento5";
		ar[6]="elemento6";
		ar[7]="elemento7";
		ar[8]="elemento8";
		ar[9]="elemento9";
		//*esegue loop su array e stampa contenuto elementi
		for(int i = 0; i < ar.length; i++) {
			System.out.println("contenuto elemento "+i+" "+ar[i]);			
		}
		//************* ARRAYLIST
		//* Aggiunge elementi a lista
		ls.add("elemento lista 0");
		ls.add("elemento lista 1");
		ls.add("elemento lista 2");
		ls.add("elemento lista 3");
		ls.add("elemento lista 4");
		ls.add("elemento lista 5");
		ls.add("elemento lista 6");
		ls.add("elemento lista 7");
		ls.add("elemento lista 8");
		ls.add("elemento lista 9");
		ls.add("elemento lista 10");
		ls.add("elemento lista 11");
		for(int i=0; i < ls.size(); i++) {
			System.out.println("contenuto elemento "+i+" "+ls.get(i));						
		}
		System.out.println("*********************************************");
		//* Aggiungo un elemento prima dell'elemento nr 3
		ls.add(2,"aggiunto prima di 2");
		for(int i=0; i < ls.size(); i++) {
			System.out.println("contenuto elemento "+i+" "+ls.get(i));						
		}
		System.out.println("*********************************************");
		//* Aggiorno valore elemento 5
		ls.set(4, "Elemento 5 aggiornato");
		for(int i=0; i < ls.size(); i++) {
			System.out.println("contenuto elemento "+i+" "+ls.get(i));						
		}
		//* Elementi presenti in lista
		System.out.println("****************************************");						
		System.out.println("elementi presenti in lista"+ls.size());
		//* Elimina elementi
		ls.remove(0);
		ls.remove(ls.size()-1);		
		System.out.println("****************************************");						
		System.out.println("elementi presenti in lista"+ls.size());
	}
}