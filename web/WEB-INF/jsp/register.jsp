<%--
  Created by IntelliJ IDEA.
  User: ryan-ta
  Date: 1/27/19
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container w-100">
    <br><br><h1 class="text-secondary">Create an account</h1>
    <hr><br>
    <form method="post" action="/register">
        <div class="w-50">
            Email:<br>
            <input type="email" name="email" class="form-control">
        </div><br>
        <div class="w-50">
            Password:<br>
            <input type="password" name="password-1" class="form-control">
        </div><br>
        <div class="w-50">
            Retype Password:<br>
            <input type="password" name="password-2" class="form-control">
        </div><br>
        <div class="w-50">
            Full Name:<br>
            <input type="text" name="full-name" class="form-control">
        </div><br>
        <div class="w-50">
            Date Of Birth:<br>
            <input type="date" name="date-of-birth" class="form-control">
        </div><br>
        <div class="row">
            <div class="col-sm-2">Gender: </div>
            <div class="col-sm-2 form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="gender">Male
                </label>
            </div>
            <div class="col-sm-4 form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="gender">Female
                </label>
            </div>
        </div><br>
        <div>
            <input type="submit" value="Sign Up" class="btn w-50 btn-outline-success">
        </div>
    </form>
</div>
</body>
</html>
