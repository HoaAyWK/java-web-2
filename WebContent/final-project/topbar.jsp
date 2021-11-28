<nav id="navbar" class="navbar navbar-expand-lg navbar-light navbar-dark">
	<a class="navbar-brand ms-2" href="<c:url value='/movietickets'/>">
		<img class="logo" src="<c:url value='/assets/favicon/popcorn-32x32.png'/>" alt="logo" />
	</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
    		<li class="nav-item ms-2">
    			<a class="nav-link active" aria-current="page" href="<c:url value='/movietickets'/>">Home</a>
    		</li>
    		<li class="nav-item ms-2 me-3">
    			<a class="nav-link active" aria-current="page" href="<c:url value='/movietickets/about'/>">About</a>
    		</li>
    	</ul>
    	<div class="nav-item dropdown">
    		<c:if test="${validAccount == true}">
	    		<a href="#" class="nav-link dropdown-toggle" id="navbarDropdown" 
	    			role="button" data-bs-toggle="dropdown" aria-expanded="false">${account.username}</a>
	    		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	    			<li><a href="#">Sign Out</a></li>
	    		</ul>
	    	</c:if>
	    	<c:if test="${validAccount == false || validAccount == null}">
	    		<a href="<c:url value='/movietickets/signin'/>" 
	    			class="nav-link dropdown-toggle" id="navbarDropdown" 
	    			role="button" data-bs-toggle="dropdown" aria-expanded="false">Sign In</a>
	    		<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		    		<li><a href="<c:url value='/movietickets/signup'/>">Sign Up</a></li>	    			
	    		</ul>
	    	</c:if>
    	</div>
    </div>
</nav>