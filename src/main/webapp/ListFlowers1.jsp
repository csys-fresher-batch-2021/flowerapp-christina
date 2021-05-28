<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Display Flowers Spring</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
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
			</tr>
		</thead>
		
<tbody id="flower-tbl">
</tbody>
</table>
<script type="text/javascript">
function getAllFlower(){
	console.log("Fet`ching all Flowers ");
	let url = "ListFlowerServlet";
	fetch(url).then(res=> res.json()).then(res=>{
		let flowers = res;
		console.log(flowers);
		let SNO=1;
		console.log("Got response from servlet");
		console.log(flowers);
		let content = "";
		for(let flower of flowers){
			content += "<tr><td>" +SNO +"</td><td>" +flower.category+"</td><td>"+flower.type+"</td><td>"+flower.price+"</td></tr>"
			+"<td><a href="DeleteFlowerServlet?class="btn btn-danger" >Delete</a></td>;
				</tr>;
			SNO++;
		}
		console.log(content);
		document.querySelector("#flower-tbl").innerHTML= content;
	})
}
getAllFlower();
</script>
</main>
</body>
</html>