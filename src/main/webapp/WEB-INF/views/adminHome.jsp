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

	<h1>Upcoming Donation Pick Ups </h1>
	<h2>Displaying Donations that expire within 1 Day </h2>
	<table border="1">
		<tr>
			
			<th>Company Name</th> 
			<th>Address</th> 
			<th>product Description</th>			
						
		</tr>
<c:forEach items="${adminList}" var="donation">
	<c:if test="${donation.status == 'ready' && donation.expirationDate < 2}">
		<tr>
			<td>${donation.nameOfCompany }</td>
			<td>${donation.address }</td>
			<td>${donation.productDescription}</td>
			
			<td>
			<form action="cancel or confirm" method="get">
                <input type="hidden" name="idCompanyDonation" value="${donation.idCompanyDonation}" />
                <input type="submit" value="cancel">
                <input type ="submit" value="confirm">
            </form>
            </td>
            </c:if>
	</c:forEach>
	</table>
	 
</body>
</html>