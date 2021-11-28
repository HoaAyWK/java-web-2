package group11.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import group11.business.User;
import group11.data.UserDAO;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet(name="UsersServlet", urlPatterns= {"/ex5-admin-app/users"})
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
			UserDAO userDao = new UserDAO(mongo);
			String action = "displayUsers";
			if (request.getParameter("action") != null) {
				action = request.getParameter("action");
			};
			String url = "/ex5-admin-app/index.jsp";
			
			if (action.equals("displayUsers")) {
				
				List<User> users = userDao.getUsers();	
				request.setAttribute("users", users);
				url = "/ex5-admin-app/index.jsp";
				
			} else if (action.equals("edit")) {
				
				String id = request.getParameter("id");
				User user = userDao.getUser(id);
				request.setAttribute("user", user);
				url = "/ex5-admin-app/user.jsp";
				
			} else if (action.equals("update")) {
				
				String id = request.getParameter("id");
				String email = request.getParameter("email");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				User user = new User(id, email, firstName, lastName);
				userDao.update(user);
				url = "/ex5-admin-app/users?action=displayUsers";
				
			} else if (action.equals("delete")) {
				
				String id = request.getParameter("id");
				userDao.delete(id);
				url = "/ex5-admin-app/users?action=displayUsers";
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
