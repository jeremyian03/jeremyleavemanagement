package net.javaguides.LEAVEMANAGEMENTSYSTEM.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.LEAVEMANAGEMENTSYSTEM.dao.LeaveDAO;
import net.javaguides.LEAVEMANAGEMENTSYSTEM.model.Leave;

@WebServlet("/")
public class LeaveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LeaveDAO leaveDAO;

    public void init() {
        leaveDAO = new LeaveDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertLeave(request, response);
                break;
            case "/delete":
                deleteLeave(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateLeave(request, response);
                break;
            case "/logout":
                logoutUser(request, response);
                break;
            default:
                listLeave(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Leave> listLeave = leaveDAO.selectAllLeaves();
        request.setAttribute("listLeave", listLeave);
        RequestDispatcher dispatcher = request.getRequestDispatcher("leave-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("leave-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Leave existingLeave = leaveDAO.selectLeave(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("leave-form.jsp");
        request.setAttribute("leave", existingLeave);
        dispatcher.forward(request, response);
    }

    private void insertLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String leaveType = request.getParameter("leaveType");
        String status = request.getParameter("status");
        Leave newLeave = new Leave(name, leaveType, status);
        leaveDAO.insertLeave(newLeave);
        response.sendRedirect("list");
    }

    private void updateLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String leaveType = request.getParameter("leaveType");
        String status = request.getParameter("status");

        Leave leave = new Leave(id, name, leaveType, status);
        leaveDAO.updateLeave(leave);
        response.sendRedirect("list");
    }

    private void deleteLeave(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        leaveDAO.deleteLeave(id);
        response.sendRedirect("list");
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }
}