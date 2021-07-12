<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
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
    Add User here
</h2>
<form action = "/addUser" method = "post">
    <input type="text" placeholder="Enter Username" name="username" required><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <input type="text" placeholder="Enter Firstname" name="firstname" required><br>
    <input type="text" placeholder="Enter Lastname" name="lastname" required><br>
    <button type="submit">Add</button>
</form>
</body>
</html>