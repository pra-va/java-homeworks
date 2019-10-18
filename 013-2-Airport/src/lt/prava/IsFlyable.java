package lt.prava;

/**
 * Flyable interface to be used with human classes that can be passengers.
 * 
 * @author pra-va
 *
 */
public interface IsFlyable {

	Ticket getTicket();

	void buyTicket(int distance, Airport from, Airport to);

	void removeTicket();

}
