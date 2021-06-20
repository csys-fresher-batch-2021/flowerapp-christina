<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.time.LocalDate"%>
    <%@ page import="in.bloomapp.service.SummaryManager"%>
    <%@ page import="in.bloomapp.model.Order"%>
<!DOCTYPE html>
<html>
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
				<th >S.NO</th>
				<th>Category</th>
				<th>Type</th>
				<th >Quantity</th>
				<th >Price</th>
				<th >Delivery City</th>
				<th >Delivery address</th>
				<th >Delivery date</th>
				<th >Max Time</th>
				<th >User name</th>
				<th >user mobile No</th>
				<th >Order date</th>
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
			<td><%=order.getOrderPrice()%></td>
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