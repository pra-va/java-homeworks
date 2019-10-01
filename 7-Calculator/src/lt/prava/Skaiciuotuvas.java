package lt.prava;

import java.util.Scanner;

/**
 * Calculator program which: 1) does arithmetical operations; 2) does number
 * squaring, raising to the power of n, rooting; 3) has trigonometry
 * functionality; 4) can calculate percentage; 5) can calculate remainder.
 * 
 * @author Pranas Varaneckas
 *
 */

public class Skaiciuotuvas {
	public static void main(String[] args) {
		run();
	}

	/**
	 * This is the main method responsible for running calculator program. In order
	 * to properly function it uses while loop. While variable runTheApp is true,
	 * the application will be running. As soon as this variable will become false -
	 * the application will be terminated.
	 */
	private static void run() {
		boolean runTheApp = true;
		welcomeRead();
		while (runTheApp) {
			System.out.println("Enter Your choice to continue:");
			String choice = readFromConcole();
			switch (choice) {
			case "1":
				arithmeticOperation();
				break;

			case "2":
				squarePowerRoot();
				break;

			case "3":
				trigonometry();
				break;

			case "4":
				calculatePercentage();
				break;

			case "5":
				calculateRemainder();
				break;

			case "6":
				welcomeRead();
				break;

			case "7":
				runTheApp = false;

			}
		}
	}

	/**
	 * Method to calculate a remainder of a number.
	 */
	private static void calculateRemainder() {
		double mainNumber = 0.0;
		double divisionNumber = 0.0;
		System.out.println("5. Remainder Calculator.");
		mainNumber = readAndParseNumber("Enter main number: ");
		divisionNumber = readAndParseNumber("Enter division: ");
		System.out.println("Answer: " + round(BasicOperations.remainder(mainNumber, divisionNumber)));
	}

	/**
	 * Method to calculate percentage.
	 */
	private static void calculatePercentage() {
		double mainNumber = 0.0;
		String operator = "";
		double percentageNumber = 0.0;
		System.out.println("4. Percentage Calculator.");
		mainNumber = readAndParseNumber("Enter main number: ");
		operator = readOperator();
		percentageNumber = readAndParseNumber("Enter percentage number:");
		System.out.println("Answer: " + round(BasicOperations.percentage(mainNumber, operator, percentageNumber)));
	}

	/**
	 * Thid method will calculate numbers within trigonometric functions.
	 */
	private static void trigonometry() {
		System.out.println("3. Trigonometry Calculator. Enter: sin, cos, tg or ctg:");
		String whichFunction = "";
		double number = 0.0;
		while (true) {
			whichFunction = readFromConcole();
			if (!whichFunction.equals("sin") && !whichFunction.equals("cos") && !whichFunction.equals("tg")
					&& !whichFunction.equals("ctg")) {
				System.out.println("I did not understand that. Please try to enter funcion one more time.");
				continue;
			}

			number = readAndParseNumber("Enter desired number: ");

			switch (whichFunction) {
			case "sin":
				System.out.println("Answer: " + round(BasicOperations.sin(number)));
				return;
			case "cos":
				System.out.println("Answer: " + round(BasicOperations.cos(number)));
				return;
			case "tg":
				System.out.println("Answer: " + round(BasicOperations.tan(number)));
				return;
			case "ctg":
				System.out.println("Answer: " + round(BasicOperations.ctg(number)));
				return;
			}
		}
	}

	/**
	 * This method will deal with squaring, increasing to power and rooting the
	 * number.
	 */
	private static void squarePowerRoot() {
		String choice = "";
		double number = 0.0;
		while (true) {
			System.out.println("2. Enter:\n" + "1 - to square number;\n"
					+ "2 - to raise number to a power of another number;\n" + "3 - to root the number.");
			choice = readFromConcole();
			switch (choice) {
			case "1":
				number = readAndParseNumber("Enter number to square:");
				System.out.println("Answer: " + round(BasicOperations.square(number)));
				return;
			case "2":
				number = readAndParseNumber("Enter main number to raise to power:");
				System.out.println("Raise to power of:");
				double power = readAndParseNumber("Enter power to raise the number " + number + ":");
				System.out.println("Answer: " + round(BasicOperations.raiseToPower(number, power)));
				return;
			case "3":
				number = readAndParseNumber("Enter number to root:");
				System.out.println("Answer: " + round(BasicOperations.sqrt(number)));
				return;
			}
			System.out.println("I did not understand that :( Can you repeat it?");
		}
	}

	/**
	 * This is controller method for arithmetic operations like: +, -, *, /.
	 */
	private static void arithmeticOperation() {
		System.out.println("1. Arithmetic Calculator.");
		double firstNumber = readAndParseNumber("Enter first number:");
		String operator = readOperator();
		double secondNumber = readAndParseNumber("Enter second number:");

		switch (operator) {
		case "/":
			if (secondNumber == 0) {
				System.out.println("You are not allowed to divide by 0!!!");
				return;
			}
			System.out.println("Answer:" + round(BasicOperations.divide(firstNumber, secondNumber)));
			return;
		case "*":
			System.out.println("Answer:" + round(BasicOperations.multiply(firstNumber, secondNumber)));
			return;
		case "-":
			System.out.println("Answer:" + round(BasicOperations.substract(firstNumber, secondNumber)));
			return;
		case "+":
			System.out.println("Answer:" + round(BasicOperations.add(firstNumber, secondNumber)));
			return;
		}
	}

	/**
	 * This method will read one single user entered number from console and will
	 * try to parse it as double. If user would enter number in bad format,
	 * exception will be handled accordingly. If the number will overflow double
	 * capacity, instead of processing further (parsing) "Infinity or "NaN", it will
	 * prompt user that calculator can not accept number that high. It will also
	 * provide prompts for user interaction.
	 *
	 * @param message will accept String parameter to prompt user with a message.
	 * @return double format number that has been red and parsed.
	 */
	private static double readAndParseNumber(String message) {
		System.out.println(message);
		String number = "";
		double doubleNumber = 0.0;
		while (true) {
			number = readFromConcole();
			try {
				doubleNumber = Double.parseDouble(number);
			} catch (NumberFormatException exception) {
				System.out.println("Format of the number you entered is wrong. Please repeat:");
				continue;
			}
			if (!Double.isInfinite(doubleNumber) && !Double.isNaN(doubleNumber)) {
				return doubleNumber;
			} else {
				System.out.println("I can not deal with number that precise!!!");
			}
		}
	}

	/**
	 * This method will read operator. It will also provide prompts for user
	 * interaction.
	 *
	 * @return Operator in String format.
	 */
	private static String readOperator() {
		System.out.println("Enter operator:");
		String operator = "";
		while (true) {
			operator = readFromConcole();
			if (operator.equals("/") || operator.equals("*") || operator.equals("-") || operator.equals("+")) {
				return operator;
			} else {
				System.out.println("I do not know this operator :( Please try entering it one more time:");
			}
		}

	}

	/**
	 * This method will print greeting message in the console.
	 */
	private static void welcomeRead() {
		System.out.println("Functionality:\n" + "1 - arithmetic operation;\n"
				+ "2 - squaring, raising a number to a power of n, root;\n" + "3 - trigonometry;\n"
				+ "4 - calculate percentage;\n" + "5 - calculate remainder;\n" + "6 - repeat commands;\n"
				+ "7 - quit.");
	}

	/**
	 * This method is responsible for reading user input. It will also trim spaces
	 * and will convert it to lower case.
	 * 
	 * @return User input in String format
	 */
	private static String readFromConcole() {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		userInput = userInput.trim().replace(" ", "").toLowerCase();
		return userInput;
	}

	/**
	 * This method will round number to 4 decimal places. Also this method will
	 * check if the number passed is infinity or not a number. In that case, it will
	 * throw warning to a user.
	 *
	 * @param value - Value to round to 4 decimal places.
	 * @return Rounded to 4 decimal places double format number.
	 *
	 */
	public static double round(double value) {
		double factor = (long) Math.pow(10, 4);
		value = value * factor;
		double tmp = Math.round(value);
		double theNumber = tmp / factor;
		if (Double.isNaN(theNumber) || Double.isInfinite(theNumber)) {
			System.out.println("WARNING! Answer is to large to process!!!");
		}
		return theNumber;
	}
}
