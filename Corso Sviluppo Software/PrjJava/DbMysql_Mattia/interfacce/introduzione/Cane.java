package introduzione;

class Cane implements IAnimale, IPeso{

	@Override
	public void Parla() {
		// TODO Auto-generated method stub
		System.out.println("Bau");
	}

	@Override
	public void Parla(boolean pVoceAlta) {
		// TODO Auto-generated method stub
		System.out.println("Baubau");
	}

	@Override
	public double getPeso() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPeso(double pPeso) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






class Trota implements IAnimale {

	@Override
	public void Parla() {
		// TODO Auto-generated method stub
		System.out.println("blob");
	}

	@Override
	public void Parla(boolean pVoceAlta) {
		// TODO Auto-generated method stub
		System.out.println("Blobblob");
	}

}

class Pietra implements IPeso{
	public void Parla() {
		System.out.println("non posso parlare");
	}
	
	public void Parla(boolean pVoceAlta) {
		// TODO Auto-generated method stub
		System.out.println("non posso parlare");
	}

	@Override
	public double getPeso() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPeso(double pPeso) {
		// TODO Auto-generated method stub
		
	}
}