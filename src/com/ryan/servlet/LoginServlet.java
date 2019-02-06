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

        UserManager userManager = new UserManager();

        String emailAddress = req.getParameter("email");
        String password = req.getParameter("password");
//        String decodedPassword = md5.MD5(password); !!! stupid =))

        if (userManager.getUser(emailAddress) != null && MD5.matching(userManager.getUser(emailAddress).getPassword(), password)) {
            CookieUtils.addCookie(resp, "emailAddress", emailAddress, 60 * 60);
            HttpSession session = req.getSession();
            session.setAttribute("user", userManager.getUser(emailAddress));
            resp.sendRedirect("/home");
        } else {
            String fail = "USERNAME OR PASSWORD MIGHT INCORRECT, PLEASE ENTER AGAIN!";
            req.setAttribute("fail", fail);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
