package fp.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Showtime implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String start;
	private String end;
	private ArrayList<ArrayList<Boolean>> seats;
	private int seatsAvailable;
	private String date;
	private String movieId;
	private String cinemaId;
	
	public Showtime() {};
	public Showtime(String id, String start, String end, ArrayList<ArrayList<Boolean>> seats,
			int seatsAvailable, String date, String movieId, String cinemaId) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.seats = seats;
		this.seatsAvailable = seatsAvailable;
		this.date = date;
		this.movieId = movieId;
		this.cinemaId = cinemaId;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setStart(String startAt) {
		this.start= startAt;		
	}
	
	public String getStart() {
		return start;
	}
	
	
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setSeats(ArrayList<ArrayList<Boolean>> seats) {
		this.seats = seats;
	}
	
	public ArrayList<ArrayList<Boolean>> getSeats() {
		return seats;
	}
	
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
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
}
