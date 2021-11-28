<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercise 3: 8601</title>
<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center">Download</h2>
				<table class="table">
					<thead>
						<tr>
							<th>Song Title</th>
							<th>Audio Format</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>You Are a Star</td>
							<td><a href="#" class="text-decoration-none">MP3</a></td>
						</tr>
						<tr>
							<td>Don't Make No Difference</td>
							<td><a href="#" class="text-decoration-none">MP3</a></td>
						</tr>
					</tbody>
				</table>
				<a class="text-decoration-none" href="<c:url value='view_cookie.jsp'/>">View all cookies</a><br/>
				<a class="text-decoration-none" href="<c:url value='download?deleteCookie=true'/>">Delete all Persistent Cookies</a>
			</div>
		</div>
	</div>
</body>
</html>