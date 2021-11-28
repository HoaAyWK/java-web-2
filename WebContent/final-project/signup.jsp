<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Sign Up</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value='/final-project/css/signup.css'/>" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
	<section class="account-section bg_img"
		data-background="<c:url value='/assets/images/account-bg.jpg'/>"
		style="background-image: url(<c:url value='/assets/images/account-bg.jpg'/>);">
		<div class="container">
			<div class="padding-top padding-bottom">
				<div class="account-area">
					<c:if test="${emailExists == true}">
						<div class="alert alert-danger mb-4" role="alert">
							Email already exists!
						</div>
					</c:if>
					<div class="section-header-3">
						<span class="cate">welcome </span>
						<h2 class="title">to Movie Tickets</h2>
					</div>
					<form class="account-form" action="<c:url value='/movietickets/register'/>" method="post">
						<div class="form-group">
							<label for="username">Name<span>*</span></label> 
							<input type="text" placeholder="Enter Your Name" 
								id="username" name="username" required>
						</div>
						<div class="form-group">
							<label for="email">Email <span>*</span></label> 
							<input
								type="email" placeholder="Enter Your Email" id="email" name="email" required>
						</div>
						<div class="form-group">
							<label for="pass1">Password<span>*</span></label> 
							<input type="password" placeholder="Password" 
								id="pass1" name="pass1" onkeyup="check_pass()"  required>
						</div>
						<div class="form-group">
							<label for="pass2">Confirm Password<span>*</span></label> 
							<input type="password" placeholder="Password" 
								id="pass2" name="pass2" onkeyup="check_pass()"  required>
								<span id="icon-green" style="color:green;display:none" ><i class="fas fa-check"></i></span>
								<span id="icon-red" style="color:red;display:none"><i class="fas fa-times"></i></span>
				
						</div>
						<div class="form-group checkgroup">
							<input type="checkbox" id="bal" required checked></input> <label
								for="bal"> I agree to the <a href="#0"> Terms,
									Privacy Policy</a> And <a href="#0">Fees</a></label>
						</div>
						<div class="form-group text-center">
							<input type="submit" value="Sign Up" id="submit" disabled>
						</div>
					</form>
					<div class="option">
						Already have an account? <a href="">Login</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="<c:url value='/assets/js/main30.js'/>"></script>
</body>
</html>