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
<style>
  .margin-set {
  margin-left: 50px;
  margin-right: 50px;
  }
</style>
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

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
     		<li><a onclick="printDiv('printableArea')"> Print Receipt</a></li>
     		<li><a href="./editedRegistration"> Edit Profile</a></li>
            <li><a href="./donationform">Donation Form</a></li>
            <li><a href="./">Log Out</a></li>
            
          </ul>
  </div>
</nav>
	<div class = margin-set>
	<div id="printableArea">
	
		<h1>${companyName}</h1>
		<h2>Submitted Donations</h2>
		<table class="sortable table table-striped table-hover" border="1">
			<tr class ="danger">
				<th>Date Submitted</th>
				<th>Donation Description</th>
				<th>Weight of Donation</th>
				<th>Date Confirmed</th>
				<th>Remove</th>
			</tr>
			<c:forEach items="${itemList}" var="item">
				<tr>
					<td>${item.donation.submissionDate }
					<td>${item.donation.productDescription }</td>
					<td>${item.donation.weight }</td>
					<c:choose>
    				<c:when test="${empty item.donation.confirmationDate}">
        			<td> Ready for pickup! </td>
   				    </c:when>
    				<c:otherwise>
      				 <td>${item.donation.confirmationDate }</td>
   					</c:otherwise>
					</c:choose>
					<td>
					<form action="removeFromCompanyDonationPage" method="get">
                	<input type="hidden" name="cancel" value="${item.donation.idCompanyDonation}" />
                	<input type ="submit" value="Remove">
           			</form>
					</td>
			</c:forEach>
		</table>
	</div>
	</div>
</body>
</html>