package com.ryan.servlet;

import com.ryan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "home-servlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.getCookie(req, "emailAddress");
        if (cookie != null) {
//            String emailAddress = cookie.getValue();
//            UserManager userManager = new UserManager();
//            req.setAttribute("user", userManager.getUser(emailAddress));
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }

    }
}
