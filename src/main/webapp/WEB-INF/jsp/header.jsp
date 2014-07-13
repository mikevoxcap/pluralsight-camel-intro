<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" 
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<c:url value="/orderHome" />">Order Management</a>
	</div>
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown active">
				<a href="#" class="dropdown-toggle" 
					data-toggle="dropdown">Orders <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href='<c:url value="/orderHome" />'>Home</a>
					<li><a href='<c:url value="/viewOrders" />'>View Orders</a></li>
					<li><a href='<c:url value="/processOrders" />'>Process Orders</a></li>
					<li><a href='<c:url value="/resetOrders" />'>Reset Orders</a></li>
				</ul>
			</li>					
		</ul>
	</div><!--/.nav-collapse -->
</div>
