<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
int timeout = 3;
response.setHeader("Refresh", timeout + "; URL =http://localhost:8080/treasure/adminHome");
%>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donation Cancelled</title>
</head>
<body>
<script type="./resources/js/bootstrap.min.js"></script>
You've removed the donation!

<a href="./adminHome">Return to Admin Home</a>

</body>
</html>