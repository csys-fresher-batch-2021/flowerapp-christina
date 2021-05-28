package in.bloomapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import in.bloomapp.model.Flower;
import in.bloomapp.service.FlowerManager1;

/**
 * Servlet implementation class ListFlowerServlet
 */
@WebServlet("/ListFlowerServlet")
public class ListFlowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1: Call Service and get List of tasks
		List<Flower> list = FlowerManager1.getFlowers();
		
		// Step 2: Convert to Json string
		Gson gson = new Gson();
		String json = gson.toJson(list);

		// Step 3: Write the json in response and flush it
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}


}
