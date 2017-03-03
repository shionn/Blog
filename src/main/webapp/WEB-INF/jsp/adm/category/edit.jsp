<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts">
	</jsp:attribute>
	<jsp:attribute name="content">
		<form:form class="pure-form pure-form-aligned" method="post">
			<legend>Edition de ${category.id}</legend>
			<fieldset>
				<div class="pure-control-group">
					<label for="title">Titre</label>
					<input id="title" name="title" type="text" placeholder="Title" value="${category.title}">
				</div>
				<div class="pure-control-group">
					<label for="url">Url</label>
					<input id="url" name="url" type="text" placeholder="Url" value="${category.url}">
				</div>
				<div class="pure-control-group">
					<label for="parent.id">Parent</label>
					<input id="parent.id" name="parent.id" type="text" placeholder="Url" value="${category.parent.id}">
				</div>
				<div class="pure-controls">
					<button type="submit" class="pure-button pure-button-primary">Valider</button>
				</div>
			</fieldset>
		</form:form>
	</jsp:attribute>
</t:template>
