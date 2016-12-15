<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Donation Form</title>
<script type="./resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<link rel="stylesheet" href="./resources/css/bootstrap-theme.min.css">

<style>
.grey-color {
background-color:#f5f5f5;
}

</style>
</head>

<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Found Harvest</a>
    </div>
     <ul class="nav navbar-nav navbar-right">
            <li><a href="./CompanyDonations"> Your Company Donations</a></li>
            <li><a href="./editedRegistration"> Edit Profile</a></li>
            <li><a href="./">Log Out</a></li>
          </ul>
  </div>
</nav>

<div class="container grey-color">

<h1>Submit Donation Here</h1>
	<form name="DonationForm" class="form-horizontal" action="./submittedDonation"
		onSubmit="return validateDonation()" method="POST">
		
		Donation Requirements: <br>
			<ul>
		<li>Donation pick-up routes currently only service <strong>Oakland, McComb and Wayne counties </strong></li>
		<li>Donation pick-up package size needs to <strong>weight 200lbs or more</strong>. </li>
		<li>If your donation is outside these counties and weight requirements please contact us directly</li>
			</ul>
		
		<fieldset>
				
		<legend> </legend>
		
		<div class="form-group">
      <label for="inputdescription" class="col-lg-2 control-label">Product Description</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="productDescription" placeholder="Brief description of what is being donated (required)">
      </div>
		</div>	
		
		
		<div class="form-group">
      <label for="daysToPickUp" class="col-lg-2 control-label">How many days do we have to pick this up?</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="expirationDate" placeholder="e.g. 1 (required) ">
      </div>
		</div>
		
		
		<div class="form-group">
      <label for="estimatedLBS" class="col-lg-2 control-label">Please enter estimated weight of package(s) in (lbs)</label>
      <div class="col-lg-4">
        <input type="text" class="form-control" name="enterWeight" placeholder="e.g. 500 (required)">
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
	</div>

	<script>
	
	//validation for blanks
	function validateDonation() {
		
		
		
		var pd = document.forms["DonationForm"]["productDescription"].value;
		var ed = document.forms["DonationForm"]["expirationDate"].value;
	  	var ew = document.forms["DonationForm"]["enterWeight"].value;

	  	var reg = /^\d+$/;
		
	  	if (pd == "") {
			alert("Product Description must be filled out");
			
			return false;
		} else if (reg.test(ed) === false){
			alert("Please enter in a number for how many days we have to pick it up");
			
			return false;
		}else if ((reg.test(ew) === false) || (ew < 200)) {
			alert("We only pick up donations over 200 lbs, please consider dropping your donation off at our location");
			return false;
			
		}
	  	return radioValidation();
		
	}
	
	
		
	
	
	//validation for radio
	 	function radioValidation() {
			var packaged = document.getElementsByName('packaged');
			
			if (packaged[1].checked == true) {
				alert("We only pick up items that are packaged");
				
				return false;
				}
			
				
		

				if (packaged[0].checked == false
						&& packaged[1].checked == false) {
					alert("Please select an option");
					
					return false;

				}
				
			return true;
	}
		
	 
		
</script>
</body>
</html>

