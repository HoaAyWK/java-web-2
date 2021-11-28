<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Exercise 4: Cart Application</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<h3 class="text-center">Welcome to Cart application</h3>
				<form action="loadProducts" method="get">
					<input type="hidden" name="action" value="load"/>
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-primary">Load Products</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>