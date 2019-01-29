package com.ryan.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "my-profile-servlet", urlPatterns = "/my-profile")
public class MyProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(CookieUtils.getCookie(req, "emailAddress") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/my-profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }
}
