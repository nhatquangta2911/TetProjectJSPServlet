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
    <title>Edit Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container w-100">
    <br><br><h1 class="text-secondary">Edit Profile</h1>
    <hr><br>
    <p class="text-warning">${fail}</p>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <form method="post" action="/edit-my-profile">
        <div class="w-50">
            Email:<br>
            <input type="email" name="email" disabled value="<%= user.getEmailAddress()%>" class="form-control form-control-sm">
        </div><br>
        <div class="w-50">
            Full Name:<br>
            <input type="text" required name="full-name" value="<%= user.getFullName()%>" class="form-control form-control-sm">
        </div><br>
        <div class="w-50">
            Date Of Birth:<br>
            <input type="date" required name="date-of-birth" value="<%= user.getDateOfBirth()%>" class="form-control form-control-sm">
        </div><br>
        <div class="row">
            <div class="col-sm-2">Gender: </div>
            <div class="col-sm-2 form-check-inline">
                <label class="form-check-label">
                    <input type="radio" value="male" class="form-check-input" <%= user.isFemale()?"":"checked"%> name="edited-gender">Male
                </label>
            </div>
            <div class="col-sm-4 form-check-inline">
                <label class="form-check-label">
                    <input type="radio" value="female" required class="form-check-input" <%= user.isFemale()?"checked":""%> name="edited-gender">Female
                </label>
            </div>
        </div><br>
        <div>
            <input type="submit" value="Edit Profile" class="btn w-50 btn-outline-info">
        </div>
    </form>
    <button onclick="redirect()" class="w-50 btn btn-outline-success">Back</button>
</div>

<script>
    function redirect() {
        window.location = "/home";
    }
</script>

</body>
</html>
