

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Account Form</title>
<s:url var="h_data" value="/resource/css/style1.css"></s:url>
<link rel="stylesheet" href="${h_data}">
</head>
<body style="background-color: white">
	<!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->

	<div height="10px"><jsp:include page="include/header.jsp"></jsp:include></div>


	<div height="60px" style="background-color: #1b4d3e; padding: 20px;"
		align="right">
		<a class="menu" href="index">Home</a> <a class="menu"> | </a> <a
			class="menu" href="aboutUs">About</a><a class="menu"> | </a> <a
			class="menu" href="logoutUser">logout</a>
	</div>


	<div align="center" style="padding: 50px;">
		<div align="center" style="padding: 20px">
			<h1>Add Account Form</h1>
		</div>



		<f:form action="newAccountSubmit" modelAttribute="account">
			<table class="table">
				<tr>
					<c:if test="${message!=null}">
						<p>${message}</p>

					</c:if>
					<c:if test="${err!=null}">
						<p style="color: red">${err}</p>
					</c:if>
				</tr>
				<tr>
					<td>Customer Id</td>
					<td><f:input path="personId" /></td>
				</tr>
				<tr>
					<td>Balance</td>
					<td><f:input path="balance" /></td>
				</tr>
				<tr>
					<td>Status</td>
					<td><f:input path="status" /></td>
				</tr>
				<tr>
					<td>Account Type</td>
					<td><f:input path="accountType" /></td>
				</tr>
				<tr>
					<td>Minimum Balance</td>
					<td><f:input path="minBalance" /></td>
				</tr>

				<tr>
					<td><a><button class="button" onclick="myFunction()"
								type="submit" value="Submit">
								<span>add</span>
							</button></a></td>
				</tr>
			</table>

		</f:form>

	</div>

	<br>
	<br>
	<div align="center">
		<%--Footer --%>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
	<script>
		function myFunction() {
			if (!(confirm('are you sure you want to add?')))
				return false;
		}
	</script>
</body>
</html>

