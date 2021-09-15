<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Authentication</title>
</head>
<body>
	<h2 align="center"> Validate OTP Here</h2>
	${error}
	${FAIL}
	${msg}
	<form action="validateOtp" method="post" style="max-width: 400px; margin: 0 auto;">
	
		Enter OTP <input type="text" name="otpnum" required/> <br>
		<input type="submit" value="verify"/>
	</form>
	<a href="generateOtp">Resend</a>
	
	
	<form action="logout" method="get">
		<input type="submit" value="LOGOUT"/>
	</form>
	
	
	
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
	String userName = (String) session.getAttribute("username");
	if (null == userName) {
	
		request.setAttribute("Error", "Session has ended.  Please login.");
	}
	%>
</body>
</html>



