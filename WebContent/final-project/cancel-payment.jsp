<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Cancel payment</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="<c:url value='/final-project/css/style.css'/>" rel="stylesheet"/>
	<script src="https://js.stripe.com/v3/"></script>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-lg-8 offset-lg-2 d-flex justify-content-center">
				<div class="mt-5">
					<h1>Can not make payment!</h1>
				    <p>
				      Something went wrong...
				    </p>
				    <div class="d-flex justify-content-center">
				    	<a href="<c:url value='/movietickets'/>" class="btn btn-primary">Continue Booking</a>
				    </div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>