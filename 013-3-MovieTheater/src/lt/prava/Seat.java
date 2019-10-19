package lt.prava;

/**
 * Seat class for single seat object. The seat may have row character and seat
 * number. Also if ticket for particular seat is sold, seat should be
 * taken(isTaken = true);
 * 
 * @author pra-va
 *
 */
public class Seat {
	private int seat;
	private char row;
	private boolean isTaken;

	public Seat(int seat, char row) {
		super();
		this.seat = seat;
		this.row = row;
	}

	public int getSeat() {
		return seat;
	}

	public char getRow() {
		return row;
	}

	public boolean isTaken() {
		return isTaken;
	}

	/**
	 * This method is used to reserve seat if ticket for this seat is sold.
	 */
	public void setTaken() {
		this.isTaken = true;
	}

}
