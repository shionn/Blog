<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="content" fragment="true" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="posts">Articles</a></li>
			<li><a href="comments">Commentaires</a></li>
		</ul>
	</div>
	<div class="page">
    <jsp:invoke fragment="content"/>
	</div>
</body>
</html>