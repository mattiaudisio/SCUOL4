package tryCatchFInally;

public class TryCatchFinally {
	
	public static void main(String[] args) {
		esempio_01_NoCatch();
		esempio_01_Catch();
		System.out.println("\nProgramma Terminato\n");
	}
	
	//errore out of bounds
	private static void esempio_01_NoCatch() {
		int [] ar = new int[3];
		ar[0] = 2;
		ar[1] = 3;
		ar[2] = 4;
		for(int i = 0; i <= ar.length; i++) {
			System.out.println(ar[i]);
		}		
	}
	
	//intercetta errore out of bounds
	private static void esempio_01_Catch() {
		int [] ar = new int[3];
		ar[0] = 2;
		ar[1] = 3;
		ar[2] = 4;
		try {
			for(int i = 0; i <= ar.length; i++) {
				System.out.println(ar[i]);
			}					
		}catch (Exception e){
			System.out.println("\ndescrizione errore: "+e.getMessage());
		}

	}
}
