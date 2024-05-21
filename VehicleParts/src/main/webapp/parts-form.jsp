<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Parts details</title>

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
				<a href="https://www.xadmin.net" class="navbar-brand"> parts details </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Parts</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${parts != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${parts == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${parts != null}">
            			Edit Parts
            		</c:if>
						<c:if test="${parts == null}">
            			Add New Parts
            		</c:if>
					</h2>
				</caption>

				<c:if test="${parts != null}">
					<input type="hidden" name="partID" value="<c:out value='${parts.partID}' />" />
				</c:if>
                <form>
				<fieldset class="form-group">
					<label>PartName</label> <input type="text"
						value="<c:out value='${parts.partName}' />" class="form-control"
						name="partName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>partdescription</label> <input type="text"
						value="<c:out value='${parts.partdescription}' />" class="form-control"
						name="partdescription">
				</fieldset>

				<fieldset class="form-group">
					<label>category</label> <input type="text"
						value="<c:out value='${parts.category}' />" class="form-control"
						name="category">
				</fieldset>
				
				<fieldset class="form-group">
					<label>supplier</label> <input type="text"
						value="<c:out value='${parts.supplier}' />" class="form-control"
						name="supplier" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>quantity </label> <input type="text"
						value="<c:out value='${parts.quantity}' />" class="form-control"
						name="quantity">
				</fieldset>
				<fieldset class="form-group">
					<label>unitPrice </label> <input type="text"
						value="<c:out value='${parts.unitPrice}' />" class="form-control"
						name="unitPrice">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>