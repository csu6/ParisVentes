

<%@ include file="layouts/header.jsp"%>
<style>
body {
	padding-top: 30px;
}

.glyphicon {
	margin-bottom: 10px;
	margin-right: 10px;
}

small {
	display: block;
	line-height: 1.428571429;
	color: #999;
}

.container {
	margin: 20px;
}
</style>




<div class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="well well-sm">
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<img src="#" alt=""
							class="img-rounded img-responsive" />
					</div>
					<div class="col-sm-6 col-md-8">
						<h4>${user.firstname} ${fn:toUpperCase(user.lastname)}</h4>
						<p>
							<i class="glyphicon glyphicon-envelope"></i> ${user.email} <br />
							<i class="glyphicon glyphicon-phone"></i>${user.phone}</p>
	
					</div>
					<div class="col-sm-12">
						<div class="row">
						<br />
						<br />
							<form class="form-signin" style="" method="POST" class="" action="${pageContext.request.contextPath}/login">
								<input type="submit" name="logout"  value="Se déconnecter"
									id="logout" class="form-control btn btn-danger" />

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<%@ include file="layouts/footer.jsp"%>