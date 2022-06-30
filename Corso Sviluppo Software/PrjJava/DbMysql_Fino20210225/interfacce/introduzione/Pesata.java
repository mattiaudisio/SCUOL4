package introduzione;

public class Pesata {
	
	public static void main(String[] args) {
		Cane fido = new Cane();
		Trota nemo = new Trota();
		Pietra marmo = new Pietra();

		dammiPeso(fido);
		dammiPeso(marmo);
	}
	
	public static void dammiPeso(IPeso objPeso) {
	//	System.out.println(obj.getPeso);
		System.out.println(objPeso.getPeso());
	}
}
