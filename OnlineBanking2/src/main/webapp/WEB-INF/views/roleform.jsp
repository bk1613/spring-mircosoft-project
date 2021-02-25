<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>Role form</h2>
<frm:form action="saverole" method="POST" modelAttribute="role">
	<table>
		<tr>
		<td>Role ID:</td>
		<td><frm:input path="roleId"/></td>
		</tr>
		
		<tr>
		<td>Role ID:</td>
		<td><frm:input path="name"/></td>
		</tr>
		
		<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" value="submit"/>
		</tr>
	</table>
</frm:form>

<h3>List of Roles</h3>
<table border="1">
		<tr>
			<th>Role ID</th>
			<th>Role Name</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${roles}" var="r">
			<tr>
				<td>${r.roleId}</td>
				<td>${r.name}</td>
				<td><a href="${pageContext.request.contextPath}/deleterole?id=<c:out value='${r.roleId}'/>">Delete</a></td>
			</tr>
		</c:forEach>

</table>
</div>
</body>
</html>