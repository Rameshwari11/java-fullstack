<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer details.....</title>
</head>
<body>
<h2>showing customer details...</h2><hr><br/>
Customer ID: ${c.customerId}<br/>
First Name: ${c.lastName }<br/>
Last Name: ${c.firstName}<br/>
Email: ${c.email }
</body>
</html>