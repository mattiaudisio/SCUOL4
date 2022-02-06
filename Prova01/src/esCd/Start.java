package esCd;

public class Start {
	public static void main(String[] args) {
		int traccia1 = 8;
		int durata1 = 2554;
		int traccia2 = 15;
		int durata2 = 3105;

		CD cd1 = new CD("Led Zeppelin IV", "Led Zeppelin", traccia1, durata1);
		CD cd2 = new CD("Educazione Sabauda", "Willie Peyote", traccia2, durata2);
		System.out.println("Album " + cd1.getTitolo() + " è dei " + cd1.getAutore() + ", ha " + traccia1 + " e dura "
				+ durata1 + "secondi");
		System.out.println("Album " + cd2.getTitolo() + " è dei " + cd2.getAutore() + ", ha " + traccia2 + " e dura "
				+ durata2 + "secondi");
		if (traccia1 > traccia2) {
			System.out.println("l'album " + cd1.getTitolo() + " ha la durata maggiore");
		} else {
			System.out.println("l'album " + cd2.getTitolo() + " ha la durata maggiore");
		}
	}
}
