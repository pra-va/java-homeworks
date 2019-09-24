package com.prava;

import java.util.Scanner;

/**
 * A simple console calculator to use with byte numbers
 * 
 * @author Pranas Varaneckas
 *
 */

public class ByteCalculator {
	public static void main(String[] args) {

		// First binary number.
		System.out.print("Enter first number in binary form: ");
		String firstString = reader();
		int firstInt = binaryToInteger(firstString);
		

		// Action.
		System.out.print("Enter action (+, -, *, / or cancel): ");
		String action = action();
		if (action.equals(null)) {
			return;
		}

		// Second binary number.
		System.out.print("Enter second number in binary form: ");
		String secondString = reader();
		int secondInt = binaryToInteger(secondString);

		// Calculate the answer.
		int answer = 0;
		switch (action) {
		case "+":
			answer = firstInt + secondInt;
			break;
		case "-":
			answer = firstInt - secondInt;
			break;
		case "*":
			answer = firstInt * secondInt;
			break;
		case "/":
			answer = firstInt / secondInt;
			break;
		}

		// Print the answer.
		System.out.println(firstInt + " (" + firstString + ") " + action + " " + secondInt + " (" + secondString
				+ ") = " + answer + " (" + Integer.toBinaryString(answer) + ")");
	}
	
	/**
	 * The method bellow will transform String with binary code to integer, using Integer.parseint
	 * method. In the scenario where first, or second String with binary code would have been
	 * filler incorrectly, exception needs to be handled.  
	 * 
	 * @param binaryString - String format of binary number
	 * @return integer converted from String
	 */
	public static int binaryToInteger(String binaryString) {
		try {
			return Integer.parseInt(binaryString, 2);
		} catch (NumberFormatException exception) {
			System.out.print("Format of the number is wrong!!! (" + binaryString + ")");
			return -1;
		}
	}
	

	/**
	 * This method will use java.util.Scanner class to read input from console.
	 * 
	 * @return Binary number as String
	 */
	public static String reader() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		return str;
	}

	/**
	 * This method will use reader method to scan user input and to obtain action
	 * which is going to be performed in calculations. The method will evaluate
	 * correctness of the input and will return proper action if proper input is
	 * provided.
	 * 
	 * @return action as String
	 */
	public static String action() {
		String action = "";
		while (true) {
			action = reader();
			if (action.equalsIgnoreCase("cancel")) {
				System.out.println("Terminating...");
				return null;
			} else if (action.equals("*") || action.equals("/") || action.equals("-")
					|| action.toString().equals("+")) {
				return action;
			}
		}
	}

}
