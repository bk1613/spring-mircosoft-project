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

	    $('#historytransaction').DataTable( {
	        orderCellsTop: true,
	        fixedHeader: true,
	        paginate: true,
			"order": [[ 4, 'asc' ]]
	    });

	});
</script> 
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
Welcome <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp; <a href="${pageContext.request.contextPath}/login?logout">logout</a>
</sec:authorize>
<div align="center" class="container-fluid">
<h1>Bank Transaction</h1>
</div>

<div align="center" class="container-fluid">

<sec:authorize access="hasAuthority('Manager')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="accounts" role="tab" data-toggle="tab">Account</a></li>
            <li style="margin-left: 50px;"><a href="#" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>
</sec:authorize>
<sec:authorize access="hasAuthority('User')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="#" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <!--<li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="account" role="tab" data-toggle="tab">Account</a></li>-->
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>

</sec:authorize>


<frm:form action="movetotransactions" method="POST" modelAttribute="bankTransaction">
<table class="table table-borderless">
	
		<tr>
			
			<td>
			What type of transaction are you going to do?
			<frm:select name="TransactionType" path="transactionType">
			<frm:option value="" label="Please select a value"/>
			<frm:options items="${transactionType}"/>
			</frm:select>
			</td>
			<td><frm:errors path="transactionType" cssStyle="color:red"/></td>
		</tr>

	
	
	<tr>
		<td colspan="3" align="center"><input type="submit" class="btn btn-primary" value="submit" name="submit"/></td>
	</tr>

</table>
</frm:form>

<sec:authorize access="hasAuthority('Manager')">
<table id= "historytransaction" class="table table-striped">
<thead>
<tr>
	<th>Transaction Id</th>
	<th>Account From</th>
	<th>Account To</th>
	<th>Amount</th>
	<th>Transaction Type</th>
	<th>Date of Transaction</th>
	<th>Comments</th>
	
</tr>
</thead>

<tbody>
<c:forEach items="${banktransactions}" var="tran">
<tr>
	<td>${tran.bankTransactionId}</td>
	<td>${tran.bankTransactionFromAccount}</td>
	<td>${tran.bankTransactionToAccount}</td>
	<td>${tran.bankTransactionAmount}</td>
	<td>${tran.transactionType}</td>
	<td>${tran.bankTransactionDateTime}</td>
	<td>${tran.comments}</td>
</tr>
</c:forEach>
</tbody>
</table>
</sec:authorize>

</div>
</body>
</html>