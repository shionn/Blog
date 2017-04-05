<%@ page pageEncoding="UTF-8"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:template>
	<jsp:attribute name="title">${post.title}</jsp:attribute>
	<jsp:attribute name="content">
		<article>
			<header>
				<c:if test="${post.logo != null}">
					<img src="<spring:url value="/img/${post.logo}"/>" />
				</c:if>
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
				<em class="author">par ${post.author.name}, dernière modification le <fmt:formatDate pattern="dd MMMM yyyy HH:mm" value="${post.updated}" /></em>
				<hr>
			</footer>
		</article>
		<section class="comments">
			<a name="comments"></a>
			${post.commentCount} réflexions au sujet de « ${post.title} »
			<ul>
				<c:forEach items="${post.comments}" var="comment" varStatus="loop">
					<li>
						<c:if test="${loop.last}"><a name="lastcomment"></a></c:if>
						<div class="author">
							<img src="https://www.gravatar.com/avatar/${comment.gravatar}?d=retro&s=74&r=g"></img>
							<span>
								<c:if test="${not empty comment.authorWeb}">
									<a href="${comment.authorWeb}" target="_blank">${comment.authorName}</a>
								</c:if>
								<c:if test="${empty comment.authorWeb}">
									${comment.authorName}
								</c:if>
							</span>
							<span class="date"><fmt:formatDate pattern="dd MMMM yyyy HH:mm" value="${comment.date}" /></span>
						</div>
						<div class="content">
							<p>${comment.content}</p>
						</div>
					</li>
				</c:forEach>
			</ul>
			<spring:url value="/${post.url}/comment" var="posturl"/>
			<form:form method="post" action="${posturl}#lastcomment" >
				<p class="title">Laissez un commentaire</p>
				<fieldset>
					<label for="authorName">Nom</label><input name="authorName" type="text" required="required" placeholder="Pseudonyme" value="${user.name}"<c:if test="${not empty user.name}"> readonly="readonly"</c:if>>
				</fieldset>
				<fieldset>
					<label for="authorEmail">E-Mail</label><input name="authorEmail" type="email" required="required" placeholder="email" value="${user.email}"<c:if test="${not empty user.email}"> readonly="readonly"</c:if>>
				</fieldset>
				<fieldset>
					<label for="authorWeb">Site web</label><input name="authorWeb" type="text" placeholder="Votre site internet" value="${user.web}"<c:if test="${not empty user.web}"> readonly="readonly"</c:if>>
				</fieldset>
				<fieldset>
					<label for="content">Commentaire</label>
					<textarea name="content"></textarea>
					<p>Vous pouvez utilisez du <a href="">markdown</a> pour la mise en forme<br>
				</fieldset>
				<p><em>Votre adresse de messagerie ne sera pas publiée.</em></p>
				<input type="submit" value="Valider">
			</form:form>
		</section>
	</jsp:attribute>
</t:template>
