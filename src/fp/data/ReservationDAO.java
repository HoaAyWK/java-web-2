package fp.data;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import fp.business.Reservation;
import fp.converter.ReservationConverter;

public class ReservationDAO {
	MongoCollection<Document> collection;
	
	public ReservationDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("reservations");
	}
	
	public Reservation create(Reservation reservation) {
		Document doc = ReservationConverter.toDocument(reservation);
		this.collection.insertOne(doc);
		ObjectId id = doc.getObjectId("_id");
		reservation.setId(id.toString());
		return reservation;
	}
	
	public void update(Reservation reservation) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(reservation.getId())),
				new Document("$set", ReservationConverter.toDocument(reservation)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean exits(String id) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).limit(1);
		return doc.first() != null;
	}
	
	public Reservation getReservation(String id) {
		Document doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).first();
		return ReservationConverter.toReservation(doc);
	}
	
	public List<Reservation> getReservations(String email) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		MongoCursor<Document> cursor = collection.find(Filters.eq("email", email)).iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				reservations.add(ReservationConverter.toReservation(doc));
			}
		} finally {
			cursor.close();
		}
		return reservations;
	}
	
	public List<Reservation> getAllReservations() {
		List<Reservation> reservations = new ArrayList<Reservation>();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				reservations.add(ReservationConverter.toReservation(doc));
			}
		} finally {
			cursor.close();
		}
		return reservations;
	}
}
