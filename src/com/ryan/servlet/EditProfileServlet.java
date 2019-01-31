package com.ryan.servlet;

import com.ryan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "edit-my-profile-servlet", urlPatterns = "/edit-my-profile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (CookieUtils.getCookie(req, "emailAddress") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/edit-profile.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String editedFullName = req.getParameter("full-name");
        String editedDateOfBirth = req.getParameter("date-of-birth");
        String editedGender = req.getParameter("edited-gender");
        boolean isFemale = editedGender.equals("Female");

        user.setFullName(editedFullName);
        user.setDateOfBirth(editedDateOfBirth);
        user.setGender(isFemale);

        UserManager userManager = new UserManager();
        userManager.removeUser(user.getEmailAddress());
        userManager.addUser(user);

        resp.sendRedirect("/my-profile");
    }
}
