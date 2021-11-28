package group11.converter;

import org.bson.Document;
import org.bson.types.ObjectId;

import group11.business.User;

public class UserConverter {
	public static Document toDocument(User user) {
		Document doc = new Document("email", user.getEmail())
				.append("firstName", user.getFirstName())
				.append("lastName", user.getLastName());
		if (user.getId() != null) {
			doc.append("_id", new ObjectId(user.getId()));
		}
		return doc;
	}
	
	public static User toUser(Document doc) {
		User user = new User();
		ObjectId id = (ObjectId) doc.get("_id");
		user.setId(id.toString());
		user.setEmail((String) doc.get("email"));
		user.setFirstName((String) doc.get("firstName"));
		user.setLastName((String) doc.get("lastName"));
		return user;
	}
}
