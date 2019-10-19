package lt.prava;

/**
 * This is method to store users payment accounts. User is allowed to create 5
 * payment accounts in total: 1 credit and 4 debit. Regarding Payable[] accounts
 * array, the 0th member is always reserved for credit account, while other 4
 * places are for debit accounts.
 * 
 * @author pra-va
 *
 */
public class UserAccount {
	private Payable[] accounts;
	private String ownerName;

	public UserAccount(String ownerName) {
		this.accounts = new Payable[5];
		this.ownerName = ownerName;
	}

	public Payable[] getAccounts() {
		return accounts;
	}

	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Method will create new debit account if there are less than 5 debit accounts
	 * in array.
	 */
	public void createNewDebitAccount() {
		for (int i = 1; i <= this.accounts.length; i++) {
			if (this.accounts[i] == null) {
				this.accounts[i] = new DebitAccount(this.ownerName);
				System.out.println("Creating new debit account.");
				DispatcherSingleton.getInstance().addAcount(this.accounts[i]);
				return;
			}
		}
		System.out.println("Unable to create another debit account. User already has 4 debit accounts.");
	}

	/**
	 * Method will create credit account if such does not exist in accounts array.
	 */
	public void createNewCreditAccount() {
		if (this.accounts[0] == null) {
			this.accounts[0] = new CreditAccount(5000, this.ownerName);
			System.out.println("Creating new debit account with available 5000 credit.");
			DispatcherSingleton.getInstance().addAcount(this.accounts[0]);
		} else {
			System.out.println("User already has a credit account.");
		}
	}

	/**
	 * Will return bank account by number from payable accounts array.
	 * 
	 * @param number - 1-5 depending on which account user wants to get.
	 * @return
	 */
	public Payable getBankAccount(int number) {
		return this.accounts[number - 1];
	}

	public void printBalances() {
		for (int i = 0; i < accounts.length; i++) {
			if (this.accounts[i] != null) {
				System.out.println((i + 1) + ". " + accounts[i].getBalance());
			}
		}
	}

}
