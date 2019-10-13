package lt.prava;

/**
 * Interface to implement for items in the shop. It needs to be used because
 * this way ShoppingCard becomes abstract and is able to accept not just certain
 * items, but items that are implementing IItem interface.
 * 
 * @author pra-va
 *
 */
public interface IItem {
	String getName();

	double getPriceNoTaxEur();

	double getPriceWithTaxEur();

	double getPriceNoTaxUSD(double exchangeRate);

	double getPriceWithTaxUSD(double exchangeRate);
}
