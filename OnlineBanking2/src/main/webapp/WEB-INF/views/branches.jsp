<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/tabstyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h2>Welcome to Online Banking</h2>
</div>
<sec:authorize access="hasAuthority('Manager')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="accounts" role="tab" data-toggle="tab">Account</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/hometransaction" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>
</sec:authorize>
<sec:authorize access="hasAuthority('User')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/hometransaction" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <!--<li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="account" role="tab" data-toggle="tab">Account</a></li>-->
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="#" aria-controls="customer" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>

</sec:authorize>
<div align="center">


<h3>List of Branches</h3>
<sec:authorize access="hasAuthority('Manager')">
<a href="branchform">BranchForm</a>
</sec:authorize>

<table border="1">
		<tr>
			<th>Branch ID</th>
			<th>Branch Name</th>
			<th>Branch Address1</th>
			<th>Branch Address2</th>
			<th>Branch city</th>
			<th>Branch state</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${branchs}" var="b"><tr>
			
				<td>${b.branchId}</td>
				<td>${b.branchName}</td>
				<td>${b.branchAddress.addressLine1}</td>
				<td>${b.branchAddress.addressLine2}</td>
				<td>${b.branchAddress.city}</td>
				<td>${b.branchAddress.state}</td>
				<td><a href="${pageContext.request.contextPath}/updateBranch?id=<c:out value='${b.branchId}'/>">Update</a></td>
				<td><a href="${pageContext.request.contextPath}/deleteBranch?id=<c:out value='${b.branchId}'/>">Delete</a></td>
			
		</tr></c:forEach>
</table>
</div>
</body>
</html>