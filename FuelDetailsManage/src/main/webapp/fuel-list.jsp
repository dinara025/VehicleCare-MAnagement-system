<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Fuel Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Fuel Details </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Fuel</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Fuel</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Fuel</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Type</th>
						<th>date</th>
						<th>Quantity</th>
						<th>tankIdentification</th>
						<th>unitPrice</th>
						<th>totalCost</th>
						<th>supplier</th>
						<th>employeeID</th>
						<th>note</th>
						<th>Actions</th> 
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="fuel" items="${listFuel}">

						<tr>
							<td><c:out value="${fuel.id}"/></td>
							<td><c:out value="${fuel.fuelType}" /></td>
							<td><c:out value="${fuel.date}"/></td>
							<td><c:out value="${fuel.fuelQuantity}"/></td>
							<td><c:out value="${fuel.tankIdentification}"/></td>
							<td><c:out value="${fuel.unitPrice}"/></td>
							<td><c:out value="${fuel.totalCost}"/></td>
							<td><c:out value="${fuel.supplier}"/></td>
							<td><c:out value="${fuel.employeeID}"/></td>
							<td><c:out value="${fuel.note}"/></td>
							<td><a href="edit?id=<c:out value='${fuel.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${fuel.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>