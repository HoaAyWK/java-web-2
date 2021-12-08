package fp.controller.checkout;

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

import fp.business.Showtime;
import fp.business.Ticket;
import fp.data.CinemaDAO;
import fp.data.MovieDAO;
import fp.data.ShowtimeDAO;
import fp.business.Account;
import fp.business.Cart;
import fp.business.Cinema;
import fp.business.Movie;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet(name="CheckOutServlet", urlPatterns= {"/movietickets/checkout"})
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("account");		
		
		String url = "/final-project/checkout/checkout1.jsp";
		
		System.out.println(account);
		
		if (account == null) {
			response.sendRedirect("/movietickets/signin");
			return;
		} 
		else {			
			
			boolean validAccount = (boolean) session.getAttribute("validAccount");
			if (validAccount == false) {
				session.removeAttribute("account");
				response.sendRedirect("/movietickets/signin");
				return;
			}
			
			MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
			
			MovieDAO movieDao = new MovieDAO(mongo);
			ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
			CinemaDAO cinemaDao = new CinemaDAO(mongo);
			
			String showtimeId = request.getParameter("showtimeId");
			String movieId = request.getParameter("movieId");
			String seats = request.getParameter("seats");
			
			Showtime showtime = showtimeDao.getShowtime(showtimeId);
			Cinema cinema = cinemaDao.getCinema(showtime.getCinemaId());
			Movie movie = movieDao.getMovie(movieId);
				
			Matcher matcherDigit = Pattern.compile("\\d+").matcher(seats);
				
			List<Integer> cols = new ArrayList<>();
		
			while (matcherDigit.find()) {
				cols.add(Integer.valueOf(matcherDigit.group()));
			}
				
			int noTickets = cols.size();
			
			
			Cart cart = (Cart) session.getAttribute("cart");
			
			
			boolean booked = false;
			Ticket ticket = new Ticket(movieId, showtimeId, seats);
			for (int i = 0; i < cart.getTickets().size(); i++) {
				if (cart.getTickets().get(i).getMovieId().equals(movieId) && cart.getTickets().get(i).getShowtimeId().equals(showtimeId)) {
					cart.getTickets().set(i, ticket);
					booked = true;
					break;
				}
			}
			if (booked == false) {
				cart.addTicket(ticket);
			}
			System.out.print("cart size: ");
			System.out.println(cart.getTickets().size());
			for (int i = 0; i < cart.getTickets().size(); i++) {
				System.out.println(cart.getTickets().get(i).getSeats());
			}
			String chr= "ABCDEFGH";
			session.setAttribute("cart", cart);	
			request.setAttribute("chr", chr);
			request.setAttribute("noTickets", noTickets);
			request.setAttribute("seats", seats);
			request.setAttribute("movie", movie);
			request.setAttribute("showtime", showtime);
			request.setAttribute("cinema", cinema);
		}
		
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
