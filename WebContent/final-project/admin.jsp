<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Movie Tickets</title>
	<link rel="shortcut icon" type="image/png/x-icon" href="<c:url value='/assets/favicon/popcorn-favicon.ico'/>">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="<c:url value='/final-project/css/admin1.css'/>" rel="stylesheet"/>
	<script src="https://kit.fontawesome.com/d99e1d4bab.js"></script>
</head>
<body>
	<main>
		<%@ include file="sidebar.jsp" %>
		<div class="side-wrapper" style="width: 100%; background-color: #edf3f9;">
			<%@ include file="header.jsp" %>
			<div class="container side-content">
				<div class="row">
					<div class="col-md-12">
						<div class="table-wrapper" style="background-color: #fff!important;">
							<div class="d-flex justify-content-center py-2" style="border: 1px solid #ccc;">
								<h4 class="text-capitalize">Contact us</h4>
							</div>
							<ul class="d-flex list-unstyled justify-content-between py-4" style="border: 1px solid #ccc;
								box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
								<li>
									<div class="m-2 p-2 rounded" style="background-color: #edf3f9;
										box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
										<ul class="d-flex list-unstyled">
											<li class="me-2">
												<h6>Founder</h6>
												<h5>Khánh Hoa</h5>
												<p>Address: LĐ - VN</p>
												<p>Phone: +84 987654321</p>
											</li>
											<li>
												<div class="d-flex jusify-content-center align-items-center px-2"
													style="height: 100%;">
													<%-- <img src="<c:url value='/assets/images/houseinlake.jpg'/>"
														style="width: 120px; height: 120px; border-radius: 50%;
														border: 1px solid #ddd;" alt="avatar"> --%>
													<i class="far fa-user-circle fa-4x"></i>
												</div>
											</li>
										</ul>
									</div>
								</li>
								<li>
									<div class="m-2 p-2 rounded" style="background-color: #edf3f9;
										box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
										<ul class="d-flex list-unstyled">
											<li class="me-2">
												<h6>Co-Founder</h6>
												<h5>Đình Xuân</h5>
												<p>Address: BRVT - VN</p>
												<p>Phone: +84 987654321</p>
											</li>
											<li>
												<div class="d-flex jusify-content-center align-items-center px-2"
													style="height: 100%;">
													<%-- <img src="<c:url value='/assets/images/sea1.jpg'/>"
														style="width: 120px; height: 120px; border-radius: 50%;
														border: 1px solid #ddd;" alt="avatar"> --%>
													<i class="far fa-user-circle fa-4x"></i>
												</div>
											</li>
										</ul>
									</div>
								</li>
								<li>
									<div class="m-2 p-2 rounded" style="background-color: #edf3f9;
										box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
										<ul class="d-flex list-unstyled">
											<li>
												<h6>Co-Founder</h6>
												<h5>Mạnh Cường</h5>
												<p>Address: BĐ - VN</p>
												<p>Phone: +84 987654321</p>
											</li>
											<li>
												<div class="d-flex jusify-content-center align-items-center px-2"
												style="height: 100%;">
													<%-- <img src="<c:url value='/assets/images/sea2.jpg'/>"
														style="width: 120px; height: 120px; border-radius: 50%;
														border: 1px solid #ddd" alt="avatar"> --%>
													<i class="far fa-user-circle fa-4x"></i>
												</div>
											</li>
										</ul>
									</div>
								</li>										
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>