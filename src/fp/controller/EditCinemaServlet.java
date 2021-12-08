package fp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Cinema;
import fp.data.CinemaDAO;

/**
 * Servlet implementation class EditCinemaServlet
 */
@WebServlet(name="EditCinemaServlet", urlPatterns = {"/admin/edit-cinema"})
public class EditCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCinemaServlet() {
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
		
		CinemaDAO cinemaDao = new CinemaDAO(mongo);
				
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		Cinema cinema = cinemaDao.getCinema(id);
		
		if (!name.equals(cinema.getName())) {
			cinema.setName(name);
			cinemaDao.update(cinema);
		}
		
		response.sendRedirect("/admin/cinemas");
	}

}
