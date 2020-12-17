<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
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
<div align="center""container">
	
	<div class="col-3">
		Username: <input class="form-control" type="text" id="username" name="Username"/>
	</div>
	
	<div class="col-3">
		Password: <input class="form-control" type="text" id="password" name="Password"/>
	</div>
	
	<div class="col-3">
		Email: <input class="form-control" type="text" id="email" name="Email"/>
	</div>

	<div>
		<c:forEach items="${roleSet}" var="role" varStatus="status">	
			<c:if test="${user.username == null}">
					${role.rolename}<frm:checkbox path="roles" value="${role.roleId}"/> 
			</c:if> 
			<c:if test="${user.username != null}">
					<c:forEach items="${user.roles}" var="urole">
						<c:if test="${role.rolename == urole.rolename}">
							<c:set var = "roname" value="${urole.rolename}"/>
						</c:if>
					</c:forEach>
					 <c:if test="${role.rolename == roname}">
					 	${role.rolename}<frm:checkbox path="roles" value="${role.roleId}" checked="true"/>
					 </c:if>
					 <c:if test="${role.rolename != roname}">
					 	${role.rolename}<frm:checkbox path="roles" value="${role.roleId}"/>
					 </c:if>
			</c:if> 
		</c:forEach>
	</div>

<div colspan="3" align="center"><input type="submit" class="btn btn-primary" id="signBtn" value="submit" name="Signin"/></div>


</div>


</body>
</html>