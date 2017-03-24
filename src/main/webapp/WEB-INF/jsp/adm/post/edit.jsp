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
			})
		</script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<form:form class="pure-form pure-form-aligned post-edit" method="post">
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
				<div class="pure-control-group">
					<label for="category.title">Categorie</label>
					<input type="hidden" name="category.id" value="${post.category.id}">
					<input type="text" name="category.title" value="${post.category.title}">
				</div>
				<div class="pure-controls">
					<button id="edit-tag-button" type="button" class="pure-button pure-button-secondary">Editer les tags</button>
					<button type="submit" class="pure-button pure-button-primary">Sauvegarder</button>
				</div>
			</fieldset>
		</form:form>
		TODO : liste des sauvegarde
		<table>
			<tbody>
				<tr>
					<td>*Italic*</td>
					<td>_Italic_</td>
					<td><em>Italic</em></td>
				</tr>
				<tr>
					<td>**Bold**</td>
					<td>__Bold__</td>
					<td><strong>Bold</strong></td>
				</tr>
				<tr>
					<td># Heading 1</td>
					<td>Heading 1<br>=========</td>
					<td><h1>Heading 1</h1></td>
				</tr>
				<tr>
					<td>## Heading 2</td>
					<td>Heading 2<br>---------</td>
					<td><h2>Heading 2</h2></td>
				</tr>
				<tr>
					<td>[link](/uri "title")</td>
					<td></td>
					<td><a href="/uri" title="title">link</a></td>
				</tr>
				<tr>
					<td>![alt](img/foo.png "title")</td>
					<td></td>
					<td><img src="img/foo.png" alt="alt" title="title"></td>
				</tr>
				<tr>
					<td>* List<br>* List<br>* List</td>
					<td>- List<br>- List<br>- List</td>
					<td><ul><li>List</li><li>List</li><li>List</li></ul></td>
				</tr>
				<tr>
					<td>1. One<br>2. Two<br>3. Three</td>
					<td>1) One<br>2) Two<br>3) Three</td>
					<td><ol><li>One</li><li>Two</li><li>Three</li></ol></td>
				</tr>
				<tr>
					<td>---</td>
					<td>***</td>
					<td><hr></td>
				</tr>
				<tr>
					<td>`Inline code` with backticks</td>
					<td>&nbsp;</td>
					<td><code>Inline code</code> with backticks</td>
				</tr>
				<tr>
					<td>```<br>Multi-line code block<br>```</td>
					<td>~~~java<br>Multi-line code block<br>~~~</td>
					<td><pre><code>Multi-line code block</code></pre></td>
				</tr>
			</tbody>
		</table>
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
