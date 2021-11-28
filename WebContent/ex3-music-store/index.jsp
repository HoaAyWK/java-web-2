<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Exercise 3: Music Store</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<c:if test="${cookie.userEmail.value != null}">
					<h1 class="text-center">Welcome!</h1><br/>					
					<p class="text-center">User email: <c:out value="${cookie.userEmail.value}"/></p>
				</c:if>
				<h1 class="text-center">List of albums</h1>
				<div class="mt-3 p-3 bg-light rounded">
					<a href="download?action=checkUser&amp;productCode=8601" class="text-decoration-none">86 (the band) - True Life Songs and Pictures</a><br/>
					<a href="download?action=checkUser&amp;productCode=pf01" class="text-decoration-none">Paddlefoot - The First CD</a><br/>
					<a href="download?action=checkUser&amp;productCode=pf02" class="text-decoration-none">Paddlefoot - The Second CD</a><br/>
					<a href="download?action=checkUser&amp;productCode=jr01" class="text-decoration-none">Joe Rut - Genuine Wood Grained Finish</a><br/>
				</div>
			</div>	
		</div>
	</div>
</body>
</html>