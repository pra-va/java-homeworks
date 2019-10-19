package lt.prava;

/**
 * Shop objects main purpose is to sell single specialized item. For example:
 * pop corn, tickets etc.
 * 
 * @author pra-va
 *
 */
public abstract class Shop {
	private double itemPrice;

	public double getItemPrice() {
		return itemPrice;
	}

	public abstract void sellItem(Human buyer, Seans seans);

}
