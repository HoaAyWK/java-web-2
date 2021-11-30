package fp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Cinema;
import fp.business.Movie;
import fp.business.Showtime;
import fp.data.CinemaDAO;
import fp.data.MovieDAO;
import fp.data.ShowtimeDAO;

/**
 * Servlet implementation class AddSessionServlet
 */
@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		
		List<Movie> movies = movieDao.getMovies();
		List<Cinema> cinemas = cinemaDao.getCinemas();
		
		request.setAttribute("movies", movies);
		request.setAttribute("cinemas", cinemas);
		getServletContext().getRequestDispatcher("/final-project/add-session.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
		
		String movieName = request.getParameter("movieName");
		String cinemaName = request.getParameter("cinemaName");		
		String start = request.getParameter("start");		
		String end = request.getParameter("end");
		String date = request.getParameter("date");
		
		Movie movie = movieDao.getMovieByName(movieName);
		Cinema cinema = cinemaDao.getCinemaByName(cinemaName);
		
		Showtime showtime = new Showtime();
		showtime.setStart(start);
		showtime.setEnd(end);
		showtime.setDate(date);
		showtime.setMovieId(movie.getId());
		showtime.setCinemaId(cinema.getId());
		showtime.setSeats(cinema.getSeats());
		showtime.setSeatsAvailable(cinema.getSeatsAvailable());
		
		showtimeDao.create(showtime);
		
		response.sendRedirect("/java-web/admin/sessions");
		
	}

}
