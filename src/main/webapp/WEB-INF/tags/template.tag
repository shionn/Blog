<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<a href="#">Toggle</a>
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#s1">Menu 1</a>
					<ul>
						<li><a href="#">Header a</a>
							<ul>
								<li><a href="#">Submenu x</a></li>
								<li><a href="#">Submenu y</a></li>
								<li><a href="#">Submenu z</a></li>
								<li><a href="#">Submenu v</a></li>
								<li><a href="#">Submenu u</a></li>
							</ul></li>
						<li><a href="#">Header b</a>
							<ul>
								<li><a href="#">Submenu x</a></li>
								<li><a href="#">Submenu y</a></li>
								<li><a href="#">Submenu z</a></li>
							</ul></li>
					</ul></li>
				<li><a href="#s2">Menu 2</a>
					<ul>
						<li><a href="#">Header c</a>
							<ul>
								<li><a href="#">Submenu x</a></li>
								<li><a href="#">Submenu y</a></li>
								<li><a href="#">Submenu z</a></li>
							</ul></li>
						<li><a href="#">Header d</a>
							<ul>
								<li><a href="#">Submenu x</a></li>
								<li><a href="#">Submenu y</a></li>
								<li><a href="#">Submenu z</a></li>
								<li><a href="#">Submenu c</a></li>
								<li><a href="#">Submenu d</a></li>
							</ul></li>
						<li><a href="#">Header e</a>
							<ul>
								<li><a href="#">Submenu x</a></li>
								<li class="active"><a href="#">Submenu z</a></li>
								<li><a href="#">Submenu c</a></li>
								<li><a href="#">Submenu d</a></li>
							</ul></li>
					</ul></li>
				<li><a href="#">Menu 3</a></li>
				<li class="active"><a href="#">Menu 4</a></li>
				<li><a href="#">Menu 5</a></li>
			</ul>
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
				<a href="#">Quisque</a> <a href="#">semper</a> <a href="#">nisl</a> <a href="#">at</a> <a
					href="#">pellentesque</a> <a href="#">faucibus.</a> <a href="#">Donec</a> <a href="#">accumsan</a>
				<a href="#">magna sed</a> <a href="#">velit</a> <a href="#">eleifend</a> <a href="#">auctor.</a>
				<a href="#">Donec</a> <a href="#">erat</a> <a href="#">purus,</a> <a href="#">feugiat</a> <a
					href="#">a</a> <a href="#">ante</a> <a href="#">vel, ultricies</a> <a href="#">placerat</a> <a
					href="#">ex.</a> <a href="#">Cras</a> <a href="#">in</a> <a href="#">mollis</a> <a href="#">augue.</a>
				<a href="#">Maecenas</a> <a href="#">tristique, ante</a> <a href="#">vitae</a> <a href="#">euismod</a>
				<a href="#">aliquam,</a> <a href="#">est</a> <a href="#">mi</a> <a href="#">semper</a> <a
					href="#">purus,</a> <a href="#">sit</a> <a href="#">amet</a> <a href="#">sollicitudin</a> <a
					href="#">nunc</a> <a href="#">mi</a>
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