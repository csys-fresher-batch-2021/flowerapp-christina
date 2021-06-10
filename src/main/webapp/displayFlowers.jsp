<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="in.bloomapp.model.Flower" %>
<%@ page import ="in.bloomapp.dao1.FlowerManagerDAO1" %>
<!DOCTYPE html>
<html lang="en">
<%
String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>
<head>
<meta charset="ISO-8859-1">
<title>Flowers available</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1 style="color:pink">Flowers available</h1>
	<table class="table table-border">
	<caption style="color:white">Flowers available</caption>
		<thead>
			<tr>
				<th scope="col" id= "serialnumber">S.NO</th>
				<th scope="col" id="category">Category</th>
				<th scope="col"id="type">Type</th>
				<th scope="col"id="price">Price</th>
				<th scope="col"id="quantity">Price</th>
				
			</tr>
		</thead>
		
			<tbody>
		<%
			final List<Flower> flowers = FlowerManagerDAO1.getFlower();
			int i=0;
			for(Flower flower: flowers){
				i++;
			%>
			<tr>
			<th  scope="col"><%=i%></th>
			<td><%=flower.getCategory() %></td>
			<td><%=flower.getType()%></td>
			<td>Rs.<%=flower.getPrice()%>/-</td>
			 <% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("ADMIN")){ %>
			<td><a href="DeleteFlowerServlet?type=<%=flower.getType()%>&category=<%=flower.getCategory()%>"class="btn btn-danger">Delete</a></td>
			 <%} %> 
			 <% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("USER")){ %>
			<td><a href="CartServlet?type=<%=flower.getType()%>&category=<%=flower.getCategory()%>&price=<%=flower.getPrice()%>
			&username=<%=loggedInUsername%>" class="btn btn-success">ADD</a></td>
				<%}%>
					<% } %>
				</tr>
	
		</tbody>
	</table>
		 <% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("ADMIN")){ %>
		<a href="addFlower.jsp">Add flowers</a>
		 <% } %>
		 		 <% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("USER")){ %>
		 		 <a href="DisplayCart.jsp" class="btn btn-success">CART</a>
		 		<%}%>	 		 
</main>
</body>
</html>