package ripasso2021_pom;

public final class ClsStringhe {

	//La differenza tra una variabile ed una costante e che la variabile posso cambaiarla quando voglio, la costante no
	//Per definire una costante devo mettere final
	private final double PI = 3.14;
	private double Ps = 3.14;	
	
	public int mtCicloFor() {
		String s = "Filippo";
		for (int i = 0; i <= s.length() - 1; i++) {
			char c = s.charAt(i);
			if(c == 'p'){
				break;
			}
			if(c != 'p'){
				break;
			}
			System.out.println(c);
		}
		return 0;
	}
	
	public char GetChar(int pValue) {
		String s = "Filippo";
		int i = 10 , i1 = 6;
		Ps = 20;
		
		System.out.println("PI: "+PI+"\tPs: "+Ps);
		
		switch(i) {
			case 1:
			{
				System.out.println("valore i è 1");
				break;
			}
			case 10:
			{
				System.out.println("valore i è 10");
				break;				
			}
			case 11:
			{
				System.out.println("valore i è 11");
				break;				
			}
			default:
			{
				System.out.println("valore i è "+1);
				break;				
			}				
		}
				
		if(i <= 6 || i > 16) {		
			System.out.println("Valore minore di i " + i);
		}else if(i1 <= 6 && i1 > 16) {		
			System.out.println("Valore minore di i1 " + i1);			
		}else if(s == "p") {
			System.out.println("Valore minore di i1 " + i1);			
		}else {
			System.out.println("Altro");
		}		
		char c = s.charAt(pValue);
		return c;
	}
	
	public void metodo01() {
		String s = "Filippo";
		char c = s.charAt(0);
		System.out.println(c);
	}
}