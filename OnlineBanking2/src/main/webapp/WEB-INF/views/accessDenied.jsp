<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
Welcome <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp; <a href="${pageContext.request.contextPath}/login?logout">Logout</a>

<sec:authentication property="principal.authorities" var="authorities"/>
<c:forEach items="${authorities}" var="authority">
	<br>${authority}
</c:forEach>
</sec:authorize>

Hi ${pageContext.request.userPrincipal.name}
You are not allowed access to this page. Please click on the following link to return to home page. <br>
<a href="${pageContext.request.contextPath}/">Home</a>


</body>
</html>