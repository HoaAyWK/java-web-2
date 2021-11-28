package fp.converter;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import fp.business.Cinema;

public class CinemaConverter {
	public static Cinema toCinema(Document doc) {
		Cinema cinema = new Cinema();
		cinema.setName((String) doc.get("name"));
		cinema.setSeats((ArrayList<ArrayList<Boolean>>) doc.get("seats"));
		cinema.setSeatsAvailable((int) doc.get("seatsAvailable"));
		ObjectId id = (ObjectId) doc.get("_id");
		cinema.setId(id.toString());
		return cinema;
	}
	
	public static Document toDocument(Cinema cinema) {
		Document doc = new Document("name", cinema.getName())
				.append("seats", cinema.getSeats())
				.append("seatsAvailable", cinema.getSeatsAvailable());
		if (cinema.getId() != null) {
			doc.append("_id", new ObjectId(cinema.getId()));
		}
		return doc;
	}
}
