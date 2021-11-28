<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Sign In</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value='/final-project/css/signin.css'/>"/>
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
						<span class="cate">hello</span>
						<h2 class="title">welcome back</h2>
					</div>
					<form class="account-form" action="<c:url value='/movietickets/signin'/>" method="post">
						<div class="form-group">
							<label for="email2">Email <span>*</span>
							</label> 
							<input type="text" placeholder="Enter Your Email" id="email2" name="email" required>
						</div>
						<div class="form-group">
							<label for="pass3">Password <span>*</span></label> 
							<input type="password" placeholder="Password" id="pass3" required name="password">
						</div>
						<div class="form-group checkgroup">
							<input type="checkbox" id="bal2" required checked> <label
								for="bal2">remember password</label> <a href=""
								class="forget-pass">Forget Password</a>
						</div>
						<c:if test="${accountExists == false || wrongPassword == true}">
							<div class="alert alert-danger" role="alert">
  								Email or password is incorrect!
							</div>
						</c:if>
						<div class="form-group text-center">
							<input type="submit" value="log in">
						</div>
					</form>
					<div class="option">
						Don't have an account? <a href="<c:url value='/movietickets/signup'/>">sign up now</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>