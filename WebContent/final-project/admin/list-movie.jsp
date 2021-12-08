<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>List Movie</title>
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
		      	<li class="nav-item">
		       	 	<a href="<c:url value='/admin/movies'/>" class="nav-link active" aria-current="page">
		          	<i class="fas fa-film me-2 bi"></i>
		          	Movies
		        	</a>
		      	</li>
		      	<li class="nav-item">
		        	<a href="<c:url value='/admin/customers'/>" class="nav-link text-white">
		          	<i class="fas fa-user-alt me-2 bi"></i>
		          	Customers
		        	</a>
		      	</li>
		      	<li>
		        	<a href="<c:url value='/admin/cinemas'/>" class="nav-link text-white">
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
						<div class="py-2">
							<h4 class="text-capitalize">List Movie</h4>
						</div>
						<div class="table-wrapper" style="background-color: #fff!important;">							
							<div class="profile-info" style="border: 1px solid #ccc;
								box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
								<div class="float-end py-2 pe-2">
									<a class="btn btn-success" href="<c:url value='/admin/movies/add'/>">
										<i class="fas fa-plus me-2"></i>
										Add Movie
									</a>
								</div>
								<table class="table table-hover">
									<thead>
										<tr class="table-dark">
											<th>No.</th>
											<th>Movie Name</th>
											<th>Genre</th>											
											<th>Release Date</th>
											<th>Running Time</th>
											<th>Status</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="movie" items="${movies}" varStatus="loop">
											<tr>
												<td>${loop.count}.</td>
												<td class="fw-bold"><c:out value="${movie.title}"/></td>	
												<td><c:out value="${movie.genre}"/></td>
												<td><c:out value="${movie.release}"/></td>	
												<td><c:out value="${movie.runningTime}"/></td>
												<c:if test="${movie.nowShowing == true}">
													<td>Now showing</td>
												</c:if>
												<c:if test="${movie.nowShowing == false}">
													<td>Coming soon</td>
												</c:if>
												<td>
													<div class="d-flex justify-content-center align-items-center" 
														style="width: 100%; height: 100%;">
														<form action="" method="post" class="mx-1">
															<input type="hidden" name="action" value="edit">
															<input type="hidden" name="id" value="<c:out value='${movie.id}'/>">
															<button class="btn btn-success" type="submit">Edit</button>
														</form>
														<form action="" method="post" class="mx-1">
															<input type="hidden" name="action" value="delete">
															<input type="hidden" name="id" value="<c:out value='${movie.id}'/>">
															<button class="btn btn-danger" type="submit">Delete</button>
														</form>
													</div>
												</td>	
											</tr>
										</c:forEach>
									</tbody>
								</table>							
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