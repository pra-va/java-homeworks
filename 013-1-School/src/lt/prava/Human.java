package lt.prava;

/**
 * Human class that is main abstract class for other human entities in this
 * program.
 * 
 * @author pra-va
 *
 */
public abstract class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
