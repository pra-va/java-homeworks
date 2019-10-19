package lt.prava;

/**
 * Ticket shop sells human object tickets. It extends from shop class which
 * contains all the variables needed for ticket shop to exist.
 * 
 * @author pra-va
 *
 */
public class TicketShop extends Shop {

	/**
	 * Method used to sell human object tickets.
	 */
	@Override
	public void sellItem(Human buyer, Seans seans) {
		for (int i = 0; i < seans.getSeats().length; i++) {
			if (!seans.getSeats()[i].isTaken()) {
				if (buyer.deductMoney(seans.getShowable().getTicketPrice())) {
					System.out.println("He just aquired new ticket for a movie.");
					seans.getSeats()[i].setTaken();
					buyer.assignTicket(new Ticket(seans));
					return;
				} else {
					System.out.println("His money account does not contain sufficient amount of money.");
					return;
				}
			}
		}
		System.out.println("All seats are taken!");
	}

}
