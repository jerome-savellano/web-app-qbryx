<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.qbryx.dm.Category"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="page-header">
					<h1>
						Hi,
						<c:out value="${customer.getUsername()}" />!
					</h1>
				</div>
				<h2>Shopping cart</h2>
				<form action="removeProductFromcart" method="get">
					<table class="table">
						<thead>
							<tr>
								<th>Date added</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Amount</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productsInCart}" var="product"
								varStatus="status">
								<input type="hidden" name="myObject" value="${product.getUpc()}" />
								<tr class="active">
									<td>${product.getDateAdded()}</td>
									<td>${product.getName()}</td>
									<td>${product.getQuantity()}</td>
									<td style="color: green;">&#8369;
										${product.getTotalAmount()}</td>
									<td><input type="submit" class="btn btn-warning btn-xs"
										value="Remove from cart" ></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
			<div class="col-md-4">
				<h1>Browse products</h1>
				<form method="post" action="customer" class="form-inline">
					<div class="form-group">
						<select class="form-control" name="category">
							<option selected disabled>SELECT CATEGORY</option>
							<c:forEach items="${categories}" var="item">
								<option>${item.getName()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-info" value="VIEW CATEGORY">
					</div>
					<c:if test="${categorySelected}">
						<div class="list-group">
							<div class="page-header">
								<h1>${category}</h1>
							</div>
							<c:forEach items="${products}" var="item" varStatus="status">
								<a
									href="processProduct?upc=${item.getUpc()}&category=${category}"
									class="list-group-item">${item.getName()}</a>
							</c:forEach>
						</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
</body>
</html>