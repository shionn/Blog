<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:adm-template>
	<jsp:attribute name="scripts"></jsp:attribute>
	<jsp:attribute name="content">
		<form class="pure-form pure-form-stacked" method="post">
			<fieldset>
				<legend>Edition de ${post.id}</legend>
				<label for="title">Titre</label>
				<input id="title" name="title" type="text" class="pure-input-1" placeholder="Title" value="${post.title}">
				
				<label for="content">Contenu</label>
				<textarea class="pure-input-1" placeholder="Contenu" rows="30" name="content">${post.content}</textarea>
				<button type="submit" class="pure-button pure-button-primary">Sauvegarder</button>
			</fieldset>
		</form>
		TODO : liste des sauvegarde
	</jsp:attribute>
</t:adm-template>
