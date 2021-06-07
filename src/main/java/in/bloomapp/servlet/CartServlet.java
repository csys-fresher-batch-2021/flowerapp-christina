package in.bloomapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		// List<Flower> order= new ArrayList<>();
		  // PrintWriter out = response.getWriter();
		   String category = request.getParameter("category");
	        String type = request.getParameter("type");
	        String price = request.getParameter("price");
	        int price1=Integer.parseInt(price);
	       String username=request.getParameter("username");
	       int quantity=1;
	      //  out.println(category+ type+price+username+quantity);
	       // for(Flower item:order) {
//	        if(category.equals(item.getCategory())&& type.equals(item.getType())) {
//	        	item.setQuantity(item.getQuantity() + 1);
//	        	
//	        }
//	        else {
	        	Flower newOrder=new Flower(category,type,price1,quantity);
	        	// order.add(newOrder);
	       // }
	        //}
	        CartManager.addToCart(newOrder, username);
	        response.sendRedirect("displayFlowers.jsp");
	       
	       
	     
	        
}
}
