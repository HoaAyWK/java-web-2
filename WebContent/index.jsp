<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Web Programming</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
<%@ include file="/common/topbar.jsp" %>
	<div class="main">
		<div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active" data-bs-interval="4000">
					<div class="img-overlay">
						<img src="<c:url value='/assets/images/codeservlet.png'/>" class="d-block w-100" alt="..."/>
					</div>
					<div class="carousel-caption d-none d-md-block carousel-text-box">
						<h5>Learn Web Programming With Java</h5>
						<p>Bulding a website with Java Servlet and JSP</p>
					</div>
				</div>
				<div class="carousel-item" data-bs-interval="4000">
					<div class="img-overlay">
						<img src="<c:url value='/assets/images/code.jpg'/>" class="d-block w-100" alt="..."/>
					</div>
					<div class="carousel-caption d-none d-md-block carousel-text-box">
						<h5>HTML5 and CSS3</h5>
						<p>Bulding a website with HTML5 and CSS3</p>
					</div>
				</div>
				<div class="carousel-item"  data-bs-interval="4000">
					<div class="img-overlay">
						<img src="<c:url value='/assets/images/mvc.jpg'/>" class="d-block w-100" alt="..."/>
					</div>
					<div class="carousel-caption d-none d-md-block carousel-text-box">
						<h5>MVC Parttern</h5>
						<p>Building a website with MVC architecture pattern</p>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true" style="color: white"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true" style="color: white"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<div class="container mt-5">
			<div class="row my-2">
				<div class="col-lg-4 text-center">
					<img class="avatar" src="<c:url value='/assets/images/houseinlake.jpg'/>" alt="picture"/>
					<h2>Vy Minh Khanh Hoa</h2>
					<p>Student at HCMUTE</p>
					<p> 
						<a class="btn btn-primary" href="<c:url value='/members?name=hoa'/>">View details</a>
					</p>
				</div>
				<div class="col-lg-4 text-center">
					<img class="avatar" src="<c:url value='/assets/images/sea1.jpg'/>" alt="picture"/>
					<h2>Bui Dinh Xuan</h2>
					<p>Student at HCMUTE</p>
					<p> 
						<a class="btn btn-primary" href="<c:url value='/members?name=xuan'/>">View details</a>
					</p>
				</div>
				<div class="col-lg-4 text-center">
					<img class="avatar" src="<c:url value='/assets/images/sea2.jpg'/>" alt="picture"/>
					<h2>Tran Manh Cuong</h2>
					<p>Student at HCMUTE</p>
					<p> 
						<a class="btn btn-primary" href="<c:url value='/members?name=cuong'/>">View details</a>
					</p>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7">
					<a href="<c:url value='/final-project'/>" class="feature-link" target="_blank">
						<h2>Final Project</h2>
					</a>
					<p class="lead">Movie Tickets Online Booking</p>
				</div>
				<div class="col-md-5 d-flex justify-content-center">
					<a href="<c:url value='/final-project'/>" target="_blank">
						<img src="<c:url value='/assets/images/final-project.png'/>" alt="picture" style="width: 100%; height: 100%; box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);"/>
					</a>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<a href="<c:url value='/ex1-email-list/emailList'/>" class="feature-link" target="_blank">
						<h2>Exercise 1</h2>
					</a>
					<p class="lead">Write a simple application with JSP and Servlet</p>
				</div>
				<div class="col-md-5 order-md-1 d-flex justify-content-center">
					<a href="<c:url value='/ex1-email-list/emailList'/>" target="_blank">
						<img src="<c:url value='/assets/images/ex11.png'/>" alt="picture" style="width: 100%; height: 100%; box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);"/>
					</a>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7">
					<a href="https://drive.google.com/drive/folders/1miQ8UIP12gq1YwNO1cff2xet-vVZlTa-" class="feature-link" target="_blank">
						<h2>Exercise 2</h2>
					</a>
					<p class="lead">Think and discuss about an web application for final project</p>
				</div>
				<div class="col-md-5 d-flex justify-content-center">
					<a href="https://drive.google.com/drive/folders/1miQ8UIP12gq1YwNO1cff2xet-vVZlTa-" target="_blank">
						<img src="<c:url value='/assets/images/drive.png'/>" alt="picture" style="width: 100%; height: 100%; box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);"/>
					</a>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<a href="<c:url value='/ex3-music-store/download'/>" class="feature-link" target="_blank">
						<h2>Exercise 3</h2>
					</a>
					<p class="lead">Music download app (using sessions and cookies)</p>
				</div>
				<div class="col-md-5 order-md-1 d-flex justify-content-center">
					<a href="<c:url value='/ex3-music-store/download'/>" target="_blank">
						<img src="<c:url value='/assets/images/ex3.png'/>" alt="picture" style="width: 100%; height: 100%; box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);">
					</a>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7 ">
					<a href="<c:url value='/ex4-cart/loadProducts'/>" class="feature-link" target="_blank">
						<h2>Exercise 4</h2>
					</a>
					<p class="lead">Cart application</p>
				</div>
				<div class="col-md-5 d-flex justify-content-center">
					<a href="<c:url value='/ex4-cart/loadProducts'/>" target="_blank">
						<img src="<c:url value='/assets/images/ex4.png'/>" alt="picture" style="width: 100%; height: 100%; box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);"/>
					</a>
				</div>
			</div>
			<hr class="featurette-divider">
			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<a href="<c:url value='/ex5-admin-app/users'/>" class="feature-link" target="_blank">
						<h2>Exercise 5</h2>
					</a>
					<p class="lead">Admin application</p>
				</div>
				<div class="col-md-5 order-md-1 d-flex justify-content-center">
					<a href="<c:url value='/ex5-admin-app/users'/>" target="_blank">
						<img src="<c:url value='/assets/images/ex5.png'/>" alt="picture" style="width: 100%; height: 100%; box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);"/>
					</a>
				</div>
			</div>
		</div>		
	</div>
<%@ include file="/common/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>