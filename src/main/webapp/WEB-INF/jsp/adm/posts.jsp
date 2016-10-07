<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:adm-template>
	<jsp:attribute name="content">
		<c:forEach items="${posts}" var="post">
			<c:out value="${post.title}"/>
		</c:forEach>
	</jsp:attribute>
</t:adm-template>
