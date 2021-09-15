<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1 align="center">Login Here</h1>
	
	<form action="verifyLogin" method="post"
		style="max-width: 400px; margin: 0 auto;">

		Username <input type="email" name="email" required /> <br> <br>
		Password <input type="password" name="password" required /> <br>
		<input type="submit" value="Login" />
		<a href="showReg" > New Registration</a>
	</form>
	
	<h3 align="center">${error} </h3>
</body>
</html>