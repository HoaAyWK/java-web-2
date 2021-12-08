package fp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Movie;
import fp.data.MovieDAO;

/**
 * Servlet implementation class AddMovieServlet
 */
@WebServlet(name = "AddMovieServlet", urlPatterns= {"/admin/movies/add"})
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/final-project/admin/add-movie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		MovieDAO movieDao = new MovieDAO(mongo);
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String imgPath = request.getParameter("imgPath");
		String bannerPath = request.getParameter("bannerPath");
		String rate = request.getParameter("rate");
		String genre = request.getParameter("genre");
		String release = request.getParameter("release");
		String runningTime = request.getParameter("runtime");
		String status = request.getParameter("status");
		System.out.println(status);
		boolean nowShowing = false;
		
		if (status.equals("Now Showing")) nowShowing = true;
		else if(status.equals("Coming Soon")) nowShowing = false;
		
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setDescription(description);
		movie.setImgPath(imgPath);
		movie.setBannerPath(bannerPath);
		movie.setGenre(genre);
		movie.setRate(Double.parseDouble(rate));
		movie.setRelease(release);
		movie.setRunningTime(Integer.parseInt(runningTime));
		movie.setNowShowing(nowShowing);
		
		movieDao.create(movie);
		
		response.sendRedirect("/admin/movies");
		
	}

}
