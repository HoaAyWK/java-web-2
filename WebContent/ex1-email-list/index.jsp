<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/ex1-email-list/includes/header.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="text-center">
				    <h1>Join our email list</h1>
				    <p>To join email list, enter your name and email address below</p>
			    </div>
			    <div class="bg-light mb-2 p-4 rounded">
			        <form action="emailList" method="post">
			            <input type="hidden" name="action" value="add"/>
			            <div class="mb-3">
				            <label class="form-label">Email:</label>
				            <input class="form-control" type="email" name="email" required/>
				        </div>
				        <div class="mb-3">
				            <label class="form-label">First name:</label>
				            <input class="form-control" type="text" name="firstName" required/>
			            </div>
			            <div class="mb-3">
				            <label class="form-label">Last name:</label>
				            <input class="form-control" type="text" name="lastName" required/>
				        </div>
			            <div class="d-flex justify-content-center">
			                <button type="submit" class="btn btn-primary">Join now</button>
			            </div>
			         </form>
			    </div>
		    </div>
	    </div>
    </div>
<c:import url="/ex1-email-list/includes/footer.jsp"/>