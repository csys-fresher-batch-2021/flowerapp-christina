<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Registration page</h3>
		<form action="RegisterUserServlet" method="post">		
		<label for="Name">User Name:</label>
		<input type="text" name="Name" placeholder="Enter your name" pattern="[a-zA-Z0-9\s]{3,}" required autofocus />
		<br/>
		<label for="Password">Password:</label>
		<input type="Password" name="Password" placeholder="Enter password"   required autofocus />
		<br/>
		<label for="Email">Email:</label>
		<input type="text" name="Email" placeholder="Enter Email" required autofocus />
		<br/>
		<label for="MobileNo">Mobile Number:</label>
		<input type="number" name="MobileNo" placeholder="Enter mobile number" pattern="(0/91)?[6-9][0-9]{9}" required autofocus />
		<br/>
		<label for="Address">Address:</label>
		<input type="text" name="Address" placeholder="Enter Address"   size="100" required autofocus />
		<br/>
		<button type="submit" class="btn btn-info">Submit</button>
		<a href="Login.jsp">Login</a>
		</form>
	</main>
</body>
</html>