package fp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

import fp.business.Cart;
import fp.business.Cinema;
import fp.business.Reservation;
import fp.business.Showtime;
import fp.business.Ticket;
import fp.data.CinemaDAO;
import fp.data.ReservationDAO;
import fp.data.ShowtimeDAO;

/**
 * Servlet implementation class CreditCardServlet
 */
@WebServlet(name="CreditCardServlet", urlPatterns= {"/movietickets/make-payment"})
public class CreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditCardServlet() {
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
		
		Stripe.apiKey = "sk_test_51JNerUA5N5of65pzn50kAjVR263E4LabFJ1gZcdR1j16WzjbfW7cc7w3JYfwSVgxu7AsTYGk3uV9FSYfrkPDSeCW00ES4vT7ux";
		
		ReservationDAO reservationDao = new ReservationDAO(mongo);
		ShowtimeDAO showtimeDao = new ShowtimeDAO(mongo);
				
		String movieId = request.getParameter("movieId");
		String seats = request.getParameter("seats");
		String showtimeId = request.getParameter("showtimeId");
		String stripeToken = request.getParameter("stripeToken");
		
		String url = "/final-project/success-payment.jsp";
		
		if (movieId == null || movieId == "" || seats == null || seats == ""
				|| showtimeId == null || showtimeId == "" || stripeToken == null || stripeToken == "") {
			url = "/final-project/error.jsp";
		} 
		else {
			Showtime showtime = showtimeDao.getShowtime(showtimeId);
			
			String character[] = { "A", "B", "C", "D", "E" };
	
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
			for (int i = 0; i < characters.size(); i++) {
				for (int j = 0; j < character.length; j++) {
					if (characters.get(i).equals(character[j])) {
						rows.add(j);
					}
				}
				
			}
			
			ArrayList<ArrayList<Integer>> seatsChoice = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < rows.size(); i++) {
				ArrayList<Integer> inner = new ArrayList<Integer>();
				inner.add(rows.get(i));
				inner.add(cols.get(i));
				seatsChoice.add(inner);
			}
			
			boolean isAvailable = true;
			ArrayList<ArrayList<Boolean>> currentSeats = showtime.getSeats();
			for (int i = 0; i < seatsChoice.size(); i++) {
				int rowChoice = seatsChoice.get(i).get(0);
				int colChoice = seatsChoice.get(i).get(1);
				if (currentSeats.get(rowChoice).get(colChoice) == true) {
					url = "/final-project/cancel-payment.jsp";
					isAvailable = false;
					break;
				}
			}
			
			if (isAvailable) {
			
				Reservation reservation = new Reservation();
				Date date = new Date();
				int total = seatsChoice.size();
				double price = 10 * total;
				
				reservation.setDate(date);
				reservation.setMovieId(movieId);
				reservation.setStartAt(showtime.getStart());
				reservation.setSeats(seatsChoice);
				reservation.setTicketPrice(price);
				reservation.setTotal(total);
				reservation.setShowtimeId(showtime.getId());
				reservation.setUsername("iovay");
				reservation.setEmail("iovay@gmail.com");
							
			    
				Map<String, Object> params = new HashMap<>();
				params.put("description", "Testing");
				params.put("amount", total * 1000);
				params.put("source", stripeToken);
				params.put("currency", "usd");
				
				try {		
					Charge charge = Charge.create(params);
					Reservation re = reservationDao.create(reservation);
					ArrayList<ArrayList<Integer>> reSeats = reservation.getSeats();
					ArrayList<ArrayList<Boolean>> cinemaSeats = showtime.getSeats(); 
					for (int i = 0; i < reSeats.size(); i++) { 
						ArrayList<Boolean> seatsRow = new ArrayList<>(); 
						for (int j = 0; j < cinemaSeats.get(0).size(); j++) {
							seatsRow.add(cinemaSeats.get(reSeats.get(i).get(0)).get(j)); 
						}
					 seatsRow.set(reSeats.get(i).get(1), true);
					 cinemaSeats.set(reSeats.get(i).get(0), seatsRow); 
					 } 
					int seatsAvaiable = showtime.getSeatsAvailable() - total;
					showtime.setSeats(cinemaSeats); showtime.setSeatsAvailable(seatsAvaiable);
					showtimeDao.update(showtime);
					HttpSession session = request.getSession();
					Cart cart = (Cart) session.getAttribute("cart");
					cart.removeTicket(movieId, showtimeId);
					System.out.println(cart.getTickets().size());
					
				} 
				catch (StripeException e) {
					// TODO Auto-generated catch block
					url = "/final-project/cancel-payment.jsp";
					e.printStackTrace();
				}
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		/*
		 * SessionCreateParams params = SessionCreateParams.builder()
		 * .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
		 * .setMode(SessionCreateParams.Mode.PAYMENT)
		 * .setSuccessUrl("http://localhost:8900/final-project/success")
		 * .setCancelUrl("http://localhost:8900/final-project/cancel") .addLineItem(
		 * SessionCreateParams.LineItem.builder() .setQuantity((long) total)
		 * .setPriceData( SessionCreateParams.LineItem.PriceData.builder()
		 * .setCurrency("usd") .setUnitAmount(10L) .build()) .build()) .build(); try {
		 * Session session = Session.create(params);
		 * 
		 * 
		 * 
		 * Reservation re = reservationDao.create(reservation);
		 * ArrayList<ArrayList<Integer>> reSeats = reservation.getSeats();
		 * ArrayList<ArrayList<Boolean>> cinemaSeats = cinema.getSeats(); for (int i =
		 * 0; i < reSeats.size(); i++) { ArrayList<Boolean> seatsRow = new
		 * ArrayList<>(); for (int j = 0; j < cinemaSeats.get(0).size(); j++) {
		 * seatsRow.add(cinemaSeats.get(reSeats.get(i).get(0)).get(j)); }
		 * seatsRow.set(reSeats.get(i).get(1), true);
		 * cinemaSeats.set(reSeats.get(i).get(0), seatsRow); } int seatsAvaiable =
		 * cinema.getSeatsAvailable() - total;
		 * 
		 * cinema.setSeats(cinemaSeats); cinema.setSeatsAvailable(seatsAvaiable);
		 * 
		 * cinemaDao.update(cinema);
		 * 
		 * System.out.println(re.getId()); System.out.println(session.getUrl());
		 * 
		 * response.sendRedirect(session.getUrl()); } catch (StripeException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
