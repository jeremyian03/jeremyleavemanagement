package net.javaguides.LEAVEMANAGEMENTSYSTEM.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.LEAVEMANAGEMENTSYSTEM.dao.UserDAO;
import net.javaguides.LEAVEMANAGEMENTSYSTEM.model.User;

@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
            case "register":
                registerUser(request, response);
                break;
            case "login":
                loginUser(request, response);
                break;
            }
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contactNumber = request.getParameter("contactNumber");
        String emailAddress = request.getParameter("emailAddress");

        User newUser = new User(username, password, contactNumber, emailAddress);

        try {
            if (userDAO.insertUser(newUser)) {
                response.sendRedirect("login.jsp"); // Redirect to login page after successful registration
            } else {
                // Registration failed
                // You can handle this case accordingly, e.g., display an error message
                response.sendRedirect("register.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userDAO.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                // Successful login
                // You can set session attributes to indicate that the user is logged in
                request.getSession().setAttribute("user", user);
                response.sendRedirect("list"); // Redirect to leave list page after successful login
            } else {
                // Login failed
                // You can handle this case accordingly, e.g., display an error message
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}