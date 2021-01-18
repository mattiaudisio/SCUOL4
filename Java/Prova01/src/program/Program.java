package program;

import java.util.ArrayList;
import provaClasseAstratta.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Animale a = new Animale();	  Un interfaccia non è instanziabile
		Gatto g = new Gatto();		 	//Adesso non è più una classe astratta quindi può essere istanziata
		Cane c = new Cane();
		Mammifero m = new Mammifero();
		Mammifero m1 = new Mammifero();
		Pesce p = new Pesce();
		Pesce p1 = new Pesce();

		g.verso();
		c.verso();

		ArrayList<AnimaleAcquatico> animali = new ArrayList<AnimaleAcquatico>(); 
		animali.add(m);
		animali.add(m1);
		animali.add(p);
		animali.add(p1);
		for(AnimaleAcquatico a: animali){	//foreach in JAVA
			a.respira();
		}

	}

}
