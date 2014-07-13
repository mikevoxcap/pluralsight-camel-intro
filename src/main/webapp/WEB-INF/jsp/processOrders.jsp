<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="starter-template">
	<div class="row">
		<form method="post" id="processOrdersForm" action='<c:url value="/processOrders" />'>
			<h1>Process Orders</h1>
			<p class="lead">
				Click the button below to run order fulfillment processing. 
			</p>
			<p><button id="processButton" class="btn btn-primary" type="button">Click Me!</button></p>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#processButton').click(function() {
			$('#processOrdersForm').submit();
		});
	});
</script>