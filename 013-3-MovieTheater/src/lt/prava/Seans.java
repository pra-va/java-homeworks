package lt.prava;

/**
 * Seans objects are used in timetable. Each seans consists of movie that is
 * going to be shown and seats schema so human objects would be able to check
 * which seats are occupied and buy free space in theater.
 * 
 * @author pra-va
 *
 */
public class Seans {
	private Showable showable;
	private Seat[] seats;

	public Seans(Showable showable, Theater theater) {
		this.showable = showable;
		copySeats(theater);
	}

	private void copySeats(Theater theater) {
		this.seats = new Seat[theater.getSeats().length];
		for (int i = 0; i < seats.length; i++) {
			this.seats[i] = theater.getSeats()[i];
		}
	}

	public Showable getShowable() {
		return showable;
	}

	public Seat[] getSeats() {
		return seats;
	}

}
