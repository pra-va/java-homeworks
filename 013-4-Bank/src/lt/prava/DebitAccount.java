package lt.prava;

/**
 * This object should be created for user account that wants to open debit
 * account.
 * 
 * @author pra-va
 *
 */
public class DebitAccount extends Account implements Payable {

	public DebitAccount(String ownerName) {
		super(0, ownerName);
	}

	/**
	 * Method used to transfer money between bank accounts.
	 */
	@Override
	public void sendMoney(double amount, int accountNumber) {
		for (Payable account : DispatcherSingleton.getInstance().getUserAccounts()) {
			if (account.getAccountNumber() == accountNumber) {
				account.addMoney(super.removeMoney(amount));
				break;
			}
		}
	}

}
