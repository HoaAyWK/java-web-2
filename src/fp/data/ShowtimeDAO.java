package fp.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import fp.business.Showtime;
import fp.converter.ShowtimeConverter;

public class ShowtimeDAO {
	private MongoCollection<Document> collection;
	
	public ShowtimeDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("showtimes");
	}
	

	public Showtime create(Showtime showtime) {
		Document doc = ShowtimeConverter.toDocument(showtime);
		this.collection.insertOne(doc);
		ObjectId id = doc.getObjectId("_id");
		showtime.setId(id.toString());
		return showtime;
	}
	
	public void update(Showtime showtime) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(showtime.getId())),
				new Document("$set", ShowtimeConverter.toDocument(showtime)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean exists(String id) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("id", new ObjectId(id))).limit(1);
		return doc.first() != null;
	}
	
	public Showtime getShowtime(String id) {
		Document doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).first();
		return ShowtimeConverter.toShowtime(doc);
	}
	
	public List<Showtime> getShowtimes(String movieId) {
		List<Showtime> showtimes = new ArrayList<Showtime>();
		MongoCursor<Document> cursor = this.collection
				.find(Filters.eq("movieId", new ObjectId(movieId))).iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				showtimes.add(ShowtimeConverter.toShowtime(doc));
			}
		} finally {
			cursor.close();
		}
		
		return showtimes;
	}
}
