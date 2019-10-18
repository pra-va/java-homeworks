package lt.prava;

/**
 * Human abstract class for passenger to extend from.
 * 
 * @author pra-va
 *
 */
public abstract class Human {
	private String name;
	private int age;
	private double money;

	public Human(String name, int age, double money) {
		this.name = name;
		this.age = age;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getMoney() {
		return money;
	}

	public void deductMoney(double amount) {
		this.money -= amount;
	}
}
