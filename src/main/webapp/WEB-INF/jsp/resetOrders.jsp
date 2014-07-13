<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="starter-template">
	<div class="row">
		<form method="post" id="resetOrdersForm" action='<c:url value="/resetOrders" />'>
			<h1>Reset Orders</h1>
			<p class="lead">
				Clicking the button below will reset the order statuses of all orders to new.  
			</p>
			<p><button id="resetButton" class="btn btn-primary" type="button">Click Me!</button></p>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#resetButton').click(function() {
			$('#resetOrdersForm').submit();
		});
	});
</script>