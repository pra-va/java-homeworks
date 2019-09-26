package com.prava;

/**
 * Programa, demonstruojanti Java kalbos
 * kintamųjų sintaksę.
 * @author pra-va
 *
 */

public class Sintakse {

	public static void main(String[] args) {
		/**
		 * 1. Apibrėžti kintamuosius.
		 */
		
		// byte - nuo -128 iki 127
		byte myByte = -128;
		
		// short - -32768 - 32767 
		short myShort = 32767;
		
		// int
		int myInt = 1685431325;
		
		// long
		long myLong = 321698783;
		
		// float
		float myFloat = 0.1625163f;
		
		// double
		double myDouble = 0.0005456;
		
		// boolean
		boolean myBoolean = false;
		
		// char
		char myChar = 'C';
		
		/**
		 * 2. Atspausdinti kintamuosius komandinėje eilutėje.
		 */
		System.out.println(myByte + " " + myShort + " " + myInt + " " + myLong + " " + myFloat + " " + myDouble + " " + myBoolean + " " + myChar);
		
		/**
		 * 3. Įvykdyti veiksmus su kintamaisiais.
		 */
		// byte
		System.out.println("\nByte:");
		myByte += 128;
		System.out.println(myByte);
		
		// int
		System.out.println("\nInt:");
		int a = 10, b = 5;
		System.out.println("a + b = " + (a + b));
		System.out.println("a - b = " + (a - b));
		System.out.println("a / b = " + (a / b));
		System.out.println("a * b = " + (a * b));
		System.out.println("a % b = " + (a % b));
		System.out.println("a++: " + a++);
		System.out.println("a = " + a);
		System.out.println("--b: " + --b);
		System.out.println("b = " + b);
		
		// long
		System.out.println("");
		long ilgasPirmas = 468543, ilgasAntras = -11155;
		System.out.println("ilgasPirmas + ilgasAntras = " + (ilgasPirmas + ilgasAntras));
		System.out.println("ilgasPirmas - ilgasAntras = " + (ilgasPirmas - ilgasAntras));
		System.out.println("ilgasPirmas / ilgasAntras = " + (ilgasPirmas / ilgasAntras));
		System.out.println("ilgasPirmas * ilgasAntras = " + (ilgasPirmas * ilgasAntras));
		
		// boolean
		System.out.println("");
		boolean tiesa = true;
		boolean melas = false;
		System.out.println("!tiesa: " + ! tiesa);
		System.out.println("tiesa | melas: " + (tiesa | melas));
		System.out.println("tiesa & melas: " + (tiesa & melas));
		System.out.println("tiesa ^ melas: " + (tiesa ^ melas));
		System.out.println("melas ^ tiesa : " + (melas ^ tiesa));
		System.out.println("tiesa && melas: " + (tiesa && melas));
		
		// char
		System.out.println("");
		char koduotas = '\u03A9';
		System.out.println(koduotas);
		char raide = 'a';
		char naujaEilute = '\n';
		System.out.print(naujaEilute);
		System.out.println(raide);
		
		/**
		 * 4. Panaudoti objekto skaitinius ir
		 * vietinius kintamuosius.
		 */
		
		// Sukuriame klasės dviratis naujas instancijas.
		Dviratis canondale = new Dviratis("Scalpel");
		Dviratis cube = new Dviratis("Atention");
		Dviratis unibike = new Dviratis("Flite 29");
		
		// Atspausdiname dviraciu info
		System.out.println("\nDviračiai");
		System.out.println(canondale.getModelis() + " " + canondale.getPagaminta() + " " + canondale.getPavaruSkaicius());
		System.out.println(cube.getModelis() + " " + cube.getPagaminta() + " " + cube.getPavaruSkaicius());
		System.out.println(unibike.getModelis() + " " + unibike.getPagaminta() + " " + unibike.getPavaruSkaicius());
		
		/**
		 * 5. Panaudoti specialius simbolius String'e.
		 */
		System.out.println("\tŠiame String simbolyje pavaizduosiu specialis simbolius.\n"
				+ "Tekstas iš naujos eilutės. \u03A9 - specialus simbolis. Vydūno \"Raštai\".");
		
		/**
		 * 6. Pademonstruoti įvairių tipų (ne tik matematinių)
		 * operatorių eiliškumo tvarką.
		 */
		System.out.println("\nOperatorių eiliškumas.");
		int x =  1 + 3 * (2 + 1);
		System.out.println("x = " + x);
		boolean kazkas = true & (false | true) | !true;
		System.out.println(kazkas);
		
		/**
		 * 7. Pademonstruoti, kaip kelių tipų kintamieji gali būti panaudoti viename reiškinyje.
		 *
		 */
		System.out.println("\nKeletas skirtingu kintamuju");
		int pirmasInt = 15151;
		long antrasLong = 135145315;
		int trecias = pirmasInt + (int) antrasLong;
		System.out.println(trecias);
		
		float foatKitur = 0.0054854f;
		double atsakymas = 15328d + foatKitur;
		System.out.println(atsakymas);
		
		
	
	}

}




































