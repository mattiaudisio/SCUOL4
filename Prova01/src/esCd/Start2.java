package esCd;

public class Start2 {

	static CD[] album=new CD[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		album[0]= new CD("The Poison","Bullet For My Valentine",13,3206);
		album[1]=new CD("Musica per bambini","Rancore",10,2558);
		album[2]=new CD("Mutter","Rammstein",11,2694);
		album[3]=new CD("Smells Like children","Marilyn Manson",16,3292);
		album[4]=new CD("The Black Parade","My Chemical Romance",14,3117);
		album[5]=new CD("Il sogno del gorilla bianco","Tre Allegri Ragazzi Morti",13,2140);
		album[6]=new CD("Follow the leader","Korn",14,4201);
		album[7]=new CD("Master of Puppets","Metallica",8,3285);
		album[8]=new CD("Habemus Capa","Caparezza",20,3544);
		album[9]=new CD("Automatic for the people","R.E.M",12,2932);
		
		System.out.print("Elenco album\n\n");
		for(int i=0; i<album.length; i++){
			System.out.println(album[i].getAutore()+","+album[i].getTitolo()+","+album[i].getTracce()+","+album[i].getDurata());
		}
		
		boolean flag=true;
		while(flag==true){
			flag=false;
			for(int i=0; i<album.length-1; i=i+1){
				if(album[i].getDurata()>album[i+1].getDurata()){
					//Scambia Durata
					int k=album[i].getDurata();
					album[i].setDurata(album[i+1].getDurata());
					album[i+1].setDurata(k);					
					//Scambia Tracce
					k=album[i].getTracce();
					album[i].setTracce(album[i+1].getTracce());
					album[i+1].setTracce(k);
					//Scambia Artisti
					String a=album[i].getAutore();
					album[i].setAutore(album[i+1].getAutore());
					album[i+1].setAutore(a);
					//Scambia Titoli
					a=album[i].getTitolo();
					album[i].setTitolo(album[i+1].getTitolo());
					album[i+1].setTitolo(a);
					flag=true;
				}
			}
		}
		
        System.out.println("\nElenco ordinato\n");
		for(int i=0; i<album.length; i++) {
			System.out.println(album[i].getAutore()+","+album[i].getTitolo());
		}
	}
}
