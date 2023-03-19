
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About</title>
<s:url var="h_data" value="/resource/css/style1.css"></s:url>
<link rel="stylesheet" href="${h_data}">
</head>
<body style="background-color: white">
	<div height="10px"><jsp:include page="include/header.jsp"></jsp:include></div>


	<div height="60px" style="background-color: #1b4d3e; padding: 20px;" align="right">
		<a class="menu" href="index">Home</a> <a class="menu"> | </a> <a
			class="menu" href="loginUser">Login</a>
	</div>
	
	

	<div style="width: 100%;">
		<div
			style="width: 35%; height: 100px; float: left; padding-top: 20px; padding-left: 20px;">
			<p>It is a story scripted in corporate wisdom and social pride.
 It is a story crafted in private capital, princely patronage and state ownership. 
 It is a story of ordinary bankers and their extraordinary contribution in the ascent of Bank
  to the formidable heights of corporate glory. It is a story that needs to be shared with all those millions of
   people - customers, stakeholders,
 employees & the public at large - who in ample measure, have contributed to the making of an institution.</p>
		</div>
		<div align="right">
			<img alt="im"
				src="https://www.bing.com/th?id=OIP.660epq0yP5B_dCDuAVLwVAHaFj&w=288&h=216&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2">
		</div>
	</div>
	<div align="center">
		<%--Footer --%>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>

