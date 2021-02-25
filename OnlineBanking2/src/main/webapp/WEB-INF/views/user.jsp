<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">

<frm:form action="saveUser" method="POST" modelAttribute="user">
<table class="table table-borderless">
<tr>
<td>Usee Id:</td><td><frm:input path="userId"/></td><td><frm:errors path="userId"/></td>
</tr>

<tr>
<td>Name:</td><td><frm:input path="name"/></td><td><frm:errors path="name"/></td>
</tr>

<tr>
<td>Password:</td><td><frm:input type="password" path="password"/></td><td><frm:errors path="password"/></td>
</tr>

<tr>
<td>Email:</td><td><frm:input path="email"/></td><td><frm:errors path="email"/></td>
</tr>

<tr>
<td>Roles:</td>
<td>


	
<c:forEach items="${roleSet}" var="role" varStatus="status">	
	<c:if test="${user.name == null}">
			${role.name}<frm:checkbox path="roles" value="${role.roleId}"/> 
	</c:if> 
	<c:if test="${user.name != null}">
			<c:forEach items="${user.roles}" var="urole">
				<c:if test="${role.name == urole.name}">
					<c:set var = "roname" value="${urole.name}"/>
				</c:if>
			</c:forEach>
			 <c:if test="${role.name == roname}">
			 	${role.name}<frm:checkbox path="roles" value="${role.roleId}" checked="true"/>
			 </c:if>
			 <c:if test="${role.name != roname}">
			 	${role.name}<frm:checkbox path="roles" value="${role.roleId}"/>
			 </c:if>
	</c:if> 
		</c:forEach>	

</td>
<td><frm:errors path="roles"></frm:errors></td>
</tr>

<tr>
<td colspan="3" align="center"><input type="submit" class="btn btn-primary" value="submit" name="submit"/></td>
</tr>
</table>

</frm:form>

<br>
<hr/>
<table class="table table-striped">
<thead>
<tr>
<th>User Id</th><th>Name</th><th>Email</th><th>Roles</th><th colspan="2">Action</th>
</tr>
</thead>

<tbody>
<c:forEach items="${users}" var="user">
<tr>
	<td>${user.userId}</td>
	<td>${user.name}</td>
	
	<td>${user.email}</td>
	<td>
		<c:forEach items="${user.roles}" var="role">
			<strong>${role.name}</strong> &nbsp;
		</c:forEach>
		
	</td>
	<td><a href='${pageContext.request.contextPath}/deleteUser?userId=<c:out value="${user.userId}"/>'>Delete</a></td>
	<td><a href='${pageContext.request.contextPath}/updateUser?userName=<c:out value="${user.name}"/>'>Update</a></td>
</tr>
</c:forEach>
</tbody>

</table>

</div>
</body>
</html>