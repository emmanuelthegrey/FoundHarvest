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
	<!--   
<script>
function validateForm() {
    var x = document.forms["form1"]["firstName"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}
 onsubmit="return validateForm()" 
</script> -->



	<h1>Submit Donation Here</h1>

	<form name="DonationForm" action="./submittedDonation"
		onsubmit="return radioValidation()" method="POST">
		Product Description: <input type="text" name="productDescription">
		<br> How many days do we have to pick this up? <input type="text"
			name="expirationDate"> <br> Is food packaged:<br> <input
			type="radio" name="packaged" id="yespack" value="yes"> Yes<br>
		<input type="radio" name="packaged" id="nopack" value="no"> No<br>
		Is food greater than 200lbs:<br> <input type="radio"
			name="weight" id="yespack" value="yes"> Yes<br> <input
			type="radio" name="weight" id="nopack" value="No"> No<br>
		Please enter estimated weight of package(s) in (lbs): <input
			type="text" name="enterWeight"> <br> <input
			type="submit" value="Submit">
	</form>
	<br>
	<a href="./CompanyDonations">Check your companies profile</a>

	<script>
	
	
		
	
	
	//validation for radio
	 	function radioValidation() {
			validateDonation();
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
					
					return false;
				}
			}
			return true;
	 
			//validation for blanks
		function validateDonation() {
			allLetter(inputtxt);
			var pd = document.forms["DonationForm"]["productDescription"].value;
			var ed =document.forms["DonationForm"]["expirationDate"].value;
		  	var ew = document.forms["DonationForm"]["enterWeight"].value;

			
			if (pd == "") {
				alert("Product Description must be filled out");
				
				return false;
			}
			if (ed == "") {
				alert("Expiration must be filled out");
				
				return false;
			}
			if (ew == "") {
				alert("Weight must be filled out");
				
				return false;
				
				else if (allnumeric(ew) == false) {
					alert("Invalid weight");
					return false;
			}
			return true;
		}
		
		//validation for letters
		function allLetter(inputtxt) { 
			allNumeric(inputtxt);
		
	      var letters = /^[A-Za-z]+$/;
	      if(inputtxt.value.match(letters))
	      {
	      alert('Your name have accepted : you can try another');
	      return true;
	      
	      }else{
	      alert('Please input alphabet characters only');
	      return false;
	      }
	      }
		
		//validation for numbers
		function allnumeric(inputtxt) {
	      
			var numbers = /^[0-9]+$/;
	      if(inputtxt.value.match(numbers && inputtxt.value > 200)) {
	      alert('Your Registration number has accepted....');
	    
	       return true;
	     
	      }else{
	      alert('Please input numeric characters only and greater than 200lbs');
	      
	      return false;
	      }
	      
		}
		return true;
	} 

	
	</script>
</body>
</html>
