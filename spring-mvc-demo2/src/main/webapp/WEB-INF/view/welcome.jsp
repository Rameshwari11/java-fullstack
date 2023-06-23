<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
	out.println("There we go   "+ request.getAttribute("ATTR2") + " email " + request.getAttribute("ATTR3")+ " age" + request.getAttribute("ATTR4"));
%>
</body>
</html>
