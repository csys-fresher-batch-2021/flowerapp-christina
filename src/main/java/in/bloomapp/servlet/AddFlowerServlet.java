package in.bloomapp.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bloomapp.service.FlowerManager;

/**
 * Servlet implementation class AddFlowerServlet
 */
@WebServlet("/AddFlowerServlet")
public class AddFlowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		        String category = request.getParameter("Category");
		        String type = request.getParameter("flowerType");
		        String price = request.getParameter("price");
		        int amount=Integer.parseInt(price);
		        try {
				boolean isAdded = FlowerManager.addFlower(category,type,amount);
				if (isAdded) {
					response.sendRedirect("displayFlowers.jsp");
				} 
				else {
					String errorMessage = "Unable to add flower type";
					response.sendRedirect("addproduct.jsp?errorMessage=" + errorMessage);
				}
		        }
		        catch(RuntimeException e){
		        	
		        	String message=e.getMessage();
		        	response.sendRedirect("addproduct.jsp?errorMessage=" + message);
		        	
		        }
			}

		

	}

	
