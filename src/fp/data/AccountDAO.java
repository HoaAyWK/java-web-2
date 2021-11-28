package fp.data;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.List;

import fp.business.Account;
import fp.converter.AccountConverter;

public class AccountDAO {
	
	private MongoCollection<Document> collection;
	
	public AccountDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("accounts");
	}
	
	public Account create(Account account) {
		Document doc = AccountConverter.toDocument(account);
		this.collection.insertOne(doc);
		ObjectId id = (ObjectId)doc.get("_id");
		account.setId(id.toString());
		return account;
	}
	
	public void update(Account account) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(account.getId())),
				new Document("$set", AccountConverter.toDocument(account)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean isEmailExists(String email) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("email", email)).limit(1);
		return doc.first() != null;
	}
	
	public Account getAccount(String email) {
		Document doc = this.collection.find(Filters.eq("email", email)).first();
		return AccountConverter.toAccount(doc);
	}
	
	public List<Account> getAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		MongoCursor<Document>cursor = collection.find().iterator();
		try {
			while(cursor.hasNext()) {
				Document doc = cursor.next();
				Account account = AccountConverter.toAccount(doc);
			  accounts.add(account);
			}
		} finally {
			cursor.close();
		}
		return accounts;
	}

}