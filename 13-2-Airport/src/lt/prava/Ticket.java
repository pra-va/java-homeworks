package lt.prava;

/**
 * Ticket class. Passengers buy tickets for their money. Ticket class has two
 * methods do calculate price: static method calculatePrice and get price which
 * returns ticket price. Also, ticket has two fields: Airport from and Airport
 * to.
 * 
 * @author pra-va
 *
 */
public class Ticket {
	private Airport from;
	private Airport to;
	private double price;

	public Ticket(int distanceToTravel, Airport from, Airport to) {
		this.from = from;
		this.to = to;
		this.price = distanceToTravel * 0.05;
	}

	public Airport getFrom() {
		return from;
	}

	public Airport getTo() {
		return to;
	}

	public double getPrice() {
		return price;
	}

	public static double calculatePrice(int distance) {
		return distance * 0.05;
	}

}
