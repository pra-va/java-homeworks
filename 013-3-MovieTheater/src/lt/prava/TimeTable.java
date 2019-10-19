package lt.prava;

/**
 * Time table class for single day. It has one field: a list of showable items.
 * The maximum number of showables per day is 5 because of movie or theater
 * length usually is around 2 hours. The object of this class can add showable
 * items using addShowable method.
 * 
 * @author pra-va
 *
 */
public class TimeTable {
	private Seans[] seans;

	public TimeTable() {
		this.seans = new Seans[6];
	}

	/**
	 * Method adds showable item to seans list.
	 * 
	 * @param showable
	 * @param theater
	 */
	public void addShowable(Showable showable, Theater theater) {
		for (int i = 0; i < this.seans.length; i++) {
			if (this.seans[i] == null) {
				this.seans[i] = new Seans(showable, theater);
				System.out.println("Adding " + showable.getType() + " " + showable.getName() + " to timetable.");
				return;
			}
		}
		System.out.println("Failed to add " + showable.getType() + " " + showable.getName()
				+ " to timetable, because it is full.");
	}

	public Seans[] getSeans() {
		return seans;
	}

}
