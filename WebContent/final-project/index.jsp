<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Movie Tickets</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value='/final-project/css/style.css'/>" rel="stylesheet"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
	<body>
		<%@ include file="topbar.jsp" %>
		<section class="banner-section">
			<div class="banner-bg bg-img bg-fixed" data-background="<c:url value='/assets/images/banner.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner.jpg'/>)">
			</div>
			<div class="container">
				<div class="banner-content text-center">
					<h1 class="title">BOOK YOUR TICKET FOR <span class="title-highlight">MOVIE</span></h1>
					<p>Easy, fast, secure, reliable ticketing!</p>
				</div>
			</div>
		</section>
		<section class="movie-section mt-5">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="tab-movies">
							<ul class="nav nav-tabs" role="tablist" id="myTab">
								<li class="nav-item" role="presentation">
									<button id="now-showing-tab" class="nav-link active text-uppercase" data-bs-toggle="tab" data-bs-target="#now-showing" type="button" role="tab" aria-controls="now-showing" aria-selected="true">Now Showing</button>
								</li>
								<li class="nav-item" role="presentation">
									<button id="coming-soon-tab" class="nav-link text-uppercase" data-bs-toggle="tab" data-bs-target="#coming-soon" type="button" role="tab" aria-controls="coming-soon" aria-selected="fales">Coming soon</button>
								</li>
							</ul>
							<div class="tab-content" id="myTabContent">
								<div class="tab-pane fade show active" id="now-showing" role="tabpanel" aria-labelledby="now-showing-tab">
									<div class="row movies-group animated fadeInUp">
										<c:forEach var="movie" items="${movies}">
											<c:if test="${movie.nowShowing == true}">
												<div class="col-sm-4 col-md-4 col-xs-6 movie-item">
													<div class="article-movie-home">
														<img class="lazy loaded" src="<c:url value='${movie.imgPath}'/>" data-src="<c:url value='${movie.imgPath}'/>" data-was-process="true"/>
														<a href="<c:url value='/movietickets/movie?id=${movie.id}'/>">
															<div class="description-hover overlay">
																<div class="movie-content">
																	<div class="text-uppercase btn btn-outline-success">Details</div>
																</div>
															</div>
														</a>
													</div>
													<div class="title-movie text-center text-uppercase mt-2">
														<a href="<c:url value='/movietickets/movie?id=${movie.id}'/>" class="text-decoration-none fw-bold"><p>${movie.title}</p></a>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</div>
								</div>
								<div class="tab-pane fade" id="coming-soon" role="tabpanel" aria-labelledby="coming-soon-tab">
									<div class="row movies-group animated fadeInUp">
										<c:forEach var="movie" items="${movies}">
											<c:if test="${movie.nowShowing == false}">
												<div class="col-sm-4 col-md-4 col-xs-6 movie-item">
													<div class="article-movie-home">
														<img class="lazy loaded" src="<c:url value='${movie.imgPath}'/>" data-src="<c:url value='${movie.imgPath}'/>" data-was-process="true"/>
														<a href="<c:url value='/movietickets/movie?id=${movie.id}'/>">
															<div class="description-hover overlay">
																<div class="movie-content">
																	<div class="text-uppercase btn btn-outline-success">Details</div>
																</div>
															</div>
														</a>
													</div>
													<div class="title-movie text-center text-uppercase mt-2">
														<a href="<c:url value='/movietickets/movie?id=${movie.id}'/>" class="text-decoration-none fw-bold"><p>${movie.title}</p></a>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<%@ include file="footer.jsp" %>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
		<script src="assets/js/topbar-scroll.js"></script>
	</body>
</html>