package lt.prava;

/**
 * This is airplane class. Its main purpose is to ship passenger objects from
 * airport a to airport b.
 * 
 * @author pra-va
 *
 */
public class Airplane {
	private String name;
	private int fitsNumberOfPassangers;
	private Passenger[] passangers;

	public Airplane(String name, int fitsNumberOfPassangers) {
		this.name = name;
		this.fitsNumberOfPassangers = fitsNumberOfPassangers;
		this.passangers = new Passenger[fitsNumberOfPassangers];
	}

	public String getName() {
		return name;
	}

	public int getFitsNumberOfPassangers() {
		return fitsNumberOfPassangers;
	}

	public Passenger[] getPassangers() {
		return this.passangers;
	}

	/**
	 * Method that ships passengers from one airport to another airport.
	 * 
	 * @param from
	 * @param to
	 */
	public void fly(Airport from, Airport to) {
		System.out.println("\nBoarding airplane flying to: " + to.getName());
		board(from, to);
		System.out.println("\nBoarding - compleate. Taking of.");
		unboardPassangers(to);
	}

	/**
	 * This method removes shipped passenger tickets, adds them to a new airport
	 * passengers list and removes their reference in this airplane object.
	 * 
	 * @param to
	 */
	private void unboardPassangers(Airport to) {
		System.out.println("\nEnd of flight. Unboarding passangers and removing their valid tickets.");
		for (int i = 0; i < passangers.length; i++) {
			if (this.passangers[i] != null) {
				this.passangers[i].removeTicket();
				to.addPassangers(this.passangers[i]);
			}
		}
		this.passangers = null;
	}

	/**
	 * Copy passengers from airport that they are flying from to airplane passengers
	 * list if they have appropriate ticket and there is still free space in
	 * airplanes passenger array.
	 * 
	 * @param from
	 * @param to
	 */
	private void board(Airport from, Airport to) {
		int passangerCounter = 0;
		for (int i = 0; i < from.getPassangers().length; i++) {
			if (from.getPassangers()[i].getTicket() != null && from.getPassangers()[i].getTicket().getTo().equals(to)
					&& passangerCounter + 1 < this.passangers.length) {
				this.passangers[passangerCounter] = from.getPassangers()[i];
				from.getPassangers()[i] = null;
				passangerCounter++;
			}
		}
		from.rearangePassangersList();
	}
}
