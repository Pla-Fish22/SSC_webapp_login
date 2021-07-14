<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body class="bg-dark">
<div class="container mt-4">
    <div class="container">
        <nav class="navbar navbar-dark navbar-expand-lg  bg-Dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">SSC - Login Webapp</a>
                <a class="btn btn-light pull-right" type="button" href="/logout">
                    <i class="fa fa-sign-out"></i> &nbsp; Logout
                </a>
            </div>
        </nav>
        <div class="row">
            <div class="col-12">
                <h3 class="my-4 text-light">Welcome, ${username}</h3>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-12">
                <a class="btn btn-info" type="button" href="/change">
                    <i class="fa fa-pencil-square-o"></i>&nbsp; Change Password
                </a>
                <a class="btn btn-success px-4" type="button" href="/addUser">
                    <i class="fa fa-plus"></i> &nbsp; Add User
                </a>
            </div>
        </div>

<table class="table table-striped table-secondary">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td class="py-3">${user.id}</td>
            <td class="py-3">${user.username}</td>
            <td class="py-3">${user.firstname}</td>
            <td class="py-3">${user.lastname}</td>
            <td class="align-middle">
            <div>
                <a class="btn btn-warning btn-sm" type="button" href="/edit?userName=${user.username}">
                    <i class="fa fa-pencil"></i>
                </a>
                <c:if test="${username != user.username}">
                    <a class="btn btn-danger btn-sm" type="button"
                       href="/delete?userName=${user.username}"
                       >
                        <i class="fa fa-trash"></i>
                    </a>
                </c:if>
            </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</div>
</body>
</html>