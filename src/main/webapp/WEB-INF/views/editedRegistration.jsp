<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Donation Form</title>
<script type="./resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">
</head>

<body>
	
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Found Harvest</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="./CompanyDonations"> Your Company Donations</a></li>
			<li><a href="./donationform">Donation Form</a></li>
			<li><a href="/treasure/">Log in</a></li>
		</ul>
	</div>
	</nav>
	
	<h1>Edit Your Account Information</h1>

	<div>
		<form name="RegistrationForm" class="form-horizontal" action="./editedConfirmation" onsubmit="return validateForm()" method="POST">
		<fieldset>
		<legend></legend>
		
			
			 <div class="form-group">
      <label for="inputcompanyname" class="col-lg-2 control-label">Company Name</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="companyName" value=${companyProfile.companyName }>
      </div>
		</div>	
			<div class="form-group">
      <label for="inputCompanyAddress" class="col-lg-2 control-label">Company Address</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="address" value="${companyProfile.address }">
      </div>
    </div>
    	<div class="form-group">
      <label for="inputMainContact" class="col-lg-2 control-label">Main Contact</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="contact" value="${companyProfile.mainContact }">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPhoneNumber" class="col-lg-2 control-label">Phone Number</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="phoneNumber" value="${companyProfile.companyPhoneNumber }">
      </div>
    </div>
     <div class="form-group">
      <label for="inputPhoneNumber" class="col-lg-2 control-label">Email</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="email" value="${companyProfile.email }">
      </div>
    </div>
     
    <div class="form-group">
      <label for="inputTwitterName" class="col-lg-2 control-label">Twitter Name @</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="twitterName" value="${companyProfile.twitterName }">
      </div>
    </div>
     <div class="form-group">
      <label for="inputUserName" class="col-lg-2 control-label">User Name</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="username" value="${companyProfile.userName }">
      </div>
    </div>
      <div class="form-group">
      <label for="inputPassword" class="col-lg-2 control-label">Password</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="password" placeholder="Your password">
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-4 col-lg-offset-2">
      		 <input type="hidden" name="companyID" value="${companyProfile.companyID}" />
			 <input type="submit" class="btn btn-default" value="Submit">
			 </div>
			 </div>
				
				</fieldset>
		</form>
		

		<script>
			function validateForm() {
			
				var cn = document.forms["RegistrationForm"]["companyName"].value;
				var ad = document.forms["RegistrationForm"]["address"].value;
				var ct = document.forms["RegistrationForm"]["contact"].value;
				var pn = document.forms["RegistrationForm"]["phoneNumber"].value;
				var em = document.forms["RegistrationForm"]["email"].value;
				var un = document.forms["RegistrationForm"]["username"].value;
				var pswrd = document.forms["RegistrationForm"]["password"].value;

				if (cn == "") {
					alert("Company Name must be filled out");
					return false;
				}
				if (ad == "") {
					alert("Company Address must be filled out");
					return false;
				}
				if (ct == "") {
					alert("Company Main Contact must be filled out");
					return false;
				}
				if (pn == "") {
					alert("Phone Number must be filled out");
					return false;
				}
				if (em == "") {
					alert("Email must be filled out");
					return false;
				}
				if (un == "") {
					alert("Username must be filled out");
					return false;
				} if (pswrd == "") {
					alert("You must retype your password");
					return false;
				} else if (validatePhone(pn) == false) {
					alert("Invalid Phone Number");
					return false;
				} else if (validateEmail(em) == false) {
					alert("Invalid email");
					return false;
				}
				
			}
			function validateEmail(x) {
				var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
				return re.test(x);
			}
			function validatePhone(p) {
				var ph = /^(\()?\d{3}(\))?(-|\s)?\d{3}(-|\s)\d{4}$/;
				return ph.test(p);
			}
			
			function myFunction() {
			    var x = document.getElementById("myText").placeholder;
			    document.getElementById("twittername").innerHTML = x;
			}
			
			function myFunction() {
			    var y = document.getElementById("phoneNumber").placeholder;
			    document.getElementById("xxx-xxx-xxxx").innerHTML = y;
			}
			
		
	
	</script>
	
	<script src="js/bootstrap.min.js"> </script>
	</div>
</body>
</html>