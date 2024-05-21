<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Service details</title>

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
				<a href="https://www.xadmin.net" class="navbar-brand"> service details </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Service</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${service != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${service == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${service != null}">
            			Edit Service
            		</c:if>
						<c:if test="${service == null}">
            			Add New Service
            		</c:if>
					</h2>
				</caption>

				<c:if test="${service != null}">
					<input type="hidden" name="serviceID" value="<c:out value='${service.serviceID}' />" />
				</c:if>
                <form>
				<fieldset class="form-group">
					<label>Service Name</label> <input type="text"
						value="<c:out value='${service.serviceName}' />" class="form-control"
						name="serviceName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Service Type</label> <input type="text"
						value="<c:out value='${service.serviceType}' />" class="form-control"
						name="serviceType">
				</fieldset>

				<fieldset class="form-group">
					<label>service Description</label> <input type="text"
						value="<c:out value='${service.serviceDescription}' />" class="form-control"
						name="serviceDescription">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Service Availability</label> <input type="text"
						value="<c:out value='${service.serviceAvailability}' />" class="form-control"
						name="serviceAvailability" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Service Price</label> <input type="text"
						value="<c:out value='${service.servicePrice}' />" class="form-control"
						name="servicePrice">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>