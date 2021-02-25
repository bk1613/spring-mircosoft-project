<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<div align="center" class="container-fluid">
<form action="login" method="POST">
<table>
<tr>
<td>User Name:</td><td><input type="text" name="username"/></td>
</tr>

<tr>
<td>Password:</td><td><input type="password" name="password"/></td>
</tr>

<tr>
<td colspan="2"><input type="submit" class="btn btn-primary" name="submit" value="submit"/></td>
</tr>
</table>
</form>
<a href="userForm">Sign up</a>
</div>

</body>
</html>