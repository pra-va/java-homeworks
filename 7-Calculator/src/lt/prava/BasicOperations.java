package lt.prava;

public class BasicOperations {
	/**
	 * This method is used to get sum of two numbers.
	 */
	public static double add(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * This method is used to get difference of two numbers.
	 */
	public static double substract(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

	/**
	 * This method is used to get product of two numbers.
	 */
	public static double multiply(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}

	/**
	 * This method is used to get division result of two numbers.
	 */
	public static double divide(double firstNumber, double secondNumber) {
		return firstNumber / secondNumber;
	}

	/**
	 * This method is used to get a square root of a number.
	 */
	public static double sqrt(double number) {
		return Math.sqrt(number);
	}

	/**
	 * This method is used to get a number squared.
	 */
	public static double square(double number) {
		return number * number;
	}

	/**
	 * This method does number raising to the power of n.
	 */
	public static double raiseToPower(double number, double power) {
		return Math.pow(number, power);
	}

	/**
	 * This method calculates sinus of a number.
	 */
	public static double sin(double number) {
		return Math.sin(number);
	}

	/**
	 * This method calculates cosinus of a number.
	 */
	public static double cos(double number) {
		return Math.cos(number);
	}

	/**
	 * This method calculates tangent of a number.
	 */
	public static double tan(double number) {
		return Math.tan(number);
	}

	/**
	 * This method calculates cotangent of a number.
	 */
	public static double ctg(double number) {
		double cotan = 1.0 / Math.atan(number);
		return cotan;
	}

	/**
	 * This method calculates remainder of two numbers.
	 */
	public static double remainder(double mainNumber, double dividerNumber) {
		return mainNumber % dividerNumber;
	}

	/**
	 * This method calculates percentage of two numbers.
	 */
	public static double percentage(double mainNumber, String operator, double percentNumber) {
		switch (operator) {
		case "+":
			return mainNumber + (mainNumber * percentNumber / 100);
		case "-":
			return mainNumber - (mainNumber * percentNumber / 100);
		case "*":
			return mainNumber * (mainNumber * percentNumber / 100);
		case "/":
			return mainNumber / (mainNumber * percentNumber / 100);
		}

		return 0.0;
	}
	


}
