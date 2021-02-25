<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-2.1.1.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="css/tabstyle.css">
<script>
	$(document).ready(function() {

	    $('#historytransaction').DataTable( {
	        orderCellsTop: true,
	        fixedHeader: true,
	        paginate: true,
			"order": [[ 0 ]]
	    });

	});
</script> 
<meta charset="ISO-8859-1">
<title>Bank Home page</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
Welcome <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp; <a href="${pageContext.request.contextPath}/login?logout">Logout</a>
</sec:authorize>
<div align="center" >
<h1>Welcome to Online Banking</h1></div>
<div  align="center"  >



<%-- <sec:authorize access="hasAuthority('Manager')">
<a href="accountform">Account</a>
</sec:authorize>  --%>

<sec:authorize access="hasAuthority('Manager')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="#" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
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
            <li class="active" style="margin-left: 50px;"><a href="#" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/hometransaction" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <!--<li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="account" role="tab" data-toggle="tab">Account</a></li>-->
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/customerform" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>

</sec:authorize>

</div>
<div id="info" style="margin-right:60px">
<div class="col-2 border rounded" style="margin-left:50px;padding:25px">
<c:forEach items="${balances}" var="balance">

	<div>${balance.accountType}: ${balance.accountBalance}</div>

</c:forEach>
</div>
<br/>
<div class="col-2 border rounded" style="margin-left:50px;padding:25px">
SSN: ${ssn}
</div> 
</div>
<div id="historypos" style="margin-left:150px">
	<div style='text-align:center;font-size:20px;font-family:"Trebuchet MS", Helvetica, sans-serif'>Transaction History:</div>
<div  class="container">

<table id="historytransaction" class="table table-striped">

<thead>
<tr>
	
	<th>Account To</th>
	<th>Amount transfered</th>
	<th>TransactionType</th>
	<th>date</th>
	
	
</tr>
</thead>
<tbody>
<c:forEach items="${history}" var="bt">
<tr>
	<td>${bt.bankTransactionToAccount}</td>
	<td>${bt.bankTransactionAmount}</td>
	<td>${bt.transactionType}</td>
	<td>${bt.bankTransactionDateTime}</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</div>
</div>
</body>
</html>