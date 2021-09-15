<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> New Registration </title>
</head>
<body>
	
	
	<h2>Register Here</h2>
	${error} 
	<br>
	
	<form action="saveReg" method="post">
		<table>
		
		<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName" required/><td>
		</tr>
		
		<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName" required/></td>
		</tr>
		
		<tr>
		<td>Email</td>
		<td><input type="email" name="emailId" required/></td>
		</tr>
		
		<tr>
		<td>Mobile</td>
		<td><input type="text" name="mobile" required/></td>
		</tr>
		
		<tr>
		<td>Qualification </td>
		<td><input type="text" name="qualification" required/></td>
		</tr>
		
		<tr>
		<td>Designation</td>
		<td> <input type="text" name="designation" required/></td>
		</tr>
		
		<tr>
		<td>Address</td>
		 <td><input type="text" name="address" required/></td>
		 </tr>
		 
		<tr>
		<td>Password</td>
		<td><input type="text" name="password" required/></td>
		</tr>
		
		<tr>
		<td><input type="submit" value="Register" /></td>
		<td><a href="showLogin">Login</a></td>
		</tr>
		
		
		
	</table>
	</form>
	
</body>
</html>