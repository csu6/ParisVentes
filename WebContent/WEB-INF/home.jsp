
	
<%@ include file="layouts/header.jsp" %>
	<style>
	body {
		background: url('img/bg.jpg');
	}
	</style>

	<section>
	<c:forEach var="article" items="${articles}">
	
		<article><h4>
		 ${article.getTitle()} </h4><figure><a href="${pageContext.request.contextPath}/article?id=${article.getId()}">
		 <img src="<%=request.getContextPath()%>/img/${article.getLinkImg()}" alt=""></a>
		 <figcaption>
		${article.getDescription()} + "</figcaption></figure><span>
		${article.price} + "</span></article>
		
	</c:forEach>

	</section>
	</div>

<%@ include file="layouts/footer.jsp" %>