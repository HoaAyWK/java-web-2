package fp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import fp.data.AccountDAO;
import fp.business.Account;

/**
 * Servlet implementation class RegisterVerify
 */
@WebServlet(name="RegisterVerify", urlPatterns = {"/movietickets/check-auth"})
public class RegisterVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		AccountDAO accountDao = new AccountDAO(mongo);
		
		String url = "/final-project/verify.jsp";
		boolean invalidCode = false;
		
		
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		String code = request.getParameter("code");
		
		boolean validAccount = false;

		if(code.equals(account.getCode())){
			account = accountDao.create(account);

		    request.setAttribute("account", account);
		    
		    validAccount = true;
		    url = "/final-project/signin.jsp";
		    session.removeAttribute("account");
		    
		}
		else {
			invalidCode = true;
		}
		session.setAttribute("validAccount", validAccount);
		request.setAttribute("invalidCode", invalidCode);
		getServletContext().getRequestDispatcher(url)
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
