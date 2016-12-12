<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<script type="./resources/js/bootstrap.min.js" >  </script>
	<title>Login Form</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
   
</nav>

      
<form name="loginForm" class="form-horizontal" action="./login" method ="POST">
	<h1>Log in</h1>
	<input type="text" name="username" placeholder="Username" required><br>
	<input type="password" name="password" placeholder="Password" required><br>
	<input type="submit" value ="Login"> <br>
	
	<a href="./resources/registration.html"> First time donating? Sign up here!</a>
</form>

</body>
</html>
