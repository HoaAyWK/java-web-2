<div class="d-flex flex-wrap align-items-center justify-content-between py-2 mb-3 sticky-top" 
	style="background-color: #fff; box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 5%), inset 0 -1px 0 rgb(0 0 0 / 15%);">
	<a href=""
		class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
		<svg class="bi me-2" width="40" height="32" role="img"
			aria-label="Bootstrap">
			<use xlink:href="#bootstrap"></use></svg>
	</a>	
	<div class="dropdown text-end me-4">		
		<a href="<c:url value='/admin/admin-profile'/>"
			class="d-block link-dark text-decoration-none dropdown-toggle"
			id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
			<i class="fas fa-user-circle me-1 bi"></i>
		</a>
		<ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1"
			style="">
			<li><a class="dropdown-item" href="<c:url value='/admin/admin-profile'/>">Profile</a></li>
			<li><hr class="dropdown-divider"></li>
			<li><a class="dropdown-item" href="<c:url value='/movietickets/signout'/>">Sign out</a></li>
		</ul>
	</div>
</div>