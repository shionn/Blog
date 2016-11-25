<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts"></jsp:attribute>
	<jsp:attribute name="content">
		<form:form class="pure-form pure-form-aligned" method="post">
			<legend>Edition de ${post.id}</legend>
			<fieldset class="pure-group">
				<input id="title" name="title" type="text" class="pure-input-1" placeholder="Title" value="${post.title}">
				<textarea class="pure-input-1" placeholder="Contenu" rows="30" name="content">${post.content}</textarea>
			</fieldset>
			<fieldset>
				<div class="pure-control-group">
					<label for="url">Lien</label>
					<input id="url" name="url" type="text" class="pure-input-1-4" placeholder="Url" value="${post.url}">
					<label for="published">Publication </label>
					<input id="published" name="published" type="text" class="pure-input-1-4" placeholder="jj/mm/aaaa" 
						value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${post.published}"/>">
				</div>
				<div class="pure-control-group">
					<label for="type">Type</label>
					<select name="type" class="pure-input-1-4">
						<option <c:if test="${post.type == \"post\"}"> selected="selected"</c:if>>post</option>
						<option <c:if test="${post.type == \"page\"}"> selected="selected"</c:if>>page</option>
					</select>
					<label for="status">Status</label>
					<select name="status" class="pure-input-1-4">
						<option <c:if test="${post.status == \"draft\"}"> selected="selected"</c:if>>draft</option>
						<option <c:if test="${post.status == \"publish\"}"> selected="selected"</c:if>>publish</option>
					</select>
				</div>
				<div class="pure-controls">
					<button type="submit" class="pure-button pure-button-primary">Sauvegarder</button>
				</div>
			</fieldset>
		</form:form>
		TODO : liste des sauvegarde
	</jsp:attribute>
</t:template>
