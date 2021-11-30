package fp.converter;

import org.bson.Document;
import org.bson.types.ObjectId;



import fp.business.Account;

public class AccountConverter {
	public static Account toAccount(Document doc) {
		Account account = new Account();
		account.setEmail((String)doc.get("email"));
		account.setUsername((String) doc.get("username"));
		account.setPassword((String)doc.get("password"));
		account.setPhone((String) doc.get("phone"));
		account.setAddress((String) doc.get("address"));
		account.setIsAdmin((boolean)doc.get("isAdmin"));
		ObjectId id = (ObjectId)doc.get("_id");
		account.setId(id.toString());
		return account;
	}
	
	public static Document toDocument(Account account) {
		Document doc=new Document("email",account.getEmail())
			.append("username", account.getUsername())
			.append("password",account.getPassword())
			.append("phone", account.getPhone())
			.append("address", account.getAddress())
			.append("isAdmin",account.getIsAdmin());
		if(account.getId() != null) {
			doc.append("_id", new ObjectId(account.getId()));
		}
		return doc;
	}
}