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
    <title>Change Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container w-100">
    <br><br><h1 class="text-secondary">Change password</h1>
    <hr><br>
    <form method="post" action="/change-password">
        <div class="w-50">
            Current Password:<br>
            <input type="password" name="current-password" class="form-control">
        </div><br>
        <div class="w-50">
            New Password:<br>
            <input type="password" name="new-password-1" class="form-control">
        </div>
        <br>
        <div class="w-50">
            Retype Password:<br>
            <input type="password" name="new-password-2" class="form-control">
        </div>
        <br>
        <div>
            <input type="submit" value="Change Password" class="btn w-50 btn-outline-danger ">
        </div>
    </form>
    <form method="get" action="/home">
        <input type="submit" value="Back" class="btn w-50 btn-outline-success">
    </form>
</div>
</body>
</html>
