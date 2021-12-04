package fp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import fp.business.Account;
import fp.business.Cinema;
import fp.business.Movie;
import fp.business.Reservation;
import fp.data.AccountDAO;
import fp.data.CinemaDAO;
import fp.data.MovieDAO;
import fp.data.ReservationDAO;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/movietickets/profile"})
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		ReservationDAO reservationDao = new ReservationDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("account");
		
		String email = account.getEmail();
		
		List<Reservation> reservations = reservationDao.getReservations(email);
		
		List<String> lstMovieName = new ArrayList<String>();
		List<String> lstCinemaName = new ArrayList<String>();
		
		int size = reservations.size();
		for (int i = 0; i < size; i++) {
			Movie movie = movieDao.getMovie(reservations.get(i).getMovieId());
			Cinema cinema = cinemaDao.getCinema(reservations.get(i).getCinemaId());
			lstMovieName.add(movie.getTitle());
			lstCinemaName.add(cinema.getName());
		}
		
		request.setAttribute("lstCinemaName", lstCinemaName);
		request.setAttribute("lstMovieName", lstMovieName);
		request.setAttribute("reservations", reservations);
		
		getServletContext().getRequestDispatcher("/final-project/user-profile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		AccountDAO accountDao = new AccountDAO(mongo);
		ReservationDAO reservationDao = new ReservationDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("account");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		boolean changed = false;
		
		if (!name.equals(account.getUsername())) {
			changed = true;
			account.setUsername(name);
		}
		
		if (!phone.equals(account.getPhone())) {
			changed = true;
			account.setPhone(phone);
		}
		
		if (!address.equals(account.getAddress())) {
			changed = true;
			account.setAddress(address);
		}
		
		if (changed) {
			accountDao.update(account);
		}
		
		List<Reservation> reservations = reservationDao.getReservations(account.getEmail());
		
		List<String> lstMovieName = new ArrayList<String>();
		List<String> lstCinemaName = new ArrayList<String>();
		
		int size = reservations.size();
		for (int i = 0; i < size; i++) {
			Movie movie = movieDao.getMovie(reservations.get(i).getMovieId());
			Cinema cinema = cinemaDao.getCinema(reservations.get(i).getCinemaId());
			lstMovieName.add(movie.getTitle());
			lstCinemaName.add(cinema.getName());
		}
		
		request.setAttribute("lstCinemaName", lstCinemaName);
		request.setAttribute("lstMovieName", lstMovieName);
		request.setAttribute("reservations", reservations);
		
		getServletContext().getRequestDispatcher("/final-project/user-profile.jsp").forward(request, response);
	}

}
