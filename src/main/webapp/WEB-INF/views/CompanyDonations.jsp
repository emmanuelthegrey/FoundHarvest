<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.team.treasure.Donation"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donation List</title>
<script src="./resources/sorttable.js"/></script>
</head>
<script>
	function printDiv(printableArea) {
		var printContents = document.getElementById(printableArea).innerHTML;
		var originalContents = document.body.innerHTML;

		document.body.innerHTML = printContents;

		window.print();

		document.body.innerHTML = originalContents;
	}
	</script>

<body>
	<div id="printableArea">

		<h1>${companyName}</h1>
		<h2>Submitted Donations</h2>
		<table class="sortable table table-striped table-hover" border="1">
			<tr class ="success">
				<th>Date Submitted</th>
				<th>Donation Description</th>
				<th>Weight of Donation</th>
				<th>Date Confirmed</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
				<tr>
					<td>${item.donation.submissionDate }
					<td>${item.donation.productDescription }</td>
					<td>${item.donation.weight }</td>
					<td>${item.donation.confirmationDate }</td>
			</c:forEach>
		</table>
	</div>
	<input type="button" onclick="printDiv('printableArea')"
		value="Print Reciept" />
</body>
</html>