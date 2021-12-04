<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><c:out value="${movie.title}"/></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
	<link href="<c:url value='/final-project/css/book1.css'/>" rel="stylesheet"/>
</head>
<body>
	<%@ include file="/final-project/topbar.jsp" %>	
	<section class="banner-section">
		<div class="banner-bg bg-img bg-fixed" data-background="<c:url value='/assets/images/banner04.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner04.jpg'/>)">
		</div>
		<div class="container">
			<div class="banner-content text-center">
				<h1 class="title">${movie.title}</h1>
			</div>
		</div>
	</section>
	<section class="book-section bg-one">
		<div class="container">
			<div class="row">
				<div class="col d-flex justify-content-center align-items-center">
					<Button class="btn btn-primary px-4" name="back" onclick="history.back()">Back</Button>
				</div>
			</div>
		</div>
    </section>
    <div class="ticket-plan-section py-5">
    	<div class="container">
    		<div class="row d-flex justify-content-center">
    			<div class="col-lg-9 mb-5 mb-lg-0">
    				<ul class="seat-plan-wrapper bg-five list-unstyled">
    					<c:forEach var="showtime" items="${showtimes}" varStatus="loop">
	    					<li>
	    						<form class="ticket-form" action="<c:url value='/movietickets/seat'/>" method="get">
	    							<input type="hidden" name="movieId" value="${movie.id}">
	    							<input type="hidden" name="showtimeId" value="${showtime.id}">
	    							<div class="movie-date">
	    								<span>${showtime.date}</span>
	    							</div>
		    						<div class="movie-name">
		    							<div class="icons">
		    								<i class="far fa-heart"></i>
		    								<i class="fas fa-heart"></i>
		    							</div>
		    							<p class="name text-decoration-none">${cinemasName.get(loop.index)}</p>
		    							<div class="location-icon">
		    								<i class="fas fa-map-marker-alt"></i>
		    							</div>
		    						</div>
		    						<div class="movie-schedule">
		    							<button type="submit" class="item btn" style="mask-image: url(<c:url value='/assets/images/ticket.png'/>); -webkit-mask-image: url(<c:url value='/assets/images/ticket.png'/>);">${showtime.start}</button>
		    						</div>
		    					</form>
	    					</li>
	    				</c:forEach>
    				</ul>
    			</div>
    		</div>
    	</div>
    </div>
    <%@ include file="/final-project/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="<c:url value='/assets/js/nc-select.js'/>"></script>
	<script src="<c:url value='/assets/js/main30.js'/>"></script>
	<script src="<c:url value='/assets/js/topbar-scroll.js'/>"></script>
</body>
</html>