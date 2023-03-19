</html>
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
<s:url var="h_data" value="/resource/css/style1.css"></s:url>
<link rel="stylesheet" href="${h_data}">
</head>
<body style="background-color: white">
	<!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->

	<div>
		<div height="10px"><jsp:include page="include/header.jsp"></jsp:include></div>


		<div height="70px" style="background-color: #1b4d3e; padding: 20px;"
			align="right">
			<a class="menu" href="index">Home</a> <a class="menu"> | </a> <a
				class="menu" href="changePassword">Change Password</a> <a
				class="menu"> | </a> <a class="menu" href="logoutUser">logout</a>
		</div>

		<div style="width: 100%; padding-top: 40px">
			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">


					<h4>Check your current balance</h4>

					<a href="balanceEnquirym"><button class="button">
							<span> Balance </span>
						</button> </a>


				</div>
			</div>
			
			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<h4>Check your Transactions</h4>
					<a href="miniStatementm"><button class="button">
							<span>Mini Statement </span>
						</button></a>
				</div>
			</div>

			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;  padding-right: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<h4>Want to Transfer Money</h4>
					<a href="fundTransferm"><button class="button" class="button">
							<span>fund transfer </span>
						</button> </a>

				</div>
			</div>

			
		</div>
		<div style="width: 100%; padding-top: 40px">
			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">


					<h4>Want to add Account</h4>

					<a href="newAccount"><button class="button">
							<span> Add  </span>
						</button> </a>


				</div>
			</div>

			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<%-- <h4>Want to Edit Account</h4>
					<a href="editAccount"><button class="button" class="button">
							<span>Edit </span>
						</button> </a>
 --%>
				</div>
			</div>

			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px; padding-right: 20px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<h4>Want to Delete Account</h4>
					<a href="deleteAccount"><button class="button">
							<span>Delete </span>
						</button></a>
				</div>
			</div>
		</div>
		<div style="width: 100%; padding-top: 40px">
			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">


					<h4>Want to add Customer</h4>

					<a href="newCustomer"><button class="button">
							<span> Add  </span>
						</button> </a>


				</div>
			</div>

			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<%-- <h4>Want to Edit Customer</h4>
					<a href="editCustomer"><button class="button" class="button">
							<span>Edit </span>
						</button> </a>
 --%>
				</div>
			</div>

			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px; padding-right: 20px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<h4>Want to Delete Customer</h4>
					<a href="deleteCustomer"><button class="button">
							<span>Delete </span>
						</button></a>
				</div>
			</div>
		</div>
			<div style="width: 100%; padding-top: 40px" align="center">
			<div
				style="width: 25%; height: 100px; float: left; padding-left: 80px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">


					<h4>Want to Deposit Money</h4>

					<a href="deposit"><button class="button">
							<span> Deposit  </span>
						</button> </a>


				</div>
			</div>

			<div
				style="width: 25%; height: 100px; float: right; padding-left: 80px; padding-right: 95px;  padding-top: 20px;"
				align="left">
				<div style="width: 100%;" class="wholeBlock" align="center">

					<h4>Want to Withdraw Money</h4>
					<a href="withdraw"><button class="button">
							<span>Withdraw </span>
						</button></a>
				</div>
			</div>
		</div>
		


		<br>
		<br>
		<br>

		<br>	<br>
		<br>
		<br>

		<br>	<br>
		<br>
		<br>

		<br>	<br>
		<br>
	

		<br><br>
		<br>

		<br>
		<br>
		<div align="center">
			<!-- 	Footer -->
			<jsp:include page="include/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
