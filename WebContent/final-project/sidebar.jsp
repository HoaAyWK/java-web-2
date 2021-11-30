<div class="sidebar d-flex flex-column flex-shrink-0 text-white bg-dark"
	style="width: 280px;">
	<div
		class="logo-wrapper mb-4 d-flex justify-content-center align-items-center"
		style="border-bottom: 1px solid #ddd; height: 48px;">
		<a href="/"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
			<img class="logo me-2"
			src="<c:url value='/assets/favicon/popcorn-32x32.png'/>" alt="logo" />
			<span class="fs-5">MovieTickets</span>
		</a>
	</div>
	<ul class="nav nav-pills flex-column mb-auto px-3">
		<li class="nav-item"><a href="<c:url value='/admin'/>"
			class="nav-link active" aria-current="page"> <i
				class="fas fa-home me-2 bi"></i> Home
		</a></li>
		<li><a href="<c:url value='/admin/orders'/>"
			class="nav-link text-white"> <i
				class="fas fa-calendar-alt me-2 bi"></i> Orders
		</a></li>
		<li><a href="<c:url value='/admin/movies'/>"
			class="nav-link text-white"> <i class="fas fa-film me-2 bi"></i>
				Movies
		</a></li>
		<li><a href="<c:url value='/admin/customers'/>"
			class="nav-link text-white"> <i class="fas fa-user-alt me-2 bi"></i>
				Customers
		</a></li>
		<li><a href="<c:url value='/admin/cinemas'/>"
			class="nav-link text-white"> <i
				class="fas fa-user-alt me-2 bi"></i> Cinemas
		</a></li>
		<li><a href="<c:url value='/admin/sessions'/>" class="nav-link text-white">
				<i class="fas fa-clipboard-list me-2 bi"></i> Sessions
		</a></li>
	</ul>
</div>