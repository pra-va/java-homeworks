package lt.prava;

/**
 * Passenger class extends from Human abstract class. Passenger is distinct from
 * human class because it implements flyable interface which allows user to buy
 * new ticket or for ticket to be removed.
 * 
 * @author pra-va
 *
 */
public class Passenger extends Human implements IsFlyable {
	private Ticket ticket;

	public Passenger(String name, int age, double money) {
		super(name, age, money);
	}

	@Override
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * This method is used for passenger object to obtain a ticket. In order to
	 * obtain it, passenger instance must have sufficient amount of money in their
	 * account. As soon as passenger buys new ticket, its price is deducted from
	 * his/her money account.
	 */
	@Override
	public void buyTicket(int distance, Airport from, Airport to) {
		if (super.getMoney() > Ticket.calculatePrice(distance)) {
			this.ticket = new Ticket(distance, from, to);
			super.deductMoney(this.ticket.getPrice());
			System.out.println("\n" + super.getName() + " bought a plane ticket from " + from.getName() + " to "
					+ to.getName() + " for " + this.ticket.getPrice());
		} else {
			System.out.println("\n" + super.getName() + " does not have enaught money!");
		}
	}

	/**
	 * This method is used to remove ticket from passenger when it arrives to his
	 * destination airport.
	 */
	@Override
	public void removeTicket() {
		this.ticket = null;
	}

}
