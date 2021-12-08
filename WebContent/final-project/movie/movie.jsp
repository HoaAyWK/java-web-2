<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><c:out value="${movie.title}"/></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="<c:url value='/final-project/css/movie4.css'/>" rel="stylesheet"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
	<%@ include file="/final-project/layouts/topbar.jsp" %>
	<section class="details-banner bg_img" data-background="<c:url value='/assets/images/banner03.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner04.jpg'/>);">
        <div class="container">
            <div class="details-banner-wrapper">
                <div class="details-banner-thumb">
                    <img src="<c:url value='${movie.bannerPath}'/>" alt="movie">
                    <a href="https://www.youtube.com/embed/KGeBMAgc46E" class="video-popup">
                        <img src="<c:url value='/assets/images/video-button.png'/>" alt="movie">
                    </a>
                </div>
                <div class="details-banner-content offset-lg-3">
                    <h3 class="title">${movie.title}</h3>
                    <div class="genre">${movie.genre}</div>
                    <div class="social-and-duration">
                        <div class="duration-area">
                            <div class="item">
                                <i class="fas fa-calendar-alt"></i><span> ${movie.release}</span>
                            </div>
                            <div class="item">
                                <i class="far fa-clock"></i><span> ${movie.runningTime} mins</span>
                            </div>
                        </div>
                        <ul class="social-share list-unstyled">
                            <li><a href="#0"><i class="fab fa-facebook-f"></i></a></li>
                            <li><a href="#0"><i class="fab fa-twitter"></i></a></li>
                            <li><a href="#0"><i class="fab fa-pinterest-p"></i></a></li>
                            <li><a href="#0"><i class="fab fa-linkedin-in"></i></a></li>
                            <li><a href="#0"><i class="fab fa-google-plus-g"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="book-section bg-one">
        <div class="container">
            <div class="book-wrapper offset-lg-3">
                <div class="left-side">
                    <div class="item">
                        <div class="item-header">
                            <h5 class="title">Rated: ${movie.rate}</h5>
                            <div class="rated">
                                <i class="fas fa-star"></i>
                            </div>
                        </div>
                    </div>                    
                </div>
                <div class="d-flex">
	                <button class="btn btn-primary px-3 me-4" name="back" onclick="history.back()">Back</button>
	                <a href="<c:url value='/movietickets/book?id=${movie.id}'/>" class="btn btn-primary">Book tickets</a>
                </div>
            </div>
        </div>
    </section>
	<section class="movie-details-section padding-top padding-bottom">
        <div class="container">
            <div class="row mb--50">
            	<div class="col-lg-10 offset-lg-1 col md-10 offset-md-1">
            		<h4 class="text-uppercase">Content</h4>
            		<p>${movie.description}</p>
            	</div> 
            </div>
        </div>
    </section>
	<%@ include file="/final-project/layouts/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="assets/js/topbar-scroll.js"></script>
</body>
</html>