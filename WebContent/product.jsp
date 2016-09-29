<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>${product.getName()}</title>
<style>
h3, h5{
	display: inline;
}
div{
	margin: 10px;
}
</style>
</head>
<body>
	<div style="padding: 100px;">
		<div class="page-header">
   			<h1>${product.getName()}</h1>
   			<h1>${session.getAttribute("username")}</h1>
   			<h1><span style="color: green;">${product.getPrice()}</span> Php</h1>
		</div>
		<div>
			<h3><b>UPC:</b></h3>
			<h3><i>${product.getUpc()}</i></h3>
		</div>
		<div>
			<h3 class="card-text"><b>Category: </b></h3>
			<h3 class="card-text"><i>${category}</i></h3>
		</div>
		<div>
			<h4><b>Description: </b></h4>
			<h4 class="card-text"><i>${product.getDescription()}</i></h4>
		</div>	
	</div>
</body>
</html>