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
            <li><a href="./CompanyDonations">Company Profile</a></li>
            <li><a href="./">Log Out</a></li>
          </ul>
  </div>
</nav>





	<h1>Submit Donation Here</h1>

	<form name="DonationForm" class="form-horizontal" action="./submittedDonation"
		onSubmit="return validateDonation()" method="POST">
		<fieldset>
		<legend></legend>
		
		
		<div class="form-group">
      <label for="inputdescription" class="col-lg-2 control-label">Product Description</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="productDescription" placeholder="Quick Description of what is being donated">
      </div>
		</div>	
		
		
		<div class="form-group">
      <label for="daysToPickUp" class="col-lg-2 control-label">How many days do we have to pick this up?</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="expirationDate">
      </div>
		</div>
		
		
		<div class="form-group">
      <label for="estimatedLBS" class="col-lg-2 control-label">Please enter estimated weight of package(s) in (lbs)</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="enterWeight">
      </div>
		</div>
		
		  <div class="form-group">
      <label class="col-lg-2 control-label">Is Food Packaged?</label>
      <div class="col-lg-4">
        <div class="radio">
          <label>
            <input type="radio" name="packaged" id="yespack" value="yes">
            Yes
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="packaged" id="nopack" value="no">
            No
          </label>
        </div>
      </div>
    </div>
		<div class="form-group">
      <div class="col-lg-4 col-lg-offset-2">
			 <input type="submit" class="btn btn-default" value="Submit">
			 </div>
			 </div>
		
		 
		 
		
		 
			</fieldset>
	</form>

	<script>
	
	//validation for blanks
	function validateDonation() {
		radioValidation();
		
		
		
		var pd = document.forms["DonationForm"]["productDescription"].value;
		var ed = document.forms["DonationForm"]["expirationDate"].value;
	  	var ew = document.forms["DonationForm"]["enterWeight"].value;

	  	var reg = /^\d+$/;
		
	  	
	  	
	  	if (pd == "") {
			alert("Product Description must be filled out");
			
			return false;
		} else if (reg.test(ed) === false) {
			alert("Please enter in a number");
			
			return false;
		}else if (reg.test(ew) === false) {
			alert("Please enter in a number");
			
			return false;
			
		}else{
			return true;
	} 
	}
	
	
		
	
	
	//validation for radio
	 	function radioValidation() {
			var packaged = document.getElementsByName('packaged');
			var weight = document.getElementsByName('weight');
			
			
			if (packaged[1].checked == true) {
				alert("We cannot pick this item up");
				
				return false;
				}
			if (weight[1].checked == true) {
				alert("We cannot pick this item up");
				
				return false;
				
			} else {

				if (packaged[0].checked == false
						&& packaged[1].checked == false) {
					alert("Please select an option");
					
					return false;

				}
				if (weight[0].checked == false && weight[1].checked == false) {
					alert("Please select an option");
					
					return false;	}
		
			return true;
	}
	}		
	 
		
</script>
</body>
</html>

