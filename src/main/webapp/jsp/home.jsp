<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

<spring:url value="/css/generated/style.css" var="styleCss" />

<link rel="stylesheet" href="${styleCss}" />

</head>
<body>
	<header class="container">
		<div class="banner">
			<h1>
				<a href="/">Shionn::Blog()</a>
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
			<article>
				<header>
					<img
						src="http://www.shionn.org/wp-content/uploads/Magic-The-Gathering-Tactics-6151-604x270.jpg" />
					<h1>Un titre d'article pas fou</h1>
					<span class="date">25 octobre 2015</span>
					<a href="#">category</a><a href="#"> tags</a>
				</header>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eros orci, malesuada quis
					lorem vel, ultricies tempus felis. Proin eleifend lacus a fringilla condimentum. Fusce nec
					pellentesque nibh, ut maximus mauris. Maecenas eu orci nulla. Praesent eget magna ac dui
					condimentum suscipit et sit amet tellus. Nulla pellentesque leo vel ante volutpat, at tincidunt
					mi elementum. Aenean sit amet tellus aliquam, feugiat tellus ac, lacinia sem. Ut tempus rhoncus
					pretium. Ut luctus congue velit quis lobortis. Vestibulum luctus tortor ac sollicitudin dictum.
					Etiam aliquet neque ut mauris porttitor rhoncus. Nullam nec lacus ut nulla suscipit porttitor
					ut eu sem. Phasellus eget blandit nunc, eu placerat risus. Vestibulum elit ex, posuere sed
					molestie vel, pretium vitae diam. Proin consequat ac augue et sagittis. Nam lobortis accumsan
					sagittis. In tincidunt elit vitae tincidunt iaculis. Curabitur ut magna convallis, faucibus
					ante vel</p>
				<h2>Un sous titre</h2>
				<p>congue turpis. Sed gravida metus ut pulvinar feugiat. Donec auctor ipsum sed lectus
					elementum faucibus. Maecenas ac cursus lectus. Proin mollis nisi ipsum, nec aliquam felis
					condimentum sodales. Curabitur fermentum condimentum nisi, quis aliquam magna ultrices et.
					Fusce eget placerat leo. Cras felis nunc, feugiat ut justo vel, luctus sollicitudin magna.
					Mauris a eros eget odio maximus</p>
				<p>Ce nombre ${message.a} à été injecté</p>
				<h3>un sous sous titre</h3>
				<p>tincidunt vitae auctor lorem. Curabitur eget purus eu lectus laoreet rutrum. Etiam tellus
					justo, feugiat id congue a, facilisis sit amet sapien. Nulla id tellus consequat, hendrerit
					elit a, tempus risus. Nam eget lorem quis massa gravida egestas. Quisque ullamcorper sapien sed
					iaculis commodo. Ut eu tempus nibh, vel interdum sapien. Duis non tortor vel nunc vehicula
					faucibus in ac risus. Proin id purus sem. Praesent ullamcorper justo vitae elit sollicitudin
					imperdiet. Sed sagittis, sem non rhoncus faucibus, odio ante egestas sem, vitae dapibus nibh
					urna ac est. Pellentesque sodales elementum nunc, vitae laoreet enim pulvinar et. Proin lacinia
					non massa a euismod. Morbi iaculis purus et purus rutrum venenatis. Vivamus ornare, arcu sit
					amet aliquam porta, leo sapien suscipit ligula, eget ultrices nisl lectus non orci. Nulla non
					imperdiet odio. Quisque semper nisl at pellentesque faucibus. Donec accumsan magna sed velit
					eleifend auctor. Donec erat purus, feugiat a ante vel, ultricies placerat ex. Cras in mollis
					augue. Maecenas tristique, ante vitae euismod aliquam, est mi semper purus, sit amet
					sollicitudin nunc mi non velit. Nunc viverra cursus erat, et feugiat nulla sollicitudin id.
					Vivamus congue placerat sem ut sollicitudin. Mauris ut urna porttitor, laoreet turpis a,
					accumsan velit. Nam mollis, risus rutrum varius accumsan, massa ipsum fringilla ex, sit amet
					laoreet urna leo ac nibh. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas
					odio velit, pulvinar vitae nunc a, feugiat eleifend enim. Quisque efficitur placerat efficitur.
					Maecenas rutrum turpis a sagittis eleifend. Aenean rhoncus iaculis sagittis. Aliquam odio dui,
					dapibus placerat neque non, volutpat congue ligula. Nunc at sagittis ligula.</p>
				<footer>
					<a>Laisser un commentaire</a>
				</footer>
			</article>
		</div>
		<div class="side">
			<div class="lastcomment">
				<h1>Commentaires récents</h1>
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
				<h1>Tags</h1>
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
	<spring:url value="/js/lib/jquery-3.1.0.min.js" var="jqueryJs" />
	<spring:url value="/js/menu.js" var="menuJs" />

	<script src="${jqueryJs}"></script>
	<script src="${menuJs}"></script>
</body>
</html>