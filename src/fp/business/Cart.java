package fp.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Ticket> tickets;
	
	public Cart() {
		tickets = new ArrayList<Ticket>();
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	public void removeTicket(String movieId, String showtimeId) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getMovieId().equals(movieId) && tickets.get(i).getShowtimeId().equals(showtimeId)) {
				tickets.remove(i);
				return;
			}
		}
	}
}
