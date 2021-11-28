package group11.controller;

import java.io.IOException;
//import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;

import group11.business.Cart;
import group11.business.LineItem;
import group11.business.Product;
import group11.data.ProductDAO;
//import exercise.data.ProductIO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
		productDao = new ProductDAO(mongo);
		
		ServletContext sc = getServletContext();
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "cart";
		}
		
		String url = "/ex4-cart/index.jsp";
		if (action.equals("shop")) {
			url = "/ex4-cart/index.jsp";
		} else if (action.equals("cart")) {
			String productId = request.getParameter("productId");
			String quantityString = request.getParameter("quantity");
			
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
			}
			
			int quantity;
			
			try {
				quantity = Integer.parseInt(quantityString);
				if (quantity < 0) {
					quantity = 1;
				}
			} catch(NumberFormatException nfe) {
				quantity = 1;
			}
			
			/*
			 * String path = sc.getRealPath("/WEB-INF/products.txt"); Product product =
			 * ProductIO.getProduct(productCode, path);
			 */
			/*
			 * Product product = null; try { product = ProductDAO.getProduct(productCode); }
			 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */
			Product product = productDao.getProduct(productId);
			
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			lineItem.setQuantity(quantity);
			if (quantity > 0) {
				cart.addItem(lineItem);
			} else if (quantity == 0) {
				cart.removeItem(lineItem);
			}
			
			session.setAttribute("cart", cart);
			url = "/ex4-cart/cart.jsp";
		} else if (action.equals("checkout")) {
			url = "/ex4-cart/checkout.jsp";
		}
		sc.getRequestDispatcher(url)
			.forward(request, response);
	}

}
