<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts">
	</jsp:attribute>
	<jsp:attribute name="content">
		<table class="pure-table pure-table-horizontal">
			<thead>
				<tr>
					<th>Id</th>
					<th>Titre</th>
					<th>Url</th>
					<th>#</th>
				</tr>
			</thead>
	
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.title}</td>
						<td>${category.url}</td>
						<td>
							<a href="<spring:url value="/adm/category/edit/${category.id}"/>" class="fa fa-pencil"></a>
							<a href="<spring:url value="/adm"/>" class="fa fa-eraser"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</t:template>
