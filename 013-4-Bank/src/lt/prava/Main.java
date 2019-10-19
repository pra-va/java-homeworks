package lt.prava;

/**
 * Main class to run bank program.
 * 
 * NOTE only UserAccount objects should be initiated
 * 
 * @author pra-va
 *
 */
public class Main {
	public static void main(String[] args) {
		UserAccount accountOne = new UserAccount("Petras");
		accountOne.createNewCreditAccount();
		accountOne.getBankAccount(1).addMoney(10000.0);
		accountOne.getBankAccount(1).removeMoney(15000);
		accountOne.getBankAccount(1).getBalance();
		accountOne.printBalances();

		UserAccount accountTwo = new UserAccount("Vaclav");
		accountTwo.createNewDebitAccount();
		accountTwo.getBankAccount(2).addMoney(1000000);
		accountTwo.createNewDebitAccount();
		accountTwo.getBankAccount(3).addMoney(1000000);
		accountTwo.createNewDebitAccount();
		accountTwo.getBankAccount(4).addMoney(1000000);
		accountTwo.createNewDebitAccount();
		accountTwo.getBankAccount(5).addMoney(1000000);

		UserAccount accountThree = new UserAccount("Pranas");
		accountThree.createNewCreditAccount();
		accountThree.getBankAccount(1).sendMoney(5000, 2);

		DispatcherSingleton.getInstance().printAllAccounts();

	}
}
