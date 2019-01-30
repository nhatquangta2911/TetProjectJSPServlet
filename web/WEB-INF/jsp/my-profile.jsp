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
    <title>My Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container w-100">
    <br><br><h1 class="text-secondary">My Profile</h1>
    <hr><br>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <div class="row w-50">
        <div class="col-sm-4">
            Email:
        </div>
        <div class="col-sm-8">
            <p class="text-info"><%= user.getEmailAddress()%></p>
        </div>
        <div class="col-sm-4">
            Full Name:
        </div>
        <div class="col-sm-8">
            <p class="text-info"><%= user.getFullName()%></p>
        </div>
        <div class="col-sm-4">
            Date Of Birth:
        </div>
        <div class="col-sm-8">
            <p class="text-info"><%= user.getDateOfBirth()%></p>
        </div>
        <div class="col-sm-4">
            Gender:
        </div>
        <div class="col-sm-8">
            <p class="text-info"><%= user.isFemale()?"Female":"Male"%></p>
        </div>
    </div>
    <%--<p>Email: <span class="text-success"><%= user.getEmailAddress()%></span></p>--%>
    <%--<p>Full Name: <span class="text-success"><%= user.getFullName()%></span></p>--%>
    <%--<p>Date Of Birth: <span class="text-success"><%= user.getDateOfBirth()%></span></p>--%>
    <%--<p>Gender: <span class="text-success"><%= user.isFemale()?"Female":"Male"%></span></p>--%>

    <br>
    <button onclick="redirect()" class="btn w-50 btn-outline-success">Back</button>
</div>

<script>
    function redirect() {
        window.location = "/home"
    }
</script>

</body>
</html>
