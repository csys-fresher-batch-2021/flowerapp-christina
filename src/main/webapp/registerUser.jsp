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
		<div class="d-flex justify-content-center">
		<h3>Registration page</h3>
		</div>
		<form onsubmit="register()" method="post">	
		<label  class="d-flex justify-content-center" id="testLabel" style="color:red"></label>
		<div class="d-flex justify-content-center">
		<label for="Name">User Name:</label>
		</div>
		<div class="d-flex justify-content-center">
		<input type="text" name="Name" id="Name" placeholder="Enter your name" pattern="[a-zA-Z0-9\s]{3,}" required autofocus />	
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<label for="Password">Password:</label>
		</div>
		<div class="d-flex justify-content-center">
		<input type="Password" name="Password" id="Password" placeholder="Enter password" required />
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<label for="Email">Email:</label>
		</div>
		<div class="d-flex justify-content-center">
		<input type="email" name="Email" id="Email" placeholder="Enter Email" required />
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<label for="MobileNo">Mobile Number:</label>
		</div>
		<div class="d-flex justify-content-center">
		<input type="number" name="MobileNo" id="MobileNo" placeholder="Enter mobile number" pattern="(0/91)?[6-9][0-9]{9}" required />
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<label for="Address">Address:</label>
		</div>
		<div class="d-flex justify-content-center">
		<input type="text" name="Address" id="Address" placeholder="Enter Address"   size="100" required />
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<button type="submit" class="btn btn-info">Submit</button>
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<a href="Login.jsp">Login</a>
		</div>
		<br/>
		</form>
		
		<script type="text/javascript">
		function register(){
			event.preventDefault();
			let name=document.querySelector("#Name").value;
			let password=document.querySelector("#Password").value;
			let email=document.querySelector("#Email").value;
			let mobileNo=document.querySelector("#MobileNo").value;
			let address=document.querySelector("#Address").value;
			const queryParameter="?name="+name+"&password="+password+"&email="+email+"&mobileNo="+mobileNo+"&address="+address;
			let url="RegisterUserServlet"+queryParameter;
			fetch(url,{ method:'POST'}).then(res => res.json()).then(res=>{
				
				if(res.IS_ADDED=="Registration successfull"){
				
					alert(res.IS_ADDED);
					window.location.href="Login.jsp";
					
				}
					
				else{
					document.getElementById('testLabel').innerHTML = (res.IS_ADDED);
					//window.location.href="registerUser.jsp";
				}
			});
		}
		</script>		
	</main>
</body>

</html>