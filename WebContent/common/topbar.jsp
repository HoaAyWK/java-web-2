	<header class="navbar navbar-expand-lg navbar-light sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="home">
			  	<img class="logo" src="<c:url value='/assets/favicon/favicon-32x32.png'/>" alt="logo" />
			</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			     	<li class="nav-item">
			        	<a class="nav-link active" aria-current="page" href="home">Home</a>
			    	 </li>
			      	 <li class="nav-item">
			        	<a class="nav-link" href="about">About</a>
			      	 </li>
			      	 <li class="nav-item dropdown">
			        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			          		Exercises
			        	</a>
				        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
				          	<li><a class="dropdown-item" href="<c:url value='/ex1-email-list/emailList'/>" target="_blank">Exercise 1</a></li>
				          	<li><a class="dropdown-item" href="https://drive.google.com/drive/folders/1miQ8UIP12gq1YwNO1cff2xet-vVZlTa-" target="_blank">Exercise 2</a></li>
				          	<li><a class="dropdown-item" href="<c:url value='/ex3-music-store/download'/>" target="_blank">Exercise 3</a></li>
				          	<li><a class="dropdown-item" href="<c:url value='/ex4-cart/loadProducts'/>" target="_blank">Exercise 4</a></li>
				          	<li><a class="dropdown-item" href="<c:url value='/ex5-admin-app/users'/>" target="_blank">Exercise 5</a></li>
			        	</ul>
			      	</li>
			      	<li class="nav-item">
			      		<a class="nav-link" href="<c:url value='movietickets'/>" target="_blank">Final Project</a>
			      	</li>
			    </ul>
		     </div>
		 </div>
	</header>