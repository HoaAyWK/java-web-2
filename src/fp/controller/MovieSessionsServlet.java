package fp.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class MovieSessionsServlet
 */
@WebServlet(name = "MovieSessionsServlet", urlPatterns = {"/admin/sessions"})
public class MovieSessionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieSessionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		List<Showtime> showtimes = showtimeDao.getAllShowtimes();
		
		List<String> lstMovieName = new ArrayList<String>();
		List<String> lstCinemaName = new ArrayList<String>();
		
		int size = showtimes.size();
		for (int i = 0; i < size; i++) {
			Movie movie = movieDao.getMovie(showtimes.get(i).getMovieId());
			Cinema cinema = cinemaDao.getCinema(showtimes.get(i).getCinemaId());
			lstMovieName.add(movie.getTitle());
			lstCinemaName.add(cinema.getName());
		}
		
		request.setAttribute("lstCinemaName", lstCinemaName);
		request.setAttribute("lstMovieName", lstMovieName);
		request.setAttribute("showtimes", showtimes);
		
		getServletContext().getRequestDispatcher("/final-project/list-session.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		String url = "/final-project/list-session.jsp";
		
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		if (action.equals("delete")) {
			showtimeDao.delete(id);
		}
		
		List<Showtime> showtimes = showtimeDao.getAllShowtimes();
		
		List<String> lstMovieName = new ArrayList<String>();
		List<String> lstCinemaName = new ArrayList<String>();
		
		int size = showtimes.size();
		for (int i = 0; i < size; i++) {
			Movie movie = movieDao.getMovie(showtimes.get(i).getMovieId());
			Cinema cinema = cinemaDao.getCinema(showtimes.get(i).getCinemaId());
			lstMovieName.add(movie.getTitle());
			lstCinemaName.add(cinema.getName());
		}
		
		request.setAttribute("lstCinemaName", lstCinemaName);
		request.setAttribute("lstMovieName", lstMovieName);
		request.setAttribute("showtimes", showtimes);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
