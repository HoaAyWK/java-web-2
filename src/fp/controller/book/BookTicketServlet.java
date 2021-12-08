package fp.controller.book;

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
 * Servlet implementation class BookTicketServlet
 */
@WebServlet(name="BookTicketServlet", urlPatterns= {"/movietickets/book"})
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTicketServlet() {
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
		ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		String id = request.getParameter("id");
		Movie movie = movieDao.getMovie(id);
		
		List<Showtime> showtimes = showtimeDao.getShowtimes(id);	
		
		List<String> cinemasName = new ArrayList<String>();
		List<String> dates = new ArrayList<String>();
		
		for (int i = 0; i < showtimes.size(); i++) {
			Cinema cinema = cinemaDao.getCinema(showtimes.get(i).getCinemaId());
			cinemasName.add(cinema.getName());
			if (dates.indexOf(showtimes.get(i).getDate()) == -1) {
				dates.add(showtimes.get(i).getDate());
			}
		}
		
		String url = "/final-project/book-ticket/book-tickets.jsp";
		
		request.setAttribute("movie", movie);
		request.setAttribute("dates", dates);
		request.setAttribute("showtimes", showtimes);
		request.setAttribute("cinemasName", cinemasName);

		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
