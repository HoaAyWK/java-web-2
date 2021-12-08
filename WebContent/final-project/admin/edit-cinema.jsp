<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Edit Cinema: ${cinema.name}</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value='/final-project/css/admin1.css'/>" rel="stylesheet"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
	<main>
		<div class="sidebar d-flex flex-column flex-shrink-0 text-white bg-dark" style="width: 280px;">
			<div class="logo-wrapper mb-4 d-flex justify-content-center align-items-center" 
				style="border-bottom: 1px solid #ddd; height: 48px;">
				<a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
		      		<img class="logo me-2" src="<c:url value='/assets/favicon/popcorn-32x32.png'/>" alt="logo" />
		      		<span class="fs-5">MovieTickets</span>
		    	</a>
			</div>
		    <ul class="nav nav-pills flex-column mb-auto px-3">
		      	<li>
		        	<a href="<c:url value='/admin'/>" class="nav-link text-white">
		          	<i class="fas fa-home me-2 bi"></i>
		          	Home
		        	</a>
		      	</li>      
		      	<li>
		        	<a href="<c:url value='/admin/orders'/>" class="nav-link text-white">
		         	<i class="fas fa-calendar-alt me-2 bi"></i>
		         	 Orders
		        	</a>
		      	</li>
		      	<li>
		       	 	<a href="<c:url value='/admin/movies'/>" class="nav-link text-white">
		          	<i class="fas fa-film me-2 bi"></i>
		          	Movies
		        	</a>
		      	</li>
		      	<li>
		        	<a href="<c:url value='/admin/customers'/>" class="nav-link text-white">
		          	<i class="fas fa-user-alt me-2 bi"></i>
		          	Customers
		        	</a>
		      	</li>
		      	<li class="nav-item">
		        	<a href="<c:url value='/admin/cinemas'/>" class="nav-link active" aria-current="page">
		          	<i class="fas fa-video me-2 bi"></i>
		          	Cinemas
		        	</a>
		      	</li>
		      	<li>
		        	<a href="<c:url value='/admin/sessions'/>" class="nav-link text-white">
		          	<i class="fas fa-clipboard-list me-2 bi"></i>
		          	Sessions
		        	</a>
		      	</li>
		    </ul>
		</div>
		<div class="side-wrapper" style="width: 100%; background-color: #edf3f9;">
			<%@ include file="/final-project/layouts/header.jsp" %>
			<div class="container side-content" style="margin-top: 60px;">
				<div class="row">
					<div class="col-md-12">
						<div class="table-wrapper" style="background-color: #fff!important;">
							<div class="py-2" style="border: 1px solid #ccc;">
								<h4 class="text-capitalize ps-3">${cinema.name}</h4>
							</div>
							<div class="profile-info p-3" style="border: 1px solid #ccc;
								box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
								<form action="<c:url value='/admin/edit-cinema'/>" method="post">
									<input type="hidden" name="id" value="${cinema.id}">
									<div class="mb-2">
										<label class="form-label" for="title">Cinema Name</label>
										<input class="form-control" type="text" name="name" value="${cinema.name}">
									</div>									
									<div class="mb-2">
										<label class="form-label" for="release">Capacity</label>
										<input class="form-control" type="text" name="seatsAvailable" value="${cinema.seatsAvailable}" disabled>
									</div>									
									<div class="d-flex justify-content-end me-3">
										<button type="submit" class="btn btn-success me-2">Save</button>
										<a href="<c:url value='/admin/cinemas'/>" class="btn btn-danger">Cancel</a>
									</div>
								</form>									
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>