package lt.prava;

/**
 * Main (controller) class for shopping cart program. All prices are rounded to
 * two decimal places using static ShoppingCart.round(double number) method.
 * This method uses DecimalFormat class and RoundMode.UP. For example, if
 * certain item price after tax calculation would be 1.211, it is going to be
 * rounded to 1.22 so that the shop would not have expenses when rounding
 * fractional numbers.
 * 
 * @author pra-va
 *
 */
public class Shop {

	public static void main(String[] args) {
		IItem one = new GeneralItem("Duona", 0.88);
		IItem two = new GeneralItem("Kiausiniai", 1.22);
		IItem three = new GeneralItem("Pienas", 1.19);
		IItem four = new GeneralItem("Avokadas", 0.50);
		IItem five = new GeneralItem("Vytautas", 1.00);

		IItem six = new Medicine("Ibuprofen", 2.68);
		IItem seven = new Medicine("Vision Ace", 8.21);

		IItem eight = new PeriodicalPublicatoin("Vakaro Zinios", 0.45);
		IItem nine = new PeriodicalPublicatoin("Donaldas ir kiti", 2.21);

		ShoppingCart cart = new ShoppingCart(1.10);

		cart.addItem(one);
		cart.addItem(two);
		cart.addItem(three);
		cart.addItem(four);
		cart.addItem(five);
		cart.addItem(six);
		cart.addItem(seven);
		cart.addItem(eight);
		cart.addItem(nine);

		cart.printCart();
	}

}
