<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
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
<title>${product.getName()}</title>
<style>
h3, h5 {
	display: inline;
}

div {
	margin: 10px;
}
</style>
</head>
<body>
	<div style="padding: 50px;">
		<div class="page-header">
			<h1>${product.getName()}</h1>
			<h1>
				<span style="color: green;">${product.getPrice()}</span> Php
			</h1>
		</div>
		<div>
			<h3>
				<b>UPC:</b>
			</h3>
			<h3>
				<i>${product.getUpc()}</i>
			</h3>
		</div>
		<div>
			<h3>
				<b>Category: </b>
			</h3>
			<h3>
				<i>${category}</i>
			</h3>
		</div>
		<div>
			<h4>
				<b>Description: </b>
			</h4>
			<h4>
				<i>${product.getDescription()}</i>
			</h4>
		</div>
		<div>
			<h3>
				<b>Quantity in cart: </b>
			</h3>
			<h3>
				<i>${quantity}</i>
			</h3>
		</div>
		<form class="form-inline" method="post">
			<div class="form-group">
				<label for="quantity">Qty:</label> <input type="number"
					data-fv-notempty-message="The password is required"
					class="form-control" name="quantity" min="1" max="100"
					data-bind="value:replyNumber" required>
			</div>
			<button type="submit" class="btn btn-primary">Add to cart</button>
		</form>
		<c:if test="${wasalak}">
			<div class="alert alert-success fade in"
				style="position: relative; width: 50%; padding: 20px;">
				<strong>Success!</strong> Item added to cart!
			</div>

		</c:if>
	</div>

</body>
</html>