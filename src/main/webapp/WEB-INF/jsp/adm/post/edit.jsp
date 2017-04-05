<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/adm"%>
<t:template>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="<spring:url value="/js/modal.js"/>"></script>
		<script type="text/javascript" src="<spring:url value="/js/lib/jquery-ui-autocomplete-1.12.1.min.js"/>"></script>
		<script type="text/javascript">
			$(function(){
				$(window).keypress(function(event) {
					if (!(event.which == 115 && event.ctrlKey) && !(event.which == 19)) return true;
					event.preventDefault();
					$("form.post-edit").submit();
					return false;
				});
				$("#edit-tag-button").on("click", function() {
					$("#edit-tag-modal").modal();
				});
				$( "input[name='category.title']" ).autocomplete({
					source: function (request, response) {
						$.ajax({
							url : "<spring:url value='/adm/autocomplete/cat/'/>",
							dataType : 'json',
							data : {term: request.term},
							contentType : 'application/json',
							success : function(data) {
								var link = new Array();
								$.each(data, function() {
									link.push({value : this.id, label : this.title});
								});
								response(link);
							}
						});
					},
					select : function(e, ui){
						$("input[name='category.id']").val(ui.item.value);
						$("input[name='category.title']").val(ui.item.label);
						return false;
					}
				});
				$( "input[name='logo']" ).autocomplete({
					source: function (request, response) {
						$.ajax({
							url : "<spring:url value='/adm/autocomplete/img/'/>",
							dataType : 'json',
							data : {term: request.term},
							contentType : 'application/json',
							success : response
						});
					},
					select : function(e, ui){
						$("input[name='logo']").val(ui.item.value);
						$("img[name='logo']").attr("src", '<spring:url value="/img/"/>' + ui.item.value);
						return false;
					}
				});
				$("button[name=help]").on("click", function(){
					$("form.post-edit").toggleClass("pure-u-4-5");
					$("div.help").toggle();
					return false;
				});
			})
		</script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<form:form class="pure-form pure-form-aligned post-edit" method="post">
			<legend>Edition de ${post.id} <button name="help" class="pure-button pure-button-secondary">Aide</button></legend>
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
				<div class="pure-control-group">
					<label for="category.title">Categorie</label>
					<input type="hidden" name="category.id" value="${post.category.id}">
					<input type="text" name="category.title" value="${post.category.title}">
				</div>
				<div class="pure-control-group">
					<label for="logo">Image titre</label>
					<input type="text" name="logo" value="${post.logo}">
					<img name="logo" class="pure-u-1-2" src='<spring:url value="/img/${post.logo}"/>'>
				</div>
				<div class="pure-controls">
					<button id="edit-tag-button" type="button" class="pure-button pure-button-secondary">Editer les tags</button>
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
		<div id="edit-tag-modal" class="modal" tabindex="-1" role="dialog">
			<spring:url value="/adm/post/edit/tag/${post.id}" var="edittagurl"/>
			<form:form action="${edittagurl}" class="pure-form pure-form-stacked" method="post" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close">
							<span aria-hidden="true">&times;</span>
						</button>
						Edition des tags : ${post.title} 
					</div>
					<div class="modal-body">
						<fieldset>
							<div class="pure-g">
								<c:forEach items="${post.tags}" var="tag" >
									<div class="pure-u-1-5">
										<label for="type" class="pure-checkbox">
											<input name="${tag.id}"<c:if test="${tag.postCount>0}"> checked="checked"</c:if> type="checkbox">${tag.title}
										</label>
									</div>
								</c:forEach>
							</div>
						</fieldset>
					</div>
					<div class="modal-footer">
						<button type="button" class="pure-button close">Fermer</button>
						<button type="submit" class="pure-button pure-button-primary">Save changes</button>
					</div>
				</div>
			</form:form>
		</div>
	</jsp:attribute>
</t:template>
