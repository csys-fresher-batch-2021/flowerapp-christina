package in.bloomapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bloomapp.service.FlowerManager;

/**
 * Servlet implementation class DeleteFlowerServlet
 */
@WebServlet("/DeleteFlowerServlet")
public class DeleteFlowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String category = request.getParameter("category");
        String type = request.getParameter("type");
        try {
			boolean isAdded = FlowerManager.deleteFlower(category,type);
			if (isAdded) {
				String errorMessage = "Successfully Deleted Flower";
				response.sendRedirect("displayFlowers.jsp?errorMessage=" + errorMessage);
			} 
			else {
				String errorMessage = "Unable to add flower type";
				response.sendRedirect("displayFlowers.jsp?errorMessage=" + errorMessage);
			}
	        }
	        catch(RuntimeException e){
	        	
	        	String message=e.getMessage();
	        	response.sendRedirect("displayFlowers.jsp?errorMessage=" + message);
	        	
	        }
		}

	}

	


