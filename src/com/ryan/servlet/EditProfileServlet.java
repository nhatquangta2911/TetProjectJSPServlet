package com.ryan.servlet;

import com.ryan.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String editedEmailAddress = req.getParameter("email");
        String editedFullName = req.getParameter("full-name");
        String editedDateOfBirth = req.getParameter("date-of-birth");
        String gender = req.getParameter("gender");
        boolean isFemale = gender.equals("Female");
    }
}
