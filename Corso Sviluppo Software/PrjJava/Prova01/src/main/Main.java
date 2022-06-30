package main;

import stampantiHP.*;

public class Main {

	public static void main(String[] args) {
		//----------------- HpLaser107
		HpLaser107 hpLaser107 = new HpLaser107();
		hpLaser107.accendiStampante();
		hpLaser107.inserisciCavo();
		//----------------- HpInkFast
		HpInkFast hpInkFast = new HpInkFast();
		hpInkFast.accendiStampante();
	}

}
