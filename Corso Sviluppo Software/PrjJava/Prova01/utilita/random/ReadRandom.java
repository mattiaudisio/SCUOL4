package random;

import java.util.Random;

public class ReadRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getByMinMax(int min, int max) {
		Random random = new Random();
		return random.nextInt((max + 1 - min)) + min;
	}

}