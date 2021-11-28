<%@ include file="/ex1-email-list/includes/header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-8 offset-md-2">
			<div class="text-center">
				<h1>Thank for joining our email list</h1>
				<p>Here is the information that you entered</p>
			</div>
			<div class="p-2 my-3 bg-light rounded mb-3 border-bottom">
				<div class="col-md-6 offset-md-3">
					<label class="fw-bold">Email: </label> <span>${user.email}</span><br>
					<label class="fw-bold">First name: </label> <span>${user.firstName}</span><br>
					<label class="fw-bold">Last name: </label> <span>${user.lastName}</span>
				</div>
				<p class="mb-2 text-center">To enter another email address,
					click on the back button in your Browser or the return button shown
					below</p>
				<form action="emailList" method="get">
					<input type="hidden" name="action" value="join" />
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-success">Return</button>
					</div>
				</form>
			</div>
			<div class="bg-light border-bottom mb-3 p-2">
				<h4 class="text-center">The first tow users of ArrayList of
					User object</h4>
				<h5>1. Email address: ${users[0].email}</h5>
				<h5>2. Email address: ${users[1].email}</h5>
			</div>
			<div class="bg-light mb-3 border-bottom p-2">
				<h4 class="text-center">The customer service email</h4>
				<h5>Email address: ${custServEmail}</h5>
			</div>
		</div>
	</div>
</div>
<%@ include file="/ex1-email-list/includes/footer.jsp" %>