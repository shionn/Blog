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

<link rel="stylesheet" href="<spring:url value="/css/pure/pure-min.css"/>" /> 
<link rel="stylesheet" href="<spring:url value="/css/generated/admin.css"/>" />
</head>
<body>
	<div class="content pure-g">
		<div id="menu" class="pure-u-1-6">
			<div class="pure-menu custom-restricted-width">
				<a href="<spring:url value="/adm"/>" class="pure-menu-heading">Admin</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item<c:if test="${activepage == \"posts\"}"> pure-menu-selected</c:if>">
						<a href="<spring:url value="/adm/posts"/>" class="pure-menu-link">Articles</a>
					</li>
					<li class="pure-menu-item<c:if test="${activepage == \"comments\"}"> pure-menu-selected</c:if>">
						<a href="<spring:url value="/adm"/>" class="pure-menu-link">Commentaires (X)</a>
					</li>
					<li class="pure-menu-item">
						<a href="<spring:url value="/"/>" class="pure-menu-link">Blog</a>
					</li>
					<li class="pure-menu-item">
						<a href="<spring:url value="/logout"/>" class="pure-menu-link">Déconnexion</a>
					</li>
				</ul>
			</div>
		</div>

		<div id="content" class="pure-u-5-6">
			<jsp:invoke fragment="content" />
		</div>
	</div>

	<script type="text/javascript" src="<spring:url value="/js/lib/jquery-3.1.0.min.js"/>"></script>
	<jsp:invoke fragment="scripts" />
</body>
</html>