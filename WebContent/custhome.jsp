<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AccountHomePage</title>
</head>
<body>

<center>
<div>
<p>User Id:= ${sessionScope.customer.custId }</p>
<p>User Name:= ${sessionScope.customer.custName }</p>
<p>User Balance:= ${sessionScope.customer.custAccount.balance }</p>
</div>

<div><a href="fundtransfer.jsp">Fund Transfer</a></div>
  <div><a href="changepassword.jsp">Change Password</div>
  <div><a href="logout.jsp">Change Password</div>

</center>
</body>
</html>