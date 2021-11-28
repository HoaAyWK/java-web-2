package fp.business;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private ArrayList<ArrayList<Boolean>> seats;
	private int seatsAvailable;
	
	public Cinema() {};
	public Cinema(String id, String name, ArrayList<ArrayList<Boolean>> seats, int seatsAvailable) {
		this.id = id;
		this.name = name;
		this.seats = seats;
		this.seatsAvailable = seatsAvailable;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
} 
