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
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-8 offset-md-2">
				<h2 class="text-center" style="color: #6610f2">Admin Application</h2>
				<table class="table table-hover mt-5">
					<thead>
						<tr class="table-info">
							<th>Email</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td><c:out value="${user.email}"/></td>	
								<td><c:out value="${user.firstName}"/></td>
								<td><c:out value="${user.lastName}"/></td>		
								<td class="d-flex justify-content-center">
									<form action="" method="get" class="mx-1">
										<input type="hidden" name="action" value="edit">
										<input type="hidden" name="id" value="<c:out value='${user.id}'/>">
										<button class="btn btn-success" type="submit">Edit</button>
									</form>
									<form action="" method="post" class="mx-1">
										<input type="hidden" name="action" value="delete">
										<input type="hidden" name="id" value="<c:out value='${user.id}'/>">
										<button class="btn btn-danger" type="submit">Delete</button>
									</form>
								</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>