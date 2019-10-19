package lt.prava;

/**
 * Movie class that implements Showable interface.
 * 
 * @author pra-va
 *
 */
public class Movie implements Showable {

	private String type; // Movie, theater etc
	private String name; // Name of the movie.
	private double ticketPrice;

	public Movie(String name, double ticketPrice) {
		this.type = "movie";
		this.name = name;
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getTicketPrice() {
		return this.ticketPrice;
	}

}
