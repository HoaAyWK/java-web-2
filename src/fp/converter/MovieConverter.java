package fp.converter;

import org.bson.Document;
import org.bson.types.ObjectId;

import fp.business.Movie;

public class MovieConverter {
	public static Movie toMovie(Document doc) {
		Movie movie = new Movie();
		movie.setTitle((String) doc.get("title"));
		movie.setDescription((String) doc.get("description"));
		movie.setImgPath((String) doc.get("imgPath"));
		movie.setBannerPath((String) doc.get("bannerPath"));
		movie.setRate((Double) doc.get("rate"));
		movie.setGenre((String) doc.get("genre"));
		movie.setRunningTime((int) doc.get("runTime"));
		movie.setRelease((String) doc.get("release"));
		movie.setNowShowing((Boolean) doc.get("nowShowing"));
		ObjectId id = (ObjectId) doc.get("_id");
		movie.setId(id.toString());
		return movie;
	}
	
	public static Document toDocument(Movie movie) {
		Document doc = new Document("title", movie.getTitle())
				.append("description", movie.getDescription())
				.append("imgPath", movie.getImgPath())
				.append("bannerPath", movie.getBannerPath())
				.append("rate", movie.getRate())
				.append("genre", movie.getGenre())
				.append("runTime", movie.getRunningTime())
				.append("release", movie.getRelease())
				.append("nowShowing", movie.getNowShowing());
		if (movie.getId() != null) {
			doc.append("_id", new ObjectId(movie.getId()));
		}
		return doc;
	}
}
