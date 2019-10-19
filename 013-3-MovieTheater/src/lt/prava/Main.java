package lt.prava;

public class Main {
	public static void main(String[] args) {
		MovieTheater theater = new MovieTheater(10, 25, 3.95);

		Human one = new Human("Tomas", 100.0);
		Human two = new Human("Vaclav", 1000000.0);
		Human three = new Human("Pranas", -500.0);

		Movie movieOne = new Movie("Interstellar", 10.2);
		Movie movieTwo = new Movie("Martian", 10.2);

		theater.getTimetable()[0].addShowable(movieOne, theater);
		theater.getTimetable()[1].addShowable(movieOne, theater);
		theater.getTimetable()[2].addShowable(movieOne, theater);
		theater.getTimetable()[3].addShowable(movieOne, theater);
		theater.getTimetable()[4].addShowable(movieOne, theater);
		theater.getTimetable()[5].addShowable(movieOne, theater);

		theater.getTimetable()[0].addShowable(movieTwo, theater);
		theater.getTimetable()[1].addShowable(movieTwo, theater);
		theater.getTimetable()[2].addShowable(movieTwo, theater);
		theater.getTimetable()[3].addShowable(movieTwo, theater);

		theater.printTimetable();

		one.toString();
		two.toString();
		three.toString();

		theater.sellTicket(one, movieOne, 1);
		theater.sellTicket(two, movieOne, 1);
		theater.sellTicket(three, movieOne, 1);

		one.toString();
		two.toString();
		three.toString();

		theater.getPopcornShop().sellItem(one);
		theater.getPopcornShop().sellItem(three);

		one.toString();
		two.toString();
		three.toString();
	}
}
