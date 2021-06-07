package in.bloomapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bloomapp.model.Flower;
import in.bloomapp.service.CartManager;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("category");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		int price1 = Integer.parseInt(price);
		int quantity = 1;
		Flower newOrder = new Flower(category, type, price1, quantity);
		CartManager.addToCart(newOrder);
		response.sendRedirect("displayFlowers.jsp");

	}
}
