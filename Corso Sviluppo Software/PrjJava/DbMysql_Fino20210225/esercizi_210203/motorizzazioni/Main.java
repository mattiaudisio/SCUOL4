package motorizzazioni;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Automobile auto = new Automobile("Panda","Panda 500 Vintage","aF91cN");
		System.out.println("Targa: " + auto.getTarga()); 
		System.out.println("Marca: " + auto.getMarca()); 
		System.out.println("Modello: " + auto.getModello()); 
		System.out.println("Numero Posti: " + auto.getNumeroPosti()); 
		System.out.println(" "); 
		Moto moto = new Moto("Kawasaki","Turbo 800","aF91cN",900);
		System.out.println("Targa: " + moto.getTarga()); 
		System.out.println("Marca: " + moto.getMarca()); 
		System.out.println("Modello: " + moto.getModello()); 
		System.out.println("Cilindrata: " + moto.getCilindrata()); 
	}

}
