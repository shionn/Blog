<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="<spring:url value="/js/adm/posts.js"/>"></script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<form:form class="pure-form" method="post">
			<fieldset>
				<input type="text" placeholder="Titre" name="title">
				<select name="type">
					<option selected="selected">post</option>
					<option>page</option>
				</select>
				<button type="submit" class="pure-button pure-button-primary">Nouveau</button>
			</fieldset>
		</form:form>
		<table class="pure-table pure-table-horizontal">
			<thead>
				<tr>
					<th>Titre</th>
					<th><a href="?sortby=published">Publié</a></th>
					<th><a href="?sortby=updated">Mise à Jour</a></th>
					<th>
						<form:form class="pure-form filter" method="get">
							<select name="type">
								<option <c:if test="${filters.type == \"post\"}"> selected="selected"</c:if>>post</option>
								<option <c:if test="${filters.type == \"page\"}"> selected="selected"</c:if>>page</option>
							</select>
						</form:form>
					</th>
					<th>
						<form:form class="pure-form filter" method="get">
							<select name="status">
								<option <c:if test="${filters.status == \"draft\"}"> selected="selected"</c:if>>draft</option>
								<option <c:if test="${filters.status == \"publish\"}"> selected="selected"</c:if>>publish</option>
							</select>
						</form:form>
					</th>
					<th>#</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach items="${posts}" var="post">
					<tr>
						<td>${post.title}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${post.published}" /></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${post.updated}" /></td>
						<td>${post.type}</td>
						<td>${post.status}</td>
						<td>
							<a href="<spring:url value="/adm/post/edit/${post.id}"/>" class="fa fa-pencil"></a>
							<a href="<spring:url value="/adm"/>" class="fa fa-eraser"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</t:template>
