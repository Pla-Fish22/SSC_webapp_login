<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
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
<p>
    ${error}
</p>
<h1>LOGIN</h1>
<form action="/login" method="post">
    <input type="text" placeholder="Enter Username" name="username" required/>
    <input type="password" placeholder="Enter Password" name="password" required/>
    <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
</form>
</body>
</html>

