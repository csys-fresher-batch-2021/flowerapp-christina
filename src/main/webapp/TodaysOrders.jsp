<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.time.LocalDate"%>
    <%@ page import="in.bloomapp.service.SummaryManager"%>
    <%@ page import="in.bloomapp.model.Order"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Todays Orders</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h1 style="color:pink">Flowers to be delivered</h1>
	<table class="table table-bordered" style="font-size: 15px">
	<caption style="color:white">Flowers available</caption>
		<thead>
			<tr>
				<th scope="col" id= "serialnumber" >S.NO</th>
				<th scope="col" id= "category">Category</th>
				<th scope="col" id= "type">Type</th>
				<th scope="col" id= "quantity">Quantity</th>
				<th scope="col" id= "price">Price</th>
				<th scope="col" id= "deliveryCity">Delivery City</th>
				<th scope="col" id= "deliveryAddress">Delivery address</th>
				<th scope="col" id= "deliveryDate">Delivery date</th>
				<th scope="col" id= "time">Max Time</th>
				<th scope="col" id= "userName">User name</th>
				<th scope="col" id= "mobileNo">user mobile No</th>
				<th scope="col" id= "orderdate">Order date</th>
			</tr>
		</thead>
		
<tbody id="order-tbl">
 <%  final List<Order> approve = SummaryManager.getOrders();
			int i=0;
			for(Order order: approve){%>
<tr>
<td>SNO </td><td><%=order.getOrderCategory()%></td>
			<td><%=order.getOrderType()%></td>
			<td><%=order.getOrderQuantity()%></td>
			<td rs.><%=order.getOrderPrice()%></td>
			<td><%=order.getDeliveryCity()%></td>
			<td><%=order.getDeliverAddress()%></td>
			<td><%=order.getDeliveryDate()%></td>
			<td><%=order.getDeliveryTime()%></td>
			<td><%=order.getUserName()%></td>
			<td><%=order.getUserMobileNo()%></td>
			<td><%=order.getOrderDate()%></td></tr><%} %>
</tbody>
</table>
</main>
</body>
</html>