<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.team.treasure.Donation"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donations in the Queue</title>
</head>
<body>

	<h1>Donations in the Queue </h1>
	<h2> </h2>
	<table border="1">
		<tr>
			
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
                <input type ="submit" value="cancel">
            </form>
            </td>
                  
	</c:forEach>
	</table>
	 
</body>
</html>