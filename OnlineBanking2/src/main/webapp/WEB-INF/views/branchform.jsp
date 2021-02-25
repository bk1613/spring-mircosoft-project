<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/tabstyle.css">
<meta charset="ISO-8859-1">
<title>Welcome Branch</title>
</head>
<body>
${Branch}
<sec:authorize access="isAuthenticated()">
Welcome <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp; <a href="${pageContext.request.contextPath}/login?logout">logout</a>
</sec:authorize>
<div align="center" class="container-fluid">
<h2>Branch Form</h2>


<sec:authorize access="hasAuthority('Manager')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <!--<li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="account" role="tab" data-toggle="tab">Account</a></li>-->
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/hometransaction" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>
</sec:authorize>
<frm:form action="savebranch" method="POST" modelAttribute="branch">
	<table>
		<tr>
		<td colspan="2" align="left"><frm:errors path="*" cssStyle="color:red"/>
		</tr>
		<tr>
		<td>Branch ID:</td>
		<td><frm:input path="branchId" value="${Branch.branchId}"/></td>
		<td><frm:errors path="branchId"/></td>
		</tr>
		
		<tr>
		<td>Branch Name:</td>
		<td><frm:input path="branchName" value="${Branch.branchName}"/></td>
		<td><frm:errors path="branchName"/></td>
		</tr>

		<tr>
		<td>Branch Address1:</td>
		<td><frm:input path="branchAddress.addressLine1" value="${Branch.branchAddress.addressLine1}"/></td>
		<td><frm:errors path="branchAddress.addressLine1"/></td>
		</tr>

		<tr>
		<td>Branch Address2:</td>
		<td><frm:input path="branchAddress.addressLine2" value="${Branch.branchAddress.addressLine2}"/></td>
		<td><frm:errors path="branchAddress.addressLine2"/></td>
		</tr>
		
		
		<tr>
		<td>Branch City:</td>
		<td><frm:input path="branchAddress.city" value="${Branch.branchAddress.city}"/></td>
		<td><frm:errors path="branchAddress.city"/></td>
		</tr>
		
		
		<tr>
		<td>Branch State:</td>
		<td><frm:input path="branchAddress.state" value="${Branch.branchAddress.state}"/></td>
		<td><frm:errors path="branchAddress.state"/></td>
		</tr>
		
		<tr>
		<td colspan="2" align="center"><input type="submit" name="submit" value="submit"/>
		</tr>
	</table>

</frm:form>


</div>
</body>
</html>