<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Form</title>

<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/item.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Item Form</h2>
<div align="center""container">
<div class="col-3">
		name: <input class="form-control" type="text" id="name" name="name"/>
	</div>
	
	<div class="col-3">
		type: <input class="form-control" type="text" id="type" name="type"/>
	</div>
	
	<div class="col-3">
		rate: <input class="form-control" type="number" id="rate" name="rate"/>
	</div>

	<div colspan="3" align="center"><input type="submit" class="btn btn-primary" id="additem" value="submit" name="additem"/></div>
</div>
</body>
</html>