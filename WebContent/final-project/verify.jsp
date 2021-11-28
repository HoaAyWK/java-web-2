<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Verify Email</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value='/final-project/css/verify.css'/>" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
	<section class="account-section bg_img"
		data-background="<c:url value='/assets/images/account-bg.jpg'/>"
		style="background-image: url(<c:url value='/assets/images/account-bg.jpg'/>);">
		<div class="container">
			<div class="padding-top padding-bottom">
				<div class="account-area">
					<div class="section-header-3">
						<span class="cate">Verify Your Email</span> 
						<span class="title">
						We already send email a verification code to your email</span>
					</div>
					 <form class="account-form" action="<c:url value='/movietickets/check-auth'/>" method="post">
					 <div class="form-group">
							<label for="email2">code confirm<span>*</span>
							</label> 
							<input type="text" placeholder="Enter Your Code" id="authcode" name="code">
						</div>
						<c:if test="${invalidCode == true}">
							<div class="alert alert-danger my-2" role="alert">
							  Your code is invalid!
							</div>
						</c:if>
						<div class="form-group text-center">
							<input type="submit" value="Submit" id="submit" >
						</div>
					 </form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>