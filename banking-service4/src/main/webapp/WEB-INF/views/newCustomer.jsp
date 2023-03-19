


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer Form</title>
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
			<h1>Add Customer Form</h1>
		</div>



		<f:form action="newCustomerSubmit" modelAttribute="customer">

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
					<td>Person Name</td>
					<td><f:input path="personName" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><f:input path="gender" /></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><f:input type="date" path="date" /></td>
				</tr>
				<tr>
					<td>Flat No</td>
					<td><f:input path="flatNo" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><f:input path="city" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><f:input path="state" /></td>
				</tr>
				<tr>
					<td>Pin</td>
					<td><f:input path="pincode" /></td>
				</tr>
				<tr>
					<td>Telephone Number</td>
					<td><f:input path="telephoneNumber" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><f:input path="email" /></td>
				</tr>

				<tr>
					<td>User Name</td>
					<td><f:input path="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><f:input path="password" /></td>
				</tr>


				<tr>
					<td><a><button class="button" onclick="myFunction()"
								type="submit" value="Submit">
								<span>Add</span>
							</button></a></td>
				</tr>
			</table>

		</f:form>

	</div>
	
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


