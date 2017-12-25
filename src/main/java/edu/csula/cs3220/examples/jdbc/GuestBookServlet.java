package edu.csula.cs3220.examples.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/jdbc/guestbook")
public class GuestBookServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        GuestBookDAO dao = new GuestBookDAO();
        request.setAttribute("list", dao.list());

        request.getRequestDispatcher("/WEB-INF/jdbc/guestbook.jsp")
            .forward(request, response);
    }
}
