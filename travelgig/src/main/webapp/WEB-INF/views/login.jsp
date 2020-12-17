<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="css/jquery-ui.min.css" rel="stylesheet">
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/signinup.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" type="text/css" href="home.css"> -->
</head>
<body>
<form action="login" method="POST">
<div align="center" class="container border rounded" style="margin:auto;padding:50px;margin-top:50px;margin-bottom:50px">
	<h3>Please Login</h3>
	
	<table>
	<tr>
	<td>User Name:</td><td><input type="text" name="username"/></td>
	</tr>
	
	<tr>
	<td>Password:</td><td><input type="password" name="password"/></td>
	</tr>
	
	</table>
	<div colspan="2"><input type="submit" class="btn btn-primary" name="submit" value="submit"/></div>
	</form>
	<a href="signupform">Sign up</a>
	
</div>
</form>

</body>
</html>