<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="in.bloomapp.model.Flower" %>
<%@ page import ="in.bloomapp.service.CartManager" %>
<!DOCTYPE html>
<html lang="en">
<%
String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");
String role = (String) session.getAttribute("ROLE");
%>
<head>
<meta charset="ISO-8859-1">
<title>View Cart</title>
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
				<th scope="col"id="Quantity">Quantity</th>
			</tr>
		</thead>
		
			<tbody>
		<%
			final List<Flower> flowers = CartManager.getOrder();
			int i=0;
			for(Flower flower: flowers){
				i++;
			%>
			<tr>
			<th  scope="col"><%=i%></th>
			<td><%=flower.getCategory() %></td>
			<td><%=flower.getType()%></td>
			<td>Rs.<%=flower.getPrice()%>/-</td>
		    <td><%=flower.getQuantity() %></td>
				</tr>
			<%}%>	
		</tbody>
	</table>
		 		 <% if (loggedInUsername != null && role != null && role.equalsIgnoreCase("USER")){ %>
		 		 <a href="displayFlower.jsp" class="btn btn-success">FLower</a>
		 		<%}%>	 		 
</main>
</body>
</html>