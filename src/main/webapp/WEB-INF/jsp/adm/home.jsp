<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<t:adm-template>
	<jsp:attribute name="scripts">
		<script type="text/javascript" src="<spring:url value="/js/modal.js"/>"></script>
		<script type="text/javascript">
			$(function() {
				$("button").on("click", function() {
					$("#myModal").modal();
				});
			});
		</script>
	</jsp:attribute>
	<jsp:attribute name="content">
		<h1>Page d'acceuil, WiP</h1>
		<button type="button">modal</button>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi eget ultricies libero, ut cursus sapien. Nulla non orci pulvinar magna finibus rutrum. Quisque interdum nibh sit amet elit sagittis, sit amet maximus nisi finibus. Quisque sed egestas sapien, vitae venenatis ex. Vivamus sit amet placerat massa. Cras ligula orci, efficitur ac molestie vel, malesuada sit amet massa. Proin id ipsum tellus. Nullam rhoncus ipsum laoreet vestibulum sodales. Vestibulum in nunc ligula</p>
		<div id="myModal" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Modal title</h4>
				</div>
				<div class="modal-body">
					<p>One fine body&hellip;</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</jsp:attribute>
</t:adm-template>
