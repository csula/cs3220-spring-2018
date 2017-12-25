<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <ul>
    <c:forEach items="${list}" var="entry">
    <li>${entry.name} - ${entry.comment}</li>
    </c:forEach>
    </ul>

    <a href="guestbook/create">Add new comment</a>
</body>
</html>
