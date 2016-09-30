<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4">
				<h1 class="text-center text-primary">Add a product</h1>
				<form role="form" style="padding: 5%">
					<div class="form-group">
						<label for="productName">Product name </label> <input type="text"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="upc">UPC (Universal Product Code) </label> <input
							type="number" class="form-control" />
					</div>
					<div class="form-group">
						<label for="category"></label> <select class="form-control"
							name="category">
							<option selected disabled>SELECT CATEGORY</option>
							<c:forEach items="${categories}" var="item">
								<option>${item.getName()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<textarea class="form-control" rows="5" name="description"></textarea>
					</div>
					<div class="form-group">
						<label for="price">Price</label> <input type="number"
							class="form-control" name="price" />
					</div>
					<button type="submit" class="btn btn-primary">Add product</button>
				</form>
			</div>
			<div class="col-md-4" style="text-align: center">
				<h1 class="text-center text-primary">Search product</h1>
				<form class="form-inline" style="padding: 5%">
					<div class="form-group">
						<label for="email"><h4>UPC:</h4></label> <input type="email"
							class="form-control" id="email">
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>
			<div class="col-md-4">
				<h1 class="text-center text-primary">View product by category</h1>
				<form class="form-inline" style="padding: 7%; text-align: center;"
					method="post">
					<div class="form-group">
						<select class="form-control" name="category">
							<option selected disabled>SELECT CATEGORY</option>
							<c:forEach items="${categories}" var="item">
								<option>${item.getName()}</option>
							</c:forEach>
						</select>
						<button type="submit" class="btn btn-primary">Search</button>
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
		<div class="row" style="padding: 1%;">
		</div>
		<div class="row" style="padding: 1%;">
		</div>
		<div class="row" style="padding: 1%;">
			<div class="col-md-12">
				<form action="logout">
					<button type="submit" class="btn btn-primary">Logout</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>