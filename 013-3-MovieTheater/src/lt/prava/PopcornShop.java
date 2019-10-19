package lt.prava;

public class PopcornShop extends Shop {

	private double price;

	public PopcornShop(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public void sellItem(Human buyer, Seans seans) {

	}

	public void sellItem(Human buyer) {
		if (buyer.deductMoney(price)) {
			System.out.println("Tasty popcorn!!! " + buyer.getName() + " likes it a lot!");
		} else {
			System.out.println("No money - no pop corn. Go get a real job!");
		}
	}

}
