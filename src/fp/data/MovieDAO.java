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

import fp.business.Movie;
import fp.converter.MovieConverter;

public class MovieDAO {
	private MongoCollection<Document> collection;
	
	public MovieDAO(MongoClient mongo) {
		this.collection = mongo.getDatabase("java-web").getCollection("movies");
	}
	
	public Movie create(Movie movie) {
		Document doc = MovieConverter.toDocument(movie);
		this.collection.insertOne(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		movie.setId(id.toString());
		return movie;
	}
	
	public void update(Movie movie) {
		this.collection.updateOne(Filters.eq("_id", new ObjectId(movie.getId())),
				new Document("$set", MovieConverter.toDocument(movie)));
	}
	
	public void delete(String id) {
		this.collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}
	
	public boolean exists(String id) {
		FindIterable<Document> doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).limit(1);
		return doc.first() != null;
	}
	
	public Movie getMovie(String id) {
		Document doc = this.collection.find(Filters.eq("_id", new ObjectId(id))).first();
		return MovieConverter.toMovie(doc);
	}
	
	public Movie getMovieByName(String name) {
		Document doc = this.collection.find(Filters.eq("title", name)).first();
		return MovieConverter.toMovie(doc);
	}
	
	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while(cursor.hasNext()) {
				Document doc = cursor.next();
				Movie movie = MovieConverter.toMovie(doc);
				movies.add(movie);
			}
		} finally {
			cursor.close();
		}
		return movies;
	}
}
