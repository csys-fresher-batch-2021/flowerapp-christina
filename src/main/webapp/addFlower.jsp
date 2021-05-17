<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Add Flowers</h3>
		
		<form action="AddFlowerServlet" method="get">
		
		<label for="Category">Flower Category</label>
		<input type="text" name="Category" placeholder="Enter Flower Category" required autofocus />
		<br/>
		<label for="flowerType">Flower Type</label>
		<input type="text" name="flowerType" placeholder="Enter Flower Type" required autofocus />
		<br/>
		<label for="price">Price</label>
		<input type="number" name="price" placeholder="Enter Flower price" required autofocus />
		<br/>
		<button type="submit" class="btn btn-info">Submit</button>
		<a href="displayFlowers.jsp">Flower List</a>
		</form>
	</main>
</body>
</html>