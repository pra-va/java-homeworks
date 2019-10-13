package lt.prava;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Shopping cart class for shop program.
 * 
 * @author pra-va
 *
 */
public class ShoppingCart {
	IItem[] items;
	double exchangeRate;

	/**
	 * Constructor for ShoppingCart class. When the object from this class is
	 * created, it will automatically create items array.
	 * 
	 * @param currentEURtoUSDExchangeRate - current exchange rate at the moment (EUR
	 *                                    TO USD).
	 */
	public ShoppingCart(double currentEURtoUSDExchangeRate) {
		items = new IItem[0];
		this.exchangeRate = currentEURtoUSDExchangeRate;
	}

	/**
	 * Method to add extra item to shopping carts items list.
	 * 
	 * @param item
	 */
	public void addItem(IItem item) {
		IItem[] newItems = new GeneralItem[this.items.length + 1];
		for (int i = 0; i < newItems.length - 1; i++) {
			newItems[i] = items[i];
		}
		newItems[this.items.length] = item;
		this.items = newItems;
	}

	/**
	 * EUR VERSION. This method will call appropriate shopping cart price
	 * calculator.
	 * 
	 * @param withTAX if true - will calculate price with taxes. Otherwise - it will
	 *                calculate price without taxes.
	 * @return price of shopping cart.
	 */
	public double calculatePriceEur(boolean withTAX) {
		if (withTAX) {
			return round(calculateCartPriceEurWithTax());
		} else {
			return round(calculateCartPriceEurNoTax());
		}
	}

	/**
	 * USD VERSION. This method will call appropriate shopping cart price
	 * calculator.
	 * 
	 * @param withTAX if true - will calculate price with taxes. Otherwise - it will
	 *                calculate price without taxes.
	 * @return price of shopping cart.
	 */
	public double calculatePriceUSD(boolean withTAX) {
		if (withTAX) {
			return round(calculateCartPriceUSDWithTax());
		} else {
			return round(calculateCartPriceUSDNoTax());
		}
	}

	/**
	 * Method to be called from calculatePriceEur(boolean withTAX) method.
	 * 
	 * @return total price of shopping cart in EUR WITH TAX.
	 */
	private double calculateCartPriceEurWithTax() {
		double price = 0.0;
		for (int i = 0; i < items.length; i++) {

			price += items[i].getPriceWithTaxEur();
		}
		return price;
	}

	/**
	 * Method to be called from calculatePriceEur(boolean withTAX) method.
	 * 
	 * @return total price of shopping cart in EUR WITHOUT TAX.
	 */
	private double calculateCartPriceEurNoTax() {
		double price = 0.0;
		for (int i = 0; i < items.length; i++) {
			price += items[i].getPriceNoTaxEur();
		}
		return price;
	}

	/**
	 * Method to be called from calculatePriceUSD(boolean withTAX) method.
	 * 
	 * @return total price of shopping cart in USD WITH TAX.
	 */
	private double calculateCartPriceUSDWithTax() {
		double price = 0.0;
		for (int i = 0; i < items.length; i++) {
			price += items[i].getPriceWithTaxUSD(this.exchangeRate);
		}
		return price;
	}

	/**
	 * Method to be called from calculatePriceUSD(boolean withTAX) method.
	 * 
	 * @return total price of shopping cart in USD WITHOUT TAX.
	 */
	private double calculateCartPriceUSDNoTax() {
		double price = 0.0;
		for (int i = 0; i < items.length; i++) {
			price += items[i].getPriceNoTaxUSD(exchangeRate);
		}
		return price;
	}

	/**
	 * Method to print out shopping cart in format [ITEM_NAME: PRICE_EUR_WITH_TAX].
	 */
	public void printCart() {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].getName() + ": " + round(items[i].getPriceNoTaxEur()) + " EUR, "
					+ round(items[i].getPriceWithTaxEur()) + " EUR (WITH TAX)");
		}
	}

	/**
	 * Method rounds provided number as method parameter. Method uses DecimalFormat
	 * class. It rounds all numbers up.
	 * 
	 * @param number
	 * @return
	 */
	public static double round(double number) {
		DecimalFormat format = new DecimalFormat("#.##");
		format.setRoundingMode(RoundingMode.UP);
		return Double.parseDouble(format.format(number));
	}

}
