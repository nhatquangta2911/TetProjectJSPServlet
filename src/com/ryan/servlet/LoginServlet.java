package com.ryan.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login-servlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emailAddress = req.getParameter("email");
        String password = req.getParameter("password");

        if (emailAddress.equals("user01@gmail.com") && password.equals("123456")) {
            req.setAttribute("user", emailAddress);
            resp.sendRedirect("/home");
            HttpSession session = req.getSession();
            session.setAttribute("user", emailAddress);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
//            requestDispatcher.forward(req, resp);

        } else {
            String fail = "USERNAME OR PASSWORD MIGHT INCORRECT, PLEASE ENTER AGAIN!";
            req.setAttribute("fail", fail);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
