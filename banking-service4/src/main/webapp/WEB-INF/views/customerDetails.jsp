
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
	
	

	<div align="center" style="padding: 20px" >
	<table id="details"  cellpadding="5";>
				<tbody>
					<tr>
						<td>Name</td>
						<td>Gender</td>
						<td>City</td>
						<td>Flat No</td>
						<td>Pin code</td>
						<td>State</td>
					</tr>
					<tr>

						<td>
							<%
							String name = (String) session.getAttribute("name");
							%> <%
 out.println(name);
 %>
						</td>
						<td>
							<%
							String gender = (String) session.getAttribute("gender");
							%> <%
 out.println(gender);
 %>
						</td>
						
						<td>
							<%
							String city = (String) session.getAttribute("city");
							%> <%
 out.println(city);
 %>
						</td>
						<td>
							<%
							Integer flatNo = (Integer) session.getAttribute("flatNo");
							%> <%
 out.println(flatNo);
 %>
						</td>
						<td>
							<%
							Integer pin = (Integer) session.getAttribute("pin");
							%> <%
 out.println(pin);
 %>
						</td>
						<td>
							<%
							String state = (String) session.getAttribute("state");
							%> <%
 out.println(state);
 %>
						</td>
						
					</tr>
				</tbody>

			</table>
	
			</div>
	<div align="center">
		<%--Footer --%>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>

