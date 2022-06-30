package anonymousClass_Tester;

public abstract class ClasseAstratta {
	/*
	 * metodo astratto : dovrà essere implementato in classi figlie
	 */
	public abstract void print();

	/*
	 * metodo normale di cui come al solito se si desidera le classi figlie possono
	 * fare Override
	 */
	public void read() {
		System.out.println("read di Classe astratta");
	}

	// ********** static main
	public static void main(String[] args) {
		UfoRobot ufinoRobottino = new UfoRobot();
		ufinoRobottino.print();
		
		ClasseAstratta Mazzinga = new ClasseAstratta() {

			@Override
			public void print() {
				System.out.println("print implementazione classe anonima [Non c'è sto a capì er senso (questa vita.. che un senso non c'è la)]");				
			}
			
		};
	}
}

class UfoRobot extends ClasseAstratta {

	@Override
	public void print() {
		System.out.println("Secondo Giuliano è giusto");
	}
}