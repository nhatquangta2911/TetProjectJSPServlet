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
    <hr>
    <p class="text-warning">${notification}</p>
    <br>
    <form method="post" action="/register" name="registerForm">
        <div class="w-50">
            Email:<br>
            <input type="email" name="email" required class="form-control">
        </div><br>
        <div class="w-50">
            Password:<br>
            <input type="password" name="password1" required class="form-control">
        </div><br>
        <div class="w-50">
            Retype Password:<br>
            <input type="password" name="password2" required class="form-control">
        </div><br>
        <div class="w-50">
            Full Name:<br>
            <input type="text" name="full-name" required class="form-control">
        </div><br>
        <div class="w-50">
            Date Of Birth:<br>
            <input type="date" name="date-of-birth" required class="form-control">
        </div><br>
        <div class="row">
            <div class="col-sm-2">Gender: </div>
            <div class="col-sm-2 form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" required value="male"  name="gender">Male
                </label>
            </div>
            <div class="col-sm-4 form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" value="female" name="gender">Female
                </label>
            </div>
        </div><br>
        <div>
            <input type="submit" value="Sign Up" onclick="return matchPassword()" class="btn w-50 btn-outline-success">
        </div>
    </form>
</div>

<script>
    function matchPassword() {
        var firstPassword = document.registerForm.password1.value;
        var secondPassword = document.registerForm.password2.value;
        if (firstPassword !== secondPassword) {
            alert('Password must be the same!');
            return false;
        }
        return true;
    }
</script>
</body>
</html>
