<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login Form</title>
</head>
<body>

<form name="loginForm" action="./login" method ="POST">
	<h1>Log in</h1>
	<input type="text" name="username" placeholder="Username" required><br>
	<input type="password" name="password" placeholder="Password" required><br>
	<input type="submit" value ="Login"> <br>
	
	<a href="./resources/registration.html"> First time donating? Sign up here!</a>
</form>
</body>
</html>
