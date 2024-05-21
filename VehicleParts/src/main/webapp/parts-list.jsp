<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Parts Details</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Parts Details </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Parts</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Parts</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Parts</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Part ID</th>
						<th>Part Name</th>
						<th>part description </th>
						<th>category</th>
						<th>supplier</th>
						<th>quantity</th>
						<th>unitPrice</th>
						<th>Actions</th> 
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="parts" items="${listParts}">

						<tr>
							<td><c:out value="${parts.partID}"/></td>
							<td><c:out value="${parts.partName}" /></td>
							<td><c:out value="${parts.partdescription}"/></td>
							<td><c:out value="${parts.category}"/></td>
							<td><c:out value="${parts.supplier}"/></td>
							<td><c:out value="${parts.quantity}"/></td>
							<td><c:out value="${parts.unitPrice}"/></td>
						
							<td><a href="edit?partID=<c:out value='${parts.partID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?partID=<c:out value='${parts.partID}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>