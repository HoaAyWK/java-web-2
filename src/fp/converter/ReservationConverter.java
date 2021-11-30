package fp.converter;

import java.util.ArrayList;
import fp.business.Reservation;

import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

public class ReservationConverter {	
	
	public static Reservation toReservation(Document doc) {
		Reservation reservation = new Reservation();
		reservation.setDate((Date) doc.get("date"));
		reservation.setStartAt((String) doc.get("startAt"));
		reservation.setSeats((ArrayList<ArrayList<Integer>>) doc.get("seats"));
		reservation.setTicketPrice((double) doc.get("ticketPrice"));
		reservation.setTotal(doc.getInteger("total"));
		ObjectId movieId = doc.getObjectId("movieId");
		reservation.setMovieId(movieId.toString());
		ObjectId cinemaId = doc.getObjectId("cinemaId");
		reservation.setCinemaId(cinemaId.toString());
		reservation.setUsername(doc.getString("username"));
		reservation.setEmail(doc.getString("email"));
		ObjectId id = doc.getObjectId("_id");
		reservation.setId(id.toString());
		return reservation;
	}
	
	public static Document toDocument(Reservation reservation) {
		Document doc = new Document("date", reservation.getDate())
				.append("startAt", reservation.getStartAt())
				.append("seats", reservation.getSeats())
				.append("ticketPrice", reservation.getTicketPrice())
				.append("total", reservation.getTotal())
				.append("movieId", new ObjectId(reservation.getMovieId()))
				.append("cinemaId", new ObjectId(reservation.getCinemaId()))
				.append("username", reservation.getUsername())
				.append("email", reservation.getEmail());
		if (reservation.getId() != null) {
			doc.append("_id", new ObjectId(reservation.getId()));
		}
		return doc;
	}
}
