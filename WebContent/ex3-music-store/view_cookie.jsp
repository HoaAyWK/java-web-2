<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Exercise 3</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Value</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cook" items="${cookie}">
						<tr>
							<td>
								<c:out value="${cook.value.name}"/>
							</td>
							<td>
								<c:out value="${cook.value.value}"/>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="text-decoration-none" href="<c:url value='/ex3-music-store/download'/>">Download page</a>
			</div>
		</div>
	</div>
</body>
</html>