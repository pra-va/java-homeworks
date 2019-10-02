package lt.prava;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * Homework number 10: 1) create array of 100 elements with Random class or
 * Math.random method and sort it; 2) calculate Fibonacci sequence 120th member
 * which can not take more than 5 seconds. Create 2 integer arrays with length
 * of >= 20 and find their largest members average. Use Math.random method or
 * Random class to fill the arrays; 3) program creates 10 members array filled
 * with String type members (for example with names) and sorts in alphabet
 * order; 4) program, using quick sort algorithm for array with 50k members.
 * 
 * @author pra-va
 *
 */
public class Algorithms {

	public static void main(String[] args) {
//		createAndSortArray();
//		fibonachiSequance();
//		findTwoLargestAndAverageThem();
//		createAndSortStringArray();
		quickSortArray();

	}

	/**
	 * 1) create array of 100 elements with Random class or Math.random method and
	 * sort it.
	 */
	private static void createAndSortArray() {
		int[] intArray = new int[100];
		Random ranodm = new Random();
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = ranodm.nextInt(1000);
		}
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
	}

	/**
	 * 2) calculate Fibonacci sequence 120th member which can not take more than 5
	 * seconds. Since 120th member of Fibonacci sequence is larger than integer
	 * (MAX_VAL =2.147 * 10 ^9) variable type can handle, variable type of
	 * BigInteger has to be used. Three BigInteger variables are created. They are
	 * user with for loop to store current Fibonacci number as well as two previous
	 * Fibonacci sequence numbers as the sum of them is the current Fibonacci
	 * number.
	 * 
	 * NOTE: this method to find 120th Fibonacci number takes no longer than 3 ms on
	 * my computer
	 */
	private static void fibonachiSequance() {
		long methodStartTime = System.currentTimeMillis();
		// Initializing big integers.
		BigInteger twoNumbersBack = new BigInteger("0"); // F(n-2)
		BigInteger oneNumberBack = new BigInteger("1"); // F(n-1)
		BigInteger fibonacciNumber = new BigInteger("1");
		// Looping until current fibonacciNumber is 120th.
		for (int i = 3; i < 121; i++) {
			twoNumbersBack = oneNumberBack;
			oneNumberBack = fibonacciNumber;
			fibonacciNumber = twoNumbersBack.add(oneNumberBack);
		}
		// Printing Fibonacci number.
		System.out.println(fibonacciNumber.toString());
		long methodEndTime = System.currentTimeMillis();
		System.out
				.println("Finding 120th Fibonacci number took: " + (methodEndTime - methodStartTime) + " miliseconds.");
	}

	/**
	 * 2) Create 2 integer arrays with length of >= 20 and find their largest
	 * members average. Use Math.random method or Random class to fill the arrays.
	 */
	private static void findTwoLargestAndAverageThem() {
		// Creating arrays.
		int[] firstArray = new int[20];
		int[] secondArray = new int[20];
		// Use Random class to fill arrays and find their largest members average value.
		firstArray = fillArray(firstArray, 1000);
		secondArray = fillArray(secondArray, 1000);
		int averageOfLargestMembers = (findLargestMemberInArray(firstArray) + findLargestMemberInArray(secondArray))
				/ 2;
		System.out.println("Average value of largest arrays memers is: " + averageOfLargestMembers);
	}

	/**
	 * Method to fill the array of integers with random values using Random class.
	 * 
	 * @param intArrayToFill - any lenght array to be filled with random values.
	 * @return filled array.
	 */
	private static int[] fillArray(int[] intArrayToFill, int largestPossibleNumber) {
		Random random = new Random();
		for (int i = 0; i < intArrayToFill.length; i++) {
			intArrayToFill[i] = random.nextInt(largestPossibleNumber);
		}
		System.out.println(Arrays.toString(intArrayToFill));
		return intArrayToFill;
	}

	private static long[] fillArray(long[] longArrayToFill) {
		Random random = new Random();
		for (int i = 0; i < longArrayToFill.length; i++) {
			longArrayToFill[i] = random.nextLong();
		}
		return longArrayToFill;
	}

	/**
	 * This method is used to find largest member of int type array.
	 * 
	 * @param array - array to find the largest member from.
	 * @return int type largest member of array parameter.
	 */
	private static int findLargestMemberInArray(int[] array) {
		int largestMember = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > largestMember) {
				largestMember = array[i];
			}
		}
		return largestMember;
	}

	/**
	 * 3) program creates 10 members array filled with String type members (for
	 * example with names) and sorts in alphabet order. This method features two
	 * sorting algorithms: 1) from Arrays.sort method; 2) my own written bubble sort
	 * algorithm which is in the while loop. This loop will continue until there are
	 * no array member to swap in the method. Each member is individually checked to
	 * their next member by letters until the letters do not match. This is where
	 * the sort algorithm decides if members should be swapped or not (by ascII char
	 * values).
	 */
	private static void createAndSortStringArray() {
		String[] names = { "Algimantas", "Vaclav", "Gintare", "Aurelija", "Vilius", "Tomas", "Pranas", "Gintare",
				"Jone", "Giedrius" };
		// First and easy method to sort array.
//		Arrays.sort(names); 

		// My written sort algorithm.
		int numberOfSwaps = 1;
		while (numberOfSwaps > 0) {
			numberOfSwaps = 0;
			for (int i = 0, j = 1; j < names.length; i++, j++) {

				System.out.println("restart for loop");
				// 1) find the shorter comparable member length.
				int shorterLenght = 0;
				if (names[i].length() > names[j].length()) {
					shorterLenght = names[j].length();
				} else {
					shorterLenght = names[i].length();
				}
				// 2) compare their char values in lower case.
				for (int k = 0; k < shorterLenght; k++) {
					System.out.println("k = " + k);
					int firstMemberChar = names[i].toLowerCase().charAt(k);
					System.out.println("first member char: " + firstMemberChar);
					int secondMemberChar = names[j].toLowerCase().charAt(k);
					System.out.println("second member char: " + secondMemberChar);
					if (firstMemberChar == secondMemberChar) {
						System.out.println("continue with loop");
						continue;
					} else if (firstMemberChar < secondMemberChar) {
						System.out.println("break");
						break;
					} else if (firstMemberChar > secondMemberChar) {
						System.out.println("switch members");
						String temp = names[j];
						names[j] = names[i];
						names[i] = temp;
						numberOfSwaps++;
						break;
					}

				}
			}
		}
		System.out.println(Arrays.toString(names));
	}

	/**
	 * 4) program, using quick sort algorithm for array with 50k members. Also, this
	 * method is using earlier created fillArray(longArray) method.
	 */
	private static void quickSortArray() {
		long[] longArray = new long[50000];
		longArray = fillArray(longArray);
		Arrays.sort(longArray);
		for (long item : longArray) {
			System.out.println(item);
		}
	}

}