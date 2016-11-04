<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:adm-template>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="<spring:url value="/js/lib/bootstrap/modal.js"/>"></script>
		<script type="text/javascript">
			$('div.modal').modal({
				keyboard: false
			});
		</script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<h1>Page d'acceuil, WiP</h1>
		<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
			Launch demo modal
		</button>
		<div class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">
						<p>One fine body&hellip;</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	</jsp:attribute>
</t:adm-template>
