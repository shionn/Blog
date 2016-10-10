<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:adm-template>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="<spring:url value="/js/adm/posts.js"/>"></script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<table class="pure-table pure-table-horizontal">
			<thead>
				<tr>
					<th>Titre</th>
					<th><a href="?sortby=published">Publié</a></th>
					<th><a href="?sortby=updated">Mise à Jour</a></th>
					<th>
						<form class="pure-form filter" method="get">
							<select name="type">
								<option<c:if test="${filters.type == \"post\"}"> selected="selected"</c:if>>post</option>
								<option<c:if test="${filters.type == \"page\"}"> selected="selected"</c:if>>page</option>
							</select>
						</form>
					</th>
					<th>
						<form class="pure-form filter" method="get">
							<select name="status">
								<option<c:if test="${filters.status == shionn.blog.db.dbo.Post.Status.draft}"> selected="selected"</c:if>>draft</option>
								<option<c:if test="${filters.status == shionn.blog.db.dbo.Post.Status.publish}"> selected="selected"</c:if>>publish</option>
							</select>
						</form>
					</th>
					<th>#</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach items="${posts}" var="post">
					<tr>
						<td><c:out value="${post.title}" /></td>
						<td><fmt:formatDate pattern="MM/dd/yyyy" value="${post.published}" /></td>
						<td><fmt:formatDate pattern="MM/dd/yyyy" value="${post.updated}" /></td>
						<td><c:out value="${post.type}" /></td>
						<td><c:out value="${post.status}" /></td>
						<td>Edit</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</t:adm-template>
