<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">
	<div class="links">
		<h1><a href="list">Book store</a></h1>
		<h2><a href="new">Add New Book</a></h2>
	</div>
	<div class="booktable">
		<table>
			<caption><h2>List of Books</h2></caption>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
			</tr>
			
			<c:forEach items="${book_list}" var="item">
				<tr>
					<td> ${ item.getTitle() } </td>
					<td> ${ item.getAuthor() } </td>
					<td> ${ item.getPrice() } </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>
</html>