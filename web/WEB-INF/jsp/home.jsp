<%@ page import="com.ryan.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ryan-ta
  Date: 1/27/19
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <br><br>
        <div class="row">
            <h1 class="col-sm-8 text-secondary">HOME PAGE</h1>
            <form class="col-sm-4" method="get" action="/logout">
                <input type="submit" value="Log Out" class="w-100 btn mt-1 btn-outline-warning">
            </form>
        </div>
        <div>
            <hr style="width: 100%; color: gray; height: 0.1px; background-color: gainsboro;" />
            <br>
            <%
                User user = (User) session.getAttribute("user");
            %>
            <p>Hello <span class="text-primary "><%= user.getFullName()%></span> !<span> Welcome to my website!</span></p>
        </div><br><br>
        <div class="row">
            <form class="col-sm-4" method="get" action="/my-profile">
                <input class="btn w-100 btn-outline-primary" type="submit" value="My Profile">
            </form>
            <form class="col-sm-4" method="get" action="/edit-my-profile">
                <input type="submit" class="w-100 btn btn-outline-info" value="Edit Profile">
            </form>
            <form  class="col-sm-4" method="get" action="/change-password">
                <input type="submit" class="w-100 btn btn-outline-danger" value="Change Password">
            </form>
        </div>
    </div>
</body>
</html>
