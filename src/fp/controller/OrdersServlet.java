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
import fp.business.Reservation;
import fp.data.CinemaDAO;
import fp.data.MovieDAO;
import fp.data.ReservationDAO;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet(name = "OrdersServlet", urlPatterns = {"/admin/orders"})
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
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
		
		List<Reservation> reservations = reservationDao.getAllReservations();
		
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
		
		getServletContext().getRequestDispatcher("/final-project/admin/orders.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		ReservationDAO reservationDao = new ReservationDAO(mongo);
		MovieDAO movieDao = new MovieDAO(mongo);
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		String url = "/final-project/admin/orders.jsp";
		
		if (action.equals("delete")) {
			reservationDao.delete(id);						
		}
		
		List<Reservation> reservations = reservationDao.getAllReservations();
		
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
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
