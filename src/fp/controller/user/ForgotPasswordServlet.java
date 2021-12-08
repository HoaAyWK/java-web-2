package fp.controller.user;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Account;
import fp.data.AccountDAO;
import fp.util.EmailUtility;

/**
 * Servlet implementation class forgetpassword
 */
@WebServlet(name="ForgotPassword", urlPatterns = {"/movietickets/forget-password"})
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/final-project/user/forget-password.jsp";
		getServletContext().getRequestDispatcher(url)
		.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		AccountDAO accountDao = new AccountDAO(mongo);
		String url = "/final-project/user/forget-password.jsp";
		String email = request.getParameter("email3");
		boolean isEmailExists = accountDao.isEmailExists(email);
		boolean success;
		System.out.println(isEmailExists);
		if (!isEmailExists) {
			request.setAttribute("emailExists", isEmailExists);
			getServletContext().getRequestDispatcher(url).forward(request, response);
		} else {
			try {
				Account account = accountDao.getAccount(email);
				success = EmailUtility.sendEmail("smtp.gmail.com", "587", "registercard123@gmail.com",
						"fntykgbfzudwkugp", email, "Password", "Your password is: " + account.getPassword());
			} catch (MessagingException e) {
				e.printStackTrace();
				success = false;
			}
		}
		response.sendRedirect("/movietickets/signin");
		return;
	}
}