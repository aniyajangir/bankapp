<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login Form</title>
</head>
<body >
<div><img src="data:image/png;base64" width="200" height="120"></div>
	<form:form name="submitForm" method="POST" style="padding:120px">
		<div align="center" style="padding:20px;border:solid 1px lightgreen;border-radius:20px">
		
			<table style="padding:20px;border:solid 1px ;border-radius:20px" >
				<h2>Enter Your Credentials</h2>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input style="position:relative;top:5px;width:85%;background-color: #4CAF50;padding:10px;border:none;border-radius:12px;color:white" type="submit" value="Submit" /></td>
				</tr>
			</table>
			<%-- <div style="color: red">${error}</div>

		</div> --%>
	</form:form>
</body>
</html>