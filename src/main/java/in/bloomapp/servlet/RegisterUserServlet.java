package in.bloomapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.userservice.UserManager;
import in.bloomapp.validator.UserValidator;

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
				String message="Registration successfull";
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp?infoMessage=" + message);
				rd.forward(request, response);
				//response.sendRedirect("Login.jsp");
				
			} 
			else {
				String errorMessage = "Unable to register";
				//response.sendRedirect("registerUser.jsp?errorMessage=" + Message);
				RequestDispatcher rd = request.getRequestDispatcher("registerUser.jsp?errorMessage=" + errorMessage);
				rd.forward(request, response);
			}
	        }
	        catch( DBException | InvalidInputException |UserValidator e){
	        	String errorMessage=e.getMessage();
	        	//response.sendRedirect("registerUser.jsp?errorMessage=" + message);
	        	RequestDispatcher rd = request.getRequestDispatcher("registerUser.jsp?errorMessage=" + errorMessage);
				rd.forward(request, response);
				e.printStackTrace();
	        } 
	}

}
