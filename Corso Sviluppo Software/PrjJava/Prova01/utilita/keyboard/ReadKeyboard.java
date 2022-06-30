package keyboard;

import java.util.Scanner;

import random.*;

public class ReadKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int rt, rt2, num;
//		rt = getValue();
//		rt = rt + 11;
//
//		Scanner scanner;
//		scanner = new Scanner(System.in);
//
//		System.out.println("\nIl numero inserito, sommato di 11, è: " + rt);
//		System.out.print("Inserire un numero: ");
//		num = scanner.nextInt();
//		rt2 = getValue01(num);
//		System.out.println("\nIl numero inserito, sommato al numero inserito prima, è: " + rt2);
		System.out.print("numero "+ReadRandom.getByMinMax(5,10));
	}

	public static int getValue() {
		// Metodo che torna un numero da tastiera
		Scanner scanner;
		scanner = new Scanner(System.in);
		System.out.print("Inserire un numero intero: ");
		return scanner.nextInt();
	}

	public static int getValue01(int num) {
		// Metodo che torna un numero da tastiera
		Scanner scanner;
		scanner = new Scanner(System.in);
		System.out.print("Inserire un numero intero: ");
		var rt = scanner.nextInt() + num;
		return rt;
	}

}
