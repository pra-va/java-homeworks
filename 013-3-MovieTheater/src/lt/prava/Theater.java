package lt.prava;

/**
 * Theater is abstract class that movie theater (and possibly all other types of
 * theaters that have places) could be extended from. Theater object must have
 * ticket shop.
 * 
 * @author pra-va
 *
 */
public abstract class Theater {
	private Seat[] seats; // Row and place
	private TicketShop ticketShop;
	private TimeTable[] timetable;

	public Theater(int numberOfRows, int seatsPerRow) {
		this.ticketShop = new TicketShop();
		generateSeats(numberOfRows, seatsPerRow);
		generateTimeTable();
	}

	public Seat[] getSeats() {
		return seats;
	}

	public TicketShop getTicketShop() {
		return ticketShop;
	}

	public TimeTable[] getTimetable() {
		return timetable;
	}

	/**
	 * This method generates theater seats array.
	 * 
	 * @param numberOfRows
	 * @param numberOfSeats
	 */
	private void generateSeats(int numberOfRows, int numberOfSeats) {
		this.seats = new Seat[numberOfRows * numberOfSeats];
		char rowNumber = 'A';
		char seatNumber = 1;
		int seatCalculator = 0;
		for (int i = 1; i <= numberOfRows; i++) {
			for (int j = 1; j <= numberOfSeats; j++) {
				this.seats[seatCalculator] = new Seat(seatNumber, rowNumber);
				seatNumber++;
				seatCalculator++;
			}
			seatNumber = 1;
			rowNumber++;
		}
		System.out.println("Generator created " + seatCalculator + " seats in total.");
	}

	/**
	 * This method will generate time table array using TimeTable objects using
	 * length of 7 (one for each week day).
	 */
	private void generateTimeTable() {
		System.out.println("Generating time table for a theater.");
		this.timetable = new TimeTable[7];
		for (int i = 0; i < this.timetable.length; i++) {
			this.timetable[i] = new TimeTable();
		}
	}

	/**
	 * Initiates ticket shop object to sell ticket to a human object passed as a
	 * method parameter.
	 * 
	 * @param human
	 * @param seans
	 */
	public void sellTicket(Human human, Showable showable, int day) {
		// Checking if there is such seans as a human desires.

		for (int j = 0; j < 6; j++) {
			if (this.timetable[day - 1] != null && this.timetable[day - 1].getSeans()[j] != null) {
				if (this.timetable[day - 1].getSeans()[j].getShowable() == showable) {
					System.out.println(human.getName() + " buys a ticket.");
					this.ticketShop.sellItem(human, this.timetable[day - 1].getSeans()[j]);
					break;
				}
			}
		}

	}

	/**
	 * This method will print out theaters timetable of seanses.
	 */
	public void printTimetable() {
		System.out.println("Printing theater timetable.");
		for (int i = 0; i < timetable.length; i++) {
			System.out.println("Weekday " + (i + 1));
			for (int j = 0; j < timetable[i].getSeans().length; j++) {
				if (timetable[i].getSeans()[j] != null) {
					System.out.println(timetable[i].getSeans()[j].getShowable().getName());
				}
			}
		}
	}
}
