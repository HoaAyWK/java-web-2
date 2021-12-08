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
 * Servlet implementation class EditAdminServlet
 */
@WebServlet(name="EditAdminServlet", urlPatterns = {"/admin/edit-admin-profile"})
public class EditAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		request.setAttribute("account", account);
		getServletContext().getRequestDispatcher("/final-project/admin/edit-admin-profile.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		AccountDAO accountDao = new AccountDAO(mongo);
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		
		account.setUsername(name);
		account.setPhone(phone);
		account.setAddress(address);
		
		accountDao.update(account);
		
		session.setAttribute("account", account);
		response.sendRedirect("/admin/admin-profile");
	}

}
