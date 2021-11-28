package group11.converter;

import org.bson.Document;
import org.bson.types.ObjectId;

import group11.business.Product;

public class ProductConverter {

	public static Product toProduct(Document doc) {
		Product product = new Product();
		product.setCode((String) doc.get("code"));
		product.setDescription((String) doc.get("description"));
		product.setPrice((Double) doc.get("price"));
		ObjectId id = (ObjectId) doc.get("_id");
		product.setId(id.toString());
		return product;
	}
	
	public static Document toDocument(Product product) {
		Document doc = new Document("code", product.getCode())
				.append("description", product.getDescription()).
				append("price", product.getPrice());
		if (product.getId() != null) {
			doc.append("_id", new ObjectId(product.getId()));
		}
		return doc;
	}
}
