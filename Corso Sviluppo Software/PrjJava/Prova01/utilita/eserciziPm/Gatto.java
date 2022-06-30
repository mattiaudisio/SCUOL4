package eserciziPm;

public class Gatto extends Mammifero{

		public Gatto() {
			super.scriviNome("gatto");
			parla();
		}
		
		@Override
		public void parla() {
			System.out.println("Sto miagolando");
		}
}
