<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t"      tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts">
	</jsp:attribute>
	<jsp:attribute name="content">
		<table class="pure-table pure-table-horizontal">
			<thead>
				<tr>
					<th>Date</th>
					<th>Autheur</th>
					<th>Post</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comments}" var="comment">
					<tr>
						<td style="border-bottom: 0px">
							<fmt:formatDate pattern="dd/MM/yyyy" value="${comment.date}" />
						</td>
						<td style="border-bottom: 0px">
							<a href="mailto:${comment.authorEmail}" title="${comment.authorName}">${fn:substring(comment.authorName,0,15)}</a>
						</td>
						<td style="border-bottom: 0px">
							<a href="<spring:url value="/${comment.post.url}"/>" 
									target="_blank" 
									title="${comment.post.title}">
								${comment.post.title}</a>
						</td>
						<td rowspan="2">
							<a href="<spring:url value="/adm/comment/edit/${comment.id}"/>" class="fa fa-pencil"></a>
							<a href="<spring:url value="/adm"/>" class="fa fa-eraser"></a>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<a href="<spring:url value="/adm/comment/edit/${comment.id}"/>" 
									title="${comment.content}">
								${fn:substring(comment.content, 0, 150)}</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</t:template>
