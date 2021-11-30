package fp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import fp.business.Account;
import fp.data.AccountDAO;

/**
 * Servlet implementation class SigninSevlet
 */
@WebServlet(name="SigninSevlet", urlPatterns = {"/movietickets/signin"})
public class SigninSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/final-project/signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		AccountDAO accountDao = new AccountDAO(mongo);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean emailExists = accountDao.isEmailExists(email);
		System.out.println(email);
		System.out.println(password);
		System.out.println(emailExists);
		
		boolean accountExists = false;
		boolean wrongPassword = false;
		String url = "/final-project/signin.jsp";
		
		if (emailExists) {
			accountExists = true;
			
			Account account = accountDao.getAccount(email);									
			

			String accPassword = account.getPassword();
				
			if (password.equals(accPassword)) {
				
				if (account.getIsAdmin() == false)
					url = "/movietickets";
				else url = "/admin";
				HttpSession session = request.getSession();
				boolean validAccount = true;
				session.removeAttribute("validAccount");
				session.setAttribute("validAccount", validAccount);
				session.setAttribute("account", account);
			}
			else {
				wrongPassword = true;
			}
		 
		}
		
		request.setAttribute("accountExists", accountExists);
		request.setAttribute("wrongPassword", wrongPassword);		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
