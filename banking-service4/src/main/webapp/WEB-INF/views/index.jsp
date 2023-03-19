

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BankConnect</title>
<s:url var="h_data" value="/resource/css/style1.css"></s:url>
<link rel="stylesheet" href="${h_data}">
</head>
<body>
	<div height="10px">
		<h1 align="center"
			style="color: #679267; font-family: monospace; font-style: oblique;">
			<b>Welcome to Piggy Bank Connect</b>
		</h1>
	</div>


	<div height="70px" style="background-color: #1b4d3e; padding: 20px;"
		align="right">
		<a class="menu" href="aboutUs">About</a><a class="menu"> | </a> <a
			class="menu" href="loginUser">Login</a>

	</div>
	<div style="width: 100%;">
		<div
			style="width: 35%; height: 100px; float: left; padding-top: 20px; padding-left: 20px;"
			align="left">
			<div style="width: 100%;">
				<h2 class="h2Index">
					Stay Connected with your accounts 24/7
				</h2>
				<br>
				<h2 class="h2Index">
					Online Banking
					<br> <i> Check your Account Balance,Transfer Money and check MiniStatements</i>
				</h2>
				<br>
				<h2 class="h2Index">
					Accounts
					<br> <i>Get Details About your Accounts</i>
				</h2>

			</div>
		</div>
		<div align="right">
			<img alt="im"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1dRsJEFdTkayb-rppJ2Or2rmQ1gb7st1lzw&amp;usqp=CAU">
		</div>
	</div>
	<div align="center">
		<%--Footer --%>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>