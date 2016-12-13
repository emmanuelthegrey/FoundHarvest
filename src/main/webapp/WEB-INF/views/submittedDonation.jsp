<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.team.treasure.Donation"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">


<%
int timeout = 3;
response.setHeader("Refresh", timeout + "; URL = http://localhost:8080/treasure/donationform");
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Donation Submission</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
            <li><a href="./donationform">Donation Form</a></li>
            <li><a href="./">Log Out</a></li>
          </ul>
  </div>
</nav>



<script type="./resources/js/bootstrap.min.js" >  </script>

	<h1>Submitted Donation: </h1>
	<P>Thanks for the ${productDescription }!</P>
<!--  	<p>Publisher: "${publisher }" </p> -->
<!--	<p>Sales: "${sales }" </p> -->
	<ol>
	
	</ol>
	
<!--  <a href="./list">Back to List</a> -->
<!-- <a href="./">Back to home</a> -->
<a href="./donationform"> add another Donation?</a>
</body>
</html>