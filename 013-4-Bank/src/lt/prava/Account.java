package lt.prava;

/**
 * Bank account abstract class for debit and credit accounts to be extended
 * from.
 * 
 * @author pra-va
 *
 */
public abstract class Account {
	private double balance;
	private double[] history;
	private double allowedNegativeBalance;
	private int accountNumber;
	private String ownerName;

	public Account(double allowedNegativeBalance, String ownerName) {
		this.history = new double[0];
		this.allowedNegativeBalance = allowedNegativeBalance;
		this.ownerName = ownerName;
		this.accountNumber = DispatcherSingleton.getInstance().getNewAccountNumber();
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double[] getHistory() {
		return history;
	}

	public double getAllowedNegativeBalance() {
		return allowedNegativeBalance;
	}

	/**
	 * This method will add money to bank users account.
	 * 
	 * @param amount
	 */
	public void addMoney(double amount) {
		System.out.println("Adding " + amount + " to bank account for user " + this.ownerName + ", bank account id "
				+ this.accountNumber);
		this.balance += amount;
		addTransactionToHistory(amount);
	}

	/**
	 * This method will remove money from the account. It will be done ony if the
	 * balance is greater then the amount of money user is removing.
	 * 
	 * @param amount
	 * @return
	 */
	public double removeMoney(double amount) {
		if (this.balance + this.allowedNegativeBalance < amount) {
			System.out.println(
					"Unable to remove " + amount + " from user " + this.ownerName + ", id " + this.accountNumber);
			return 0.0;
		}
		this.balance -= amount;
		addTransactionToHistory(-amount);
		return amount;
	}

	/**
	 * Method prints transaction history.
	 */
	public void printHistory() {
		for (int i = 0; i < history.length; i++) {
			System.out.print(this.history[i] + " ");
		}
		System.out.println("\n");
	}

	/**
	 * This method is called upon when new transaction is being executed. The
	 * purpose of this method is to record new transaction to history array.
	 * 
	 * @param transaction
	 */
	private void addTransactionToHistory(double transaction) {
		double[] newTransactionArray = new double[this.history.length + 1];
		for (int i = 0; i < history.length; i++) {
			newTransactionArray[i] = this.history[i];
		}
		newTransactionArray[this.history.length] = transaction;
		this.history = newTransactionArray;
	}
}
