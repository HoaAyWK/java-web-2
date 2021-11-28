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
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">				
				<h1 class="text-center">CD List</h1>
				<table class="table">
					<thead>
						<tr>
							<th>Description</th>
							<th>Price</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products}">
							<tr>
								<td><c:out value="${product.description}"/></td>
								<td>$<c:out value="${product.price}"/></td>
								<td>
									<form action="cart" method="post">
										<input type="hidden" name="productId" value="${product.id}"/>
										<button class="btn btn-primary" type="submit">Add To Cart</button>
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