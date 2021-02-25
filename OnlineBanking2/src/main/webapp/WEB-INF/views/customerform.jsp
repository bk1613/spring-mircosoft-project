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

	    $('#customertable').DataTable( {
	        orderCellsTop: true,
	        fixedHeader: true,
	        paginate: true,
			"order": [[ 4, 'asc' ]]
	    });

	});
</script> 
<meta charset="ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
Welcome <strong>${pageContext.request.userPrincipal.name}</strong> &nbsp; <a href="${pageContext.request.contextPath}/login?logout">logout</a>
</sec:authorize>

<div align="center" class="container-fluid">
<h1>Customer Bank</h1>
</div>

<div align="center" class="container-fluid">

<sec:authorize access="hasAuthority('Manager')">
<divid="Tabs" role="tabpanel">
<ul class="nav nav-tabs" role="tablist">
            <li class="active" style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/home" aria-controls="personal" role="tab" data-toggle="tab">Home</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/accountform" aria-controls="accounts" role="tab" data-toggle="tab">Account</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/hometransaction" aria-controls="transaction" role="tab" data-toggle="tab">Transaction</a></li>
            <li style="margin-left: 50px;"><a href="#" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
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
            <li style="margin-left: 50px;"><a href="#" aria-controls="customer" role="tab" data-toggle="tab">Customer</a></li>
            <li style="margin-left: 50px;"><a href="${pageContext.request.contextPath}/branches" aria-controls="branch" role="tab" data-toggle="tab">Branch</a></li>
</ul>
</div>

</sec:authorize>
<h2>Customer Signin Form</h2>
<frm:form action="saveCustomer" method="POST" modelAttribute="customer">
	<table class="table table-borderless">
	
		<tr>
		<td>Customer Id:</td>
		<td><frm:input path="customerId"/></td>
		<td><frm:errors path="customerId"/></td>
		</tr>
		
		<tr>
		<td>Cutomer name:</td>
		<td><frm:input path="customerName"/></td>
		<td><frm:errors path="customerName"/></td>
		</tr>
		
		<tr>
		<td>Gender:</td>
		<td>
		<frm:radiobutton name="gender" path="customerGender" value="male" label="male"/>
		<frm:radiobutton name="gender" path="customerGender" value="female" label="female"/>
		</td>
		<td><frm:errors path="customerGender" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Date of Birth:</td>
		<td><frm:input type="date" path="customerDob"/></td>
		<td><frm:errors path="customerDob" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Customer Moblie:</td>
		<td><frm:input path="customerMoblieNo"/></td>
		<td><frm:errors path="customerMoblieNo" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Customer Phone:</td>
		<td><frm:input path="customerPhone"/></td>
		<td><frm:errors path="customerPhone" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Customer Address1:</td>
		<td><frm:input path="customerAddess.addressLine1"/></td>
		<td><frm:errors path="customerAddess.addressLine1" cssStyle="color:red"/></td>
		</tr>

		<tr>
		<td>Customer Address2:</td>
		<td><frm:input path="customerAddess.addressLine2" /></td>
		<td><frm:errors path="customerAddess.addressLine2" cssStyle="color:red"/></td>
		</tr>
		
		
		<tr>
		<td>Customer City:</td>
		<td><frm:input path="customerAddess.city"/></td>
		<td><frm:errors path="customerAddess.city" cssStyle="color:red"/></td>
		</tr>
		
		
		<tr>
		<td>Customer State:</td>
		<td><frm:input path="customerAddess.state"/></td>
		<td><frm:errors path="customerAddess.state" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>Customer ssn:</td>
		<td><frm:input path="customerssn"/></td>
		<td><frm:errors path="customerssn" cssStyle="color:red"/></td>
		</tr>
		
		<tr>
		<td>User ID:</td>
		<td><frm:input path="user.userId"/></td>
		<td><frm:errors path="user" cssStyle="color:red"/></td>
		</tr>
		<tr>
		<td colspan="3" align="center"><input type="submit" class="btn btn-primary" value="submit" name="submit"/></td>
		</tr>
	</table>
</frm:form>

<br>
<hr/>
<sec:authorize access="hasAuthority('Manager')">
<table id = "customertable" class="table table-striped">
<thead>
<tr>
<th>Customer Id</th>
<th>name</th>
<th>Gender</th>
<th>Date of Birth</th>
<th>Moblie number</th>
<th>Phone Number</th>
<th>Address1</th>
<th>Address2</th>
<th>City</th>
<th>State</th>
<th>ssn</th>
<th>User Id</th>
<th colspan="2">Action</th>
</tr>
</thead>

<tbody>
<c:forEach items="${customers}" var="customer">
<tr>
	<td>${customer.customerId}</td>
	<td>${customer.customerName}</td>
	<td>${customer.customerGender}</td>
	<td>${customer.customerDob}</td>
	<td>${customer.customerMoblieNo}</td>
	<td>${customer.customerPhone}</td>
	<td>${customer.customerAddess.addressLine1}</td>
	<td>${customer.customerAddess.addressLine2}</td>
	<td>${customer.customerAddess.city}</td>
	<td>${customer.customerAddess.state}</td>
	<td>${customer.customerssn}</td>
	<td>${customer.user.userId}</td>
	<td><a href='${pageContext.request.contextPath}/deleteCustomer?id=<c:out value="${customer.customerId}"/>'>Delete</a></td>
	<td><a href='${pageContext.request.contextPath}/updateCustomer?id=<c:out value="${customer.customerId}"/>'>Update</a></td>
</tr>
</c:forEach>
</tbody>

</table>
</sec:authorize>


</div>

</body>
</html>