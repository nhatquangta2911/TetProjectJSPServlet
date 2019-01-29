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

        UserManager userManager = new UserManager();

        String emailAddress = req.getParameter("email");
        String password = req.getParameter("password-2");
        String fullName = req.getParameter("full-name");
        String dateOfBirth = req.getParameter("date-of-birth");
        boolean isFemale = false;
        if (req.getParameter("gender").equals("female")) {
            isFemale = true;
        }

        User newUser = new User(emailAddress, password, fullName, dateOfBirth, isFemale);
        if (userManager.addUser(newUser)) {
            req.setAttribute("emailAddress", emailAddress);
            req.setAttribute("password", password);
            req.setAttribute("fullName", fullName);
            req.setAttribute("dateOfBirth", dateOfBirth);
            req.setAttribute("isFemale", isFemale);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }
}
