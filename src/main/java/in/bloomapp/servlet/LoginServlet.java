package in.bloomapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.bloomapp.userservice.AdminLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		boolean isValid = AdminLogin.login(username, password);
	
		if(isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", username);
			session.setAttribute("ROLE", "ADMIN");
			try {
				response.sendRedirect("displayFlowers.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("login.jsp?errorMessage=Invalid Login Credentials");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	

	
}
