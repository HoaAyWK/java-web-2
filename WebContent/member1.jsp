<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Member: Vy Minh Khanh Hoa</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/favicon.ico'/>">
	<link rel="stylesheet" href="<c:url value='/css/member.css'/>"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
<%@ include file="common/topbar.jsp" %>	
	<div class="main">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="profile-cover">						
						<img class="cover-img" src="<c:url value='/assets/images/road.jpg'/>" alt="bg">						
						<img class="profile-img" src="<c:url value='/assets/images/houseinlake.jpg'/>" alt="profile">
					</div>
					<div class="profile-infor d-flex flex-column align-items-center justify-content-center">
						<h2 class="profile-name">Vy Minh Khánh Hoa</h2>
						<p class="profile-desc">Sinh viên trường Đại học Sư Phạm Kỹ thuật TpHCM</p>
					</div>
					<div class="profile-detail">
						<div class="my-3 text-center">
							<h3>Thông tin</h3>
						</div>
						<div class="d-flex">
							<div class="info-left flex-grow-1">
								<h4>Mã số sinh viên</h4>
								<p class="profile-desc">19110205</p>
								<h4>Địa chỉ email</h4>
								<p class="profile-desc">19110205@student.hcmute.edu.vn</p>
								<h4>Sở thích</h4>
								<p class="profile-desc">Xem phim, nghe nhạc, chơi game,...</p>
							</div>
							<div class="info-right flex-grow-1">
								<h4>Nhiệm vụ</h4>
								<p class="profile-desc">Đảm nhận phần view, controller, model</p>
								<p class="profile-desc">Debug</p>								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</div>
<%@ include file="common/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>