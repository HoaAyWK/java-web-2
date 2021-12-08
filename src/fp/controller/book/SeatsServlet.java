package fp.controller.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import fp.business.Cart;
import fp.business.Cinema;
import fp.business.Movie;
import fp.business.Showtime;
import fp.business.Ticket;
import fp.data.CinemaDAO;
import fp.data.MovieDAO;
import fp.data.ShowtimeDAO;

/**
 * Servlet implementation class SeatsServlet
 */
@WebServlet(name="SeatsServlet", urlPatterns = {"/movietickets/seat"})
public class SeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		MovieDAO movieDao = new MovieDAO(mongo);
		ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		String showtimeId = request.getParameter("showtimeId");
		String movieId = request.getParameter("movieId");
		
		Showtime showtime = showtimeDao.getShowtime(showtimeId);
		Cinema cinema = cinemaDao.getCinema(showtime.getCinemaId());
		String chr= "ABCDEFGH";
		
		HttpSession session = request.getSession();
		
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		ArrayList<ArrayList<Integer>> cinemaSeats = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < showtime.getSeats().size(); i++) {
			ArrayList<Integer> inner = new ArrayList<Integer>();
			for (int j = 0; j < showtime.getSeats().get(i).size(); j++) {
				if (showtime.getSeats().get(i).get(j) == false) {
					inner.add(0);
				} 
				else {
					inner.add(1);
				}
			}
			cinemaSeats.add(inner);
		}
		for (int i = 0; i < cart.getTickets().size(); i++) {
			Ticket ticket = cart.getTickets().get(i);
			if (ticket.getMovieId().equals(movieId) && ticket.getShowtimeId().equals(showtimeId)) {
				String character[] = { "A", "B", "C", "D", "E" };
				String seats = ticket.getSeats();
				Matcher matcherDigit = Pattern.compile("\\d+").matcher(seats);
				Matcher matcherCharacter = Pattern.compile("\\p{Upper}").matcher(seats);
				
				List<Integer> cols = new ArrayList<>();
				List<String> characters = new ArrayList<>();
				List<Integer> rows = new ArrayList<>();
				while (matcherDigit.find()) {
				    cols.add(Integer.valueOf(matcherDigit.group()));
				}
				while (matcherCharacter.find()) {
					characters.add(String.valueOf(matcherCharacter.group()));
				}
				for (int j = 0; j < characters.size(); j++) {
					for (int k = 0; k < character.length; k++) {
						if (characters.get(j).equals(character[k])) {
							rows.add(k);
						}
					}
					
				}
				
				ArrayList<ArrayList<Integer>> seatsChoice = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < rows.size(); j++) {
					ArrayList<Integer> inner = new ArrayList<Integer>();
					inner.add(rows.get(j));
					inner.add(cols.get(j));
					seatsChoice.add(inner);
				}
				System.out.println(seatsChoice);
				for (int j = 0; j < seatsChoice.size(); j++) {
					ArrayList<Integer> seatsRow = new ArrayList<Integer>();
					for (int k = 0; k < showtime.getSeats().get(j).size(); k++) {
						seatsRow.add(cinemaSeats.get(seatsChoice.get(j).get(0)).get(k));
					}
					seatsRow.set(seatsChoice.get(j).get(1), 2);
					cinemaSeats.set(seatsChoice.get(j).get(0), seatsRow);
				}
				System.out.println(cinemaSeats);
			}
			
		}
		
		Movie movie = movieDao.getMovie(movieId);
		
		String url = "/final-project/book-ticket/seat.jsp";
		
		request.setAttribute("cinemaSeats", cinemaSeats);
		request.setAttribute("chr", chr);
		request.setAttribute("movie", movie);
		request.setAttribute("showtime", showtime);
		request.setAttribute("cinema", cinema);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
