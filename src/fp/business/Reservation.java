package fp.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String startAt;
	private Date date;
	private ArrayList<ArrayList<Integer>> seats;
	private double ticketPrice;
	private int total;
	private String movieId;
	private String cinemaId;
	private String username;
	private String email;
	
	
	public Reservation() {};
	
	public Reservation(String id, String startAt, Date date, ArrayList<ArrayList<Integer>> seats, double ticketPrice,
			int total, String movieId, String cinemaId, String username, String email) {
		this.id = id;
		this.startAt = startAt;
		this.date = date;
		this.seats = seats;
		this.ticketPrice = ticketPrice;
		this.total = total;
		this.movieId = movieId;
		this.cinemaId = cinemaId;
		this.username = username;
		this.email = email;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	
	public String getStartAt() {
		return startAt;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setSeats(ArrayList<ArrayList<Integer>> seats) {
		this.seats = seats;
	}
	
	public ArrayList<ArrayList<Integer>> getSeats() {
		return seats;
	}
	
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public Double getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public String getMovieId() {
		return movieId;
	}
	
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
	
	public String getCinemaId() {
		return cinemaId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}
