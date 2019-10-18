package lt.prava;

/**
 * This is the main class for airport program. This application consists of four
 * main components: airport, airplane, passenger and ticket classes.
 * 
 * @author pra-va
 *
 */
public class MainClass {

	public static void main(String[] args) {
		// Creating new passangers.
		Passenger one = new Passenger("Pranas", 21, 15152);
		Passenger two = new Passenger("Tomas", 20, -110);
		Passenger three = new Passenger("Antanas", 22, 1234);
		Passenger four = new Passenger("Ruta", 23, 1555);
		Passenger five = new Passenger("Gintare", 21, 32186);
		Passenger six = new Passenger("Monika", 22, 684);
		Passenger seven = new Passenger("Deivis", 23, 66666);

		// Creating new airports.
		Airport vln = new Airport("Vilnius");
		Airport ltn = new Airport("Luton");

		// Adding passengers to airport.
		vln.addPassangers(one, two, three, four, five);
		vln.addPassangers(six, seven);
		vln.printPassangers();

		// Users are buying tickets.
		one.buyTicket(2100, vln, ltn);
		two.buyTicket(2100, vln, ltn);
		three.buyTicket(2100, vln, ltn);
		four.buyTicket(2100, vln, ltn);
		five.buyTicket(2100, vln, ltn);
		six.buyTicket(2100, vln, ltn);
		seven.buyTicket(2100, vln, ltn);

		// Printing vln airport passengers.
		vln.printPassangers();

		// Creating new airplane.
		Airplane airbus = new Airplane("A150", 120);

		// Bringing passengers to destination airport.
		airbus.fly(vln, ltn);
		vln.printPassangers();

		// Printing ltn passengers list.
		ltn.printPassangers();

	}

}
