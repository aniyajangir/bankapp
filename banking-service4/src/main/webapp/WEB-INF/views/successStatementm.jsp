<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.xoriant.banking.model.User"%>
<%@ page import="com.xoriant.banking.model.Transactions"%>
<%@ page import="com.xoriant.banking.model.TransactionStatus"%>
<%@ page import="com.xoriant.banking.model.Customer"%>
<%@ page import="com.xoriant.banking.model.Account"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuccessStatements</title>
<s:url var="h_data" value="/resource/css/style1.css"></s:url>
<link rel="stylesheet" href="${h_data}">
</head>
<body style="background-color: white">
	<!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->

	<div height="10px"><jsp:include page="include/header.jsp"></jsp:include></div>


	<div height="60px" style="background-color: #1b4d3e; padding: 20px;"
		align="right">
		<a class="menu" href="index">Home</a> <a class="menu"> | </a> <a
			class="menu" href="aboutUs">About</a><a
			class="menu"> | </a> <a class="menu" href="logoutUser">logout</a>
	</div>
	<br><br><br>
		<tr>
			<td height="500px" valign="top">
				<%
	List<Transactions> transaction = (List<Transactions>) request.getAttribute("tranc");
	%>
	<%
	for (Transactions t : transaction) {
		int trancId = t.getTransactionId();
	%>
	<table  class="table" align="center">
		<tbody>

			<tr>
				<td>Transaction Id</td>
				<td>
					<%
					out.println(trancId);
					%>
				</td>
			</tr>
			<tr>
				<td>Transaction Status</td>
				<td>
					<%
					TransactionStatus trx = t.getTransactionStatus();
					out.println(trx);
					%>
				</td>
			</tr>
			<tr>
				<td>From Account</td>
				<td>
					<%
					Account fromAccountObj = t.getFromAccount();
					Account toAccountObj = t.getToAccount();

					long fromAccountNumber = fromAccountObj.getAccountNumber();

					out.println(fromAccountNumber);
					%>
				</td>
			</tr>
			<tr>
				<td>To Account</td>
				<td>
					<%
					long toAccountNumber = toAccountObj.getAccountNumber();
					out.println(toAccountNumber);
					%>
				</td>
			</tr>
			<%
			Customer fromAccountCustomer = fromAccountObj.getCustomer();
			Customer toAccountCustomer = toAccountObj.getCustomer();
			%>
			<tr>
				<td>From Person Name</td>
				<td>
					<%
					String fromPerson = fromAccountCustomer.getPersonName();
					out.println(fromPerson);
					%>
				</td>
			</tr>
			<tr>
				<td>To Person Name</td>
				<td>
					<%
					String toPerson = toAccountCustomer.getPersonName();
					out.println(toPerson);
					%>
				</td>
			</tr>
		</tbody>
	</table></br>
	<%
	}
	%>
		</tr>
		<tr>
			<td height="10px">
				<%--Footer --%> <jsp:include page="include/footer.jsp"></jsp:include>
		</tr>

	</table>
</body>
</html>