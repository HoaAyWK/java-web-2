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
	<link href="<c:url value='/final-project/css/seat2.css'/>" rel="stylesheet"/>
	<script src="https://js.stripe.com/v3/"></script>
</head>
<body>
	<%@ include file="/final-project/topbar.jsp" %>
	<section class="details-banner hero-area bg_img seat-plan-banner" data-background="<c:url value='/assets/images/banner04.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner04.jpg'/>)">
        <div class="container">
            <div class="details-banner-wrapper">
                <div class="details-banner-content style-two">
                    <h1 class="title">${movie.title}</h1>
                    <div class="tags">
                        <h4>${cinema.name}</h4>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="page-title bg-one">
    	<div class="container">
    		<div class="row">
    			<div class="col d-flex justify-content-center align-items-center">
    				<div class="select-showtime d-flex justify-content-center align-items-center">
    					<button class="btn btn-primary me-2 px-4" name="back" onclick="history.back()">Back</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </section>
    <div class="payment py-5">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-4">	
    				<div class="booking-summery p-3 mt-5 rounded" style="background-color: #011a48;">
    					<h3 class="text-center text-uppercase fw-bold pb-2 mb-3 title">Booking summery</h3>
    					<ul class="list-unstyled">
    						<li>
    							<h5 class="text-uppercase fs-5 fw-bolder">
    								<span>${movie.title}</span>
    							</h5>
    						</li>
    						<li>
    							<h5 class="text-uppercase fs-5 fw-bolder d-flex justify-content-between">
    								<span>${cinema.name}</span>
    								<span>${noTickets}</span>
    							</h5>
    							<div class="d-flex justify-content-between">
    								<span class="fw-light fs-6 text-uppercase">${showtime.start}</span>
    								<c:if test="${noTickets == 1}">
    									<span class="fw-light fs-6 text-uppercase">Tickets</span>
    								</c:if>
    								<c:if test="${noTickets > 1}">
    									<span class="fw-light fs-6 text-uppercase">Tickets</span>
    								</c:if>
    							</div>
    						</li>
    						<li>
    							<h5 class="text-uppercase fs-5 fw-bolder d-flex justify-content-between">
    								<span>Tickets Price</span>
    								<span><span>$</span>${noTickets * 10}</span>
    							</h5>
    						</li>
    					</ul>
    				</div>
    			</div>
    			<div class="col-lg-8">
    				<div class="p-3 mt-5 rounded" style="background-color: #011a48;">
    					<h4 class="fs-4 fw-bold text-capitalize">Enter your card details</h4>
    					<form action="<c:url value='/movietickets/make-payment'/>" id="checkout-form" method="POST">
    						<input class="seats-hidden-input" type="hidden" name="seats" value="${seats}">
    						<input class="movieId-hidden-input" type="hidden" name="movieId" value="${movie.id}">
    						<input class="showtime-id-hidden-input" type="hidden" name="showtimeId" value="${showtime.id}">
    						<label class="form-label" for="name">Name</label>
    						<input class="form-control" name="name" type="text" required/>
    						<label class="form-label" for="address">Address</label>
    						<input class="form-control" name="address" type="text" required/>
    						<div id="card-element" class="mt-3">
    						</div>
    						<div id="card-error" role="alert"></div>
    						<div class="d-flex justify-content-center">
    							<button class="btn btn-primary" type="submit">Make Payment</button>
    						</div>
    					</form> 
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <script src="<c:url value='/assets/js/card2.js'/>"></script>
    <%@ include file="/final-project/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="<c:url value='/assets/js/topbar-scroll.js'/>"></script>
</body>
</html>