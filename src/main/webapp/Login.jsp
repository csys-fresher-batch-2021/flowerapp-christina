<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Login Page</h3>
<form action="LoginServlet" method="get">
		<label for="username">User Name</label>
		<input type="text" name="username" placeholder="User Name" pattern="[a-zA-Z0-9\s]{3,}" required autofocus />
		<br/>
		<label for="password">Password</label>
		<input type="password" name="password" placeholder="Password" pattern="[a-zA-Z0-9\s]{3,}"  required autofocus />
		<br/>
		<button type="submit" class="btn btn-info">Submit</button>
		<button type="reset" class="btn btn-danger">Reset</button>
	

</form>
</main>
</body>
</html>