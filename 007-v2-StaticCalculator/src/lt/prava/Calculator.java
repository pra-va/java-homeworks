package lt.prava;

public class Calculator {
	/**
	 * This method is used to get sum of two numbers.
	 */
	public static double add(double firstNumber, double secondNumber) {
		return round(firstNumber + secondNumber);
	}

	/**
	 * This method is used to get difference of two numbers.
	 */
	public static double substract(double firstNumber, double secondNumber) {
		return round(firstNumber - secondNumber);
	}

	/**
	 * This method is used to get product of two numbers.
	 */
	public static double multiply(double firstNumber, double secondNumber) {
		return round(firstNumber * secondNumber);
	}

	/**
	 * This method is used to get division result of two numbers.
	 */
	public static double divide(double firstNumber, double secondNumber) {
		return round(firstNumber / secondNumber);
	}

	/**
	 * This method is used to get a square root of a number.
	 */
	public static double squareRoot(double number) {
		return round(Math.sqrt(number));
	}

	/**
	 * This method is used to get a number squared.
	 */
	public static double squareTheNumber(double number) {
		return round(number * number);
	}

	/**
	 * This method does number raising to the power of n.
	 */
	public static double raiseToPower(double number, double power) {
		return round(Math.pow(number, power));
	}

	/**
	 * This method calculates sinus of a number.
	 */
	public static double sin(double number) {
		return round(Math.sin(number));
	}

	/**
	 * This method calculates cosinus of a number.
	 */
	public static double cos(double number) {
		return round(Math.cos(number));
	}

	/**
	 * This method calculates tangent of a number.
	 */
	public static double tan(double number) {
		return round(Math.tan(number));
	}

	/**
	 * This method calculates cotangent of a number.
	 */
	public static double ctg(double number) {
		double cotan = 1.0 / Math.atan(number);
		return round(cotan);
	}

	/**
	 * This method calculates remainder of two numbers.
	 */
	public static double remainder(double mainNumber, double dividerNumber) {
		return round(mainNumber % dividerNumber);
	}

	/**
	 * This method calculates percentage of two numbers.
	 */
	public static double percentage(double mainNumber, String operator, double percentNumber) {
		switch (operator) {
		case "+":
			return round(mainNumber + (mainNumber * percentNumber / 100));
		case "-":
			return round(mainNumber - (mainNumber * percentNumber / 100));
		case "*":
			return round(mainNumber * (mainNumber * percentNumber / 100));
		case "/":
			return round(mainNumber / (mainNumber * percentNumber / 100));
		}

		return 0.0;
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
