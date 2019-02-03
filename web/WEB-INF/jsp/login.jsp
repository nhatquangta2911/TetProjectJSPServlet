<%--
  Created by IntelliJ IDEA.
  User: ryan-ta
  Date: 1/27/19
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container w-100">
        <br><br><h1 class="text-secondary">LOGIN PAGE</h1>
        <hr><br>
        <p class="text-danger">${userInfo}</p>
        <form method="post" action="/login">
            <div class="w-75">
                Email:<br>
                <input type="email" name="email" required class="form-control form-control-sm">
            </div><br>
            <div class="w-75">
                Password:<br>
                <input type="password" name="password" required class="form-control form-control-sm">
            </div>
            <br>
            <p class="text-warning">${fail}</p>
            <div>
                <input type="submit" value="LOGIN" class="btn w-75 btn-outline-primary">
            </div>
        </form>
        <form method="get" action="/register">
            <input type="submit" value="Register" class="btn w-75 btn-outline-success">
        </form>
    </div>
</body>
</html>
