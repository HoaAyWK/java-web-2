<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Exercise 5: Admin Application</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<h3 class="text-center">Edit User: <c:out value="${user.email}"/></h3>
				<form action="users" method="post" class="rounded mt-3 px-4 py-2" style="background-color: #c29ffa;">
					<input type="hidden" name="action" value="update"/>
					<input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
					<div class="mb-3">
						<label class="form-label">Email Address</label>
						<input class="form-control" name="email" value="<c:out value='${user.email}'/>">
					</div>
					<div class="mb-3">
						<label class="form-label">First Name</label>
						<input class="form-control" name="firstName" value="<c:out value='${user.firstName}'/>">
					</div>
					<div class="mb-3">
						<label class="form-label">Last Name</label>
						<input class="form-control" name="lastName" value="<c:out value='${user.lastName}'/>">
					</div>
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-success">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>