<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.team.treasure.Donation"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style></style>



<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./resources/sorttable.js"/></script>
<title>Admin Home</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
            <li><a href="" target="_blank">Colton's Right</a></li>
            <li><a href="" target="_blank">Life has no meaning</a></li>
          </ul>
  </div>
</nav>


	<h1>Upcoming Pick Ups! </h1>
	<table class="sortable table table-striped table-hover" border="1" >
		<tr class ="success">
			
			<th>Company Name</th> 
			<th>Main Contact</th>
			<th>Address</th> 
			<th>Product Description</th>	
			<th>Last Day To Pickup</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Remove </th>		
			<th>Confirm </th>
						
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
			<form action="remove" method="get">
                <input type="hidden" name="cancel" value="${item.donation.idCompanyDonation}" />
                <input type ="submit" class="btn btn-danger" value="Remove">
            </form>
            </td>
            <td>
            <form action="confirm"  method="get">
                <input type="hidden" name="confirm" value="${item.donation.idCompanyDonation}" />
                <input type="hidden" name="tweet" value="${item.company.twitterName}" />
                <input type="hidden" name="companyName" value="${item.company.companyName}" />
                <input type="hidden" name="productDescription" value="${item.donation.productDescription}" />
                <input type="submit" class="btn btn-success" value="Confirm">
            </form>
            </td>
	</c:forEach>
	</table>
	 
	<br>
	<a href="./adminHomeQueue"> Check previous donations! </a>
</body>
</html>