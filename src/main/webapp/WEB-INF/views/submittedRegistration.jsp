<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<%
int timeout = 3;
response.setHeader("Refresh", timeout + "; URL =http://localhost:8080/treasure/");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submitted Registration</title>
</head>
<body>
<script type="./resources/js/bootstrap.min.js" >  </script>

	<h1>Registered: </h1>

	<P>Thank you "${companyName }" for registering!</P>

	<a href="./"> Back to login </a>

</body>
</html>