<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qbryx.dm.Category" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
<style>
option{
	font-size: 20px;
}
.container{
	position:fixed;
    margin:0px auto;
    width: 200px;
    clear:left;
    height:auto;
    z-index: 0;
    text-align:center;
    width: 100%;
}
</style>
<script>
function myFunction() {
    alert("Hello! I am an alert box!");
}
</script>
</head>
<body>
	<div class="container">
		<div style="display: inline-block;">
			<h1>Hi, <c:out value="${customer.getUsername()}"/>!</h1>
				<form method="post" action="customer" class="form-inline">	
					<div class="form-group">		
						<select class="form-control" style="width: 500px; font-size: 15px; heigth: 500px;" name="category">
							<option selected disabled>SELECT CATEGORY</option>
								<c:forEach items="${categories}" var="item">
									<option>${item.getName()}</option>
								</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-info" value="VIEW CATEGORY">
					</div>
				</form>
		</div>
	</div>
	
	<div style="padding: 10%;">
	<c:if test="${categorySelected}">
			<div class="list-group">
				<div class="page-header">
   					<h1>${category}</h1>
				</div>
  				<c:forEach items="${products}" var="item" varStatus="status">
  					<a href="processProduct?upc=${item.getUpc()}&category=${category}" class="list-group-item">${item.getName()}</a>
  				</c:forEach>
			</div>
	</c:if>	
			<div class="page-header">
				<h1>Shopping Cart</h1>
			</div>
		</div>
	
	
</body>
</html>