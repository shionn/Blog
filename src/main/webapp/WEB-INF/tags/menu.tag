<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="menu" required="true"%>
<ul>
	<c:forEach items="${menu.items}" var="item">
		<li><a href="<spring:url value="${item.url}"/>">${item.title}</a>
			<c:if test="${not empty item.items}">
				<t:menu menu="${item}"></t:menu>
			</c:if>
		</li>
	</c:forEach>
</ul>