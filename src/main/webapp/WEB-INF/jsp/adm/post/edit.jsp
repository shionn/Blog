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
				$(window).keypress(function(event) {
					if (!(event.which == 115 && event.ctrlKey) && !(event.which == 19)) return true;
					event.preventDefault();
					$("form.post-edit").submit();
					return false;
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
				<div class="pure-controls">
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
					<td>![alt](/url "title")</td>
					<td></td>
					<td><img src="/url" alt="alt" title="title"></td>
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
	</jsp:attribute>
</t:template>
