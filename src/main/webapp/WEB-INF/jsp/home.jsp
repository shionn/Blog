<%@ page pageEncoding="UTF-8"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="content">
		<c:forEach items="${posts}" var="post">
			<article>
				<header>
					<img src="http://www.shionn.org/wp-content/uploads/Magic-The-Gathering-Tactics-6151-604x270.jpg" />
					<h1><a href="<spring:url value="/${post.url}"/>">${post.title}</a></h1>
					<span class="date">25 octobre 2015</span>
					<a href="#">category</a><a href="#"> tags</a>
				</header>
				<section>${post.content}</section>
				<footer>
					<a href="<spring:url value="/${post.url}#comments"/>">Laisser un commentaire</a>
				</footer>
			</article>
		</c:forEach>
	</jsp:attribute>
</t:template>