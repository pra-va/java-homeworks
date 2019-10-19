package lt.prava;

import java.util.ArrayList;

/**
 * This is Singleton class that works as a storage instance to store references
 * to all bank accounts that were created in this program.
 * 
 * @author pra-va
 *
 */
public class DispatcherSingleton {
	private static final DispatcherSingleton instance = new DispatcherSingleton();
	private static int sumOfAccounts = 0;
	private static ArrayList<Payable> userAccounts = new ArrayList<Payable>();

	private DispatcherSingleton() {
	};

	public static DispatcherSingleton getInstance() {
		return instance;
	}

	public static ArrayList<Payable> getUserAccounts() {
		return userAccounts;
	}

	public static void addAcount(Payable payableAccount) {
		userAccounts.add(payableAccount);
	}

	/**
	 * This method returns new account number (sumofAccounts incremented by one).
	 * 
	 * @return
	 */
	public static int getNewAccountNumber() {
		sumOfAccounts++;
		return sumOfAccounts;
	}

	/**
	 * This method will print all accounts.
	 */
	public static void printAllAccounts() {
		for (Payable account : userAccounts) {
			System.out.println("Account number: " + account.getAccountNumber() + ", account balance: "
					+ account.getBalance() + ", account owner: " + account.getOwnerName());
		}
	}

}
