package fp.business;

import java.io.Serializable;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	private String movieId;
	private String showtimeId;
	private String seats;
	
	public Ticket() {};
	public Ticket(String movieId, String showtimeId, String seats) {
		this.movieId = movieId;
		this.showtimeId = showtimeId;
		this.seats = seats;
	}
	
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public String getMovieId() {
		return movieId;
	}
	
	public void setShowtimeId(String showtimeId) {
		this.showtimeId = showtimeId;
	}
	
	public String getShowtimeId() {
		return showtimeId;
	}
	
	public void setSeats(String seats) {
		this.seats = seats;
	}
	
	public String getSeats() {
		return seats;
	}
}
