package program;

public class Calcoli {

	public double somma(double num1, double num2, double num3) {
		return num1 + num2 + num3;
	}
	
	public double somma(double[] num,int contatore) {
		//esegua la somma degli elementi di num da 0 a contatore -1
		//contatore 5
		//tornare elemento1+elemento2+elemento3+elemento4
		double somma = 0;
		for(int i = 0; i < contatore - 1; i++) {
			somma+=num[i];
		}
		return somma;
	}
	
}
