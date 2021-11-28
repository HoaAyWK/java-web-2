package group11.controller;

import java.io.IOException;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import group11.business.User;
import group11.data.UserDAO;
//import exercise.data.UserIO;
import group11.util.CookieUtil;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "viewAlbums";
		}
		String url = "/ex3-music-store/index.jsp";
		if (action.equals("viewAlbums")) {
			url = "/ex3-music-store/index.jsp";
		} else if (action.equals("checkUser")) {
			url = checkUser(request, response);
		}
		String deleteCookies = request.getParameter("deleteCookie");
		if (deleteCookies == null) deleteCookies = "false";
		if (deleteCookies.equals("true")) {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		
		getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String url = "/ex3-music-store/index.jsp";
		if (action.equals("registerUser")) {
			url = registerUser(request, response);
		}
		getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
	}	
	private String checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String productCode = request.getParameter("productCode");
		HttpSession session = request.getSession();
		
		session.setAttribute("productCode", productCode);
		User user = (User) session.getAttribute("user");
		String url;
		if (user == null) {
			Cookie[] cookies = request.getCookies();
			String emailAddress = CookieUtil.getCookieValue(cookies, "userEmail");
			if (emailAddress == null || emailAddress.equals("")) {
				url = "/ex3-music-store/register.jsp";
			}
			else {
				/*
				 * ServletContext sc = getServletContext(); String path =
				 * sc.getRealPath("/WEB-INF/EmailList.txt"); user = UserIO.getUser(emailAddress,
				 * path);
				 */
				session.setAttribute("user", user);
				url = "/ex3-music-store/" + productCode + "_download.jsp";
			}
		} else {
			url = "/ex3-music-store/" + productCode + "_download.jsp";
		}
		return url;
	}
	
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		UserDAO userDao = new UserDAO(mongo);
		
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		User usr = new User();
		
		/*
		 * ServletContext sc = getServletContext(); String path =
		 * sc.getRealPath("/WEB-INF/EmailList.txt"); UserIO.add(user, path);
		 */
		
		usr.setEmail(email);
		usr.setFirstName(firstName);
		usr.setLastName(lastName);
		
		User user = userDao.create(usr);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		Cookie cookie = new Cookie("userEmail", email);
		
		cookie.setMaxAge(60 * 60 * 24 * 365 * 3);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		String productCode = (String) session.getAttribute("productCode");
		String url = "/ex3-music-store/" + productCode + "_download.jsp";
		
		return url;
	}
}
