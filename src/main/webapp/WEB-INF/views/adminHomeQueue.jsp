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
<script src="./resources/sorttable.js"/></script>
<title>Donations in the Queue</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
            <li><a href="./adminHome">Pending Donations</a></li>
            <li><a href="./">Log Out</a></li>
          </ul>
  </div>
</nav>

<script>
function printDiv(printableArea) {
    var printContents = document.getElementById(printableArea).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}

</script>

	<h1>Completed Donations In Last 30 Days </h1>
	<h2> </h2>
				<div id="printableArea">
	
	<table class="sortable table table-striped table-hover" border="1">
		<tr class ="success">
			
			<th>Company Name</th> 
			<th>Main Contact</th>
			<th>Address</th> 
			<th>Product Description</th>	
			<th>Expiration Date</th>
			<th>Phone Number</th>
			<th>Email</th>
			
			<th>Cancel </th>		
			
						
		</tr>
<c:forEach items="${itemList}" var="item">
	
		<tr>
			
			<td>${item.company.companyName }</td>
			<td>${item.company.mainContact }</td>
			<td>${item.company.address } </td>
			<td>${item.donation.productDescription } </td>
			<td>${item.donation.expirationDate }</td>
			<td>${item.company.companyPhoneNumber }</td>
			<td>${item.company.email } </td>
			           
		
			<td>
			<form action="cancel" method="get">
                <input type="hidden" name="idCompanyDonation" value="${item.donation.idCompanyDonation}" />
                <input type ="submit" class="btn btn-danger" value="Remove">
            </form>
            </td>
                  
	</c:forEach>
	</table>
		 <input type="button" onclick="printDiv('printableArea')" value="Print Reciept" />
	
	</div>
	
</body>
</html>