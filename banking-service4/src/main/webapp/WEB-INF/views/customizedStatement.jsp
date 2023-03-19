
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Form</title>
</head>
<body
	style="background-color: #d5fefd; background-image: linear-gradient(315deg, #d5fefd 0%, #fffcff 74%);">
	<!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->

	<table border="1" width="100%" align="center">
		<tr>
			<td height="10px" style="padding: 20px"><jsp:include page="include/header.jsp"></jsp:include>
				<%--header --%>
		</tr>
		<tr>
			<td style="padding: 5px"><jsp:include page="include/menu.jsp"></jsp:include>
				<%--header --%>
		</tr>

		<tr>
			<td valign="top">
				<div align="center" style="padding: 30px">
					<h1>MiniStatements Form</h1>
				</div>

				<div align="center">

					
	<f:form action="csuccessStatement" modelAttribute="customizedStatementCommand" style="padding: 80px">

		<table>
			<tr>
				<td>Account Number</td>
				<td><f:input  path="accountNo" /></td>
			</tr>
			<tr>
				<td>fromDate</td>
				<td><f:input type="date" path="fromDate" /></td>
			</tr>
			<tr>
				<td>toDate</td>
				<td><f:input  type="date" path="toDate" /></td>
			</tr>
			<tr>
				<td>amountLowerLimit</td>
				<td><f:input path="amountLowerLimit" /></td>
			</tr>
			<tr>
				<td>numberOfTransaction</td>
				<td><f:input placeholder="eg:1" path="numberOfTransaction" /></td>
			</tr>

			<tr>
				<td><button>Send</button></td>

			</tr>
		</table>

	</f:form>

				</div>
		</tr>
		<tr>
			<td height="10px">
				<%--Footer --%> <jsp:include page="include/footer.jsp"></jsp:include>
		</tr>

	</table>
</body>
</html>