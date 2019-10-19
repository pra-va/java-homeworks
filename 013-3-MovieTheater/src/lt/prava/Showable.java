package lt.prava;

/**
 * Showable interface for things that can be shown in theaters: movies,
 * performances, shows...
 * 
 * @author pra-va
 *
 */
public interface Showable {
	String getType();

	String getName();

	double getTicketPrice();
}
