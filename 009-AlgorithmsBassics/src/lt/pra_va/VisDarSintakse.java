package lt.pra_va;

import java.util.Random;
import java.util.Scanner;

/**
 * Homework 9: 1) checks if a triangle is steep; 2) calculates discriminant; 3)
 * runs number guessing game; 4) calculates y = 3x result using for loop, where
 * x can be from 0 to 10; 5) calculates y = 3x result using while loop, where x
 * can be from 0 to 10; 6) adds all numbers from 1 to 100 using for loop; 7)
 * adds all numbers from 1 to 100 using while loop; 8) adds all numbers from 1
 * to 100 using do-while loop; 9) prints all capital alphabet letters; 10)
 * prints multiplication table to console from 1 to 100.
 * 
 * @author pra-va
 *
 */
public class VisDarSintakse {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//		isTriangleSteep();
//		calculateDiscriminant();
//		runNumberGuessingGame(100);
//		calculate3XForLoop();
//		calculate3XWhileLoop();
//		addAllForLoop(100);
//		addAllWhileLoop(100);
//		addAllDoWhileLoop(100);
//		printAllCappitalLetters();
		printMultiplicationTable();

	}

	/**
	 * 1) checks if a triangle is steep. Method reads user input in format [a,b,c].
	 * Triangle sides must be separated by comma. After reading user input, method
	 * tries to parse values and if the input is correct, stores it in a variables.
	 * This is where triangle sides are also validated if their length > 0. Next
	 * step is finding hypotenuse - the longest side of the steep triangle. Using
	 * for loop, two left-over sides are squared and added with each other in
	 * separate variable. If this variable is equal to squared hypotenuse, the the
	 * triangle is steep.
	 */
	private static void isTriangleSteep() {

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
			if (a < 0 || b < 0 || c < 0) {
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

		// Finding hypotenuse (longest side of triangle).
		int longestSideIndex = -1;
		double longestSideLenght = 0;
		for (int i = 0; i < doubleInputArray.length; i++) {
			if (doubleInputArray[i] > longestSideLenght) {
				longestSideIndex = i;
				longestSideLenght = doubleInputArray[i];
			}
		}

		// Creating variable and adding squares of two triangle sides left without
		// longest side.
		double noLongestSum = 0;
		for (int k = 0; k < doubleInputArray.length; k++) {
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

	/**
	 * 2) calculates discriminant. This method reads user input of discriminant
	 * parameters a, b, and c. If a > 0, method will calculate discriminant. Else,
	 * this method will warn user about earlier mentioned condition and will return
	 * out of the method.
	 */
	private static void calculateDiscriminant() {
		// Read user input about quadratic polynomial.
		System.out.println("Enter parameter a of ax2 + bx + c = 0:");
		double a = scanner.nextDouble();
		System.out.println("Enter parameter b of ax2 + bx + c = 0:");
		double b = scanner.nextDouble();
		System.out.println("Enter parameter c of ax2 + bx + c = 0:");
		double c = scanner.nextDouble();
		System.out.println("You entered " + a + "x^2 + " + b + "x + " + c + " = 0");
		// Check if a != 0. If true - calculate discriminant. Else print
		// warning and return out from the method.
		double discriminant = -1;
		if (a != 0) {
			discriminant = Math.round((b * b - 4 * a * c) * 100.0) / 100.0;
		} else {
			System.out.println("Parameter a in quadratic polynomial must be larger than zero.");
			return;
		}
		// Print out the answer.
		System.out.println("Discriminant is: " + discriminant);
	}

	/**
	 * 3) runs number guessing game. This method runs numbers guessing game. Random
	 * number is generated. The user must try and guess it. If number is to large or
	 * to small - method will suggest user to guess higher of smaller. If the users
	 * guess is correct, the method will display how many times it took for user to
	 * get correct answer.
	 * 
	 * @param largestNumber
	 */
	private static void runNumberGuessingGame(int largestNumber) {
		// Create random class and generate random number with largest
		// possible number provided in parameters.
		Random random = new Random();
		int numberToGuess = random.nextInt(largestNumber);
		// Initializing game with while loop
		boolean gameOver = false;
		System.out.println("Welcome to numbers guessing game.");
		int guess = -1;
		int timesGuessed = 0;
		while (!gameOver) {
			System.out.println("Enter your guess:");
			guess = scanner.nextInt();
			if (guess > numberToGuess) {
				System.out.println("Your guess is to large.");
				timesGuessed++;
			} else if (guess < numberToGuess) {
				System.out.println("Your guess is to small.");
				timesGuessed++;
			} else if (guess == numberToGuess) {
				System.out.println(
						"Your answer is correct!!! It took you " + timesGuessed + " times to get the right answer.");
				gameOver = true;
			}
		}
	}

	/**
	 * 4) calculates y = 3x result using for loop, where x can be from 0 to 10;
	 */
	private static void calculate3XForLoop() {
		for (int i = 0; i < 11; i++) {
			System.out.println(3 + " * " + i + " = " + (3 * i));
		}
	}

	/**
	 * 5) calculates y = 3x result using while loop, where x can be from 0 to 10;
	 */
	private static void calculate3XWhileLoop() {
		int iterator = 0;
		while (iterator < 11) {
			System.out.println(3 + " * " + iterator + " = " + (3 * iterator));
			iterator++;
		}

	}

	/**
	 * 6) adds all numbers from 1 to 100 using for loop.
	 */
	private static void addAllForLoop(int iterateUntill) {
		int sum = 0;
		for (int i = 1; i < iterateUntill + 1; i++) {
			sum += i;
		}
		System.out.println("Final number: " + sum);
	}

	/**
	 * 7) adds all numbers from 1 to 100 using while loop.
	 */
	private static void addAllWhileLoop(int iterateUntill) {
		int sum = 0;
		int iterator = 1;
		while (iterator <= iterateUntill) {
			sum += iterator;
			iterator++;
		}
		System.out.println("Final number: " + sum);
	}

	/**
	 * 8) adds all numbers from 1 to 100 using do-while loop.
	 */
	private static void addAllDoWhileLoop(int iterateUntill) {
		int sum = 0;
		int iterator = 1;
		do {
			sum += iterator;
			iterator++;
		} while (iterator <= iterateUntill);
		System.out.println("Final number: " + sum);
	}

	/**
	 * 9) prints all capital alphabet characters.
	 */
	private static void printAllCappitalLetters() {
		int currentChar = 65; // [65 - 90]
		while (currentChar <= 90) {
			System.out.print((char) currentChar + " ");
			currentChar++;
		}
	}

	/**
	 * 10) prints multiplication table to console from 1 to 100.
	 */
	private static void printMultiplicationTable() {
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				System.out.printf("%15s", i + "*" + j + "=" + (i * j));
			}
			System.out.println();
		}

	}

}