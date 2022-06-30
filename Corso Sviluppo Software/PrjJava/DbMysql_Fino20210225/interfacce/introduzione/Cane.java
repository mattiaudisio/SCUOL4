package introduzione;

class Cane implements IAnimale, IPeso{

	@Override
	public void Parla() {
		// TODO Auto-generated method stub
		System.out.println("\nBau\n");
	}

	@Override
	public void Parla(boolean pVoceAlta) {
		// TODO Auto-generated method stub
		System.out.println("\nBau\n");
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

class Trota implements IAnimale{

	@Override
	public void Parla() {
		// TODO Auto-generated method stub
		System.out.println("\nBlob\n");		
	}

	@Override
	public void Parla(boolean pVoceAlta) {
		// TODO Auto-generated method stub
		System.out.println("\nBlob\n");
	}

}

class Pietra implements IPeso /*IAnimale*/{
	//@Override
	public void Parla() {
		// TODO Auto-generated method stub
		System.out.println("\nNon posso parlare\n");
	}
	
	//@Override
	public void Parla(boolean pVoceAlta) {
		// TODO Auto-generated method stub
		System.out.println("\nNon posso parlare\n");		
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