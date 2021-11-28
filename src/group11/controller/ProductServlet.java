package group11.controller;

import java.io.IOException;
/*import java.sql.SQLException;
import java.util.ArrayList;*/
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import group11.business.Product;
import group11.data.ProductDAO;
//import exercise.data.ProductIO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		productDao = new ProductDAO(mongo);
		String url = "/ex4-cart/welcome.jsp";
		String action = request.getParameter("action");
		ServletContext sc = this.getServletContext();
		if (action == null) {
			action = "welcome";
		}
		if (action.equals("welcome")) {
			url = "/ex4-cart/welcome.jsp";
		}
		else if (action.equals("load")) {
			/*
			 * String path = sc.getRealPath("/WEB-INF/products.txt"); ArrayList<Product>
			 * products = ProductIO.getProducts(path);
			 */
			/*
			 * ArrayList<Product> products = null; try { products =
			 * ProductDAO.listAllProduct(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } catch
			 * (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			List<Product> products = productDao.getProducts();
			
			HttpSession session = request.getSession();
			session.setAttribute("products", products);
			url = "/ex4-cart/index.jsp";
		}
		sc.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
