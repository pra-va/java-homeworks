package lt.pra_va;

import java.util.Scanner;

/**
 * Homework 9:
 * 1) checks if a triangle is steep;
 * 2) calculates discriminant;
 * 3) runs number guessing game;
 * 4) calculates y = 3x result using for loop, where x can be from 0 to 10;
 * 5) calculates y = 3x result using while loop, where x can be from 0 to 10;
 * 6) adds all numbers from 1 to 100 using for loop;
 * 7) adds all numbers from 1 to 100 using while loop;
 * 8) adds all numbers from 1 to 100 using do-while loop;
 * 9) prints all capital alphabet letters;
 * 10) prints multiplication table to console from 1 to 100.
 * 
 * @author pra-va
 *
 */
public class VisDarSintakse {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		arTrikampisStatus();
		
	}

	private static void arTrikampisStatus() {
		
		System.out.println("Enter triangle a, b and c sides separated by coma (\",\"):");
		// Read user input
		String input = scanner.next();
		
		// Split user input to string array.
		String[] inputToArray = input.split(",");
		
		// Create triangle sides.
		double a = 0.0;
		double b = 0.0;
		double c = 0.0;
		double[] doubleInputArray = new double[3];
		
		// Try to parse triangle sides to double format using Double wrapper classes.
		// Also, check if a, b and c sides of user input are higher than 0.
		try {
			a = Double.parseDouble(inputToArray[0]);
			b = Double.parseDouble(inputToArray[1]);
			c = Double.parseDouble(inputToArray[2]);
			if (a < 0 || b < 0 || c <0) {
				System.out.println("Wrong input detected. All triangle sides must be > 0!");
				return;
			}
			doubleInputArray[0] = a;
			doubleInputArray[1] = b;
			doubleInputArray[2] = c;
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
			// Exceptions will be caught, if user entered wrong amount of triangle sides, 
			// or words/letters instead of numbers.
			System.out.println("Failed to parese user input! Please try not to be retarded :D");
			return;
		}
		
		// Finding hypotenuse (longest side of triangle.
		int longestSideIndex = -1;
		double longestSideLenght = 0;
		for (int i = 0 ; i < doubleInputArray.length ; i++) {
			if (doubleInputArray[i] > longestSideLenght) {
				longestSideIndex = i;
				longestSideLenght = doubleInputArray[i];
			}
		}
	
		// Creating variable and adding squares of two triangle sides left without longest side.
		double noLongestSum = 0;
		for (int k = 0; k < doubleInputArray.length ; k++) {
			if (k != longestSideIndex) {
				noLongestSum = noLongestSum + (doubleInputArray[k] * doubleInputArray[k]);
			}
		}
		
		// Checking if square root of noLongestSum equals hypotenuse.
		if (Math.round(Math.sqrt(noLongestSum) * 100.0) / 100.0 == Math.round(longestSideLenght * 100.0) / 100.0) {
			System.out.println("Triangle is steep!");
		} else {
			System.out.println("Triangle is NOT STEEP!");
		}
	}
	
	

}
