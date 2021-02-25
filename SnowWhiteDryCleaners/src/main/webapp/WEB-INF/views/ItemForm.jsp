<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<frm:form action="saveitem" method="POST" modelAttribute="items">
	
	<div>
		Name: <frm:input path="itemname"/>
	</div>
	<div>
		Type: <frm:input path="type"/>
	</div>
	<div>
		Type: <frm:input path="rate"/>
	</div>
	<input type="submit" name="submit" value="submit"/>
</frm:form>


</body>
</html>