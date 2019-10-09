package lt.prava;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * Algorithmic problem solutions: 1) find the greatest common measure; 2) find
 * the least common multiple; 3) using given 10 member numbers array, create
 * largest possible number; 4) add two random arrays members to a new array; 5)
 * calculate selected word appearance in a given String.
 * 
 * @author pra-va
 *
 */
public class AlgorithmicProblemSolutions {

	// First array will be used for tasks 1, 2, 3, 4 and 5.
	private static int[] numbersFirstArray = new int[10];
	// Second array will be used for task 4.
	private static int[] numbersSecondArray = new int[19];

	public static void main(String[] args) {
		// Fill numbersFirstArray()
		fillIntArray(numbersFirstArray);
		fillIntArray(numbersSecondArray);
		// Print number arrays
		System.out.println(Arrays.toString(numbersFirstArray));
		System.out.println(Arrays.toString(numbersSecondArray));

		// Task number 5.
		String text = "The quick brown fox jumps over the lazy dog";
		String wordToCount = "the";

		// Activate one or more methods to get output array.
//		greatestCommonMeasure(numbersFirstArray);
//		leastCommonMultiple(numbersFirstArray);
//		returnLargestPossibleNumber(numbersFirstArray);
//		addTwoArrays(numbersFirstArray, numbersSecondArray);
		countRepeatingWord(text, wordToCount);
	}

	/**
	 * Fills array that is provided in parameters with random values (highest int
	 * value of 100).
	 * 
	 * @param numbersFirstArray
	 */
	private static void fillIntArray(int[] numbersArray) {
		Random random = new Random();
		for (int i = 0; i < numbersArray.length; i++) {
			numbersArray[i] = random.nextInt(100);
		}
	}

	/**
	 * 1) find the greatest common measure. Firstly - find smallest member of the
	 * provided array. Secondly - loop other list items looking if they divide from
	 * smallest member. If not - deduct 1 from smallest member and loop the provided
	 * array once again. Repeat, until common measure is found
	 * 
	 * @param numbersFirstArray
	 */
	private static void greatestCommonMeasure(int[] numbersArray) {
		// Check if numbers array has at least two members as this is a minimum members
		// to complete the task.
		if (numbersArray.length < 2) {
			System.out.println("Given numbers array must be at least two members long.");
			return;
		}

		// Create variable to store the largest common measure.
		int greatestComonMeasure = 0;

		// Create smallest array member and find it in parameter array.
		int smallestArrayMember = numbersArray[0];
		for (int i = 1; i < numbersArray.length; i++) {
			if (numbersArray[i] < smallestArrayMember) {
				smallestArrayMember = numbersArray[i];
			}
		}

		// Loop the numbersArray and check if smallestArrayMember is common measure. If
		// not - do smallestArrayMember-- and repeat.
		for (int i = smallestArrayMember; i > 0; i--) {
			int withRemainderTimes = 0;
			for (int j = 0; j < numbersArray.length; j++) {
				if (numbersArray[j] % i > 0) {
					withRemainderTimes++;
					break;
				}
			}
			if (withRemainderTimes == 0) {
				greatestComonMeasure = i;
				break;
			}
		}

		// Print the answer
		if (greatestComonMeasure == 0) {
			System.out.println("There is no greatest common measure.");
		} else {
			System.out.println("The greatest common measure is: " + greatestComonMeasure);
		}
	}

	/**
	 * 2) find the least common multiple. Find largest member. Multiply it from him
	 * self. After each multiplication, check if other members divide this number
	 * without remainder. If such member would have been found, this is least common
	 * multiple.
	 * 
	 * @param numbersArray
	 */
	private static void leastCommonMultiple(int[] numbersArray) {
		// Check if numbers array has at least two members as this is a minimum members
		// to complete the task.
		if (numbersArray.length < 2) {
			System.out.println("Given numbers array must be at least two members long.");
			return;
		}

		// Initialize new integer variable and find the largest numbersArray member.
		int largestMember = numbersArray[0];
		for (int i = 1; i < numbersArray.length; i++) {
			if (largestMember < numbersArray[i]) {
				largestMember = numbersArray[i];
			}
		}

		// Add largest member to itself (multiply by 2). Check if remainder of this
		// number divided by numbersArray members are zeros. If so - this number is the
		// least common multiplier.
		boolean leastCommonMultiplierFound = false;
		int leastCommonMultiplier = 0;
		while (!leastCommonMultiplierFound) {
			leastCommonMultiplier = leastCommonMultiplier + largestMember;
			int remainderNotZeroTimes = 0;
			for (int i = 0; i < numbersArray.length; i++) {
				if (numbersArray[i] == 0) {
					continue;
				}
				if (leastCommonMultiplier % numbersArray[i] > 0) {
					remainderNotZeroTimes++;
				}
			}
			if (remainderNotZeroTimes == 0) {
				leastCommonMultiplierFound = true;
			}
		}

		// Print out the answer.
		System.out.println("The least common multiplier is: " + leastCommonMultiplier);
	}

	/**
	 * 3) using given 10 member numbers array, create largest possible number.
	 * Convert numbersArray to stringArray. Create new array and add provided
	 * numbers one by one. Before entering new number into array, check all possible
	 * combinations with a new member of an array. When largest number is found,
	 * save it and continue iterating array until done. Rinse and repeat until all
	 * numbers from numbers String array are entered into their optimal places.
	 * 
	 * How new number finds its optimal place in new numbers array so that the
	 * combined number would be the largest possible number? We start with a new
	 * array with only one item. We add second item to new arrays end. We iterate
	 * this member thorough the list using bubble sort principal. After each switch
	 * we check if current new array in current order is higher than the highest
	 * current visited combination. If it is the case, we assign this list and its
	 * string representation to a largest possible array variable and its string
	 * representation. We continue until one iteration through list is complete. We
	 * take one more member from numbers provided and repeat same process until all
	 * provided members are in their optimal places.
	 * 
	 * 
	 * @param numbersArray
	 * @return largestPossibleCombination
	 */
	private static String returnLargestPossibleNumber(int[] numbersArray) {

		// Converting int[] numbersArray to String[] stringArray.
		String[] numbersStringArray = new String[numbersArray.length];
		for (int i = 0; i < numbersArray.length; i++) {
			numbersStringArray[i] = numbersArray[i] + "";
		}

		// Creating largest possible array list with size of 1 and its string
		// representation.
		String[] largestPossibleArray = new String[1];
		largestPossibleArray[0] = numbersStringArray[0];
		String largestPossibleCombination = "";

		// This loop will iterate through the list of provided and converted to string
		// array numbers. Members from numbersStringArray will be sent to a new array
		// one by one.
		for (int i = 1; i < numbersStringArray.length; i++) {
			// Creating new array for manipulation and its string representation.
			String[] manipulationArray = new String[largestPossibleArray.length + 1];
			String currentManipulationString = "";

			// These variables will be used to store current largest combination if such is
			// found for this iteration.
			String[] currentLargestCombination = new String[largestPossibleArray.length + 1];
			String currentLargestCombinationAsString = "";

			// Add all largestPossibleArray members to manipulation array. Also, add new
			// member from numbersStringArray.
			for (int j = 0; j < manipulationArray.length - 1; j++) {
				manipulationArray[j] = largestPossibleArray[j];
				currentLargestCombination[j] = largestPossibleArray[j];
				currentLargestCombinationAsString = currentLargestCombinationAsString + largestPossibleArray[j];
			}

			// Add new member from numbersStirngArray to manipulationArray,
			// currentLargestCombination and CurrentLargestCombinationAsString variables.
			manipulationArray[largestPossibleArray.length] = numbersStringArray[largestPossibleArray.length];
			currentLargestCombination[largestPossibleArray.length] = numbersStringArray[largestPossibleArray.length];
			currentLargestCombinationAsString = currentLargestCombinationAsString
					+ numbersStringArray[largestPossibleArray.length];
			currentManipulationString = currentLargestCombinationAsString;

			// This loop will look for a new optimal place for the new member. If such is
			// found, it will store it in currentLargestCombination variable and its String
			// representation. It uses bubble sort principle.
			for (int j = manipulationArray.length - 2, k = manipulationArray.length - 1; j >= 0; j--, k--) {
				String tmp = manipulationArray[j];
				manipulationArray[j] = manipulationArray[k];
				manipulationArray[k] = tmp;
				currentManipulationString = "";

				for (int l = 0; l < manipulationArray.length; l++) {
					currentManipulationString = currentManipulationString + manipulationArray[l];
				}

				BigInteger currentManipulationBiInt = new BigInteger(currentManipulationString);
				BigInteger currentLargestCombinationAsBigInt = new BigInteger(currentLargestCombinationAsString);

				if (currentManipulationBiInt.compareTo(currentLargestCombinationAsBigInt) > 0) {
					for (int l = 0; l < currentLargestCombination.length; l++) {
						currentLargestCombination[l] = manipulationArray[l];
					}
					currentLargestCombinationAsString = currentManipulationString;
				}
			}
			largestPossibleArray = currentLargestCombination;
			largestPossibleCombination = currentLargestCombinationAsString;
		}
		// Print out the answer and return it.
		System.out.println("Largest possible number from provided array is: " + largestPossibleCombination);
		return largestPossibleCombination;
	}

	/**
	 * 4) add two random arrays members to a new array. Firstly, length variables
	 * for arrays are created. Then, new sum array is created with the longer arrays
	 * length. First array is copied to a new sum array. Then second array is added
	 * to a new sum array. Answer is returned in console and as a return variable of
	 * the method.
	 * 
	 * @param firstNumbersArray
	 * @param secondNumbersArray
	 * @return first and second numbers array sum
	 */
	private static int[] addTwoArrays(int[] numbersFirstArray, int[] numbersSecondArray) {
		// Find the longer arrays length and create new array with this length.
		int firstLength = numbersFirstArray.length;
		int secondLength = numbersSecondArray.length;
		int longerArrayLength = 0;

		if (firstLength > secondLength) {
			longerArrayLength = firstLength;
		} else {
			longerArrayLength = secondLength;
		}

		int[] sumArray = new int[longerArrayLength];

		for (int i = 0; i < firstLength; i++) {
			sumArray[i] = numbersFirstArray[i];
		}

		for (int i = 0; i < secondLength; i++) {
			sumArray[i] = sumArray[i] + numbersSecondArray[i];
		}

		System.out.println(Arrays.toString(sumArray));

		return sumArray;
	}

	/**
	 * 5) calculate selected word appearance in a given String. Provided text is
	 * converted to lower case. Then the sameLettersFound variable is created. If
	 * same as wordToCount character sequence would be found, it is going to be
	 * stored in this variable. The provided text is looped letter by letter. If
	 * same letter is found as in word program is looking for, it is going to be
	 * stored in sameLettersFound variable. If next letter is also same as in the
	 * word that program is looking for, once again this letter is going to be
	 * stored in sameLettersFound variable. If next letter would appear to be not
	 * the same as program is looking for, sameLettersFound and iterators are wiped
	 * and reset to zero values. After each loop iteration, program will check if
	 * sameLettersFound variable equals the word user provided to look for. If so,
	 * wordFoundCounter is increased and sameLettersFound as well as iterator are
	 * reset to zero values.
	 * 
	 * @param text
	 * @param wordToCount
	 * @return
	 */
	private static int countRepeatingWord(String text, String wordToCount) {
		String sameLettersFound = "";
		String textLowerCase = text.toLowerCase();
		int wordToCountIterator = 0;
		int wordFoundCounter = 0;
		for (int i = 0; i < textLowerCase.length(); i++) {
			if (textLowerCase.charAt(i) == wordToCount.charAt(wordToCountIterator)) {
				sameLettersFound += textLowerCase.charAt(i);
				wordToCountIterator++;
			} else {
				sameLettersFound = "";
				wordToCountIterator = 0;
				continue;
			}

			if (sameLettersFound.equals(wordToCount)) {
				wordFoundCounter++;
				sameLettersFound = "";
				wordToCountIterator = 0;
			}
		}

		// Easy peasy cheaty breazy method.
//		String lowerCaseText = text.toLowerCase();
//		System.out.println(lowerCaseText);
//		String[] textArray = lowerCaseText.split(" ");
//		int counter = 0;
//		for (int i = 0; i < textArray.length; i++) {
//			if (textArray[i].contains(wordToCount)) {
//				System.out.println("found at " + i);
//				counter++;
//			}
//		}

		System.out.println("Word \"" + wordToCount + "\" appears: " + wordFoundCounter + " time/times.");
		return wordFoundCounter;
	}
}
