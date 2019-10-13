package lt.prava;

/**
 * This is class for periodical publication items. It uses 9 % VAT tax rate.
 * 
 * @author pra-va
 *
 */
public class PeriodicalPublicatoin extends GeneralItem implements IItem {
	private final double TAX = 9.0;

	public PeriodicalPublicatoin(String name, double priceNoTaxEur) {
		super(name, priceNoTaxEur);
	}

	/**
	 * This method overrides TAX usage from parent class' 21 % to local 9 % VAT tax.
	 */
	@Override
	public double getPriceWithTaxEur() {
		return ShoppingCart.round(getPriceNoTaxEur() * (this.TAX + 100) / 100);
	}

}
