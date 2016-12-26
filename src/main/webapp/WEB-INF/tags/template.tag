<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/frag" %>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="scripts" fragment="true"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link rel="stylesheet" href="<spring:url value="/css/generated/style.css"/>" />
</head>
<body>
	<header class="container">
		<div class="banner">
			<h1>
				<a href="<spring:url value="/"/>">Shionn::Blog()</a>
			</h1>
			<h2>GCS/O d- s+:+ a C++ UL P L+++ E--- W++ N K- w--- M- PS PE-- Y- PGP- t+ 5 X R+ !tv b+ D+
				G- e+++ h+ r++ y+</h2>
		</div>
		<nav class="main-menu">
			<a href="#">${menu.title}</a>
			<t:menu menu="${menu}"/>
		</nav>
	</header>
	<div class="container">
		<div class="main">
			<jsp:invoke fragment="content" />
		</div>
		<div class="side">
			<div class="lastcomment">
				<h1><span class="fa fa-comments"></span> Commentaires récents</h1>
				<ul>
					<li>auteur dans <a href="#">un article pas fou</a></li>
					<li>le patron dans <a href="#">un article pas fou de truc</a></li>
					<li>auteur dans <a href="#">un qui rox pas</a></li>
					<li>auteur dans <a href="#">c'etait mieux avant</a></li>
					<li>le koala <a href="#">un article pas fou</a></li>
					<li>auteur dans <a href="#">un article pas fou</a></li>
				</ul>
			</div>
			<div class="tagclood">
				<h1><span class="fa fa-flag"></span> Tags</h1>
				<c:forEach items="${tags}" var="tag">
					<a href="<spring:url value="/tag/${tag.url}"/>">${tag.title}(${tag.postCount})</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<span>Moteur de bog</span>
		</div>
	</footer>
	
	<script type="text/javascript" src="<spring:url value="/js/lib/jquery-3.1.0.min.js" />"></script>
	<script type="text/javascript" src="<spring:url value="/js/lib/highlight-9.8.0-java.min.js"/>"></script>
	<script type="text/javascript" src="<spring:url value="/js/menu.js" />"></script>
	<script type="text/javascript">hljs.initHighlightingOnLoad();</script>
</body>
</html>