package esCD;

import java.io.BufferedReader;
import java.io.FileReader;

public class Tutte {
	static private int nRighe=0;
	public static void play() {
		try {
			FileReader f;
			f=new FileReader("QUA INSERISCO L'INDIRIZZO, IL FILE LO CARICO NELLA CARTELLA res");
			
			BufferedReader b;
			b=new BufferedReader(f);
			
			String s;
			
			while(true){
				s=b.readLine();
				if(s==null){
					break;	
				}
				nRighe++;
				
				System.out.println(nRighe+" "+s);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
