<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-2.1.1.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="css/tabstyle.css">
<script>
	$(document).ready(function() {

	    $('#accounttable').DataTable( {
	        orderCellsTop: true,
	        fixedHeader: true,
	        paginate: true,
			"order": [[ 1, 'asc' ]]
	    });

	});
</script> 
<meta charset="ISO-8859-1">
<title>Account Form</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
Welcome <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp; <a href="${pageContext.request.contextPath}/login?logout">logout</a>
</sec:authorize>

<div align="center" class="container-fluid">
<h1>Account Bank</h1>
</div>

<div align="center" class="container-fluid">
<sec:authorize access="hasAuthority('Manager')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="#" aria-controls="accounts" role="tab" data-toggle="tab">Account</a></li>
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
            <!--<li style="margin-left: 50px;"><a href="#" aria-controls="account" role="tab" data-toggle="tab">Account</a></li>-->
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>

</sec:authorize>


<frm:form action="saveAccount" method="POST" modelAttribute="account">
<table class="table table-borderless">
	<tr>
		<td>Account Id:</td>
		<td><frm:input path="accountId"/></td>
		<td><frm:errors path="accountId" cssStyle="color:red"/></td>
	</tr>
	
	<tr>
		<td>Branch Id:</td>
		<td><frm:input path="accountBranch.branchId"/></td>
		<td><frm:errors path="accountBranch" cssStyle="color:red"/></td>
	</tr>
	
	<tr>
		<td>Account Type:</td>
		<td>
		<frm:select name="accountType" path="accountType">
		<frm:option value="" label="Please select a value"/>
		<frm:options items="${accountType}"/>
		</frm:select>
		</td>
		<td><frm:errors path="accountType" cssStyle="color:red"/></td>
	</tr>
	
	<tr>
		<td>Account Holder:</td>
		<td><frm:input path="accountHolder"/></td>
		<td><frm:errors path="accountHolder"/></td>
	</tr>
	
	<tr>
		<td>Date of Account Opened:</td>
		<td><frm:input type="date" path="accountDateOPened"/></td>
		<td><frm:errors path="accountDateOPened" cssStyle="color:red"/></td>
	</tr>
	
	<tr>
		<td>Balance:</td>
		<td><frm:input type="numberdate" path="accountBalance"/></td>
		<td><frm:errors path="accountBalance" cssStyle="color:red"/></td>
	</tr>
	
	<tr>
		<td>Customer Name:</td>
		<td><frm:input path="accountCustomer.customerId"/></td>
		<td><frm:errors path="accountCustomer" cssStyle="color:red"/></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit" class="btn btn-primary" value="submit" name="submit"/></td>
	</tr>
</table>	
</frm:form>
<br>
<hr/>
<sec:authorize access="hasAuthority('Manager')">
<table id="accounttable" class="table table-striped">
<thead>
<tr>
	<th>Account Id</th>
	<th>Branch Id</th>
	<th>Account Type</th>
	<th>Account Holder</th>
	<th>Date of Account Opened</th>
	<th>Balance</th>
	<th>Customer Id</th>
	<th colspan="2">Action</th>
</tr>
</thead>

<tbody>
<c:forEach items="${accounts}" var="account">
<tr>
	<td>${account.accountId}</td>
	<td>${account.accountBranch.branchId}</td>
	<td>${account.accountType}</td>
	<td>${account.accountHolder}</td>
	<td>${account.accountDateOPened}</td>
	<td>${account.accountBalance}</td>
	<td>${account.accountCustomer.customerId}</td>
	<td><a href='${pageContext.request.contextPath}/deleteAccount?id=<c:out value="${account.accountId}"/>'>Delete</a></td>
	<td><a href='${pageContext.request.contextPath}/updateAccount?id=<c:out value="${account.accountId}"/>'>Update</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</sec:authorize>
</div>

</body>
</html>