<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.team.treasure.Donation"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donation List</title>
</head>
<body>

	<h1> ${item.company.companyName}</h1>
	<h2>Submitted Donations </h2>
	<table border="1">
		<tr>
			
			 
			<th>Product Description</th>
			<th>Expiration Date</th> 
			
			
											
		</tr>
<c:forEach items="${itemList}" var="item">
		<tr>
			
			<td>${item.donation.productDescription } </td>
			<td>${item.donation.expirationDate }</td>
			
		
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