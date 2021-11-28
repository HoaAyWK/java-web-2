<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Error</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="<c:url value='/final-project/css/style.css'/>" rel="stylesheet"/>
	<link href="<c:url value='/final-project/css/error.css'/>" rel="stylesheet"/>
	<script src="https://js.stripe.com/v3/"></script>
</head>
<body>
	<section class="section-404 py-5">
        <div class="container">
            <div class="thumb-404">
                <img src="<c:url value='/assets/images/404.png'/>" alt="404" style="width: 100%;">
            </div>
            <h3 class="title mb-4 fw-bold text-center">Oops.. looks like you got lost :( </h3>
            <div class="d-flex justify-content-center">
            	<a href="<c:url value='/movietickets'/>" class="btn btn-primary px-4 py-2">Back To Home</a>
            </div>
        </div>
    </section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>