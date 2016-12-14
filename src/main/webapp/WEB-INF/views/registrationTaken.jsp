<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<%
int timeout = 3;
response.setHeader("Refresh", timeout + "; URL = ./resources/registration.html");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Username Taken</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
            <li><a href="./donationform">Donation Form</a></li>
            <li><a href="./">Login</a></li>
          </ul>
  </div>
</nav>



<script type="./resources/js/bootstrap.min.js" >  </script>

	<h1>Sorry! </h1>

	<P>The username "${username }"" has already been taken!</P>

	<a href="./resources/registration.html"> Try Again</a><br>
	<a href="./"> Back to login </a>

</body>
</html>