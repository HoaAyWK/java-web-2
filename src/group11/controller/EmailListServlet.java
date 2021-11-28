package group11.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import group11.business.User;
import group11.data.UserDAO;
//import exercise.data.UserIO;

import java.util.GregorianCalendar;
import java.util.List;
//import java.util.ArrayList;
import java.util.Calendar;
/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/EmailListServlet")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailListServlet() {
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
		UserDAO userDao = new UserDAO(mongo);
		String url = "/exercise1/ex1-index.jsp";
        String action = request.getParameter("action");
        GregorianCalendar currentDate = new GregorianCalendar();
    	int currentYear = currentDate.get(Calendar.YEAR);
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/ex1-email-list/index.jsp";
        } else if (action.equals("add")) {
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            
            User usr = new User();
            usr.setEmail(email);
            usr.setFirstName(firstName);
            usr.setLastName(lastName);
            ServletContext sc = this.getServletContext();          
            String custServEmail = sc.getInitParameter("custServEmail");
            
            /* UserIO */
            //String path = sc.getRealPath("/WEB-INF/EmailList.txt");   
            //UserIO.add(user, path);
            //ArrayList<User> users = UserIO.getUsers(path);
            
            /* UserDAO */
            
            User user = userDao.create(usr);
            List<User> users = userDao.getUsers();
            request.setAttribute("user", user);
            request.setAttribute("users", users);
            request.setAttribute("custServEmail", custServEmail);
            url = "/ex1-email-list/thank.jsp";                       
        }
        request.setAttribute("currentYear", currentYear);
        getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
	}

}
