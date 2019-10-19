package lt.prava;

/**
 * This interface is used to unify debit and credit banking accoutns.
 * 
 * @author pra-va
 *
 */
public interface Payable {

	double getAllowedNegativeBalance();

	void addMoney(double amount);

	double removeMoney(double amount);

	void sendMoney(double amount, int accountNumber);

	int getAccountNumber();

	double getBalance();

	public String getOwnerName();

}
