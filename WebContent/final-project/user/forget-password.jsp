<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/final-project/css/verify.css'/>" />
</head>
<body>
<section class="account-section bg_img"
		data-background="<c:url value='/assets/images/account-bg.jpg'/>"
		style="background-image: url(<c:url value='/assets/images/account-bg.jpg'/>);">
		<div class="container">
			<div class="padding-top padding-bottom">
				<div class="account-area">
					<c:if test="${emailExists == false}">
						<div class="alert alert-danger mb-4" role="alert">
							Email does not exist!
						</div>
					</c:if>
					<div class="section-header-3">
						<span class="cate">Forget Password</span> 						
					</div>
					 <form class="account-form" action="<c:url value='/movietickets/forget-password'/>" method="post">
					 <div class="form-group">
							<label for="email2">Email <span>*</span>
							</label> 
							<input type="text" placeholder="Enter Your Email" id="email3" name="email3" required>
						</div>
						<div class="form-group text-center">
							<input type="submit" value="Send" id="submit" >
						</div>
					 </form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>