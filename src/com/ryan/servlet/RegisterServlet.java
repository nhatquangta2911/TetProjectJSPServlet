package com.ryan.servlet;

import com.ryan.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register-servlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MD5 md5 = new MD5();

        String emailAddress = req.getParameter("email");
        String password = req.getParameter("password2");
        String encodedPassword = md5.MD5(password);
        String fullName = req.getParameter("full-name");
        String dateOfBirth = req.getParameter("date-of-birth");
        boolean isFemale = false;
        if (req.getParameter("gender").equals("female")) {
            isFemale = true;
        }

        UserManager userManager = new UserManager();
        User newUser = new User(emailAddress, encodedPassword, fullName, dateOfBirth, isFemale);

        if (userManager.addUser(newUser)) {
            resp.sendRedirect("/login");
        } else {
            String notification = "THIS EMAIL IS ALREADY USED BY ANOTHER USER !";
            req.setAttribute("notification", notification);
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
        }
    }
}
