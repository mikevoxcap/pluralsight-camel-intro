<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="starter-template">
	<div class="row">
		<h1>View Orders</h1>
		<p>
			Below are the current list of orders in the system.
		</p>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Order #</th>
						<th>Customer</th>
						<th>Time Order Placed</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="order">
            			<tr>
      						<td>${order.id}</td>
      						<td>${order.orderNumber}</td>
      						<td>${order.customer.firstName} ${order.customer.lastName}</td>
      						<td>${order.timeOrderPlaced}</td>
      						<td>${order.status}</td>
       					</tr>
       				</c:forEach>
       			</tbody>
       		</table>
       	</div>
	</div>
</div>
