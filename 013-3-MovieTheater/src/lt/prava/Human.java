package lt.prava;

/**
 * Human class has three fields - String name, double money used for buying
 * things from shops and ticket that gets reference when this human buys a
 * ticket. It also has method to deduct money from money field if he buys
 * something from shop.
 * 
 * @author pra-va
 *
 */
public class Human {
	private String name;
	private double money;
	private Ticket ticket;

	public Human(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}

	/**
	 * This is method that is used to deduct money from human money account. If
	 * price for something that human is buying is to expensive, this method will
	 * return false. Else - true.
	 * 
	 * @param amount
	 * @return
	 */
	public boolean deductMoney(double amount) {
		if (amount <= this.money) {
			this.money -= amount;
			return true;
		} else {
			return false;
		}
	}

	public void assignTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getName() {
		return name;
	}

	public double getMoney() {
		return money;
	}

	@Override
	public String toString() {
		System.out.println(this.name + ": " + this.getMoney());
		return this.name + ": " + this.getMoney();
	}

}
