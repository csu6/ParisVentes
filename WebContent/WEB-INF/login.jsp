
<%@ include file="layouts/header.jsp"%>
<style>
body {
	background: url('img/bg.jpg');
}

.container2 {
	padding: 20px;
	margin: 20px;
	background: #c0c0c0;
}
</style>


<div class="container2">


	<c:out value="" default="hello"></c:out>


	<c:if test="${sessionScope.isLog}">
		<p>${msg}</p>
		<div class="row">
		<form class="form-signin" method="POST" class="">
			<input type="submit" name="logout" value="Se déconnecter" id="logout" 	class="form-control btn btn-danger" />

		</form>
		</div>


		<h1>
			Bonjour
			<c:out value="${personne.firstname}" default="Inconnu" />
		</h1>
		<p>
			Ton email est :
			<c:out value="${sessionScope.email}" default="hello" />
		</p>



		<br />
		<p class="h3">Voici la liste de tes amis inscrits :</p>
		<table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Phone</th>
		    </tr>
		  </thead>
		  <tbody>	
			<c:forEach var="user" items="${listPersonne}" varStatus="status">
			<c:if test="${personne.id != user.id}">
			    <tr>
			      <th scope="row"><a href="${pageContext.request.contextPath}/user?id=${user.id}">${status.count}</a></th>
			      <td><a href="${pageContext.request.contextPath}/user?id=${user.id}">${user.firstname}</a></td>
			      <td><a href="${pageContext.request.contextPath}/user?id=${user.id}">${user.lastname}</a></td>
			      <td>${user.email}</td>
			      <td>${user.phone}</td>
			    </tr>
		    </c:if>
			</c:forEach>
		  </tbody>
		</table>
				
	</c:if>

	<br /> <br />
	<c:if test="${not sessionScope.isLog}">
		<form class="form-signin" method="POST">
			<p>${msg}</p>
			<h2 class="form-signin-heading">Please sign in :
				${sessionScope.email}</h2>
			<label for="inputEmail" class="sr-only">Email</label> <input
				type="email" name="email" id="inputEmail" class="form-control"
				placeholder="Email address" autofocus> <label
				for="inputPassword" class="sr-only">Mot de passe</label> <input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Mot de passe">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Connexion</button>
		</form>
	</c:if>



	<c:forEach var="entry" items="${requestScope['myCollection']}"
		begin="0" end="9">
      ${entry}<br />
	</c:forEach>
	<!-- Afficher seulement les 10 premiers éléments -->
	<c:forEach var="entry" begin="1" end="10">${entry} </c:forEach>
	<br />
	<c:forEach var="entry" items="${str}" varStatus="status"> ${entry} => ${status.getIndex()}/${status.count} <br />
	</c:forEach>
	<br />

	<c:forTokens items="Hello comment vas-tu?/ Ca va / hello world !!"
		delims="/" var="t">
		<h3>${t}</h3>
		<br />
	</c:forTokens>
	
	<br><br>
		<h1>
		Accueil, Bonjour
		<c:out value="${sessionScope.email}">l'inconnu</c:out>
	</h1>
	<p>Test if</p>
	<p>
		<c:if test="${ 15 le 10}">
		15 est plus grande que 10
		</c:if>
	</p>
	<p>${sessionScope}</p>

	<br /> <br />
	<c:choose>
		<c:when test="${value==null}">value vaut rien</c:when>
		<c:when test="${value==1}">value vaut 1</c:when>
		<c:when test="${value==2}">value vaut 2</c:when>
		<c:when test="${value==3}">value vaut 3</c:when>
		<c:otherwise>value vaut ${value} (?)</c:otherwise>
	</c:choose>
</div>
<!-- /container -->

<%@ include file="layouts/footer.jsp"%>