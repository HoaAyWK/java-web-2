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
	<link href="<c:url value='/final-project/css/nice-select.css'/>" rel="stylesheet"/>
</head>
<body>
	<%@ include file="/final-project/layouts/topbar.jsp" %>
	<section class="details-banner hero-area bg_img seat-plan-banner" data-background="<c:url value='/assets/images/banner04.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner04.jpg'/>)">
        <div class="container">
            <div class="details-banner-wrapper">
                <div class="details-banner-content style-two">
                    <h1 class="title">${movie.title}</h1>
                    <div class="tags">
                        <h4 class="text-center">${cinema.name}</h4>
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
    					<h4 class="text-uppercase">${showtime.start} <span>${showtime.date}</span></h4>
    				</div>
    			</div>
    		</div>
    	</div>
    </section>
    <div class="seat-plan-section py-5">
        <div class="container">
            <div class="screen-area">
                <h4 class="screen">screen</h4>
                <div class="screen-thumb">
                    <img src="<c:url value='/assets/images/screen-thumb.png'/>" alt="movie"/>
                </div>
                <h5 class="subtitle">Seats</h5>
                <div class="screen-wrapper">
                    <ul class="seat-area">
                    	<c:forEach var="row" items="${cinemaSeats}" varStatus="loop">
                    		<li class="seat-line">            			
                    			<span class="seat-row">${chr.charAt(loop.index)}</span>
                    			<ul class="seat--area">
	                    			<c:forEach var="seat" items="${cinemaSeats[loop.index]}" varStatus="loop">
	                    				<c:if test="${loop.index % 4 == 0 && loop.index != 0}">
	                    						</ul>
	                    					</li>
	                    					<li class="front-seat">
	                    						<ul>
	                    				</c:if>   
	                    				<c:if test="${loop.index == 0}">
	                    					<li class="front-seat">
	                    						<ul>
	                    				</c:if>
	                    							<c:if test="${seat == 1}">
	                    								<li>
                                            				<div class="seat-booked">
                                            				</div>
                                        				</li> 
	                    							</c:if>
	                    							<c:if test="${seat == 0}">
	                    								<li>
                                            				<div class="seat d-flex justify-content-center align-items-center">
                                            					<span class="sit-num">${loop.index}</span>
                                            				</div>
                                        				</li> 
	                    							</c:if>
	                    							<c:if test="${seat == 2}">
	                    								<li>
	                    									<div class="seat seat-book d-flex justify-content-center align-items-center">
                                            					<span class="sit-num">${loop.index}</span>
                                            				</div>
	                    								</li>
	                    							</c:if> 
	                    				<c:if test="${loop.index == 11}">
	                    						</ul>
	                    					</li>
	                    				</c:if>               			
	                    			</c:forEach>
	                    		</ul>
	                    		<span>${loop.index}</span>
                    		</li>
                    	</c:forEach>
                    </ul>
                </div>
            </div>
            <div class="container">
            	<div class="row">
            		<div class="row d-flex justify-content-center">
            			<ul class="list-unstyled d-flex justify-content-between" style="width: 60%">
            				<li class="seat-sample d-flex align-items-center">
            					<div class="sample-red me-2">	
            					</div>
           						<span>Booked</span>
            				</li>
            				<li class="seat-sample d-flex mx-4 align-items-center">
            					<div class="sample-blue me-2">
            					</div>
            					<span>Available</span>
            				</li>
            				<li class="seat-sample d-flex ms-1 align-items-center">
            					<div class="sample-green me-2">
            					</div>
            					<span>Selected</span>
            				</li>
            			</ul>
            		</div>
            	</div>
            </div>
            <div class="proceed-book bg_img hide" data-background="<c:url value='/assets/images/movie-bg-proceed.jpg'/>" style="background-image: url(<c:url value='/assets/images/movie-bg-proceed.jpg'/>);">
                <div class="proceed-to-book">
                    <div class="book-item">
                        <span>You have Choosed Seat</span>
                        <h3 class="title seat-choice"></h3>
                    </div>
                    <div class="book-item">
                        <span>total price</span>
                        <h3 class="title total-price"></h3>
                    </div>
                    <div class="book-item">
                    	<form action="<c:url value='/movietickets/checkout'/>" method="get">
                    		<input name="movieId" type="hidden" value="${movie.id}"/>
                    		<input name="showtimeId" type="hidden" value="${showtime.id}"/>
                    		<input name="date" type="hidden" value="${showtime.start}"/>
                    		<input class="seats-input" name="seats" type="hidden" value=""/>
                    		<button class="btn btn-success" type="submit">Proceed</button>
                    	</form>
                    </div>
                </div>
            </div>
        </div>
    </div>
     <%@ include file="/final-project/layouts/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="<c:url value='/assets/js/nc-select.js'/>"></script>
	<script src="<c:url value='/assets/js/topbar-scroll.js'/>"></script>
	<script src="<c:url value='/assets/js/main30.js'/>"></script>
</body>
</html>