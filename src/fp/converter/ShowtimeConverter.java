package fp.converter;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import fp.business.Showtime;

public class ShowtimeConverter {
	public static Showtime toShowtime(Document doc) {
		Showtime showtime = new Showtime();
		showtime.setStart(doc.getString("start"));
		showtime.setEnd(doc.getString("end"));
		showtime.setDate(doc.getString("date"));
		showtime.setSeats((ArrayList<ArrayList<Boolean>>) doc.get("seats"));
		showtime.setSeatsAvailable(doc.getInteger("seatsAvailable"));
		ObjectId movieId = doc.getObjectId("movieId");
		ObjectId cinemaId = doc.getObjectId("cinemaId");
		showtime.setMovieId(movieId.toString());
		showtime.setCinemaId(cinemaId.toString());
		ObjectId id = doc.getObjectId("_id");
		showtime.setId(id.toString());
		return showtime;
	}
	
	public static Document toDocument(Showtime showtime) {
		Document doc = new Document("start", showtime.getStart())
				.append("end", showtime.getEnd())
				.append("date", showtime.getDate())
				.append("seats", showtime.getSeats())
				.append("seatsAvailable", showtime.getSeatsAvailable())
				.append("movieId", new ObjectId(showtime.getMovieId()))
				.append("cinemaId", new ObjectId(showtime.getCinemaId()));
		if (showtime.getId() != null) {
			doc.append("_id", new ObjectId(showtime.getId()));
		}
		
		return doc;
	}
}
