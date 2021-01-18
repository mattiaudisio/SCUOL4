package esCD;

public class Start3 {
	public static void main(String [] args) {
		String elencoCD[];
		String CD[]={"The Poison","Musica per bambini","Mutter","Smells Like children","The Black Parade","Il sogno del gorilla bianco","Follow the leader","Master of Puppets","Habemus Capa","Automatic for the people"};
		String Artisti[]={"Bullet For My Valentine","Rancore","Rammstein","Marilyn Manson","My Chemical Romance","Tre Allegri Ragazzi Morti","Korn","Metallica","Caparezza","R.E.M"};
		int Tracce[]= {13,10,11,16,14,13,14,8,20,12};
		int Durata[]= {3206,2558,2694,3292,3117,2140,4201,3285,3544,2932};
				
		for(int i=0;i<CD.length; i=i+1){
			System.out.println(CD[i]);
			System.out.println(Artisti[i]);
			System.out.println(Tracce[i]);
			System.out.print(Durata[i]);
			System.out.println("\n");
		}
		
		boolean flag=true;
		while(flag==true){
			flag=false;
			for(int i=0; i<Durata.length-1; i=i+1){
				if(Durata[i]>Durata[i+1]){
					//Scambia Durata
					int k=Durata[i];
					Durata[i]=Durata[i+1];
					Durata[i+1]=k;					
					//Scambia Tracce
					k=Tracce[i];
					Tracce[i]=Tracce[i+1];
					Tracce[i+1]=k;
					//Scambia Artisti
					 String a=Artisti[i];
					Artisti[i]=Artisti[i+1];
					Artisti[i+1]=a;
					//Scambia Titoli
					a=CD[i];
					CD[i]=CD[i+1];
					CD[i+1]=a;
					flag=true;
				}
			}
		}

		System.out.println("\nElenco dei CD da quello che ha la durata minore a quello che ha a durata maggiore:");
		for(int i=0; i<CD.length;i=i+1){
			System.out.println(CD[i]);			
		}
	}
}
