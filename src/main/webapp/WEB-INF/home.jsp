<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        h1{
            color: darkmagenta;
            font-family: Papyrus;
        }
        body{
            background-color: slategray;
        }
    </style>
</head>
<body>
<h2>
    Hello ${username}
</h2>
<c:forEach var="user" items="${users}">
    <tr>
        <td class="py-2">${user.id}</td>
        <td class="py-2">${user.firstname}</td>
        <td class="py-2">${user.lastname}</td>
    </tr>
</c:forEach>
</body>
</html>