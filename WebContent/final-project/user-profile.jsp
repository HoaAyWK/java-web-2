<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Profile</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
	<link href="<c:url value='/final-project/css/user-profile.css'/>" rel="stylesheet"/>
</head>
<body>
	<%@ include file="/final-project/topbar.jsp" %>
	<section class="details-banner hero-area bg_img seat-plan-banner" data-background="<c:url value='/assets/images/banner04.jpg'/>" style="background-image: url(<c:url value='/assets/images/banner04.jpg'/>)">
        <div class="container">
            <div class="details-banner-wrapper">
                <div class="details-banner-content style-two">
                	<div class="d-flex justify-content-center">
                		<h1 class="title">Your Profile</h1>
                	</div>                   
                    <form action="" class="p-2 rounded profile-info" method="post" style="min-width: 500px;">
                    	<div class="mb-2">
                    		<label class="form-lable" for="name">Name</label>
                    		<input class="form-control" name="name" value="${account.username}" required>
                    	</div>
	                    <div class="mb-2">
                    		<label class="form-lable" for="email">Email</label>
                    		<input class="form-control" name="email" value="${account.email}" disabled>
                    	</div>
	                    <div class="mb-2">
                    		<label class="form-lable" for="phone">Phone</label>
                    		<input class="form-control" name="phone" value="${account.phone}">
                    	</div>
                    	<div class="mb-2">
                    		<label class="form-lable" for="address">Address</label>
                    		<input class="form-control" name="address" value="${account.address}">
                    	</div>
	                    <div class="d-flex justify-content-center">
	                    	<button class="btn btn-success" type="submit">Update</button>
	                    </div>	                    
	               </form>
                </div>
            </div>
        </div>
    </section>
    <section class="page-title bg-one">
    	<div class="container">
    		<div class="row">
    			<div class="col d-flex justify-content-center align-items-center">
    				<div class="select-showtime d-flex justify-content-center align-items-center">
    					<h2 class="text-capitalize">List of purchased movies</h2>
    				</div>
    			</div>
    		</div>
    	</div>
    </section>
    <div class="ticket-plan-section py-5">
    	<div class="container">
    		<div class="row d-flex justify-content-center">
    			<div class="col-lg-9 mb-5 mb-lg-0">
    				<table class="table">
						<thead>
							<tr style="background: #162f5f; color: #fff;">
								<th>No.</th>										
								<th>Movie</th>
								<th>Cinema</th>
								<th>Start At</th>
								<th>Date</th>
								<th>No. Tickets</th>
								<th>Total Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="reservation" items="${reservations}" varStatus="loop">
								<tr style="background: #001232; color: #ccc;">
									<td>${loop.count}.</td>
									<td><c:out value="${lstMovieName.get(loop.index)}"/></td>	
									<td><c:out value="${lstCinemaName.get(loop.index)}"/></td>
									<td>${reservation.startAt}</td>
									<td>${reservation.date}</td>
									<td>${reservation.total}</td>
									<td><span>$</span>${reservation.total * 10}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>	
    			</div>
    		</div>
    	</div>
    </div>
    <%@ include file="/final-project/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="<c:url value='/assets/js/topbar-scroll.js'/>"></script>
</body>
</html>