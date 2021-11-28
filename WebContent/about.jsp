<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>About</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
	<link rel="stylesheet" href="<c:url value='/css/about.css'/>"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
<%@ include file="/common/topbar.jsp" %>	
	<div class="main">
		<div class="container">
			<div class="row">
				<div class="text-center my-3">
					<h2>Our Members</h2>
				</div>
				<div class="col-md-4 col-lg-4">
					<div class="profile-container">
						<div class="profile-cover">						
							<img class="cover-img" src="<c:url value='/assets/images/road.jpg'/>" alt="bg"/>						
							<img class="profile-img" src="<c:url value='/assets/images/houseinlake.jpg'/>" alt="profile"/>
						</div>
						<div class="profile-info">
							<p class="title">Vy Minh Khanh Hoa</p>
							<p class="profile-desc">Core member</p>
							<a class="btn btn-primary text-center" href="<c:url value='/members?name=hoa'/>">View details</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-lg-4">
					<div class="profile-container">
						<div class="profile-cover">						
							<img class="cover-img" src="<c:url value='/assets/images/horizon.jpg'/>" alt="bg">						
							<img class="profile-img" src="<c:url value='/assets/images/sea1.jpg'/>" alt="profile">
						</div>
						<div class="profile-info">
							<p class="title">Bui Dinh Xuan</p>
							<p class="profile-desc">Core member</p>
						</div>
						<a class="btn btn-primary text-center" href="<c:url value='/members?name=xuan'/>">View details</a>
					</div>
				</div>
				<div class="col-md-4 col-lg-4">
					<div class="profile-container">
						<div class="profile-cover">						
							<img class="cover-img" src="<c:url value='/assets/images/world.jpg'/>" alt="bg">						
							<img class="profile-img" src="<c:url value='/assets/images/sea2.jpg'/>" alt="profile">
						</div>
						<div class="profile-info">
							<p class="title">Tran Manh Cuong</p>
							<p class="profile-desc">Core member</p>
						</div>
						<a class="btn btn-primary text-center" href="<c:url value='/members?name=cuong'/>">View details</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="text-center mt-3">
					<a href="final-project" class="text-decoration-none" style="color: rgb(114 75 106)">
						<h2>Final Project</h2>
					</a>
				</div>
				<div class="col-md-12">
					<div class="project-container">
						<img class="lazy loaded" src="<c:url value='/assets/images/final-project.png'/>" data-src="<c:url value='/assets/images/final-project.png'/>" data-was-process="true"/>
						<a href="<c:url value='/final-project'/>">
							<div class="description-hover overlay">
								<div class="description-info">
									<div class="text-uppercase btn btn-outline-primary">View details</div>
								</div>
							</div>
						</a>	
					</div>
				</div>
			</div>
		</div>
	</div>
<%@ include file="/common/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>