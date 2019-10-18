package lt.prava;

/**
 * Airport class has two fields: name and passengers. Passengers field is array
 * of passenger instances. This is where passenger class instances are stored.
 * 
 * @author pra-va
 *
 */
public class Airport {
	private String name;
	private Passenger[] passengers;

	public Airport(String name) {
		this.name = name;
		this.passengers = new Passenger[0];
	}

	public String getName() {
		return name;
	}

	public Passenger[] getPassangers() {
		return passengers;
	}

	/**
	 * This method adds passengers to airport field.
	 * 
	 * @param passangers
	 */
	public void addPassangers(Passenger... passangers) {
		Passenger[] newPassangerArray = new Passenger[this.passengers.length + passangers.length];
		for (int i = 0; i < this.passengers.length; i++) {
			newPassangerArray[i] = this.passengers[i];
		}
		for (int i = this.passengers.length, j = 0; i < newPassangerArray.length; i++, j++) {
			newPassangerArray[i] = passangers[j];
		}
		this.passengers = newPassangerArray;
	}

	/**
	 * This method rearranges passengers array after users are boarded to airplane.
	 * It needs to be done to avoid null objects in passengers array.
	 */
	public void rearangePassangersList() {
		int passangersNotNull = 0;
		for (int i = 0; i < passengers.length; i++) {
			if (this.passengers[i] != null) {
				passangersNotNull++;
			}
		}
		Passenger[] passangersRearanged = new Passenger[passangersNotNull];
		for (int i = 0, j = 0; i < passengers.length; i++) {
			if (this.passengers[i] != null) {
				passangersRearanged[j] = this.passengers[i];
				j++;
			}
		}
		this.passengers = passangersRearanged;
	}

	/**
	 * Prints passengers array.
	 */
	public void printPassangers() {
		System.out.println("\nPrinting airport passanger list waiting to get a ticket or departure.");
		for (int i = 0; i < passengers.length; i++) {
			System.out.println(this.passengers[i].getName() + " " + this.passengers[i].getMoney());
		}
	}

}
