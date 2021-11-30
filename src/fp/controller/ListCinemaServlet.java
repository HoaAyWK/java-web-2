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
import fp.data.CinemaDAO;

/**
 * Servlet implementation class ListCinemaServlet
 */
@WebServlet(name = "ListCinemaServlet", urlPatterns = "/admin/cinemas")
public class ListCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCinemaServlet() {
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
		
		List<Cinema> cinemas = cinemaDao.getCinemas();
		
		request.setAttribute("cinemas", cinemas);
		
		getServletContext().getRequestDispatcher("/final-project/list-cinema.jsp")
			.forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
		
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		String url = "/final-project/list-cinema.jsp";
		
		if (action.equals("edit")) {
			Cinema cinema = cinemaDao.getCinema(id);
			request.setAttribute("cinema", cinema);
			url = "/final-project/edit-cinema.jsp";
			
		}
		
		List<Cinema> cinemas = cinemaDao.getCinemas();
		
		request.setAttribute("cinemas", cinemas);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);;
	}

}
