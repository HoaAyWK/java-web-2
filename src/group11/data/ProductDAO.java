package group11.data;

import org.bson.Document;
import org.bson.types.ObjectId;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import group11.business.Product;
import group11.converter.ProductConverter;

public class ProductDAO {
	
	private MongoCollection<Document> collection;
	
	public ProductDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("products");
	}
	
	public Product create(Product product) {
		Document doc = ProductConverter.toDocument(product);
		this.collection.insertOne(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		product.setId(id.toString());
		return product;
	}
	
	public void update(Product product) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(product.getId())),
				new Document("$set", ProductConverter.toDocument(product)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean exists(String id) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).limit(1);
		return doc != null;
	}
	
	public Product getProduct(String productId) {
		Document doc = new Document("_id", new ObjectId(productId));
		Document data = this.collection.find(doc).first();
		return ProductConverter.toProduct(data);
	}
	
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				Product product = ProductConverter.toProduct(doc);
				products.add(product);
			}
		} finally {
			cursor.close();
		}
		return products;
	}
	/*
	 * static Connection jdbConnection; public static Product getProduct(String
	 * productCode) throws SQLException,ClassNotFoundException{ Product product =
	 * null; String sql = "SELECT * FROM product WHERE code= ?"; jdbConnection =
	 * MySQLConnUtils.getMySQLConnection();
	 * 
	 * PreparedStatement statement=jdbConnection.prepareStatement(sql);
	 * statement.setString(1,productCode);
	 * 
	 * ResultSet resultSet=statement.executeQuery();
	 * 
	 * if(resultSet.next()) { String code = resultSet.getString("code"); String
	 * description = resultSet.getString("description"); double price =
	 * resultSet.getDouble("price"); product = new Product(); product.setCode(code);
	 * product.setDescription(description); product.setPrice(price); }
	 * 
	 * resultSet.close(); statement.close();
	 * MySQLConnUtils.disconnect(jdbConnection); return product; } public static
	 * ArrayList<Product> listAllProduct()throws SQLException,
	 * ClassNotFoundException{ ArrayList<Product> listProduct = new
	 * ArrayList<Product>(); String sql = "SELECT * FROM product"; try {
	 * jdbConnection = MySQLConnUtils.getMySQLConnection(); } catch (SQLException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } PreparedStatement
	 * statement = jdbConnection.prepareStatement(sql); ResultSet
	 * resultSet=statement.executeQuery(); while(resultSet.next()) { String
	 * code=resultSet.getString("code"); String
	 * description=resultSet.getString("description"); double
	 * price=resultSet.getDouble("price"); Product product=new Product();
	 * product.setCode(code); product.setDescription(description);
	 * product.setPrice(price); listProduct.add(product); } resultSet.close();
	 * statement.close(); MySQLConnUtils.disconnect(jdbConnection); return
	 * listProduct; }
	 */
	

}
