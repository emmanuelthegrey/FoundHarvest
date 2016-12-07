<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> <c:if test="${user == null}"> 
	It's Null!
	</c:if>
	<c:if test="${user != null}">
	${user.userName }
	You're logged in!
	</c:if>
	
	<a href="./resources/DonationForm.html"> Donate! </a>
</P>
</body>
</html>
