package in.bloomapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.userservice.UserManager;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String name = request.getParameter("Name");
	        String password = request.getParameter("Password");
	        String email= request.getParameter("Email");
	        String mobileNo= request.getParameter("MobileNo");
	        String address = request.getParameter("Address");
			
	        try {
			boolean isAdded = UserManager.addUser(name,password,email,mobileNo,address);
			if (isAdded) {
				response.sendRedirect("Login.jsp");
			} 
			else {
				String errorMessage = "Unable to register";
				response.sendRedirect("registerUser.jsp?errorMessage=" + errorMessage);
			}
	        }
	        catch( DBException | InvalidInputException e){
	        	e.printStackTrace();
	        	String message=e.getMessage();
	        	response.sendRedirect("registerUser.jsp?errorMessage=" + message);
	        	
	        } 
	}

}
