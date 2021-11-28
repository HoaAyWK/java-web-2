<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Exerciser 3: Music Store</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center">Download Registraion</h2>
				<p class="text-center">To register for our downloads, enter your name and email address below. Then click on the Submit button.</p>
				<form action="download" class="bg-light p-2 rounded" method="post">
					<input type="hidden" name="action" value="registerUser"/>
					<div class="mb-2">
						<label class="form-label">Email</label>
						<input class="form-control" type="email" name="email" value="${user.email}">
					</div>
					<div class="mb-2">
						<label class="form-label">First name</label>
						<input class="form-control" type="text" name="firstName" value="${user.firstName}">
					</div>
					<div class="mb-2">
						<label class="form-label">Last name</label>
						<input class="form-control" type="text" name="lastName" value="${user.lastName}">
					</div>
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>