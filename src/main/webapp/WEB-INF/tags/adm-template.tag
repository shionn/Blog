<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="scripts" fragment="true"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/css/" var="css" />
<link rel="stylesheet" href="${css}pure/pure-min.css" />
<link rel="stylesheet" href="${css}generated/admin.css" />
</head>
<body>
	<div class="content pure-g">
		<div id="menu" class="pure-u-1-12">
			<div class="pure-menu custom-restricted-width">
				<spring:url value="/adm" var="url" htmlEscape="true" />
				<a href="${url}" class="pure-menu-heading">Admin</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item<c:if test="${activepage == \"posts\"}"> pure-menu-selected</c:if>"><a
						href="${url}/posts" class="pure-menu-link">Articles</a></li>
					<li class="pure-menu-item<c:if test="${activepage == \"comments\"}"> pure-menu-selected</c:if>"><a
						href="${url}/comments" class="pure-menu-link">Commentaires</a></li>
				</ul>
			</div>
		</div>

		<div id="content" class="pure-u-11-12">
			<jsp:invoke fragment="content" />
		</div>
	</div>
	<spring:url value="/js/" var="js" />
	<script type="text/javascript" src="${js}lib/jquery-3.1.0.min.js"></script>
	<jsp:invoke fragment="scripts" />
</body>
</html>