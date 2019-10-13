package lt.prava;

/**
 * This is class for medicine items. It uses 5 % VAT tax rate.
 * 
 * @author pra-va
 *
 */
public class Medicine extends GeneralItem implements IItem {
	private final double TAX = 5.0;

	public Medicine(String name, double priceNoTaxEur) {
		super(name, priceNoTaxEur);
	}

	/**
	 * This method overrides TAX usage from parent class' 21 % to local 5 % VAT tax.
	 */
	@Override
	public double getPriceWithTaxEur() {
		return ShoppingCart.round(getPriceNoTaxEur() * (this.TAX + 100) / 100);
	}
}
