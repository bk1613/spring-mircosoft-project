<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Laundry Request Form</title>
</head>
<body>

	<frm:form action="makeRequest" method="POST" modelAttribute="request">
	
	<div>
		Name: <frm:input path="CustomerName"/>
	</div>
	<div>
		item:<frm:select class="form-control" name="items" path="items.itemname">
		<frm:option value="" label="Please select an item"/>
		<c:forEach items="${items}" var="item">
			<frm:option value="${items.itemname}" label="${items.itemname}"/>
		</c:forEach>
		</frm:select>

	<div>
		total garment: <frm:input path="totalPrice"/>
	</div>

	</div>
	
	<input type="submit" name="submit" value="submit"/>
</frm:form>

</body>
</html>