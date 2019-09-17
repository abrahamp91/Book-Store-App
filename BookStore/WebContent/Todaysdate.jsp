<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	java.util.Date today = new java.util.Date();
	String message = "Today's date is " + today.toString();
%>


<%=
	message
%>



</body>
</html>