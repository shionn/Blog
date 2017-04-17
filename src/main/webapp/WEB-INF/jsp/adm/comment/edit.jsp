<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts">
		<script type="text/javascript">
			$(function(){
				$("button[name=help]").on("click", function(){
					$("form.comment-edit").toggleClass("pure-u-4-5");
					$("div.help").toggle();
					return false;
				});
			})
		</script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<form:form class="pure-form pure-form-aligned comment-edit" method="post">
			<legend>Edition de ${comment.id} <button name="help" class="pure-button pure-button-secondary">Aide</button></legend>
			<fieldset class="pure-group">
				<input    name="authorName" class="pure-input-1" placeholder="Title"   type="text" value="${comment.authorName}">
				<textarea name="content"    class="pure-input-1" placeholder="Contenu" rows="20" >${comment.content}</textarea>
			</fieldset>
			<fieldset>
				<div class="pure-control-group">
					<label for="date">Publication </label>
					<input name="date" type="text" class="pure-input-1-4" placeholder="jj/mm/aaaa" 
						value="<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${comment.date}"/>">
					<label for="ip">Ip </label>
					<input name="ip" type="text" class="pure-input-1-4" value="${comment.ip}"/>
				</div>
				<div class="pure-control-group">
					<label for="authorEmail">Email</label>
					<input name="authorEmail" type="text" class="pure-input-1-4" value="${comment.authorEmail}"/>
					<label for="authorWeb">Web</label>
					<input name="authorWeb" type="text" class="pure-input-1-4" value="${comment.authorWeb}"/>
				</div>
				<div class="pure-controls">
					<button type="submit" class="pure-button pure-button-primary">Sauvegarder</button>
				</div>
			</fieldset>
		</form:form>
		<div class="pure-u-1-5 help pure-menu">
			<ul class="pure-menu-list">
				<li class="pure-menu-item"><a class="pure-menu-link">*Italic*</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">_Italic_</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">**Bold**</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">__Bold__</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link"># Heading 1</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">## Heading 2</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">[link](/uri "title")</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">![alt](img/foo.png "title")</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">* List</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">- List</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">1. List</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">1) List</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">--- (hr)</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">`Inline code`</a></li>
				<li class="pure-menu-item"><a class="pure-menu-link">~~~java</a></li>
			</ul>
		</div>
	</jsp:attribute>
</t:template>
