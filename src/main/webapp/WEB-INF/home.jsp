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
<table style="background-color: antiquewhite">
    <tr>
        <th>username</th>
        <th>firstname</th>
        <th>lastname<th>
    </tr>

    <c:forEach items="${userListMap}" var="usr" varStatus="idx">
        <tr>
            <td>${usr.username}</td><td>${usr.firstname}</td> <td>${usr.lastname}</td>
        </tr>
    </c:forEach>
</table>
<form action="/logout" method="get">
    <button type="submit">Logout</button>
</form>
<form action = "/addUser" method = "get">
    <button type = "submit">AddUser</button>
</form>
</body>
</html>