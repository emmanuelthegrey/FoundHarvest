<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Donation Form</title>
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
	<form name="DonationForm" action="./submittedDonation" method="POST">
		Product Description: <input type="text" name="productDescription"> <br>
		Number of days before food expires: <input type="text" name="expirationDate"> <br>
		Is food packaged:<br> <input type="radio" name="package" value="yes"> Yes<br>
 						 	  <input type="radio" name="package" value="no"> No<br>
		Is food greater than 200lbs:<br><input type="radio" name="weight" value="yes"> Yes<br>
									 <input type="radio" name="weight" value="No"> No<br>
		<input type="submit" value="Submit"> 
	</form> 
	<br> <a href="./CompanyDonations">Check your companies profile</a>
	
	
</body>
</html>