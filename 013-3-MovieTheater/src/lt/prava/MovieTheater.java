package lt.prava;

/**
 * Movie theater extends from theater class. It is used to setup movie theater
 * objects. Movie theater has unique shop field pop corn shop.
 * 
 * @author pra-va
 *
 */
public class MovieTheater extends Theater {
	private PopcornShop popcornShop;

	public MovieTheater(int numberOfRows, int seatsPerRow, double popcornPrice) {
		super(numberOfRows, seatsPerRow);
		this.popcornShop = new PopcornShop(popcornPrice);
	}

	public PopcornShop getPopcornShop() {
		return popcornShop;
	}

}
