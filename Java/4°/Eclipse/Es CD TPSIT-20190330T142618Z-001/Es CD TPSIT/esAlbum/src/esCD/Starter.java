package esCD;

public class Starter {
	
	static Cd[] album=new Cd[4];
	static private double media=0;
	
	public static void main(String [] args) {
		//album.add(new Cd("Highway to hell","ACDC",10,2460));
		/*album[0]=new Cd("Highway to hell","ACDC",10,2460);
		album[1]=new Cd("The Wall","Pink Floyd",26,4872);
		album[2]=new Cd("Blow up your video","ACDC",10,2580);
		album[3]=new Cd("All Kind Of Magic","Queen", 9,2442);
		for(int i=0; i<album.length; i++) {
			System.out.println(album[i].getAutore()+" "+album[i].getTitolo()+" "+album[i].getDurata());
			media=media+album[i].getDurata();
		}
		media=media/album.length;
		System.out.println("\nla durata media dei cd e di "+media+" secondi\n");
		ordinaCd();
		System.out.println("\ni Cd sono stati ordinati\n");
		for(int i=0; i<album.length; i++) {
			System.out.println(album[i].getAutore()+" "+album[i].getTitolo()+" "+album[i].getDurata());
		}
		*/
		Tutte.play();
	}
	
    static public void ordinaCd() {

        for(int i=0; i<album.length; i++) {
            boolean flag = false;
            for(int j = 0; j < album.length-1; j++) {
                if(album[j].getDurata()>album[j+1].getDurata()) {
                    int k = album[j].getDurata();
                    album[j].setDurata(album[j+1].getDurata());
                    album[j+1].setDurata(k);
                    flag=true;
                }
                
            }

            if(!flag) break;
        }
    }
    
}