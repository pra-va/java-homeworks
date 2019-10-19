package lt.prava;

/**
 * Ticket class is used as a validation mechanism to ensure that human really
 * bought a ticket to a show.
 * 
 * @author pra-va
 *
 */
public class Ticket implements Selable {

	private double price;
	private String showableName;
	private int theaterSeat;
	private char theaterRow;

	public Ticket(Seans seans) {
		this.price = seans.getShowable().getTicketPrice();
		this.showableName = seans.getShowable().getName();
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void assignSeat(Seat seat) {
		this.theaterRow = seat.getRow();
		this.theaterSeat = seat.getSeat();
	}

	public String getShowableName() {
		return showableName;
	}

	public int getTheaterSeat() {
		return theaterSeat;
	}

	public char getTheaterRow() {
		return theaterRow;
	}

}
