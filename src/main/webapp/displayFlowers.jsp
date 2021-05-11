<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="in.bloomapp.model.Flower" %>
<%@ page import ="in.bloomapp.service.FlowerManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flowers available</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h1 style="color:pink">Flowers available</h1>
	<table class="table table-border">
		<thead>
			<tr>
				<th>S.NO</th>
				<th>Category</th>
				<th>Type</th>
				<th>Price</th>
			</tr>
		</thead>
		
			<tbody>
		<%
			List<Flower> flowers = FlowerManager.getFlowerList();
			int i=0;
			for(Flower flower: flowers){
				i++;
			%>
			<tr>
			<th><%=i%></th>
			<td><%=flower.category %></td>
			<td><%=flower.type%></td>
			<td>Rs.<%=flower.price%>/-</td>
			</tr>
		<%} %>
		</tbody>
	</table>
	
</main>
</body>
</html>