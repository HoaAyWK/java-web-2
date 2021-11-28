package fp.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import fp.business.Account;
import fp.data.AccountDAO;
import fp.util.EmailUtility;
import secret.Secret;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name="RegisterServlet", urlPatterns = {"/movietickets/register"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		AccountDAO accountDao = new AccountDAO(mongo);
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass1");
		String username = request.getParameter("username");
		
		boolean isEmailExists = accountDao.isEmailExists(email);
		
		if (isEmailExists) {
			request.setAttribute("emailExists", isEmailExists);
			getServletContext().getRequestDispatcher("/movietickets/signup").forward(request, response);
		}
		else {
		
			String resultMessage = "";
			String code = EmailUtility.getRandom();
				
			Account account = new Account();
			account.setUsername(username);
			account.setEmail(email);
			account.setPassword(password);
			account.setCode(code);
				
			boolean success;
			try {
				success = EmailUtility.sendEmail(Secret.getHost(), Secret.getPort(), Secret.getHostMail(),
					    Secret.getKey(), email, "Email Verification", 
						"Registered successfully. Please verify your account using this code: "
						+ account.getCode());
			}
			catch(MessagingException e) {
				e.printStackTrace();
				success = false;
			}
				
			if(success) {
				HttpSession session = request.getSession();
				session.setAttribute("account", account);
				resultMessage = "Congratulations on successful registration";		
			}
			else {
				resultMessage = "There were an error.Please try again";
			}
			response.sendRedirect("/java-web/movietickets/verify-email");
		}
	}
}


