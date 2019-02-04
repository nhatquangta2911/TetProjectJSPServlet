package com.ryan.servlet;

import com.ryan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "change-password-servlet", urlPatterns = "/change-password")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (CookieUtils.getCookie(req, "emailAddress") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/change-password.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String currentPassword = req.getParameter("current-password");

        if (user.getPassword().equals(currentPassword)) {

            String newPassword = req.getParameter("new-password2");
            user.setPassword(newPassword);

            UserManager userManager = new UserManager();
            userManager.removeUser(user.getEmailAddress());
            userManager.addUser(user);

            resp.sendRedirect("/home");

        } else {
            String fail = "YOU HAVE ENTERED A WRONG PASSWORD!";
            req.setAttribute("fail", fail);
            req.getRequestDispatcher("/WEB-INF/jsp/change-password.jsp").forward(req, resp);
        }
    }
}
