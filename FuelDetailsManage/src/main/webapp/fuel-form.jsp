<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Fuel details</title>

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
				<a href="https://www.xadmin.net" class="navbar-brand"> fuel details </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Fuel</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${fuel != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${fuel == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${fuel != null}">
            			Edit Fuel
            		</c:if>
						<c:if test="${fuel == null}">
            			Add New Fuel
            		</c:if>
					</h2>
				</caption>

				<c:if test="${fuel != null}">
					<input type="hidden" name="id" value="<c:out value='${fuel.id}' />" />
				</c:if>
                <form>
				<fieldset class="form-group">
					<label>fuel Type</label> <input type="text"
						value="<c:out value='${fuel.fuelType}' />" class="form-control"
						name="fuelType" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>date</label> <input type="text"
						value="<c:out value='${fuel.date}' />" class="form-control"
						name="date">
				</fieldset>

				<fieldset class="form-group">
					<label>Fuel Quantity</label> <input type="text"
						value="<c:out value='${fuel.fuelQuantity}' />" class="form-control"
						name="fuelQuantity">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Tank Identification</label> <input type="text"
						value="<c:out value='${fuel.tankIdentification}' />" class="form-control"
						name="tankIdentification" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>unit Price</label> <input type="text"
						value="<c:out value='${fuel.unitPrice}' />" class="form-control"
						name="unitPrice">
				</fieldset>

				<fieldset class="form-group">
					<label>Total Cost</label> <input type="text"
						value="<c:out value='${fuel.totalCost}' />" class="form-control"
						name="totalCost">
				</fieldset>
				
				<fieldset class="form-group">
					<label>supplier</label> <input type="text"
						value="<c:out value='${fuel.supplier}' />" class="form-control"
						name="supplier">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Employee ID</label> <input type="text"
						value="<c:out value='${fuel.employeeID}' />" class="form-control"
						name="employeeID">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Note</label> <input type="text"
						value="<c:out value='${fuel.note}' />" class="form-control"
						name="note">
				</fieldset>
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>