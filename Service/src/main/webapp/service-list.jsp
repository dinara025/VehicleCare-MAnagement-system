<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Service Details</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Service Details </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Service</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Service</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Service</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Service ID</th>
						<th>service Name</th>
						<th>service Type</th>
						<th>service Description</th>
						<th>service Availability</th>
						<th>service Price</th>
						<th>Actions</th> 
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="service" items="${listService}">

						<tr>
							<td><c:out value="${service.serviceID}"/></td>
							<td><c:out value="${service.serviceName}" /></td>
							<td><c:out value="${service.serviceType}"/></td>
							<td><c:out value="${service.serviceDescription}"/></td>
							<td><c:out value="${service.serviceAvailability}"/></td>
							<td><c:out value="${service.servicePrice}"/></td>
						
							<td><a href="edit?serviceID=<c:out value='${service.serviceID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?serviceID=<c:out value='${service.serviceID}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>