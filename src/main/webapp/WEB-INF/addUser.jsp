<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Webapp</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h2>
    Add User here
</h2>
<div class="container">
    <div class="row justify-content-md-center h-100">
        <div class="col-sm-12 col-md-6 col-lg-4 my-auto">
<form action = "/addUser" method = "post">
    <div class="input-group mb-4 input-group-md">
        <span class="input-group-text" id="username" style="width: 40px">
                        <i class="fa fa-user-circle-o"></i>
        </span>
        <input type="text" class="form-control" name="newUserName" placeholder="Username" aria-label="Username"
               aria-describedby="username" required>
    </div>
</form>
        </div>
    </div>
</div>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <input type="text" placeholder="Enter Firstname" name="firstname" required><br>
    <input type="text" placeholder="Enter Lastname" name="lastname" required><br>
    <button type="submit">Add</button>
</form>
</body>
</html>