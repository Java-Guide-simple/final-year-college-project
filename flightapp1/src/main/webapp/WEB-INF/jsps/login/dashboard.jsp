<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account</title>
</head>
<body>


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
	<h2>Profile</h2>


	<table>

		<tr>
			<td>Employee Id</td>
			<td>${profile.getEid()}</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td>${profile.getFirstName()} </td>
		</tr>
		
		<tr>
			<td>Last Name</td>
			<td>${profile.getLastName()}</td>
		</tr>

		<tr>
			<td>Email Id</td>

			<td>${profile.getEmailId()}</td>

		</tr>

		<tr>
			<td>Qualification</td>
			<td>${profile.getQualification()}</td>
		</tr>

		<tr>
			<td>Designation</td>
			<td>${profile.getDesignation()}</td>
		</tr>

		<tr>
			<td>Mobile No</td>
			<td>${profile.getMobile()}</td>
		</tr>
		
		
		<tr>
			<td>Address</td>
			<td>${profile.getAddress()}</td>
		</tr>




	</table>


	<form action="logout" method="get">
		<input type="submit" value="LOGOUT" />
	</form>
</body>
</html>