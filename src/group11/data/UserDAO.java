package group11.data;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import group11.business.User;
import group11.converter.UserConverter;

public class UserDAO {
	
	private MongoCollection<Document> collection;
	
	public UserDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("users");
	}
	
	public User create(User user) {
		Document doc = UserConverter.toDocument(user);
		this.collection.insertOne(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		user.setId(id.toString());
		return user;
	}
	
	public void update(User user) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(user.getId())),
				new Document("$set", UserConverter.toDocument(user)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean exists(String id) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).limit(1);
		return doc != null;
	}
	
	public User getUser(String id) {
		Document doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).first();
		return UserConverter.toUser(doc);
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while(cursor.hasNext()) {
				Document doc = cursor.next();
				User user = UserConverter.toUser(doc);
				users.add(user);
			}
		} finally {
			cursor.close();
		}
		return users;
	}
}
