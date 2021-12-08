<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>About</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value='/final-project/css/style.css'/>" rel="stylesheet"/>
	<link href="<c:url value='/final-project/css/about.css'/>" rel="stylesheet"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
	<%@ include file="/final-project/layouts/topbar.jsp" %>
	<section class="main-page-header speaker-banner bg_img" data-background="<c:url value='/assets/images/banner07.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner07.jpg'/>);">
        <div class="container">
            <div class="speaker-banner-content">
                <h2 class="title text-uppercase">about us</h2>
                <ul class="breadcrumb d-flex justify-content-center">
                    <li class="breadcrumb-item active">
                        <a href="<c:url value='/movietickets'/>">
                            Home
                        </a>
                    </li>
                    <li class="text-capitalize breadcrumb-item">
                        about us
                    </li>
                </ul>
            </div>
        </div>
    </section>
    <section class="about-section padding-top padding-bottom">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-lg-6">
                    <div class="event-about-content">
                        <div class="section-header-3 left-style m-0">
                            <span class="cate">We are Moive Tickets </span>
                            <h2 class="title">Get to know us</h2>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor  ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor  ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida.Lorem ipsum dolor sit amet, consectetur adipiscing elit
                            </p>
                            <a href="<c:url value='/movietickets'/>" class="btn btn-primary px-3 py-2">Book Tickets</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 d-none d-lg-block">
                    <div class="about-thumb">
                        <img src="<c:url value='/assets/images/about01.png'/>" alt="about">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="philosophy-section padding-top padding-bottom bg-one bg_img bg_quater_img" data-background="<c:url value='/assets/images/about-bg.jpg'/>" 
    	style="background-image: url(<c:url value='/assets/images/about-bg.jpg'/>);">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 offset-lg-3 bg-two">
                    <div class="philosophy-content">
                        <div class="section-header-3 left-style">
                            <span class="cate">Take look at</span>
                            <h2 class="title">Our philosophy</h2>
                            <p class="ml-0">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmtempor incididunt labore et dolore magna aliqu enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip
                            </p>
                        </div>
                        <ul class="phisophy-list">
                            <li>
                                <div class="thumb">
                                    <img src="<c:url value='/assets/images/icon2.png'/>" alt="philosophy">
                                </div>
                                <h5 class="title">Honesty &amp; Fairness </h5>
                            </li>
                            <li>
                                <div class="thumb">
                                    <img src="<c:url value='/assets/images/icon2.png'/>" alt="philosophy">
                                </div>
                                <h5 class="title">Clarity &amp; Transparency</h5>
                            </li>
                            <li>
                                <div class="thumb">
                                    <img src="<c:url value='/assets/images/icon2.png'/>" alt="philosophy">
                                </div>
                                <h5 class="title">Focus on Customers</h5>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<%@ include file="/final-project/layouts/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="assets/js/topbar-scroll.js"></script>
</body>
</html>