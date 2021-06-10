package in.bloomapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bloomapp.exception.DBException;
import in.bloomapp.model.Flower;
import in.bloomapp.service.CartManager;

/**
 * Servlet implementation class ReduceFromCartServlet
 */
@WebServlet("/ReduceFromCartServlet")
public class ReduceFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * call to reduce quantity in cart
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String userName=request.getParameter("username");
		int parsedPrice = Integer.parseInt(price);
		String quantity = request.getParameter("quantity");
		int parsedQuantity = Integer.parseInt(quantity);
		Flower newOrder = new Flower(category, type, parsedPrice, parsedQuantity,userName);
		try {
			CartManager.reduceQuantity(newOrder);
		} catch (DBException e) {
			e.printStackTrace();
		}
		response.sendRedirect("DisplayCart.jsp");

	}


}