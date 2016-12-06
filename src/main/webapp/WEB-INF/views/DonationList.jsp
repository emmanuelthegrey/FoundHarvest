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

	<h1>Donation List</h1>
	<table border="1">
		<tr>
			<th>idCompanyDonation</th>
			<th>Company Name</th> 
			<th>Address</th> 
			
			<th>Delete</th>
		</tr>
	<c:forEach items="${DonationList }" var="donation">
		<tr>
			<!--  <td>${donation.idCompanyDonation }</td>-->
			<td>${donation.nameOfCompany }</td>
			<td>${donation.address }</td>
			
			<td>
			<form action="delete" method="get">
                <input type="hidden" name="idCompanyDonation" value="${donation.idCompanyDonation}" />
                <input type="submit" value="delete">
            </form>
            </td>
	</c:forEach>
	</table>
	 
</body>
</html>