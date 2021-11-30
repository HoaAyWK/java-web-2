package fp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;

import fp.business.Account;
import fp.data.AccountDAO;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet(name="CustomerServlet", urlPatterns = {"/admin/customers"})
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		
		List<Account> accounts = accountDao.getAccounts();
		List<Account> users = new ArrayList<Account>();
		
		int size = accounts.size();
		for (int i = 0; i < size; i++) {
			if (accounts.get(i).getIsAdmin() == false) {
				users.add(accounts.get(i));
			}
		}
		
		request.setAttribute("accounts", users);
		
		getServletContext().getRequestDispatcher("/final-project/customers.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		
		AccountDAO accountDao = new AccountDAO(mongo);
		String action = request.getParameter("action");
		
		if (action.equals("delete")) {
			
			
			String id = request.getParameter("id");
			
			accountDao.delete(id);			
		}
		List<Account> accounts = accountDao.getAccounts();
		List<Account> users = new ArrayList<Account>();
		
		int size = accounts.size();
		for (int i = 0; i < size; i++) {
			if (accounts.get(i).getIsAdmin() == false) {
				users.add(accounts.get(i));
			}
		}
		
		request.setAttribute("accounts", users);
		getServletContext().getRequestDispatcher("/final-project/customers.jsp")
		.forward(request, response);
	}

}
