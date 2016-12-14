<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./resources/css/bootstrap.css">

<%
int timeout = 3;
response.setHeader("Refresh", timeout + "; URL =http://localhost:8080/treasure/CompanyDonations");
%>



<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">




<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donation Cancelled</title>
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
           <li><a href="./CompanyDonations">Company Profile</a></li>
          </ul>
  </div>
</nav>


<script type="./resources/js/bootstrap.min.js"></script>
You've removed the donation!



</body>
</html>