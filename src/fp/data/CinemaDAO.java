package fp.data;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import fp.business.Cinema;
import fp.converter.CinemaConverter;

public class CinemaDAO {
	private MongoCollection<Document> collection;
	
	
	public CinemaDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("cinemas");
	}
	
	public Cinema creat(Cinema cinema) {
		Document doc = CinemaConverter.toDocument(cinema);
		
		this.collection.insertOne(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		cinema.setId(id.toString());
		return cinema;
	}
	
	public void update(Cinema cinema) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(cinema.getId())), 
				new Document("$set", CinemaConverter.toDocument(cinema)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean exists(String id) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).limit(1);
		return doc.first() != null;
	}
	
	public Cinema getCinema(String id) {
		Document doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).first();
		return CinemaConverter.toCinema(doc);
	}
}
