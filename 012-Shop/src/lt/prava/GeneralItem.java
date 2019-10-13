package lt.prava;

/**
 * General item class. It uses usual 21 % VAT tax.
 * 
 * @author pra-va
 *
 */
public class GeneralItem implements IItem {
	private String name;
	private double priceNoTaxEur;
	private final double TAX = 21.0;

	/**
	 * CONSTRUCTOR for Item class.
	 * 
	 * @param name          (of the item).
	 * @param priceNoTaxEur (of the item).
	 */
	public GeneralItem(String name, double priceNoTaxEur) {
		this.name = name;
		this.priceNoTaxEur = priceNoTaxEur;
	}

	/**
	 * 
	 * @return item name in String format
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return item price in EUR without taxes.
	 */
	@Override
	public double getPriceNoTaxEur() {
		return priceNoTaxEur;
	}

	/**
	 * 
	 * @return item price in EUR with taxes (21 % tax rate).
	 */
	@Override
	public double getPriceWithTaxEur() {
		return ShoppingCart.round(priceNoTaxEur * (TAX + 100) / 100);
	}

	/**
	 * 
	 * @param exchangeRate (EUR to USD).
	 * @return item price in USD without taxes.
	 */
	@Override
	public double getPriceNoTaxUSD(double exchangeRate) {
		return ShoppingCart.round(priceNoTaxEur * exchangeRate);
	}

	/**
	 * 
	 * @param exchangeRate (EUR to USD).
	 * @return item price in USD with taxes.
	 */
	@Override
	public double getPriceWithTaxUSD(double exchangeRate) {
		return ShoppingCart.round(getPriceWithTaxEur() * exchangeRate);
	}

}
