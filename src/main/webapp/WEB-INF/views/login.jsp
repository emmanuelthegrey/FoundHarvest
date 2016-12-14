<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/custom.min.css">

<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
<script type="./resources/js/bootstrap.min.js" >  </script>
	<title>Login Form</title>
	
	<style>
.grey-color {
background-color:#f5f5f5;
}
.margin-set { 
	margin-left:25%;
	margin-right:25%;
	text-align: center;
}	
</style>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
      </div>
      </div>
   
</nav>
<div class="grey-color margin-set">
<h1>Login</h1>

<div class="row" >
      
      <div class="col-lg-6" >
<form name="loginForm" class="form-horizontal" action="./login" onSubmit="return validateLogin()" method ="POST">
	
	<input type="text" name="username" placeholder="Username" required><br>
	<input type="password" name="password" placeholder="Password" required><br>
	
	<br> <input type="submit" value ="Login"> <br>
	<br>
	<a href="./resources/registration.html"> First time donating? Sign up here!</a>
</form>
</div>

</div>
</div>
<script>
function validateLogin() {
    
	var un = document.forms["loginForm"]["username"].value;
    var pswrd = document.forms["loginForm"]["password"].value;

    if (un === "") {
        alert("Username must be filled out");
        return false;
    }else if(pswrd === "") {
    	alert("Password must be filled out");
    	return false;
    }
}
</script>


</body>
</html>
