package fp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Cinema;
import fp.data.CinemaDAO;

/**
 * Servlet implementation class AddCinemaServlet
 */
@WebServlet(name = "AddCinemaServlet", urlPatterns = {"/admin/cinemas/add"})
public class AddCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCinemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/final-project/admin/add-cinema.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		String name = request.getParameter("name");
		
		Cinema cinema = new Cinema();
		
		cinema.setName(name);
		cinema.setSeatsAvailable(60);
		
		ArrayList<ArrayList<Boolean>> seats = new ArrayList<ArrayList<Boolean>>();
		
		for (int i = 0; i < 5; i++) {
			ArrayList<Boolean> inner = new ArrayList<Boolean>();
			for (int j = 0; j < 12; j++) {
				inner.add(false);
			}
			seats.add(inner);
		}
		
		cinema.setSeats(seats);
		
		cinemaDao.create(cinema);
		
		response.sendRedirect("/admin/cinemas");
	}

}
