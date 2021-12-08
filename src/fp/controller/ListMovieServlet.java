package fp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Movie;
import fp.data.MovieDAO;

/**
 * Servlet implementation class ListMovieServlet
 */
@WebServlet(name="ListMovieServlet", urlPatterns = {"/admin/movies"})
public class ListMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		MovieDAO movieDao = new MovieDAO(mongo);
		
		List<Movie> movies = movieDao.getMovies();
		
		request.setAttribute("movies", movies);
		
		getServletContext().getRequestDispatcher("/final-project/admin/list-movie.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		MovieDAO movieDao = new MovieDAO(mongo);
		
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String url = "/final-project/admin/list-movie.jsp";
		
		if (action == null) {
			url = "/final-project/admin/list-movie.jsp";
			
			List<Movie> movies = movieDao.getMovies();
			request.setAttribute("movies", movies);
			
		} else if (action.equals("edit")) {
			Movie movie = movieDao.getMovie(id);
			request.setAttribute("movie", movie);
			url = "/final-project/admin/edit-movie.jsp";
			
		} else if (action.equals("delete")) {
			//movieDao.delete(id);
			
			List<Movie> movies = movieDao.getMovies();			
			request.setAttribute("movies", movies);
		}
		
		
		getServletContext().getRequestDispatcher(url)
			.forward(request, response);
	}

}
