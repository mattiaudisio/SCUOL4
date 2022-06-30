package anonymousClass_Tester;

public abstract class ClasseAstratta {
	/*
	 * metodo astratto : dovr� essere implementato in classi figlie
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
				System.out.println("print implementazione classe anonima [Non c'� sto a cap� er senso (questa vita.. che un senso non c'� la)]");				
			}
			
		};
	}
}

class UfoRobot extends ClasseAstratta {

	@Override
	public void print() {
		System.out.println("Secondo Giuliano � giusto");
	}
}