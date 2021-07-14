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
<body class="bg-dark">
<h2>
    Edit
</h2>
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
            <a class="btn btn-warning" type="button" href="/">
                <i class="fa fa-home"></i>&nbsp; Home
            </a>
        </div>
    </div>
</div>
<div class="row justify-content-md-center h-90">
    <div class="col-sm-12 col-md-6 col-lg-4 my-auto">
        <h2 class="text-light"> Change Password</h2>
        <p class="text-danger">${error}</p>
        <form action="/change" method="post">
            <div class="input-group mb-4 input-group-md">
        <span class="input-group-text" id="password" style="width: 40px">
                        <i class="fa fa-keyboard-o"></i>
        </span>
                <input type="password" class="form-control" name="password" placeholder="new Password"
                       aria-label="Password"
                       aria-describedby="password">
            </div>
            <div class="d-grid gap-2">
                <button class="btn btn-info" type="submit"><i class="fa fa-pencil"></i>Change</button>
            </div>
        </form>
    </div>
</div>
</div>
</form>
</body>
</html>