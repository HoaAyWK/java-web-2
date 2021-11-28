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
			<div class="col-md-10 offset-md-1">
				<h1 class="text-center">Your Cart</h1>
				<table class="table table-hover">
					<thead>
						<tr class="table-info">
							<th>Quantity</th>
							<th>Description</th>
							<th>Price</th>
							<th>Amount</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${cart.items}">
							<tr>
								<td>
									<form action="" method="post" class="d-flex">
										<input type="hidden" name="productId"
											value="<c:out value='${item.product.id}'/>"/>
										<input style="max-width: 100px;" class="form-control" type="text" name="quantity" id="quantity"
											value="<c:out value='${item.quantity}'/>"/>
										<button class="btn btn-primary" type="submit">Update</button>
									</form>
								</td>
								<td><c:out value="${item.product.description}"/></td>
								<td>${item.product.priceCurrencyFormat}</td>
								<td>${item.totalCurrencyFormat}</td>
								<td>
									<form action="" method="post">
										<input type="hidden" name="productId"
											value="<c:out value='${item.product.id}'/>"/>
										<input type="hidden" name="quantity"
											value="0"/>
										<button class="btn btn-primary" type="submit">Remove item</button>
									</form>
								</td>
							</tr>
						</c:forEach> 
					</tbody>
				</table>
				<p><b>To change the quantity</b>, enter the new quantity and click on the Update button</p>
				<form action="" method="post" class="mb-3">
					<input type="hidden" name="action" value="shop">
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-success">Continue Shopping</button>
					</div>
				</form>
				<form action="" method="post" class="mb-3">
					<input type="hidden" name="action" value="checkout">
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-success">Checkout</button>
					</div>					
				</form>
			</div>	
		</div>
	</div>
</body>
</html>