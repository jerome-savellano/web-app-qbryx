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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form role="form" style="padding: 3%;" action="updateProduct"
					method="post">
					<div class="page-header">
						<h1>Update Product</h1>
					</div>
					<div class="form-group">
						<label for="productName">Product name </label> <input type="text"
							class="form-control" name="name" value="${product.getName()}"/>
					</div>
					<div class="form-group">
						<label for="upc">UPC (Universal Product Code) </label> <input
							type="number" class="form-control" name="upc" value="${product.getUpc()}"
							readonly="readonly"/>
					</div>
					<div class="form-group">
						<label for="category">Category</label><input type="text"
							class="form-control" value="${category}" readonly="readonly"/>
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<textarea class="form-control" rows="5" name="description">${product.getDescription()}</textarea>
					</div>
					<div class="form-group">
						<label for="price">Price</label> <input type="number"
							class="form-control" name="price" value="${product.getPrice()}" />
					</div>
					<div class="form-group">
						<label for="price">Stock</label> <input type="number"
							class="form-control" name="stock" value="${product.getStock()}" />
					</div>
					<button type="submit" class="btn btn-primary">Update
						product</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>