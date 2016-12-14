<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
int timeout = 4;
response.setHeader("Refresh", timeout + "; URL =http://localhost:8080/treasure/CompanyDonations");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Confirm</title>
</head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
            <li><a href="./">Log Out</a></li>
          </ul>
  </div>
</nav>



<script type="./resources/js/bootstrap.min.js"></script>
You've edited your profile!

<br> Were taking you back to your donations in 5 seconds!
<br> <a href="./CompanyDonations">Return To Company Donations</a>

</body>
</html>