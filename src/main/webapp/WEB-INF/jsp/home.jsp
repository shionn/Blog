<%@ page pageEncoding="UTF-8"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="content">
		<c:forEach items="${posts}" var="post">
			<article>
				<header>
					<img src="http://www.shionn.org/wp-content/uploads/Magic-The-Gathering-Tactics-6151-604x270.jpg" />
					<h1><a href="<spring:url value="/${post.url}"/>">${post.title}</a></h1>
					<span class="date"><fmt:formatDate pattern="dd MMMM yyyy HH:mm" value="${post.published}" /></span>
					<a class="category" href="<spring:url value="/category/${post.category.url}"/>"><span class="fa fa-folder-open"></span> ${post.category.title}</a>
					<span class="tags">
						<span class="fa fa-flag"></span>
						<c:forEach items="${post.tags}" var="tag" varStatus="status">
							<a href="<spring:url value="/tag/${tag.url}"/>">${tag.title}</a><c:if test="${not status.last}">,</c:if>
						</c:forEach>
					</span>
				</header>
				<section>${post.content}</section>
				<footer>
					<a href="<spring:url value="/${post.url}"/>"><span class="fa fa-eye"></span> Lire la suite</a>
					<c:choose>
						<c:when test="${post.commentCount==0}">
							<a href="<spring:url value="/${post.url}#comments"/>"><span class="fa fa-commenting"></span> Laisser un commentaire.</a>
						</c:when>
						<c:when test="${post.commentCount==1}">
							<a href="<spring:url value="/${post.url}#comments"/>"><span class="fa fa-comment"></span> Afficher le commentaire.</a>
						</c:when>
						<c:otherwise>
							<a href="<spring:url value="/${post.url}#comments"/>"><span class="fa fa-comments"></span> Afficher les ${post.commentCount} commentaires.</a>
						</c:otherwise>
					</c:choose>
				</footer>
			</article>
		</c:forEach>
	</jsp:attribute>
</t:template>